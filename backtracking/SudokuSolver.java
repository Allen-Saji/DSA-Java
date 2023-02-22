package backtracking;

public class SudokuSolver {

    public static boolean isSafe(int sudoku[][], int digit, int row, int col) {
        // row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // col
        for (int j = 0; j < 9; j++) {
            if (sudoku[j][col] == digit) {
                return false;
            }
        }

        // grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // search in 3x3 grid
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }
        // recursion
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        } else {
            for (int digit = 1; digit <= 9; digit++) {
                if (isSafe(sudoku, digit, row, col)) {
                    sudoku[row][col] = digit;
                    if (sudokuSolver(sudoku, nextRow, nextCol)) {
                        return true;
                    }
                    sudoku[row][col] = 0;
                }
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists!");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution doesn't exist!");
        }
    }

}
