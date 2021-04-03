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

/*

If the input file is 1 TB, I can't read it into the memory entirely, so I want to read it line by line, is this correct? Thank you!

#Game of Life
from copy import deepcopy

def findLives(live):
    count = collections.Counter()
    for i, j in live:
        for x in range(i-1, i+2):
            for y in range(j-1, j+2):
                if x == i and y == j:
                    continue
                count[x, y] += 1
    result = {}
    for i, j in count:
        if count[i, j] == 3:
            result.add((i, j))
        elif count[i, j] == 2 and (i, j) in live:
            result.add((i, j))
    return result

def updateBoard(board):
    live = {(i, j) for i, row in enumerate(board) for j, v in enumerate(row) if v == 1}
    live = findLives(live)
    for r, row in enumerate(board):
        for c, v in enumerate(row):
            board[r][c] = int((r, c) in live)
    for row in board:
        print(" ".join(row))

with open("input.txt") as f1:
    prev = f1.readline()
    pointer = f1.readline()
    cur = next_ = None
    while pointer:
        if not cur:
            cur = pointer
            pointer = f1.readline()
            continue

        if next_ == None:
            next_ = pointer
            pointer = f1.readline()
        if prev == None:
            tmpBoard = [ cur, next_]
            nextStateBoard = updateBoard(tmpBoard)
        else:
            tmpBoard = [deepcopy(prev), cur, next_]
            nextStateBoard =  updateBoard(tmpBoard)

        prev = cur
        cur = next_
        next_ = None

 */
