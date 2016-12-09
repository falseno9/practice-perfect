package Random;

/**
 * Created by Kunal on 12/7/2016.
 */
public class Sudoku {

    private static class Board {

        int[][] board = new int[9][9];

        public void printBoard() {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.printBoard();
    }

}
