package com.zhou;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyMap extends TestCase {
    /**
     * Map实验类对比：HashMap, LinkedHashMap, TreeMap
     */
    public void testMap() {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>();
        Map<String, String> map3 = new TreeMap<>();
        Map<String, String> map4 = new TreeMap<>((s1, s2) -> s2.compareTo(s1));

        System.out.println("Map操作：put的顺序");
        System.out.println("abc=D");
        System.out.println("1=A");
        System.out.println("2=B");
        System.out.println("3=C");

        map1.put("abc", "D");
        map1.put("1", "A");
        map1.put("2", "B");
        map1.put("3", "C");

        map2.put("abc", "D");
        map2.put("1", "A");
        map2.put("2", "B");
        map2.put("3", "C");

        map3.put("abc", "D");
        map3.put("1", "A");
        map3.put("2", "B");
        map3.put("3", "C");

        map4.put("abc", "D");
        map4.put("1", "A");
        map4.put("2", "B");
        map4.put("3", "C");

        System.out.println("HashMap: key无序");
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.toString());
        }

        System.out.println("LinkedHashMap: key有序(put的顺序)");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.toString());
        }

        System.out.println("TreeMap: key有序(默认升序)");
        for (Map.Entry<String, String> entry : map3.entrySet()) {
            System.out.println(entry.toString());
        }

        System.out.println("TreeMap: key有序(设置为减序)");
        for (Map.Entry<String, String> entry : map4.entrySet()) {
            System.out.println(entry.toString());
        }
    }
}
