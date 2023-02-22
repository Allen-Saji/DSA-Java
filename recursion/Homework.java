package recursion;

public class Homework {

    public static void allOcc(int key, int idx, int arr[], boolean isFound) {
        // base case
        if (idx == arr.length) {
            if (isFound != true) {
                System.out.println(-1);
            }
            return;
        }
        if (arr[idx] == key) {
            System.out.println(idx);
            isFound = true;
        }

        allOcc(key, idx + 1, arr, isFound);
    }

    static String digits[] = { "zero", "one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine" };

    public static void printNumber(int n) {
        if (n == 0) {
            return;
        }

        int lastDigit = n % 10;
        printNumber(n / 10);
        System.out.println(digits[lastDigit]);

    }

    static void towerOfHanoi(int n, char from_rod,
            char to_rod, char aux_rod) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod "
                + from_rod + " to rod "
                + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 3, 4, 5 };
        // allOcc(4, 0, arr, false);
        // printNumber(19682);
        int N = 3;

        // A, B and C are names of rods
        towerOfHanoi(N, 'A', 'C', 'B');
    }

}
