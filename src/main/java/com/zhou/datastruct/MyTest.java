package com.zhou.datastruct;

import java.util.*;

public class MyTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(in.nextInt());
            }

            int max = 1;
            int min = 1;
            int delta = 0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    int v = list.get(j) - list.get(i);
                    if(delta < v){
                        delta = v;
                        max = list.get(j);
                        min = list.get(i);
                    }
                }
            }
            double d = 10000.0 / min * max;
            System.out.printf("%.2f\n", d);
        }
    }

    public static Map<TreeNode, List<Integer>> findPaths(TreeNode root){
        Map<TreeNode, List<Integer>> node2list = new HashMap<>();

        if(root == null){
            return node2list;
        }

        if(root.left == null && root.right == null){
            node2list.put(root, new ArrayList<>());
            return node2list;
        }

        if(root.left != null){
            Map<TreeNode, List<Integer>> left = findPaths(root.left);
            for(List<Integer> list: left.values()){
                list.add(0, -1);
            }
            node2list.putAll(left);
        }

        if(root.right != null){
            Map<TreeNode, List<Integer>> right = findPaths(root.right);
            for(List<Integer> list: right.values()){
                list.add(0, 1);
            }
            node2list.putAll(right);
        }

        return node2list;
    }

    static class TreeNode{
        int value;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int value){
            this.value = value;
        }

        TreeNode(TreeNode left, TreeNode right){
            this.left = left;
            this.right = right;
            this.value = left.value + right.value;
        }

        @Override
        public String toString(){
            return this.value + "";
        }
    }
}


