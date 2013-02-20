package com.serena;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.log4j.Logger;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Simple GitHubAntHillTriggerBridge servlet.
 */

public final class GitHubAntHillTriggerBridge extends HttpServlet {

    static private final Logger log = Logger.getLogger(GitHubAntHillTriggerBridge.class);

    private static final String JSON_PROPERTY_REPOSITORY_URL = "url";
    private static final String JSON_PROPERTY_BRANCH = "ref";
    private static final String JSON_PROPERTY_REPOSITORY = "repository";
    private static final String PAYLOAD_REQUEST_PARAM_NAME = "payload";
        private static final String ANTHILL_TRIGGER_URL = "http://orl-sra-cmt1.serena.com:9095/trigger";
//    private static final String ANTHILL_TRIGGER_URL = "http://requestb.in/1dnqnl51";
    private static final String ANTHILL_TRIGGER_CODE = "d4297a0273899617978517793b6d28eab9f84f9e";

    private String ghRepositoryUrl = "";
    private String ghBranch = "";
    private String ghPayload = "";

    private void logDebug(String message) {
            log.debug(message);
    }

    private void logError(String message, Exception ex) {
        log.error(message, ex);
    }

    private void logInfo(String message) {
        log.info(message);
    }

    private String getGitHubRepositoryUrl() throws Exception {
        String retval = "";
        JSONObject repository = (JSONObject) getMainJSONObject().get(JSON_PROPERTY_REPOSITORY);
        if (null != repository) {
            retval = (null != repository.get(JSON_PROPERTY_REPOSITORY_URL)) ? (String) repository.get(JSON_PROPERTY_REPOSITORY_URL) : "";
        }
        logDebug("GitHub repository url(already parsed):" + retval);
        return retval;
    }

    private String getGitHubBranch() throws Exception {
        String retval = (String) getMainJSONObject().get(JSON_PROPERTY_BRANCH);
        logDebug("GitHub branch (already parsed):" + retval);
        return (null != retval) ? retval : "";
    }

    private void parseGHPayload() throws Exception {
        ghRepositoryUrl = getGitHubRepositoryUrl();
        ghBranch = getGitHubBranch();
    }

    private String getRepositoryUrlForAH() throws Exception {
        String retval = ghRepositoryUrl.replaceFirst("https://", "").replaceFirst("http://", "").concat(".git");
        logDebug("Repository url for AntHill (ready to send):" + retval);
        return retval;
    }

    private String getBranchForAH() throws Exception {
        String retval = ghBranch.replaceFirst("refs/heads/", "");
        logDebug("Branch for AntHill (ready to send):" + retval);
        return retval;
    }

    private JSONObject getMainJSONObject() throws Exception {
        return (JSONObject) new JSONParser().parse(ghPayload);
    }

    private void notifyAH() {
        HttpClient httpClient = new DefaultHttpClient();

        try {
            HttpPost request = new HttpPost(ANTHILL_TRIGGER_URL);
            StringEntity params = new StringEntity(createAHRequestString());
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            logDebug("AntHill Response Status code: " + (null != response ? response.getStatusLine().getStatusCode() : "unknown"));

        } catch (Exception ex) {
            logError("Error sending request to AntHill", ex);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private String createAHRequestString() throws Exception {
        String retval = "code=" + ANTHILL_TRIGGER_CODE;
        retval += "&repo=" + getRepositoryUrlForAH();
        retval += "&branch=" + getBranchForAH();
        logDebug("AntHill ready request string:" + retval);
        return retval;
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (needToProceed()) {
            logDebug("Proceeding Anthill trigger...");
            ghPayload = request.getParameter(PAYLOAD_REQUEST_PARAM_NAME);
            logDebug("GitHub payload message:" + ghPayload);
            System.out.println("Got request: " + ghPayload);

            if (null != ghPayload && !"".equals(ghPayload)) {
                try {
                    parseGHPayload();
    //                writer.println(ghRepositoryUrl);
    //                writer.println(ghBranch);
                } catch (Exception e) {
                    logError("Error parsing request from GitHub", e);
                }

                if (!"".equals(ghRepositoryUrl) && !"".equals(ghBranch)) {
                    try {
                        int sleepTimeoutValue = 60;
                        logDebug("Sleeping for " + sleepTimeoutValue + " seconds before notifying AntHill...");
                        Thread.sleep(sleepTimeoutValue * 1000);
                    } catch (InterruptedException e) {
                        logError("Sleep interrupted!", e);
                    }
                    notifyAH();
                }

            }
        }
    }


    private boolean needToProceed() {
        return Boolean.valueOf(AppProperties.getInstance().getProps().getProperty(AppProperties.SHOULD_RUN_ANTHILL_TRIGGER));
    }

}


//        comment for testing purposes 20
