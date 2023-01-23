package com.ankit.algorithms.recursion.practise;

public class PrintNumbers {

    public static void main(String[] args) {
        System.out.println("Printing first 10 numbers in descending order with Tail Recursion");
        printNumberTailRec(10);
        System.out.println("");
        System.out.println("Printing first 10 numbers in ascending order with Head Recursion");
        printNumberHeadRec(10);
    }
    private static void printNumberTailRec(int n){
        if(n == 0) return ;
        System.out.print(n +" ");
        printNumberTailRec(n-1);
    }

    private static void printNumberHeadRec(int n){
        if(n == 0) return ;
        printNumberHeadRec(n-1);
        System.out.print(n + " ");
    }




}


