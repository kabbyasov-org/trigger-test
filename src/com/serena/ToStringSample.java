package com.serena;

import org.apache.commons.codec.binary.Base64;

import java.util.*;
import java.io.*;

/**
 * Usage sample serializing SomeClass instance
 */
public class ToStringSample {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
//        HashMap list = new HashMap();
//        list.put("1","asd");
//        list.put("2","fff");
//        list.put("3","\"()fff");
//        String string = toString(list);
//        System.out.println(" Encoded serialized version ");
//        System.out.println(string);
//        HashMap some = (HashMap) fromString(string);
//        System.out.println("\n\nReconstituted object");
//        System.out.println(some);

//        System.out.println(Convert.FromBase64String(base64String););

    }

    /**
     * Read the object from Base64 string.
     */
    private static Object fromString(String s) throws IOException,
            ClassNotFoundException {
        byte[] data = Base64.decodeBase64(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /**
     * Write the object to a Base64 string.
     */
    private static String toString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return new String(Base64.encodeBase64(baos.toByteArray()));
    }

}
