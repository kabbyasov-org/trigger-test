package com.serena;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Simple GitHubAntHillTriggerBridge servlet.
 */

public final class GitHubJenkinsBridge extends HttpServlet {

    static private final Logger log = Logger.getLogger(GitHubJenkinsBridge.class);

    private static final String PAYLOAD_REQUEST_PARAM_NAME = "payload";
    private static final String JENKINS_URL = "http://ua007464:8081/github-webhook/";

    private String ghPayload = "";

    private void logDebug(String message) {
            log.debug(message);
    }

    private void logError(String message, Exception ex) {
        log.error(message, ex);
   }
    private void notifyJenkins() {
        HttpClient httpClient = new DefaultHttpClient();

        try {
            HttpPost request = new HttpPost(JENKINS_URL);
            StringEntity params = new StringEntity(createJenkinsRequestString());
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            logDebug("Jenkins Response Status code: " + (null != response ? response.getStatusLine().getStatusCode() : "unknown"));

        } catch (Exception ex) {
            logError("Error sending request to Jenkins", ex);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private String createJenkinsRequestString() throws Exception {
        String retval = "payload=" + ghPayload;
        logDebug("Jenkins ready request string:" + retval);
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
            logDebug("Proceeding Jenkins trigger...");
            ghPayload = request.getParameter(PAYLOAD_REQUEST_PARAM_NAME);
            logDebug("GitHub payload message:" + ghPayload);
    //        System.out.println("Got request: " + ghPayload);

            if (null != ghPayload && !"".equals(ghPayload)) {
                    notifyJenkins();
            }
        }
    }

    private boolean needToProceed() {
        return Boolean.valueOf(AppProperties.getInstance().getProps().getProperty(AppProperties.SHOULD_RUN_JENKINS_TRIGGER));
    }
}



//        comment for testing purposes 19
