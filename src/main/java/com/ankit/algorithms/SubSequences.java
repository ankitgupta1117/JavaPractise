package com.ankit.algorithms;


public class SubSequences {
    static int count = 0;

    private static void findSubSequences(String s){
        findRecursivly(s.toCharArray(), 0, s.length()-1);
    }

    private static void findRecursivly(char[] a, int i, int j){
        if(i==j){
            System.out.println(new StringBuffer().append(a));
            count++;
            return;
        }

        for(int p= i; p<=j; p++){
            swap(a, i,p);
            findRecursivly(a, i+1, j);
            swap(a,p,i);
        }
    }

    private static void swap(char[] a, int i, int p) {
        char tmp  = a[i];
        a[i] = a[p];
        a[p] = tmp;
    }

    public static void main(String[] args) {
        String input = "ABCD";
        findSubSequences(input);
        System.out.println(count);
    }
}


// A -> AB -> ABC  -> ABCD
//         -> ABD