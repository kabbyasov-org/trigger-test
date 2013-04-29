package com.serena;

import com.urbancode.commons.fileutils.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: kabbyasov
 * Date: 26.12.12
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
//        List<String> list = null;
//        for (String s : list) {
//            System.out.println(list);
//        }

//        writeOutput("русская строка");
//        setupLocation("русский текст");
//        getInstalledProperties();
//        getMajorVersion();
//        try {
//            System.out.println(FileUtils.compareDirectoryContents("c:/test", "c:/test2"));
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        String str = "hello world 123 #$%#$% вася";
        CharsetEncoder asciiEncoder = Charset.forName(Charset."US-ASCII").newEncoder();

        System.out.println(asciiEncoder.canEncode(str));
        // test

    }

    //example from Sun - Incorrect output
    static void writeOutput(String str) {

        try {
            FileOutputStream fos = new FileOutputStream("test.txt");
            Writer out = new OutputStreamWriter(fos, "UTF8");
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setupLocation(String location) {

        try {
            File installedPropsFile = new File("installed.properties");

            Properties props = new Properties();
            props.setProperty("installLocation", location);
            OutputStream out = null;
            Writer outWriter = null;
            try {
                out = new FileOutputStream(installedPropsFile);
                outWriter = new OutputStreamWriter(out, Charset.forName("UTF8"));
                props.store(outWriter, "INSTALLED PROPERTIES");
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (Exception e) {
                        //nonone cares
                    }
                }
                if (outWriter != null) {
                    try {
                        outWriter.close();
                    } catch (Exception e) {
                        //nonone cares
                    }
                }

            }
        } catch (IOException e) {
        }
    }

    public static Properties getInstalledProperties() {
        File installedPropsFile = new File("installed.properties");
        if (installedPropsFile.isFile()) {
            //set persistence path and do an install of uDeploy
            Properties installedProps = new Properties();
            InputStream inStream = null;
            Reader reader = null;
            try {
                inStream = new FileInputStream(installedPropsFile);
                reader = new InputStreamReader(inStream, "UTF-8");
                installedProps.load(reader);
            } catch (Exception e) {
                System.out.println("Exception while finding uDeploy installation location.");
                e.printStackTrace();
                installedProps = null;
            } finally {
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException e) {
                        //swallow
                    }
                }
            }
            return installedProps;
        }
        return null;
    }


    static public String getMajorVersion() {
        String majorVersion = "unknown";
        try {
            String fullVersion = "4.5.0.1234";
            if (null != fullVersion) {
                    List<String> parts = new ArrayList(Arrays.asList(StringUtils.split(fullVersion, ".")));
                    parts.remove(parts.size() - 1);
                    majorVersion = StringUtils.join(parts, ".");
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return majorVersion;
    }


}
