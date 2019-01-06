package com.sapient.datastructures.hackerRank;

import java.io.IOException;
import java.util.Scanner;

/**
 * Find the number of ways that a given integer, X , can be expressed as the sum of the Nth powers of unique, natural numbers.
 *
 * For example, if X=13 and N=2, we have to find all combinations of unique squares adding up to 13. The only solution is 2^2 + 3^2.
 *
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 */
public class PowerSum {

    private static int powerSum(int x, int n) {
        return pSumRecursive(x,n,0,1);
    }

    private static int pSumRecursive(int x, int n, int curr_Sum, int curr_Num){
        System.out.println("Called for curr_Sum = "+ curr_Sum + "curr_Num = "+ curr_Num );
        int result = 0;
        int p = pow(curr_Num, n);

        while(curr_Sum + p < x){
            System.out.println("    While started for curr_Sum = "+ curr_Sum + "curr_Num = "+ curr_Num +" p="+p);
            result = result + pSumRecursive(x,n,curr_Sum + p, curr_Num+1);
            curr_Num++;
            System.out.println("    Intermenting to cuttnum = "+curr_Num);
            p = pow(curr_Num, n);
        }
        if(curr_Sum + p  == x){
            System.out.println("Ankswer: "+curr_Num+","+curr_Sum);
            result++;
        }
        System.out.println("result = "+result+"  curr_Sum = "+ curr_Sum + "curr_Num = "+ curr_Num );
        return result;
    }


    private static int pow(int val, int pow){
        return (int) Math.pow((double)val,(double)pow);
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        System.out.println(result);


        scanner.close();
    }
}
