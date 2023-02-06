package com.example;

import java.util.Iterator;

public class lessonhw2 {
    public static class ListNode implements Iterable<Integer> {
        int val;
        ListNode next;
        
        ListNode() {
            this.next = null;
        }
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext(){
                    return false;
                }

                @Override
                public Integer next(){
                    next = ListNode.this.next.next;
                    return null;
                }
            };
        }

        public ListNode addFirst(int value) {
            return new ListNode(value,this);
        }

        public ListNode removeFirst(ListNode node){
            return this.next;
        }

        public ListNode reverse(){
            ListNode revers = new ListNode();
            ListNode now = this;
            while(now.next!=null){
                revers = revers.addFirst(now.val);
                now = now.next;
            }
            return revers;
        }
    }

    public static void main(String[] args) {
        ListNode nListNode = new ListNode(0);
        for(int i = 1; i<10;i++){
            nListNode = nListNode.addFirst(i);
        }
        ListNode now = nListNode;
        while(now.next!=null){
            System.out.printf("%d ", now.val);
            now = now.next;
        }
        
        ListNode rev = nListNode.reverse();
        while(rev.next!=null){
            System.out.printf("%d ", rev.val);
            rev = rev.next;
        }
    }
}
