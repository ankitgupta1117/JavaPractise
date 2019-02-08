package com.sapient.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {-13, 34,9,22,-25,90,45};
        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(",")));
        sort1(a);
        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(",")));

    }

    private static void sort1(int[] a){
        for(int usi = 1; usi<a.length; usi++){
            int e = a[usi];
            int i;
            for(i=usi; i>0 && a[i-1] >e ; i--){
                    a[i] = a[i-1];
            }
            a[i]=e;
        }
    }



    private static void sort(int[]a){
        int sortedPartIndx = 0;

        for(int i=sortedPartIndx+1; i<a.length; i++ ){
            int e = a[i];
            for(int j=i; j>0; j--){
                if(a[j-1]>a[j]){
                    swap(a, j-1 ,j );
                }
            }
            sortedPartIndx++;
        }

    }

    private static void swap(int[] a, int src, int trgt){
        int e = a[src];
        a[src] = a[trgt];
        a[trgt] = e;
    }

}
