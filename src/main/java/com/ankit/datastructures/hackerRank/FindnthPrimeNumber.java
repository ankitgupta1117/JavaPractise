package com.ankit.datastructures.hackerRank;

import java.util.*;

public class FindnthPrimeNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> inputList = new ArrayList<>();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            inputList.add(n);
        }
        long startTime = System.currentTimeMillis();
        int tmp = inputList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Time taken to find max : "+ (System.currentTimeMillis() - startTime) );
        long startFindPrime = System.currentTimeMillis();
        List<Integer> primeNumbers = findAllPrimesTill(tmp);
        long endFindPrime = System.currentTimeMillis();
        inputList.forEach( i -> System.out.println(primeNumbers.get(i-1)));
        System.out.println("TIme taken to find all Primes: "+ (endFindPrime - startFindPrime) + " millis");
        System.out.println("Total Time taken: "+ (System.currentTimeMillis() - startTime) + " millis");
    }
    private static List<Integer> findAllPrimesTill(int limit){
        int num = 1;
        List<Integer> primeNumList = new ArrayList(limit);
        while(primeNumList.size() != limit){
            if(isPrime(num)){
                primeNumList.add(num);
            }
            num++;
        }
        return primeNumList;
    }

    private static boolean isPrime(int i){
        if(i ==1){
            return false;
        }
        if(i==2){
            return true;
        }
        for( int n=2; n < Math.sqrt(i)+1; n ++){
            if(i % n == 0){
                return false;
            }
        }
        return  true;
    }




}