package com.sapient.algorithms.recursion.practise;

/**
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most
 * block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1].
 * A rat starts from source and has to reach the destination. The rat can move only in two
 * directions: forward and down.
 * In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the
 * path from source to destination. Note that this is a simple version of the typical Maze problem.
 *
 * For example, a more complex version can be that the rat can move in 4 directions and a more complex
 * version can be with a limited number of moves.
 */
public class RatMazeProblem {


    public static void main(String[] args) {
        int [][] inputMaze = {  {1, 0, 0, 0},
                                {1, 1, 0, 1},
                                {0, 1, 0, 0},
                                {1, 1, 1, 1}
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

    private static boolean findSolution(int[][] input, int[][] sol, int currX, int currY, int[] xMoves, int[] yMoves) {
        if(currX == input.length-1 && currY == input.length-1){
            return true;
        }
        for(int i=0; i<xMoves.length; i++){
            int nextX = currX + xMoves[i];
            int nextY = currY + yMoves[i];
            
            if(isValidMove(nextX,nextY, input)){
                sol[nextX][nextY] = 1;
                boolean ifSolution = findSolution(input, sol, nextX, nextY, xMoves, yMoves);
                if(ifSolution){
                    return true;
                }else{
                    sol[nextX] [nextY] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValidMove(int nextX, int nextY, int[][] input) {
        if(nextX < input.length && nextY < input.length && input[nextX][nextY] == 1){
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
