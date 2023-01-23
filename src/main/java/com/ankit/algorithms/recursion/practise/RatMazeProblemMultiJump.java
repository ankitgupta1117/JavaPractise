package com.ankit.algorithms.recursion.practise;

public class RatMazeProblemMultiJump {

    public static void main(String[] args) {
        int [][] inputMaze = {  {2, 1, 0, 0},
                                {3, 0, 0, 1},
                                {0, 1, 0, 1},
                                {0, 0, 0, 1}
        };
        int[][] sol = { {1, 0, 0 ,0},
                        {0 ,0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
        };
        int[] xMoves = {1,0};
        int[] yMoves = {0, 1};
        if(findSolution(inputMaze, sol, 0, 0,xMoves, yMoves)){
            printSolution(sol);
        }else{
            System.out.println("No Solution found");
        }

    }

    private static boolean findSolution(int[][] inputMaze, int[][] sol, int currX, int currY, int[] xMoves, int[] yMoves) {
        if(currX == inputMaze.length-1 && currY == inputMaze.length-1){
            return true;
        }

        for(int i=0; i < xMoves.length; i++){
            for(int j=1; j<= inputMaze[currX][currY]; j++){
                int nextX = currX + (xMoves[i] * j);
                int nextY = currY + (yMoves[i] * j);
                if(isValidMove(nextX, nextY, inputMaze)){
                    sol[nextX][nextY] = 1;
                    if(findSolution(inputMaze, sol, nextX, nextY, xMoves, yMoves)){
                        return true;
                    }else{
                        sol[nextX][nextY] = 0;
                    }
                }
            }
        }

        return false;
    }


    private static boolean isValidMove(int nextX, int nextY, int[][] input) {
        if(nextX < input.length && nextY < input.length && input[nextX][nextY] > 0){
            return true;
        }else{
            return false;
        }
    }

    private static void printSolution(int [][]sol){
        for(int i=0; i<sol.length; i++){
            for(int j=0; j<sol[i].length; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
}
