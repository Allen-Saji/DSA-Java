package bit_manipulation;

public class BitPrograms {

    public static int clearRange(int n, int i, int j) {
        int a = ~(0) << j + 1;
        int b = (1 << i) - 1;
        int bitmask = a | b;

        return (n & bitmask);
    }

    public static boolean power_of_2(int n) {
        int bit_mask = n & (n - 1);

        if (bit_mask == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int count_set_bits(int n) {
        int count = 0;
        while (n > 0) {

            int lastDigit = n & 1;
            if (lastDigit == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= a;
            }
            a *= a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(clearRange(24, 2, 4));
        // System.out.println(power_of_2(9));
        // System.out.println(count_set_bits(14));
        System.out.println(fastExpo(3, 5));
    }

}
