package com.ankit.algorithms.recursion.hackerrank;

public class PowerSum {

    private int count=0;

    public void findSum(int x, int sum, int p){
//        x = x+1;
        int currSum = sum;
        if(currSum == p){
            count ++;
            return;
        }
        if(currSum > p){
            return;
        }
        while(currSum < p){
            x++;
            currSum = x*x + sum;
            findSum(x, currSum,p);

        }

    }

    public static void main(String[] args) {
        PowerSum p = new  PowerSum();
        p.findSum(0,0,100);
        System.out.println(p.count);
    }
}
