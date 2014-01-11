package com.serena;


import java.lang.reflect.Field;

public class Child extends Parent{
    private String var2;
    private String var1;

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

//    @Override
//    public void setVar1(String var1) {
//        try {
//            Class modelClass = Parent.class;
//            Field modelList = modelClass.getDeclaredField("var1");
//            modelList.setAccessible(true);
//            modelList.set(super., var2);
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }

//    }


    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }
}
