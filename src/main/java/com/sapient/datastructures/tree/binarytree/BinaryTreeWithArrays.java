package com.sapient.datastructures.tree.binarytree;

public class BinaryTreeWithArrays {

    int[] tree;

    public BinaryTreeWithArrays(int[] tree) {
        this.tree = tree;
    }

    public void printTree(int[] tree){

    }

    public void addChild(int child, int parent){

    }

    private int search(int input, int currentNodeIndex){
        if(tree == null ||tree.length == 0 || !nodeExists(currentNodeIndex))
            return -1;

        if(tree[currentNodeIndex] == input)
            return currentNodeIndex;

        int indexFromLeft = search(input, getLeftChildIndex(currentNodeIndex));
        if(indexFromLeft != -1)
            return indexFromLeft;

        return search(input, getRightChildIndex(currentNodeIndex));
    }

    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }

    private boolean nodeExists(int nodeIndex){
        return (tree.length) >= nodeIndex+1;
    }

    public static void main(String[] args) {
        BinaryTreeWithArrays bt = new BinaryTreeWithArrays(new int[] {1,2,3,4,5,6,7,8,9});
        System.out.println(bt.search(8, 0) + " : 7");
        System.out.println(bt.search(5, 0) + " : 4");
        System.out.println(new BinaryTreeWithArrays(new int[] {}).search(8, 0)+ " : -1");
        System.out.println(new BinaryTreeWithArrays(null).search(8, 0)+ " : -1");

    }

}
