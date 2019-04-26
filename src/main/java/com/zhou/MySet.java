package com.zhou;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySet {
    public void test1(){
        Set<Integer> set1 = new HashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        TreeSet<Integer> set3 = new TreeSet<>();
        set2.add(1);
    }
}
