package com.ankit.algorithms.recursion.practise;

public class NQueeensProblem {

    private static boolean solve(int queen, char [][] board){
//        System.out.println("Finding solution for "+queen+"queen");
        if(queen == board.length){
            return true;
        }
        for(int i=0; i<board.length; i++){
            if(isPositionCorrect(i, queen, board)){
                board[i][queen] = '0';
                boolean isSolved = solve(queen+1, board);
                if(!isSolved){
                    //Backtrack
//                    System.out.println("Backtracing for "+queen+"queen");
                    board[i][queen] = '*';
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPositionCorrect(int row, int queen, char[][] board) {
        for(int p=0; p<board.length; p++){
            if(p==queen){
                continue;
            }
            if(board[row][p] == '0'){
                return false;
            }
            int tmp = row  - Math.abs(p-queen);
            if(tmp >= 0){
                if(board[tmp][p] == '0'){
                    return false;
                }
            }

            tmp = row  + Math.abs(p-queen);
            if(tmp < board.length){
                if(board[tmp][p] =='0'){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int totalQueens = 30;
        char[][] board = new char[totalQueens][totalQueens];
        initBoard(board);
        long start = System.currentTimeMillis();
        boolean b = solve(0, board);
        long end = System.currentTimeMillis();
        if(b)
            printBoard(board);
        else
            System.out.println(b);
        System.out.println( "Time Taken in millis : "+(end-start));
        /*for(int i=0; i<4; i++){
            initBoard(board);
            board[1][0] = '0';
            board[3][1] = '0';
            board[0][2] = '0';
            System.out.println(isPositionCorrect(i, 3, board));
            board[i][3] = '0';
            printBoard(board);
        }*/


    }

    private static void initBoard(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length;j++){
                board[i][j] = '*';
            }
        }
    }

    private static void printBoard(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
