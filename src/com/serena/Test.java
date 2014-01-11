package com.serena;

import com.serena.telecomitalia.XRBPManifest;
import com.urbancode.commons.fileutils.FileUtils;
import net.jmatrix.eproperties.EProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Chmod;
import org.apache.tools.ant.taskdefs.ExecuteOn;
import org.apache.tools.ant.taskdefs.optional.unix.Chown;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.selectors.FileSelector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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

        // test2

//        File file = new File("d:\\2\\1.txt");
//        System.out.println(file.exists());

//        XRBPManifest param = null;
//        try {
//            JAXBContext context = JAXBContext.newInstance(XRBPManifest.class);
//            Unmarshaller unMarshaller = context.createUnmarshaller();
//            unMarshaller.setValidating(true);
//             param = (XRBPManifest) unMarshaller.unmarshal(new FileInputStream("XRBP_manifest.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }

//        Parent test = new Parent();
//        test.setVar1("vasya");
//        System.out.println(test.getVar1());
////        System.exit(0);
//
//        Child child = new Child();
//        child.setVar1("petya");
//        child.setVar3("kolya");
//
//        System.out.println(child.getVar1());
//        System.out.println(child.getVar3());

//        System.out.println(child.getVar1());


//        Project project = new Project();
//        Chown chown = new Chown();
//        chown.setProject(project);
//        FileSet fileSet = new FileSet();
//        fileSet.setIncludes("**/*");
//        chown.addFileset(fileSet);
//        chown.setType(new ExecuteOn.FileDirBoth());
//        chown.setOwner("poison");
//        chown.setDir(new File("."));
//
//        chown.setFile();

        EProperties props = new EProperties();
        props.put("first", new ArrayList<String>() {{
            add("A)s(\"()");
            add("B");
            add("C");
        }});

        props.put("2", "second value");

        File outputPropFile = new File("D:\\1\\a.properties");
        try {
            if (outputPropFile.exists()) {
                props = new EProperties();
                props.load(outputPropFile);
                for (Object key : props.keySet()) {
                    Object value = props.get(key);
                    if ( value != null && value instanceof List) {
                        System.out.println(key + ":(list)" + ((List) value).size());
                    } else {
                        System.out.println((String)key + ":" + value);
                    }
                }
            } else {
                outputPropFile.createNewFile();
                props.save(outputPropFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        if (outputPropFile.canWrite()) {
//            OutputStream outPropStream = null;
//            try {
//                outPropStream = new FileOutputStream(outputPropFile);
//                props.store(outPropStream, "After Post Process");
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            } finally {
//                try {
//                    outPropStream.close();
//                } catch (IOException swallow) {
//                }
//            }
//        }
//
//        if (tempOutputPropsFile.exists()) {
//            InputStream propsInStream = null;
//            try {
//                propsInStream = new FileInputStream(tempOutputPropsFile);
//                props.load(propsInStream);
//            } catch (FileNotFoundException e) {
//                log.error("Output Properties file not found!", e);
//            } catch (IOException e) {
//                log.error("Error reading outputprops!", e);
//            } finally {
//                IO.close(propsInStream);
//            }
//        }


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
