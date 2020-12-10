package chap05_temp;

public class HanoiNone2 {

    public static void hanoi(int num, int src, int dst) {

        if (num > 0) {
            hanoi(num - 1, src, 6 - src - dst);
            System.out.println(num + "를 " + src + " 에서 " + dst + "로 옮깁니다.");
            hanoi(num - 1, 6 - src - dst, dst);
        }
    }

    public static void noneHanoi(int num, int src, int dst) {

        int[][] mult = new int[5][5];
        int pts = -1; int sw = 0; int cnt = 0;
        int obj = (int)Math.pow(2,num);

        while (cnt < obj-1) {
            while (num > 0) {
                pts++;
                mult[pts][0] = num;
                mult[pts][1] = src;
                mult[pts][2] = dst;
                mult[pts][3] = sw;

                if (sw == 0) {
                    num = num - 1;
                    dst = 6 - src - dst;
                }

                else if (sw == 1) {
                    System.out.println(mult[pts][0]
                            + "를 "
                            + mult[pts][1] + " 에서 "
                            + mult[pts][2] + "로 옮깁니다.");
                    cnt++;
                    num = num - 1;
                    if (num == 0) {
                        pts--; sw = 0;
                        continue;
                    }
                    src = 6 - src - dst;
                    sw = 0;
                }

                else if (sw == 2) {
                    num = 0;
                    pts--;
                }
            }
            num = mult[pts][0];
            src = mult[pts][1];
            dst = mult[pts][2];
            sw = mult[pts--][3] + 1;
        }
    }

    public static void main(String[] args) {
//        hanoi(3, 1, 3);
        System.out.println();
        noneHanoi(3, 1, 3);
    }
}
