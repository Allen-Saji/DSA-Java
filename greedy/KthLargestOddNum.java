package greedy;

public class KthLargestOddNum {
    // Java implementation for the above approach
    // Function to return Kth largest
    // odd number if it exists
    public static int kthOdd(int[] range, int K) {

        // Base Case
        if (K <= 0)
            return 0;

        int L = range[0];
        int R = range[1];

        if ((R & 1) > 0) {

            // Calculate count of odd
            // numbers within the range
            int Count = (int) Math.ceil((R - L + 1) / 2);

            // if k > range then kth largest
            // odd number is not in the range
            if (K > Count)
                return 0;

            else
                return (R - 2 * K + 2);
        } else {

            // Calculate count of odd
            // numbers within the range
            int Count = (R - L + 1) / 2;

            // If k > range then kth largest
            // odd number is not in this range
            if (K > Count)
                return 0;

            else
                return (R - 2 * K + 1);
        }
    }

    // Driver Code
    public static void main(String args[]) {

        // Initialize the range
        int[] p = { -10, 10 };

        // Initialize k
        int k = 8;

        // print the kth odd number
        System.out.println(kthOdd(p, k));
    }

}
