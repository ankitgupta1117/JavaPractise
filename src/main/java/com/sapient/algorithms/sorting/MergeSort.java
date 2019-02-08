package com.sapient.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args) {
        int a[] = { -23, -44, 50, 14, 28, 12, 5};
        mergeSort(a, 0, a.length);
        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    private static void mergeSort(int[] a, int start, int end){
        if(end - start  < 2){
            return;
        }

        int middle = (start + end)/2;

        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        merge(a, start, middle, end);
    }

    private static void merge(int a[], int start, int mid, int end){
        if(a[mid] >= a[mid-1]){
            return;
        }
        int tmp[] = new int[end-start];
        int tmpIndex = 0;
        int i=start;
        int j = mid;
        while (i<mid && j<end){
            if(a[i] >= a[j]){
                tmp[tmpIndex] = a[j];
                j++;
            }else{
                tmp[tmpIndex] = a[i];
                i++;
            }
            tmpIndex++;
        }

        if((i<mid) && j>=end){
            // copy remaining elements from right sub array
            System.arraycopy(a,i, tmp, tmpIndex, mid-i);
        }
        if(j>=end && i<mid){
            System.arraycopy(a,i, tmp, tmpIndex, end-j);
        }
//        System.arraycopy(a,i, a, start +tmpIndex, mid-i);
        System.arraycopy(tmp, 0 , a, start, tmp.length);
    }

}
