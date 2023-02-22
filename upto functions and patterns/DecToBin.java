public class DecToBin {

    public static void Dec_to_Bin(int a) {
        int rem = 0, i = 0;
        while (a > 0) {
            rem += Math.pow(10, i) * (a % 2);
            a = a / 2;
            i++;
        }
        System.out.println(rem);
    }

    public static void main(String[] args) {
        Dec_to_Bin(100);
    }

}
