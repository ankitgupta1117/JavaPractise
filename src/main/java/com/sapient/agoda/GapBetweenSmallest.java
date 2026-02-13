package com.sapient.agoda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GapBetweenSmallest {


    public static int[] solution(int[] a){
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[a.length];
        for(int i=a.length-1; i>=0 ; i--){
            int num = a[i];

            while(!stack.empty()&& stack.peek() >= num){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = 0;
                stack.push(num);
                map.put(num, i);
            }else if(stack.peek() < num){
                map.put(num, i);
                result[i] = map.get(stack.peek()) - i;
                stack.push(num);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] sol = solution(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(sol));
    }
}
