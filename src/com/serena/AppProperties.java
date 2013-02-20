package com.serena;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: kabbyasov
 * Date: 20.02.13
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
public class AppProperties {

    static public final String SHOULD_RUN_JENKINS_TRIGGER = "should.run.jenkins.trigger";
    static public final String SHOULD_RUN_ANTHILL_TRIGGER = "should.run.anthill.trigger";
    static private final Logger log = Logger.getLogger(AppProperties.class);

    private static AppProperties ourInstance = new AppProperties();
    private Properties props = new Properties();

    public Properties getProps() {
        return props;
    }
    public static AppProperties getInstance() {
        return ourInstance;
    }
    private AppProperties() {
    }

    public void loadProperties(String fileName) {
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
            props.clear();
            props.load(in);
            in.close();
        } catch (IOException e) {
            log.error("Error loading props...");
        }
    }


}
