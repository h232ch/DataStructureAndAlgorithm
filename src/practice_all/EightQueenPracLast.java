package practice_all;

public class EightQueenPracLast {

    static int[] pos = new int[5];
    static boolean[] flag_a = new boolean[pos.length];
    static boolean[] flag_b = new boolean[pos.length * 2];
    static boolean[] flag_c = new boolean[pos.length * 2];

    static void print() {
        for (int i = 0; i < pos.length; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i) {
        for (int j = 0; j < pos.length; j++) {
            if (!flag_a[j] &&
            !flag_b[i + j] &&
            !flag_c[i - j + (pos.length - 1)]) {
                pos[i] = j;
                if (i == pos.length - 1) {
                    print();
                } else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + (pos.length - 1)] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + (pos.length - 1)] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
