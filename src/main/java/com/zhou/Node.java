package com.zhou;

public class Node {
    public String value;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }
}
