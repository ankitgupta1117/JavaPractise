package com.sapient.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {


    public static void main(String[] args) {
        int a[] = {2,18,-12,34,14,28,12};
        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(",")));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }
    private static void quickSort(int[] a, int start, int end) {

        if(end <=start){
            return;
        }
        int pivot = (start+ end)/2;
        int i = partition(a, start, end, pivot);
        quickSort(a,start,i-1);
        quickSort(a,i, end);
    }

    private static int partition(int[]a, int i, int j, int pivotIdx){
        int pivot = a[pivotIdx];
        while(i<=j){

            while(a[i]<pivot) {
                i++;
            }
            while(a[j] > pivot){
                j--;
            }

            if(i<=j){
                swap(a,i,j);
                i++;
                j--;
            }
        }
        return i;
    }

    private static void swap(int[] a, int s, int t) {
        int tmp = a[s];
        a[s]= a[t];
        a[t] = tmp;
    }

}
