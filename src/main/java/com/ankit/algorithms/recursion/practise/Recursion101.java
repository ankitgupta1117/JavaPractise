package com.ankit.algorithms.recursion.practise;

import java.util.Arrays;

public class Recursion101 {


    private static String reverse(String str){
        if(str.length() == 1){
            return str;
        }

        return reverse(str.substring(1,str.length())) + str.substring(0,1);
    }

    public static void main(String[] args) {
//        System.out.println(reverse("ankit"));
//        printArray(new int []{1,2,3,4,5,6,7,8,9});
//        doSum("147",0);
        System.out.println(doSum1("147"));
    }

    private static void printArray(int[] a){

        if(a.length>0){
            System.out.println(a[0]);
            int[] arr = Arrays.copyOfRange(a,1,a.length);
            printArray(arr);
        }
    }


    private static void doSum(String s, long sum){

        while( s.length() >1) {
            sum = sum + Integer.parseInt(s.substring(0,1));
            s = s.substring(1);
            doSum( s,sum);
        }
        if(s.length() == 0){
            System.out.println(sum);
            return ;
        }
    }


    private static long doSum1(String a){
        if(a.length() ==1){
            return Long.parseLong(a);
        }
        return Long.parseLong(a.substring(0,1)) + doSum1(a.substring(1));
    }
}
