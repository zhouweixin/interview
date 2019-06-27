package com.zhou.datastruct;

import junit.framework.TestCase;

import java.util.*;

public class MyList extends TestCase {

    /**
     * 删除重复节点：1->2->3->3->4->4->5
     *
     * @param head
     */
    public Node deleteDupNodes(Node head) {
        Map<String, Integer> value2num = new HashMap<>();
        // 1.计算节点个数
        Node temp = head;
        while (temp != null) {
            int num = value2num.getOrDefault(temp.value, 0) + 1;
            value2num.put(temp.value, num);
            temp = temp.next;
        }

        // 2.移动头节点(因为头节点可能被删除)
        while (head != null) {
            if (value2num.getOrDefault(head.value, 0) > 1) {
                head = head.next;
            } else {
                break;
            }
        }

        if (head == null) {
            return head;
        }

        Node preNode = head;
        temp = head.next;
        while (temp != null) {
            if (value2num.getOrDefault(temp.value, 0) > 1) {
                preNode.next = temp.next;
                temp = temp.next;
            } else {
                preNode = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    public Node createList() {
        Node root = new Node("1");

        Node node = root;
        node.next = new Node("1");
        node = node.next;
        node.next = new Node("2");
        node = node.next;
        node.next = new Node("3");
        node = node.next;
        node.next = new Node("3");
        node = node.next;
        node.next = new Node("4");
        node = node.next;
        node.next = new Node("5");
        node = node.next;
        node.next = new Node("6");
        node = node.next;
        node.next = new Node("6");

        return root;
    }

    public void print(Node root) {
        while (root != null) {
            System.out.print("->" + root.value);
            root = root.next;
        }
        System.out.println();
    }

    public void test1() {
        System.out.println("删除前：");
        Node root = createList();
        print(root);
        System.out.println("删除后：");
        root = deleteDupNodes(root);
        print(root);
    }

    public void test2() {
        String s = Integer.toBinaryString(-3);
        System.out.println(s);
    }

    /**
     * 队列：普通队列LinkedList和优先级队列PriorityQueue
     */
    public void testQueue() {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        PriorityQueue<Integer> q3 = new PriorityQueue<>();
        PriorityQueue<Integer> q4 = new PriorityQueue<>((v1, v2) -> v2 - v1);

        System.out.println("队列操作：入队顺序");
        System.out.print(2 + " ");
        System.out.print(1 + " ");
        System.out.print(3 + " ");
        System.out.println();

        q1.offer(2);
        q1.offer(1);
        q1.offer(3);

        q2.offer(2);
        q2.offer(1);
        q2.offer(3);

        q3.offer(2);
        q3.offer(1);
        q3.offer(3);

        q4.offer(2);
        q4.offer(1);
        q4.offer(3);

        System.out.println("LinkedList: 先进先出");
        while (!q1.isEmpty()) {
            System.out.print(q1.poll() + " ");
        }
        System.out.println();

        System.out.println("LinkedList: 后进先出");
        while (!q2.isEmpty()) {
            System.out.print(q2.pollLast() + " ");
        }
        System.out.println();

        System.out.println("PriorityQueue: 优先级出队(默认最小优先级高)");
        while (!q3.isEmpty()) {
            System.out.print(q3.poll() + " ");
        }
        System.out.println();

        System.out.println("PriorityQueue: 优先级出队(设置为最大优先级高)");
        while (!q4.isEmpty()) {
            System.out.print(q4.poll() + " ");
        }
        System.out.println();
    }



}
