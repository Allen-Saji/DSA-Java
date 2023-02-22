package recursion;

public class Recursion {
    public static int sum_first_n_nat(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + sum_first_n_nat(n - 1);
        return sum;
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        int fibnm1 = fibonacci(n - 1);
        int fibnm2 = fibonacci(n - 2);
        int fib = fibnm1 + fibnm2;

        return fib;
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int lastOcc(int arr[], int key, int i) {
        if (arr[i] == key) {
            return i;
        }

        if (i == 0) {
            return -1;
        }

        return lastOcc(arr, key, i - 1);
    }

    public static int optimisedPower(int a, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower = optimisedPower(a, n / 2);
        int halfPowerSq = halfPower * halfPower;

        if (n % 2 != 0) {
            halfPowerSq *= a;
        }

        return halfPowerSq;
    }

    public static int tiling(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // work
        // n-1
        int fnm1 = tiling(n - 1);
        // n-2
        int fnm2 = tiling(n - 2);

        return fnm1 + fnm2;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static int friendPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int fnm1 = friendPairing(n - 1);
        int fnm2 = friendPairing(n - 2);
        int pairWays = (n - 1) * fnm2;

        return fnm1 + pairWays;
    }

    public static void printBinString(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        printBinString(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinString(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        // System.out.println(sum_first_n_nat(4));
        // System.out.println(fibonacci(25));
        // int arr[] = { 1, 2, 3, 4, 5, 4, 5, 5, 5 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(lastOcc(arr, 5, arr.length - 1));
        // System.out.println(optimisedPower(2, 5));
        // System.out.println(tiling(4));
        // removeDuplicates("nithin", 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendPairing(5));
        printBinString(3, 0, "");
    }
}
