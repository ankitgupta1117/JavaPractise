package com.sapient.datastructures.tree.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryHeap {

    private int [] heap;
    private int size;

    public BinaryHeap(int capacity) {
        this.size = 0;
        heap = new int[capacity];
    }

    public void insert(int value){
        if(size == heap.length){
            throw new IllegalArgumentException("Heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public void delete(int index){
        if(size == 0){
            throw new IllegalArgumentException("Heap is empty");
        }
        if(index >= size){
            throw new IllegalArgumentException("Index Out of heap");
        }
        heap[index] = heap[size-1];
        size--;
        if(heap[index] > heap[getParentIndex(index)]){
            fixHeapAbove(index);
        }else{
            fixHeapBelow(index);
        }
    }


    private void fixHeapBelow(int index){
        int leftChildIdx  = getChildIndex(index, true);
        int rightChildIdx  = getChildIndex(index, false);
        if(leftChildIdx < size){
            int toBeswappedIndex  = leftChildIdx;
            if(rightChildIdx < size){
                // find max
                if(heap[rightChildIdx] > heap[leftChildIdx]){
                    toBeswappedIndex = rightChildIdx;
                }
            }
            //swap
            if(heap[index] < heap[toBeswappedIndex]){
                swapValues(index, toBeswappedIndex);
            }

        }
    }

    private int getChildIndex(int index, boolean isLeftChild){
        return (isLeftChild) ? 2*index+1 : 2*index+2;
    }

    private void fixHeapAbove(int index){
        int parentIndex  = getParentIndex(index);
        if(heap[index] <= heap[parentIndex]){
            return;
        }

        if(heap[index] > heap[parentIndex]){
            swapValues(parentIndex, index);
            fixHeapAbove(parentIndex);
        }

    }

    private void swapValues(int srcIndex, int trgtIndex){
        int tmp = heap[trgtIndex];
        heap[trgtIndex] = heap[srcIndex];
        heap[srcIndex]  =tmp;
    }

    private int getParentIndex(int index){
        return (index -1)/2;
    }

    public static void main(String[] args) {
        BinaryHeap h = new BinaryHeap(10);
        h.insert(11);
        h.insert(0);
        h.insert(9);
        h.insert(12);
        h.insert(7);
        String s = Arrays.stream(h.heap).mapToObj(Integer::toString).collect(Collectors.joining(","));
        System.out.println(s);
//        h.delete(0);
        BinaryHeap h1 = new BinaryHeap(10);
        h1.sort(11,0,9,12,7);
        s = Arrays.stream(h1.heap).mapToObj(Integer::toString).collect(Collectors.joining(","));
        System.out.println(s);
    }

    public void sort(int... ar){
        Arrays.stream(ar).forEach(this::insert);
        for(int i=size; i>1; i--){
            swapValues(0,i-1);
            size--;
            fixHeapBelow(0);
        }
    }
}
