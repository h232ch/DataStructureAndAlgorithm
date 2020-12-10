package chap05_temp;

public class HanoiNone {
    public static void hanoi(int num, int src, int dst) {

        if (num > 0) {
            hanoi(num - 1, src, 6 - src - dst);
            System.out.println(num + "를 " + src + " 에서 " + dst + "로 옮깁니다.");
            hanoi(num - 1, 6 - src - dst, dst);
        }
    }

    public static void noneHanoi(int num, int src, int dst) {

        int[] nstk = new int[5];
        int[] sstk = new int[5];
        int[] dstk = new int[5];
        int[] swstk = new int[5];

        int pts = -1; int sw = 0; int cnt = 0;
        int obj = (int)Math.pow(2,num);

        while (cnt < obj-1) {
            while (num > 0) {

                pts++;
                nstk[pts] = num;
                sstk[pts] = src;
                dstk[pts] = dst;
                swstk[pts] = sw;

                if (sw == 0) {
                    num = num - 1;
                    dst = 6 - src - dst;
                }

                else if (sw == 1) {
                    System.out.println(nstk[pts] + "를 "
                            + sstk[pts] + " 에서 "
                            + dstk[pts] + "로 옮깁니다.");
                    cnt++;
                    num = num - 1;
                    if (num == 0) {
                        pts--; sw = 0;
                        continue;
                    }
                    src = 6 - sstk[pts] - dstk[pts];
                    sw = 0;
                }

                else if (sw == 2) {
                    num = 0;
                    pts--;
                }
            }
            num = nstk[pts];
            dst = dstk[pts];
            src = sstk[pts];
            sw = swstk[pts--] + 1;
        }
    }

    public static void main(String[] args) {
        hanoi(4, 1, 3);
        System.out.println();
        noneHanoi(4, 1, 3);
    }
}
