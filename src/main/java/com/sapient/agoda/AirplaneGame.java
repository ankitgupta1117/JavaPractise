package com.sapient.agoda;

import java.util.Arrays;

public class AirplaneGame {

    public static int calculate(int[] height, int[] speed){
        int[] time = new int[height.length];
        for(int h=0; h<height.length; h++){
            time[h] = (int)Math.ceil((double)height[h]/speed[h]);
        }

        Arrays.sort(time);
        int count = 0;
        for(int i=0; i<time.length; i++){
            if(i<time[i]){
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(calculate(new int[] {1,3,5,4,8}, new int[] {1,2,2,1,2}));
    }
}
