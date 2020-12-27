package chap05.question;

public class q9 {

    static int[] pos = new int[3];
    static int[] stk = new int[3];
    static boolean[] flag = new boolean[3];

    static int j = 0; static int i = 0;

    public static void print() {
        for (int temp :
                pos) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void nonQeen(int i) {
        st:while (true) {
            j = 0;
            while (true) {
                while (j < 3) {
                    if (!flag[j]) {
                        pos[i] = j;
                        if (i == 2) {
                            print();
                        } else {
                            flag[j] = true;
                            stk[i++] = j;
                            continue st;
                        }
                    }
                    j++;
                }
                if (--i == -1) return;
                j = stk[i];
                flag[j] = false;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        nonQeen(0);
    }
}
