public class Palindrome {
    public static void IsPalindrome(int a) {
        int num = 0, org = a;
        while (a > 0) {
            num = (a % 10) + (num * 10);
            a /= 10;
        }

        if (num == org) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static int Sum(int a) {
        int sum = 0;

        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        IsPalindrome(717);
        int a = 222;
        System.out.println("Sum of digits of " + a + " = " + Sum(a));
    }
}
