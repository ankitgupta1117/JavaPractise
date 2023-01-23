package com.ankit.algorithms.recursion.practise;

public class Backtracking {

    public boolean findSolution(int x, int y, int p, int q){
        if(x == p && y==q){
            return true;
        }
        if(x > p || y>q){
            return false;
        }

        boolean isSolution = findSolution(x+y, y ,p,q);
        if(isSolution){
            return true;
        }

        isSolution = findSolution(x,x+y,p,q);
        if(isSolution){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        boolean b = new Backtracking().findSolution(2,3, 5,7);
        System.out.println(b);

    }
}
