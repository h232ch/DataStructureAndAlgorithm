package chap05;

public class EightQueenNon {

    static boolean[] flag_a = new boolean[4];	// 각 행에 퀸이 이미 배치되어 있는가?
    static boolean[] flag_b = new boolean[7];	// ／대각선에 퀸이 이미 배치되어 있는가?
    static boolean[] flag_c = new boolean[7];	// ＼대각선에 퀸이 이미 배치되어 있는가?
    static int[] pos = new int[4]; // 각 열의 퀸의 위치

    // 체스판(각 열의 퀸의 위치)을 출력
    static void print() {
        for (int temp :
                pos) {
            System.out.print(temp + " ");
        }
        System.out.println( );

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++)
//                System.out.printf("%s", j == pos[i] ? "■" : "□");
//            System.out.println();
//        }
//        System.out.println();
    }

    // i열의 알맞은 위치에 퀸을 배치
    static void set(int i) {
        int j;
        int[] jstk = new int[4];

        Start: while (true) {
            j = 0;
            while (true) {
                while (j < 4) {
                    if (!flag_a[j]) {
                        pos[i] = j;
                        if (i == 3) // 모든 열에 배치 마침
                            print();
                        else {
                            flag_a[j] = true;
                            jstk[i++] = j; // i 열의 행을 Push
                            continue Start;
                        }
                    }
                    j++;
                }
                if (--i == -1)
                    return;
                j = jstk[i]; // i 열의 행을 Pop
                flag_a[j] = false;
                j++;
            }
        }
    }
    
    
    public static void main(String[] args) {
        set(0);
    }
}
