package com.sapient.agoda;

public class Pivot {


    public static int findPivots(int[] a){
        int count = 0;
        int n = a.length;
        int[] prefix = new int[n];
        prefix[0] = a[0];
        for(int i=1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], a[i]);
        }

        int[] suffix = new int[n];
        suffix[n-1] = a[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.min(a[i], suffix[i+1]);
        }

        for(int i=0; i<n; i++){
            if( (prefix[i] == a[i])  && (suffix[i] == a[i])){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPivots(new int[]{2,1,3,4,7,5,6,8}));
    }
}
