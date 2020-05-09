package com.puyuan.iotmanager.fact;

/**
 * @author dalididilo
 */
public class FunctionStatic {

    public static void testStatic1(){
        System.out.println("Java静态方法作为Drools的function，testStatic1()");
    }

    public static String testStatic2(){
        System.out.println("Java静态方法作为Drools的function，testStatic2()");
        return "Hello";
    }

    public static void testStatic3(String name){
        System.out.println(String.format("Java静态方法作为Drools的function，testStatic3(%s)",name));
    }

    public static String testStatic4(String name){
        System.out.println(String.format("Java静态方法作为Drools的function，testStatic4(%s)",name));
        return "Hello Drools";
    }

}
