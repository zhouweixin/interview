package com.zhou;

import org.junit.Test;

import java.util.*;

public class AllSequence {
    /**
     * 插入法
     */
    @Test
    public void test1() {
        String str = "ABCDE";

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (list1.size() == 0) {
                list1.add(c + "");
                continue;
            }

            for (String s : list1) {
                for (int j = 0; j <= s.length(); j++) {
                    list2.add(new StringBuilder(s).insert(j, c).toString());
                }
            }
            list1.clear();
            list1.addAll(list2);
            list2.clear();
        }
        Collections.sort(list1);
        list1.stream().forEach(System.out::println);
    }

    @Test
    public void test2(){
        String res = multiply("2", "3");
        System.out.println(res);
    }

    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i=0; i<num1.length(); i++){
            for(int j=0; j<num2.length(); j++){
                int v1 = num1.charAt(i) - '0';
                int v2 = num2.charAt(j) - '0';
                int v = v1 * v2;
                int idx = i + j;
                if(v > 9){
                    add(res, idx, v % 10);
                    add(res, idx + 1, v / 10);
                } else {
                    add(res, idx, v);
                }
            }
        }
        res.reverse();
        return res.toString();
    }

    public void add(StringBuilder res, int idx, int v){
        if(res.length()-1 < idx){
            res.append((char)(v+'0'));
        } else {
            v = res.charAt(idx) - '0' + v;
            if(v > 9){
                res.setCharAt(idx, (char)(v%10 + '0'));
                add(res, idx+1, v/10);
            } else {
                res.setCharAt(idx, (char)(v + '0'));
            }
        }
    }

    @Test
    public void test3(){
        System.out.println(threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> values = Arrays.asList(nums[i], nums[j], nums[k]);
                        values.sort((v1,v2)->v1-v2);
                        list.add(values);
                    }
                }
            }
        }

        list.sort((l1, l2)->{
            if(l1.get(0) < l2.get(0)){
                return -1;
            } else if(l1.get(0) == l2.get(0)){
                if(l1.get(1) < l2.get(1)){
                    return -1;
                } else if(l1.get(1) == l2.get(1)){
                    if(l1.get(2) < l2.get(2)){
                        return -1;
                    } else if(l1.get(2) == l2.get(2)){
                        return 0;
                    } else{
                        return 1;
                    }
                } else{
                    return 1;
                }
            } else{
                return 1;
            }
        });

        if(list.size() < 2){
            return list;
        }

        Iterator<List<Integer>> it = list.iterator();
        List<Integer> values = it.next();
        int x1 = values.get(0);
        int x2 = values.get(1);
        int x3 = values.get(2);
        while(it.hasNext()){
            values = it.next();
            int y1 = values.get(0);
            int y2 = values.get(1);
            int y3 = values.get(2);
            if(x1 == y1 && x2 == y2 && x3 == y3){
                it.remove();
            } else {
                x1 = y1;
                x2 = y2;
                x3 = y3;
            }
        }
        return list;
    }
}
