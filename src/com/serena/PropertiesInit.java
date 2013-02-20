package com.serena;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class PropertiesInit extends HttpServlet {

    private void initProps() {
        String prefix = getServletContext().getRealPath("/");
        String log4jfile = getInitParameter("log4j-init-file");
        // if the log4j-init-file is not set, then no point in trying
        if (log4jfile != null) {
            PropertyConfigurator.configure(prefix + log4jfile);
        }

        String propsFile = getInitParameter("props-file");
        AppProperties.getInstance().loadProperties(propsFile);
    }

    public void init() {
        initProps();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        initProps();
    }
}