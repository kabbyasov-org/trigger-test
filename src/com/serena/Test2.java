package com.serena;


import java.io.*;

public class Test2 {
    public static void main(String[] args) {

        int[][] twoD = new int[][]{new int[]{1, 2},
                new int[]{3, 4}};

        int[][] newTwoD = null; // will deserialize to this

        System.out.println("Before serialization");
        for (int[] arr : twoD) {
            for (int val : arr) {
                System.out.println(val);
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(new File("d:\\1\\test.dat"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(twoD);

            FileInputStream fis = new FileInputStream(new File("d:\\1\\test.dat"));
            ObjectInputStream iis = new ObjectInputStream(fis);
            newTwoD = (int[][]) iis.readObject();

        } catch (Exception e) {

        }

        System.out.println("After serialization");
        for (int[] arr : newTwoD) {
            for (int val : arr) {
                System.out.println(val);
            }
        }
    }
}
