package backtracking;

public class Backtracking {
    public static void findSubsets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
                return;
            } else {
                System.out.println(ans);
                return;
            }
        }

        // recursive case
        // yes
        findSubsets(str, ans + str.charAt(i), i + 1);
        // no
        findSubsets(str, ans, i + 1);
    }

    public static void findPermutations(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursive case
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // removing the used character
            String newStr = str.substring(0, i) + str.substring(i + 1);
            // passing the above string as input to new function call and adding curr to ans
            findPermutations(newStr, ans + curr);
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonally up left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonally up right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);// function call
                board[row][j] = 'X';// backtracking
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("-----Chess Board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {// condition for last cell
            return 1;
        } else if (i == n || j == m) { // condition for boundary cross
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static void main(String[] args) {
        // String str = "abc";
        // findSubsets(str, "", 0);
        // findPermutations(str, "");
        // int n = 4;
        // char board[][] = new char[n][n];

        // initialise
        // for (int i = 0; i < board.length; i++) {
        // for (int j = 0; j < board.length; j++) {
        // board[i][j] = 'x';
        // }
        // }
        // nQueens(board, 0);

        // int n = 3, m = 3;
        // time complexity 2^(n+m)
        // System.out.println(gridWays(0, 0, n, m));

    }
}
