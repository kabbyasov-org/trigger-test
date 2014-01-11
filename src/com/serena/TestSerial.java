package com.serena;

import com.urbancode.commons.util.IO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.SerializationException;
import org.apache.commons.lang.SerializationUtils;

import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

class TestSerial implements Serializable {
    public byte version = 100;
    public byte count = 0;
    public static String FILE = "d:\\1\\temp.out";
    static String asd = "123";

    public static void main(String args[]) throws Exception {

        testSerialization();
        testDeSerialization();


    }

    public static void testSerialization() throws Exception {
//        String asd = new String("Фаина вернулась в гостиную и села в кресло у окна. Широкая нога ее безвольно провисла, грудь огрузнела. Ошеломленно глядела она вниз, в полыхающее ущелье Манхэттэна, где безумные огни, разбившись на мелкие брызги у испода стеклянной параболы, осыпали черные приземистые деревья. Фаина приезжала к Линде три раза в неделю, всякий раз теряясь в изобилии низких столиков и резных дубовых буфетов, проминавших сумрачные углы. Она убиралась, готовила обед и укладывала Линду спать, когда старуха особенным манером начинала жевать губами. Сама Фаина жила у бойкого перекрестка день и ночь кипящей Астории. Вечером рекламные волны \"Будвайзера\" выплескивались на ее высокую кровать, а вместе с утрами приходил запах шашлычного чада и неизменный однообразный напев, который, в нагрузку к основному сервису, поставлял плотный усатый грек. Тут начинала она шевелиться, сбивать толстыми икрами одеяло, перекатывать с одного бока на другой полное горячее тело и, наконец, открывала глаза");

        Integer intv = 123;

        ArrayList<String> list = new ArrayList<String>();
        list.add("asd");
        list.add("fff");
        list.add("\"()fff");


        Properties props = new Properties();
        props.setProperty("3", asd);
        props.setProperty("1", doSerialization(asd));
        props.setProperty("2", doSerialization(intv));
        props.setProperty("arraylist", doSerialization(list));

        for (Map.Entry<Object, Object> ent : props.entrySet()) {
            System.out.println(ent.getKey().getClass().getName() + " : " + ent.getKey() + " = " +
                    ent.getValue().getClass().getName() + " : " + ent.getValue());
        }

        savePropsToFile(props);
    }

    public static void testDeSerialization() throws Exception {
        Properties props = loadPropsFromFile();
//        String zzz = doSerialization(asd);
        Object obj1;
        for (Map.Entry<Object, Object> ent : props.entrySet()) {
             obj1 = doDeserialization(props.getProperty(ent.getKey().toString()));
//             obj1 = doDeserialization(zzz);
            System.out.println(obj1.getClass());
            if (obj1 instanceof ArrayList) {
                ArrayList<String> list = (ArrayList<String>) obj1;
                for (String s : list) {
                    System.out.println(s);
                }
            } else if (obj1 instanceof String) {
                System.out.println(obj1);
            }
        }

    }


    public static String doSerialization(Serializable o) throws Exception {
        return new String(Base64.encodeBase64(SerializationUtils.serialize(o)));
//        return IO.decode(IO.ascii(), SerializationUtils.serialize(o));
    }

    public static Object doDeserialization(String s) throws Exception {
        Object retval = s;
        byte[] bytes = IO.encode(IO.ascii(), s);

//        System.out.println("bytes length for "+s + " is "+bytes.length);
        try {
            if (bytes.length != 0) {
//                bytes[0] = (byte) -84;
//                bytes[1] = (byte) -19;

//                retval = SerializationUtils.deserialize(bytes);
                retval = SerializationUtils.deserialize(Base64.decodeBase64(s));
//                retval = IO.deserialize(s.getBytes(Charset.forName("US-ASCII")));
            }
        } catch (SerializationException e) {
            System.out.println(e.getMessage());
        }
        return retval;
    }

    public static void savePropsToFile(Properties props) throws Exception {
        OutputStream outputPropsStream = null;
        try {
            outputPropsStream = new FileOutputStream(FILE);
            props.store(outputPropsStream, "");
        } finally {
            if (outputPropsStream != null) {
                outputPropsStream.close();
            }
        }
    }


    public static Properties loadPropsFromFile() throws Exception {
        InputStream inputStream = null;
        Properties props = new Properties();
        try {
            inputStream = new FileInputStream(FILE);
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
        }

        return props;
    }

}