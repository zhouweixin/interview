package com.zhou.datastruct;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTree extends TestCase {
    public void test1(){
        TreeNode root = create(Arrays.asList(9, 5, 7, 6, 8, 4, 10));
        printTree(root);
        root = convert(root);
        printList(root);
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        TreeNode p1 = pRootOfTree;
        TreeNode p2 = pRootOfTree.left;
        TreeNode p3;
        while(p2 != null){
            p3 = p2.right;
            while(p3 != null){
                // 左旋
                p1.left = p3;
                p2.right = p3.left;
                p3.left = p2;

                p2 = p3;
                p3 = p3.right;
            }
            p2.right = p1;

            p1 = p2;
            p2 = p2.left;
        }

        p1 = pRootOfTree;
        p2 = pRootOfTree.right;
        while(p2 != null){
            p3 = p2.left;
            while(p3 != null){
                // 右旋
                p1.right = p3;
                p2.left = p3.right;
                p3.right = p2;

                p2 = p3;
                p3 = p3.left;
            }
            p2.left = p1;

            p1 = p2;
            p2 = p2.right;
        }

        p1 = pRootOfTree;
        while(p1.left != null){
            p1 = p1.left;
        }
        return p1;
    }

    public void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
    }

    public void printList(TreeNode root) {
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }

    public TreeNode create(List<Integer> list){
        if(list == null || list.size() == 0){
            return null;
        }

        TreeNode root = new TreeNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            TreeNode p = root;
            while(true) {
                if (val < p.val) {
                    if (p.left == null) {
                        p.left = new TreeNode(val);
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    if (p.right == null) {
                        p.right = new TreeNode(val);
                        break;
                    } else {
                        p = p.right;
                    }
                }
            }
        }
        return root;
    }


}
