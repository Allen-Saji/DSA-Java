import java.util.Scanner;

public class JavaBasics {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        float a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        float amt = (a + b + c) + 0.18f * (a + b + c);

        System.out.println(amt);

        sc.close();

    }
}