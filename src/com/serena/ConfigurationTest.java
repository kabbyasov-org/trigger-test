package com.serena;


import org.apache.commons.configuration.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ConfigurationTest {
    public static void main(String[] args) throws Exception {
        File file = new File("d:\\1\\1.props");

        ArrayList list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            ArrayList<String> list2 = new ArrayList<String>();
            list2.add(new Random().nextInt() + "");
            list2.add(new Random().nextInt() + "");
            list2.add(new Random().nextInt() + "");
            list.add(list2);
        }

//        list.add("asd");
//        list.add("\"fffa,%gh%%\"");
//        list.add("\"()fff");
//        String[] array = new String[] {"\"z[,],\"","x"};

        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
        }
//        final char SEPARATOR_CHAR = ((char) 007);
        final char SEPARATOR_CHAR = '%';
        AbstractFileConfiguration.setDefaultListDelimiter(SEPARATOR_CHAR);

        PropertiesConfiguration conf = new PropertiesConfiguration(file);
        PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout(conf);


//        conf.setDelimiterParsingDisabled(false);
//        conf.setFile(file);

        conf.addProperty("3", "2");
        conf.addProperty("3", "3");
        conf.addProperty("3", 4);
        conf.addProperty("5", list);
        layout.setSingleLine("5", false);
        conf.setLayout(layout);
//        conf.addProperty("5", array);

        conf.save();

        PropertiesConfiguration conf2 = new PropertiesConfiguration(file);
//        conf2.setListDelimiter('%');
//        conf2.setDelimiterParsingDisabled(true);
//        conf2.setFile(file);
//        conf2.load(file);
        Object obj = conf2.getStringArray("5");
        System.out.println(obj instanceof ArrayList);
        System.out.println(obj instanceof String);
        ArrayList<String> al = (ArrayList<String>) obj;
        System.out.println(al.size());
        System.out.println(al);

    }
}