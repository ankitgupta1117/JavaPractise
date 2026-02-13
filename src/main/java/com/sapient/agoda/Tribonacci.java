package com.sapient.agoda;

public class Tribonacci {
    public static long[] mem;

    public static long trifibonacci(int n){
        if(n == 0 || n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;

        return trifibonacci(n-1) + trifibonacci(n-2) + trifibonacci(n-3);


    }

    public static void main(String[] args) {
//        System.out.println(trifibonacci(48));
//        System.out.println(trifibonacci_dp(48));
        System.out.println(trifibonacci_rec_mem(70));
    }

    public static long trifibonacci_dp(int n){
        if(n == 0 || n == 1)
            return 1;
        if(n == 2)
            return 2;

       long a = 1;
       long b = 1;
       long c = 2;

        for(int i = 3; i<=n;i++){
            long totalWays = a+b+c;
            a = b;
            b = c;
            c = totalWays;
        }
        return c;
    }

    public static long trifibonacci_rec_mem(int n){
        mem = new long[n+1];
       for(int i=0; i<mem.length; i++){
           mem[i] = -1;
       }
       return f(n);

    }

    public static long f(int n){
        if(n<0)
            return 0;
        if(n ==0)
            return 1;
        if(mem[n] != -1)
            return mem[n];

        mem[n] =  f(n-3) + f(n-2) + f(n-1);
        return mem[n];
    }








}
