package com.ankit.algorithms.recursion.practise;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(9));
        System.out.println(Integer.MAX_VALUE);
    }

    private static BigInteger fact(long n){
        if(n == 1 ) return  BigInteger.ONE;

        return BigInteger.valueOf(n).multiply(fact(n-1));
    }
}
