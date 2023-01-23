package com.ankit.datastructures.hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class SuperDigit {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the superDigit function below.
    private static int superDigit(String n, int k) {
        String head = n.substring(0, n.length()/2) ;
        String foot = n.substring(n.length()/2);
        int a = findSuperDigit( findSuperDigit(head) + findSuperDigit(foot) +"");
        return findSuperDigit(String.valueOf(a * k));
    }

    private static int findSuperDigit(String s){
        if(s.length() == 1){
            return (int)Long.parseLong(s);
        }
        return findSuperDigit(String.valueOf(doSum(s)));
    }

    private static int doSum(String a){
        int sum = 0;
        for(char c : a.toCharArray()){
            sum += Integer.parseInt(Character.toString(c));
        }

        return sum;
    }


    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(result);
        scanner.close();
    }
}
