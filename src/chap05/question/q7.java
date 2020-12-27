package chap05.question;

public class q7 {


    public static void hanoinon(int num, int src, int dst) {

        int[] nt = new int[5];
        int[] st = new int[5];
        int[] dt = new int[5];
        int[] swt = new int[5];

        int sw = 0;
        int pts = -1;
        int n = num;

        while (true) {
            while (n > 0) {
                pts++;
                nt[pts] = n;
                st[pts] = src;
                dt[pts] = dst;

                if (sw == 0) {
                    n = n - 1;
                    dst = 6 - st[pts] - dt[pts];
                } else if (sw == 1) {
                    System.out.println(nt[pts] + "를 " + st[pts] +
                            "에서 " + dt[pts] + "로 옮깁니다.");
                } else if (sw == 2) {
                    n = n - 1;
                    if (n == 0) continue;
                    src = 6 - st[pts] - dt[pts];
                    sw = 0;
                }
            }

            n = nt[pts];
            sw = swt[pts--] + 1;
        }
    }

    public static void main(String[] args) {
        hanoinon(3, 1, 3);
    }
}
