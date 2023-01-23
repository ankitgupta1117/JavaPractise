package com.ankit.algorithms.recursion.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {

    Map<Character, Integer> dedupMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new LongestSubsequence().getLongestSubseqLength("GEEKSFORGEEKS"));
    }

    private int getLongestSubseqLength(String str){
        char[] input = str.toCharArray();
        int maxlength =0;
        int start=0; int end = 0;
        for(int i=0; i<input.length; i++){
            end = i;
            if(dedupMap.getOrDefault(input[i], -1) == -1){
                dedupMap.put(input[i],1);
                maxlength = Math.max(maxlength, end-start+1);
            }else{
                dedupMap.clear();
                dedupMap.put(input[i],1);
                start = i;
            }
        }
        return maxlength;
    }


}
