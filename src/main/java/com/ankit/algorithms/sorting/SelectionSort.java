package com.ankit.algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {9,5,6,1,11,10};
        print(arr);
        for(int lastSortedIndex = arr.length-1; lastSortedIndex >0; lastSortedIndex--){
            int maxElementIndex = 0;
            for(int i=1; i<=lastSortedIndex; i++){
                if(arr[maxElementIndex] < arr[i]){
                    maxElementIndex = i;
                }
            }
            swap(arr, maxElementIndex, lastSortedIndex);
        }

        print(arr);

    }

    public static void swap(int[] a, int i, int j){
        if(i==j)
            return;

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void print(int[] a){
        System.out.print("[");
        for(int i=0; i<a.length; i++){
            System.out.print(" " +a[i]);
        }
        System.out.println("]");
    }
}
