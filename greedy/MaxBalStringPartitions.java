package greedy;

// Java program to find a maximum number X, such
// that a given String can be partitioned
// into X subStrings that are each balanced

class MaxBalStringPartitions {

    // Function to find a maximum number X, such
    // that a given String can be partitioned
    // into X subStrings that are each balanced
    static int BalancedPartition(String str, int n) {

        // If the size of the String is 0,
        // then answer is zero
        if (n == 0)
            return 0;

        // Variable that represents the
        // number of 'R's and 'L's
        int r = 0, l = 0;

        // To store maximum number of
        // possible partitions
        int ans = 0;
        for (int i = 0; i < n; i++) {

            // Increment the variable r if the
            // character in the String is 'R'
            if (str.charAt(i) == 'R') {
                r++;
            }

            // Increment the variable l if the
            // character in the String is 'L'
            else if (str.charAt(i) == 'L') {
                l++;
            }

            // If r and l are equal,
            // then increment ans
            if (r == l) {
                ans++;
            }
        }

        // Return the required answer
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "LLRRRLLRRL";
        int n = str.length();

        // Function call
        System.out.print(BalancedPartition(str, n) + "\n");
    }
}
