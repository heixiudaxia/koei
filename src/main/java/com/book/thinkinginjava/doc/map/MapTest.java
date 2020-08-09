package com.book.thinkinginjava.doc.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author jojo
 * @create 2020/3/22 下午7:56
 */
public class MapTest {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        Map<Object, Object> syncMap = Collections.synchronizedMap(map);
        System.out.println("张".hashCode());
        System.out.println("1".hashCode());
        System.out.println("a".hashCode());

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread = Thread.currentThread();
    }
}
