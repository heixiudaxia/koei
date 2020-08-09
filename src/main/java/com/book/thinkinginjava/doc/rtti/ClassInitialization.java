package com.book.thinkinginjava.doc.rtti;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.Random;

/**
 * @Author jojo
 * @create 2020/3/8 下午3:29
 */
public class ClassInitialization {

    public static Random rand = new Random(47);

    /**
     * After creating Initable ref
     * 47
     * Initializing Initable
     * 258
     * Initializing Initable2
     * 147
     * Initializing Initable3
     * After creating Initable3 ref
     * 74
     */

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");

        System.out.println(Initable.staticFinal);

        System.out.println(Initable.staticFinal2);

        System.out.println(Initable2.staticNotFinal);

        Class<?> initable3 = Class.forName("book/thinkinginjava/doc/rtti/Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNotFinal);

    }

}
