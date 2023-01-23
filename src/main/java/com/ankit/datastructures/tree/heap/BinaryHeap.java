package com.ankit.datastructures.tree.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryHeap {

    public int[] getData() {
        return data;
    }

    private int[] data = new int[10];
    private int heapSize = 0;
    public static void main(String[] args) throws IllegalAccessException {
        int[] input = {6,3,52,9,12, 10};
        BinaryHeap heap = new BinaryHeap();
        Arrays.stream(input)
                .forEach( a -> heap.insert(a));
        String str = Arrays.stream(heap.getData())
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
        System.out.println(str);

        heap.poll();
        str = Arrays.stream(heap.getData())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(str);

    }

    public void insert(int a){
        if(data.length == heapSize){
            //increase Size
        }else{
            data[heapSize] = a;
            heapifyUp(heapSize);
            heapSize++;
        }
    }

    public void poll() throws IllegalAccessException {
        swap(0, heapSize-1);
        this.heapifyDown(0);
    }

    private void heapifyUp(int idx) {
        if(idx == 0) return;
        int parentIdx = this.getParent(idx);
        if(data[idx] > data[parentIdx]){
            swap(parentIdx, idx);
            heapifyUp(parentIdx);
        }
    }

    private void heapifyDown(int root) throws IllegalAccessException {
       if(hasChildren(root) ){
           int leftChild = this.getLeftChild(root);
           if(data[leftChild] > data[root]){
               swap(root, leftChild);
               heapifyDown(leftChild);
           }
           int rightChild = this.getRightChild(root);
           if(data[rightChild] > data[root]){
               swap(root, rightChild);
               heapifyDown(rightChild);
           }
       }
    }

    private void swap(int a, int b){
        int tmp = data[b];
        data[b] =  data[a];
        data[a] = tmp;
    }

    public int getParent(int index){
        if (index == 0)
            return 0;
        return (index-1)/2;
    }

    private int getLeftChild(int index) throws IllegalAccessException {
        if(this.hasLeftChild(index)){
            return 2*index +1;
        }else{
            throw new IllegalAccessException();
        }
    }

    private boolean hasLeftChild(int index){
        int leftChildIdx = 2*index +1;
        return (leftChildIdx <= this.heapSize);
    }

    private int getRightChild(int index) throws IllegalAccessException {
        if(this.hasRightChild(index)){
            return 2*index +2;
        }else{
            throw new IllegalAccessException();
        }
    }

    private boolean hasRightChild(int index){
        int rightChildIdx = 2*index +2;
        return (rightChildIdx <= this.heapSize);
    }

    private boolean hasChildren(int index){
        return this.hasLeftChild(index) || this.hasRightChild(index);
    }

}
