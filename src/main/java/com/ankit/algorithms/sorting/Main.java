package com.ankit.algorithms.sorting;

public class Main {
    public static void main(String [] args){
        int[] a = { 3,50, 2,1,-33, 7, 43};
        int sortedIdx = 0;
        for(int i=sortedIdx+1; i < a.length; i++){
            if(a[sortedIdx] > a[i]){
                int tmp = a[i];
                for(int b=sortedIdx; b>=0; b--){
                    if(b == 0){
                        a[b+1] = a[b];
                        a[b] = tmp;
                        break;
                    }
                    if(a[b]> tmp)
                        a[b+1] = a[b];
                    else {
                        a[b + 1] = tmp;
                        break;
                    }
                }
            }
            sortedIdx++;
        }
        print(a);
    }


    public static void print(int[] a){
        System.out.print("[");
        for(int i=0; i<a.length; i++){
            System.out.print(" " +a[i]);
        }
        System.out.println("]");
    }
}
