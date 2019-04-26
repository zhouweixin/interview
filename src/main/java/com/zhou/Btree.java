package com.zhou;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的操作
 */
public class Btree extends TestCase {
    private String str = "ABD*G**E**CF***";
    private int idx = 0;

    /**
     * 1.创建二叉树
     */
    public Node createBinaryTree(String s) {
        if(s == null){
            s = str;
        }
        String value = s.charAt(idx++) + "";

        if (value.equals("*")) {
            return null;
        }

        Node root = new Node(value);
        root.left = createBinaryTree(s);
        root.right = createBinaryTree(s);
        return root;
    }

    /**
     * 2.先序遍历
     *
     * @param root
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 3.中序遍历
     *
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value);
            inOrder(root.right);
        }
    }

    /**
     * 4.后序遍历
     *
     * @param root
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value);
        }
    }

    /**
     * 5.前序遍历(非递归):
     *  1.出栈访问
     *  2.右节点入栈
     *  3.左节点入栈
     *
     * @param root
     */
    public void dfsPreOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 6.中序遍历(非递归)：
     *  1.左节点一直入栈
     *  2.出栈访问，设置当前节点为右节点
     *
     * @param root
     */
    public void dfsInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.value);
                node = node.right;
            }
        }
    }

    /**
     * 7.后序遍历(非递归)：
     *  1.左节点一直入栈
     *  2.出栈，如果右节点为空或右节点为上次访问的节点，则访问；否则，重新入栈，设置当前节点为右节点
     *
     * @param root
     */
    public void dfsPostOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node lastNode = null;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if(node.right == null || node.right == lastNode) {
                    System.out.print(node.value);
                    lastNode = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
    }

    /**
     * 8.广度优先遍历
     *
     * @param root
     */
    public void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 9.求二叉树的最大高度
     *
     * @param root
     */
    public int getMaxDepth(Node root){
        if(root == null){
            return 0;
        }

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 10.求二叉树的最小高度
     *
     * @param root
     */
    public int getMinDepth(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        if(root.left != null && root.right == null){
            return 1 + getMinDepth(root.left);
        }

        if(root.left == null && root.right != null){
            return 1 + getMinDepth(root.right);
        }

        return 1 + Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }

    /**
     * 11.判断root2是root1的子树
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree(Node root1,Node root2) {
        if(root2 == null || root1 == null){
            return false;
        }

        if(root1.value.equals(root2.value)){
            boolean bl = false;
            boolean br = false;
            if(root2.left == null){
                bl = true;
            } else {
                bl = hasSubtree(root1.left, root2.left);
            }
            if(root2.right == null){
                br = true;
            } else {
                br = hasSubtree(root1.right, root2.right);
            }
            if(bl && br){
                return true;
            }
        }

        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }
    public void test2(){
        isValid("()");
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }

                char c1 = stack.pop();
                String cc = c + "" + c1;
                if(cc.equals("()")){
                    return true;
                }
                if(cc.equals("()") || cc.equals("[]") || cc.equals("{}")){

                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public void test1() {
        System.out.print("1.创建二叉树：" + str);
        Node root = createBinaryTree(null);
        System.out.print("\n2.先序遍历：");
        preOrder(root);
        System.out.print("\n3.中序遍历：");
        inOrder(root);
        System.out.print("\n4.后序遍历：");
        postOrder(root);
        System.out.print("\n5.先序遍历(非递归)：");
        dfsPreOrder(root);
        System.out.print("\n6.中序遍历(非递归)：");
        dfsInOrder(root);
        System.out.print("\n7.后序遍历(非递归)：");
        dfsPostOrder(root);
        System.out.print("\n8.广度优先遍历：");
        bfs(root);
        System.out.print("\n9.求二叉树的最大高度：" + getMaxDepth(root));
        System.out.print("\n10.求二叉树的最小高度：" + getMinDepth(root));

        idx = 0;
        Node root1 = createBinaryTree("ABD**E**C**");
        idx = 0;
        Node root2 = createBinaryTree("BD**E**");
        System.out.print("\n11.root2是root1的子树：" + hasSubtree(root1, root2));
    }
}
