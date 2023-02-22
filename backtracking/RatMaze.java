package backtracking;

public class RatMaze {

    public static void printMaze(int maze[][]) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int i, int j) {
        return (i >= 0 && i < maze.length && j >= 0 && j < maze.length && maze[i][j] == 1);
    }

    public static void solveMaze(int maze[][]) {
        int n = maze.length;
        int sol[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = 0;
            }
        }

        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("The solution doesn't exist!");
            return;
        }

        printMaze(sol);
    }

    public static boolean solveMazeUtil(int maze[][], int i, int j, int sol[][]) {
        // base case
        if (i == maze.length - 1 && j == maze.length - 1) {
            sol[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j)) {
            if (sol[i][j] == 1) {
                return false;
            }

            // mark x, y as part of solution path
            sol[i][j] = 1;
            /* Move forward in x direction */
            if (solveMazeUtil(maze, i + 1, j, sol) == true)
                return true;
            // If moving right didn't work
            // move left
            if (solveMazeUtil(maze, i - 1, j, sol) == true)
                return true;
            // If moving in x direction doesn't give solution
            // then Move down in y direction
            if (solveMazeUtil(maze, i, j + 1, sol) == true)
                return true;
            // If moving down didn't work
            // move up
            if (solveMazeUtil(maze, i, j - 1, sol) == true)
                return true;
            // If none of the above movements work then
            // BACKTRACK: unmark x, y as part of solution path
            sol[i][j] = 0;
            return false;
        }
        return false;

    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 1, 1, 1 },
                { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 } };
        solveMaze(maze);
    }
}
