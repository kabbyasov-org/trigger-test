package com.serena;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Simple GitHubAntHillTriggerBridge servlet.
 */

public final class GitHubAntHillTriggerBridge extends HttpServlet {

    private static final String JSON_PROPERTY_REPOSITORY_URL = "repo_url";
    private static final String JSON_PROPERTY_REPOSITORY_BRANCH = "ref";
    private static final String JSON_PROPERTY_REPOSITORY = "repository";
    private static final String PAYLOAD_REQUEST_PARAM_NAME = "payload";
    //    private static final String ANTHILL_TRIGGER_URL = "http://orl-sra-cmt1:9095";
    private static final String ANTHILL_TRIGGER_URL = "http://requestb.in/1cnnlg71";
    private static final String ANTHILL_TRIGGER_CODE = "d4297a0273899617978517793b6d28eab9f84f9e";

    private String ghRepositoryUrl = "";
    private String ghBranch = "";
    private String ghPayload = "";


    private String getGitHubRepositoryUrl() throws Exception {
        String retval = "";
        JSONObject repository = (JSONObject) getMainJSONObject().get(JSON_PROPERTY_REPOSITORY);
        if (null != repository) {
            retval = (null != repository.get(JSON_PROPERTY_REPOSITORY_URL)) ? (String) repository.get(JSON_PROPERTY_REPOSITORY_URL) : "";
        }
        return retval;
    }

    private String getGitHubBranch() throws Exception {
        String retval = "";
        JSONObject repository = (JSONObject) getMainJSONObject().get(JSON_PROPERTY_REPOSITORY);
        if (null != repository) {
            retval = (null != repository.get(JSON_PROPERTY_REPOSITORY_URL)) ? (String) repository.get(JSON_PROPERTY_REPOSITORY_URL) : "";
        }
        return retval;
    }

    private void parseGHPayload() throws Exception {
        ghRepositoryUrl = getGitHubRepositoryUrl();
        ghBranch = getGitHubBranch();
    }

    private String getRepositoryUrlForAH() throws Exception {
        return getGitHubRepositoryUrl().replaceFirst("https://", "").replaceFirst("http://", "");
    }

    private String getBranchForAH() throws Exception {
        return getGitHubBranch().replaceFirst("refs/heads/", "");
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

            // handle response here...
        } catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    private String createAHRequestString() throws Exception {
        String retval = "code=" + ANTHILL_TRIGGER_CODE;
        retval += "&repo=" + getRepositoryUrlForAH();
        retval += "&branch=" + getBranchForAH();
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

        ghPayload = request.getParameter(PAYLOAD_REQUEST_PARAM_NAME);
        if (!"".equals(ghPayload)) {
            try {
                parseGHPayload();
                if (!"".equals(ghRepositoryUrl) && !"".equals(ghBranch)) {
                    notifyAH();
                }
            } catch (Exception e) {
                response.setContentType("text/html");
                PrintWriter writer = response.getWriter();
                writer.println("<html>");
                writer.println("<head>");
                writer.println("</head>");
                writer.println("<body bgcolor=white>");
                writer.println(e.getStackTrace());
                writer.println("</body>");
                writer.println("</html>");
            }
        }

//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<head>");
//        writer.println("</head>");
//        writer.println("<body bgcolor=white>");
//
//
//
//
//        writer.println("ghRepositoryUrl: " + ghRepositoryUrl + "<br>");
//        writer.println("</body>");
//        writer.println("</html>");


    }
}