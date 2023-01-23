package com.ankit.datastructures.hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int count=0;
        Arrays.sort(arr);
        for(int i =0; i<arr.length; i++){
            int d1= arr[i]+k;
            int d2 = arr[i]-k;
            if(d1 > 0 && Arrays.binarySearch(arr, i, arr.length, d1) > 0){
                count ++;
            }
            if(d2 > 0 && Arrays.binarySearch(arr, i, arr.length, d2) > 0){
                count ++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];
        Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder());
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        long start = System.currentTimeMillis();
        int result = pairs(k, arr);
        System.out.println("Time taken : "+ (System.currentTimeMillis() - start));
        System.out.println(result);

        scanner.close();
    }
}
