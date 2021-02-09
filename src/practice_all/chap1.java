package practice_all;

public class chap1 {

    static void leftRightTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    static void rightLeftTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    static void reverseRightLeftTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%s", (j < n - (i + 1)) ? " " : "*");
            }
            System.out.println();
        }
    }

    static void reverseLeftRightTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%s", (j < i) ? " " : "*");
            }
            System.out.println();;
        }
    }

    static void triangle(int n) {
        int mid = n / 2;
        for (int i = 0; i < mid + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (j < mid - i || j > mid + i) {
                    System.out.printf(" ");
                } else {
                    System.out.printf("*");
                }
            }
            System.out.println();
        }
    }

    static void reverseTriangle(int n) {
        int mid = n / 2;
        for (int i = 0; i < mid + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i || j > n - (i + 1)) {
                    System.out.printf(" ");
                } else {
                    System.out.printf("*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        leftRightTriangle(10);
        rightLeftTriangle(10);
        reverseRightLeftTriangle(10);
        reverseLeftRightTriangle(10);
        triangle(11);
        reverseTriangle(11);
    }
}
