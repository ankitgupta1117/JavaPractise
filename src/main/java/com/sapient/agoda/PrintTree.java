package com.sapient.agoda;

import java.util.Arrays;

public class PrintTree {


    public static void print(int[][] input){
        int height = input.length;
        int width = input[0].length;
        for(int level = 0 ; level<height; level++){
            char[] branch = new char[width];
            char[] main = new char[width];

            if(level <height-1){
                Arrays.fill(branch, ' ');
            }
            for(int col =0 ; col<width; col++){
                int val = input[level][col];
                if(val == 0){
                    main[col] = ' ';
                }else{
                    main[col] = (char)val;
                    if(level<height-1){
                        int left = col-1;
                        int right = col+1;
                        if(left >=0 && input[level+1][left] !=0){
                            branch[left] = '/';
                        }
                        if(right <width && input[level+1][right] !=0){
                            branch[right] = '\\';
                        }
                    }
                }
            }
            System.out.println();

        }
    }
}
