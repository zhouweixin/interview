package com.zhou.datastruct;

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label + "";
    }

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        RandomListNode p1 = pHead;
        while(p1 != null){
            RandomListNode node = new RandomListNode(p1.label);
            node.next = p1.next;
            p1.next = node;
            p1 = p1.next.next;
        }

        p1 = pHead;
        while(p1 != null){
            if(p1.random != null)
                p1.next.random = p1.random.next;
            p1 = p1.next.next;
        }

        pHead = pHead.next;
        p1 = pHead;
        while(p1 != null && p1.next != null){
            p1.next = p1.next.next;
            p1 = p1.next;
        }
        return pHead;
    }
}
