package chap_pra;

public class pic {

    static public void leftRightTriangle(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("*%s", j == i ? "\n" : "");
            }
        }
    }

    static public void rightLeftTriangle(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = num; j > i; j--) {
                System.out.printf("*%s", j == i + 1 ? "\n" : "");
            }
        }
    }

    static public void reverseRightTriangle(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%s", j < num - (i + 1) ? " " : "*");
            }
            System.out.println();
        }
    }

    static public void reverseLeftTriangle(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%s", j < i ? " " : "*");
            }
            System.out.println();
        }
    }

    static public void triangle(int num) {
        for (int i = 0; i < num / 2; i++) {
            for (int j = 0; j < num; j++) {

            }
        }
    }



    public static void main(String args[]) {
        leftRightTriangle(10);
        rightLeftTriangle(10);
        reverseRightTriangle(10);
        reverseLeftTriangle(10);

    }
}
