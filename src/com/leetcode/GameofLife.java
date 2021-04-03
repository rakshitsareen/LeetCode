package com.leetcode;

public class GameofLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[] neighbors = {0,1,-1};
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                int liveNeighbors = 0;
                for(int r = 0; r < 3; r++){
                    for(int c = 0; c < 3; ++c){
                        if(!(neighbors[r] == 0 && neighbors[c] == 0)){
                            int row = i + neighbors[r];
                            int col = j + neighbors[c];
                            if((row >= 0 && row < rows) && (col >= 0 && col < cols) && Math.abs(board[row][col]) == 1){
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3 ))
                    board[i][j] = -1;
                if(board[i][j] == 0 && liveNeighbors == 3) board[i][j] = 2;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}
