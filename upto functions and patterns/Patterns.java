public class Patterns {

    public static void inverted_half_pyramid(int cols) {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols - i; j++) {
                System.out.print(" " + (j + 1) + " ");
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int rows) {
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" " + (count++) + " ");
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(" " + 1 + " ");
                } else {
                    System.out.print(" " + 0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly_pattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }

            for (int j = 1; j <= 2 * (rows - i); j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }

            for (int j = 1; j <= 2 * (rows - i); j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

    }

    public static void solid_rhombus(int rows) {
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= rows - i; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= rows; j++) {
                System.out.print(" * ");
            }

            System.out.println();
        }
    }

    public static void hollow_rhombus(int rows) {
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= rows - i; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= rows; j++) {
                if (i == 1 || i == rows || j == 1 || j == rows) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.println();
        }
    }

    public static void diamond(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // inverted_half_pyramid(5);
        // floyds_triangle(4);
        // zero_one_triangle(4);
        // butterfly_pattern(4);
        // solid_rhombus(5);
        // hollow_rhombus(5);
        // diamond(4);
    }

}
