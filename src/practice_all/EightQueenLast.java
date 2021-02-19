package practice_all;

public class EightQueenLast {

    static int[] pos = new int[10];
    static boolean[] flag_a = new boolean[pos.length];
    static boolean[] flag_b = new boolean[pos.length * 2];
    static boolean[] flag_c = new boolean[pos.length * 2];

    static void print() {
        for (int i = 0; i < pos.length; i++) {
            System.out.printf("%4d", pos[i]);
        }
        System.out.println();
    }

    static void eightQueen(int n) {
        for (int i = 0; i < pos.length; i++) {
            pos[n] = i;
            if (n == pos.length - 1) {
                print();
            } else {
                eightQueen(n + 1);
            }
        }
    }

    static void eightQueenV2(int n) {
        for (int i = 0; i < pos.length; i++) {
            if (!flag_a[i] &&
                    !flag_b[n + i] &&
                    !flag_c[n - i + pos.length]){
                pos[n] = i;
                if (n == pos.length - 1) {
                    print();
                } else {
                    flag_a[i] = flag_b[n + i] = flag_c[n - i + pos.length] = true;
                    eightQueenV2(n + 1);
                    flag_a[i] = flag_b[n + i] = flag_c[n - i + pos.length] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        eightQueenV2(0);
    }
}
