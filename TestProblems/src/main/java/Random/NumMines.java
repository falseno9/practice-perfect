package Random;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class NumMines {

    static class Board {

        private int rows = 3;
        private int cols = 3;
        private int[][] board;

        Board(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.board = new int[rows][cols];
            intializeBoard();
        }

        public int getRow(int index) {
            return index / cols;
        }

        public int getCol(int index) {
            return index % cols;
        }

        /*
        0 1 2 3 4
        5 6 7 8 9
        ...
        */
        public int getIndex(int row, int col) {
            return col + cols * row;
        }

        public void intializeBoard() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    board[i][j] = 0;
                }
            }
        }

        public void printBoard() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
            }
        }

        public void placeMines(int numMines) {

            List<Integer> minesIndexes = new ArrayList<Integer>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    minesIndexes.add(getIndex(i, j));
                }
            }
            int currSize = minesIndexes.size();

            while (numMines > 0) {
                int randIndex = ThreadLocalRandom.current().nextInt(0, currSize);
                board[getRow(minesIndexes.get(randIndex))][getCol(minesIndexes.get(randIndex))] = 1;
                minesIndexes.set(randIndex, minesIndexes.get(currSize - 1));
                currSize--;
                numMines--;
            }

            //TODO: Check boundary
//     while(numMines > 0) {
//       int randRow = ThreadLocalRandom.current().nextInt(0, rows);
//       int randCol = ThreadLocalRandom.current().nextInt(0, cols);

//       if(board[randRow][randCol] != 1) {
//          board[randRow][randCol] = 1;
//          numMines--;
//       }
//     }

        }
    }

    public static void main(String[] args) {
        Board board = new Board(3, 5);
        board.printBoard();
        board.placeMines(15);
        System.out.println();
        board.printBoard();
    }
}
