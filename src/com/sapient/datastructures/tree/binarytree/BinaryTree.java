package com.sapient.datastructures.tree.binarytree;

import java.util.HashMap;

public class BinaryTree {

    private Node root;

    public void insert(int data){
        if( root == null){
            root = new Node(data, null, null);
        }else{
            root.insert(data);
        }



    }

    public void inOrderTraversal(){

    }





    private static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void insert(int data) {

            if(data == this.data){
                return;
            }
            if(data < this.data){
                if(this.left == null){
                    this.left = new Node(data, null, null);
                }else{
                    this.left.insert(data);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(data, null, null);
                }else{
                    this.right.insert(data);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(1);
        tree.insert(99);
        tree.insert(23);
        tree.insert(32);
        tree.insert(15);
        tree.insert(19);
        tree.insert(38);
        tree.inOrderTraversal();
    }

}
