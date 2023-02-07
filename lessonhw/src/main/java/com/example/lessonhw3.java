package com.example;

import java.util.Objects;

public class lessonhw3 {
    public class Tree<T extends Comparable<T>> {

        private Node root;
    
        private class Node {
            private T value;
            private Node left;
            private Node right;
    
            public Node(T value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }
    
        public void add(T value) {
            Objects.requireNonNull(value);
            root = appendNode(root, value);
        }
    
        private Node appendNode(Node current, T value) {
            if (current == null) {
                return new Node(value);
            }
    
            int compare = value.compareTo(current.value);
            if (compare < 0) {
                current.left = appendNode(current.left, value);
            } else if (compare > 0) {
                current.right = appendNode(current.right, value);
            }
    
            return current;
        }
    
        public boolean contains(Node point,T value) {
            Node now = point;
            int compare = value.compareTo(now.value);
            if(compare == 0)
            {
                return true;                    
            }
            else 
            if((now.left==null)&&(now.right==null))
            {  
                return false;
            }
            if(now.left!=null)
                {
                    return contains(now.left,value);
                }
            if(now.right!=null)
                {
                    return contains(now.right,value);
                }
            throw new UnsupportedOperationException();
        }
    }
    public static void main(String[] args) {
        
    }
}
