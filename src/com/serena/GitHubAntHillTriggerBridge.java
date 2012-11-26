package com.serena;

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


    /**
     * Respond to a GET request for the content produced by
     * this servlet.
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are producing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
      throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();        
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Sample Application Servlet Page</title>");
        writer.println("</head>");
        writer.println("<body bgcolor=white>");

        writer.println("<table border=\"0\" cellpadding=\"10\">");
        writer.println("<tr>");
        writer.println("<td>");
        writer.println("<img src=\"images/springsource.png\">");
        writer.println("</td>");
        writer.println("<td>");
        writer.println("<h1>Sample Application Servlet</h1>");
        writer.println("</td>");
        writer.println("</tr>");
        writer.println("</table>");

        writer.println("This is the output of a servlet that is part of");
        writer.println("the GitHubAntHillTriggerBridge, World application.");

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String payload = request.getParameter("payload");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body bgcolor=white>");

        JSONParser parser = new JSONParser();

        Object obj = null;
        try{
            obj = parser.parse(payload);
        }
        catch(ParseException pe){
            writer.println("position: " + pe.getPosition());
            writer.println(pe);
        }

        JSONObject jsonObject = (JSONObject) obj;
        String before = (String) jsonObject.get("before");
        String after = (String) jsonObject.get("after");

        writer.println("before: " + before + "<br>");
        writer.println("after: " + after + "<br>");
        writer.println("</body>");
        writer.println("</html>");


    }
}