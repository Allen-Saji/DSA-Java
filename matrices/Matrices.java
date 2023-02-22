package matrices;

public class Matrices {

    public static void count(int arr[][]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 7)
                    count++;
            }
        }
        System.out.println(count);
    }

    public static void sum_sec_row(int arr[][]) {
        int i = 1, sum = 0;
        while (i == 1) {
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
            i++;
        }
        System.out.println("Sum of second row = " + sum);
    }

    public static void transpose(int arr[][]) {
        System.out.println("Before Transpose: ");
        printMatrix(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        System.out.println("After Transpose:");
        printMatrix(arr);
    }

    public static void printSpiralMatrix(int arr[][]) {
        int start_row = 0;
        int end_row = arr.length - 1;
        int start_col = 0;
        int end_col = arr[0].length - 1;

        System.out.println("Matrix: ");
        printMatrix(arr);
        System.out.println();

        while (start_row <= end_row && start_col <= end_col) {
            // top
            for (int j = start_col; j <= end_col; j++) {
                System.out.print(arr[start_row][j] + " ");
            }

            // right
            for (int i = start_row + 1; i <= end_row; i++) {
                System.out.print(arr[i][end_col] + " ");
            }

            // bottom
            for (int j = end_col - 1; j >= start_col; j--) {
                if (end_row == start_row) {
                    break;
                }
                System.out.print(arr[end_row][j] + " ");
            }

            // left
            for (int i = end_row - 1; i >= start_row + 1; i--) {
                if (end_col == start_col) {
                    break;
                }
                System.out.print(arr[i][start_col] + " ");
            }
            start_row++;
            start_col++;
            end_col--;
            end_row--;
        }
    }

    public static boolean sortedMatrixSearch(int arr[][], int key) {
        int row = arr.length - 1;
        int col = 0;
        while (row >= 0 && col < arr[0].length) {
            if (arr[row][col] == key) {
                System.out.println("Element is present at index: (" + row + ", " + col + ")");
                return true;
            } else if (arr[row][col] > key) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }

    public static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] arr = { { 1, 4, 9 }, { 2, 3, 5 } };
        int nums[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        // count(arr);
        // sum_sec_row(arr);
        // transpose(arr);
        // printSpiralMatrix(arr);
        System.out.println(sortedMatrixSearch(nums, 29));
    }

}
