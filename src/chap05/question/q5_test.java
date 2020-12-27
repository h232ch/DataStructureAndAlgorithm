package chap05.question;

public class q5_test {

    public static void nRecur(int n) {

        int[] nstk = new int[20];
        int[] sstk = new int[20];
        int pts = -1;
        int sw = 0;

        while (true){
            if (n > 0) {
                pts++;
                nstk[pts] = n;
                sstk[pts] = sw;

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[pts];
                sw = sstk[pts--] + 1;
                if (sw == 2) {
                    System.out.print(n + ", ");
                    if (pts < 0) return;
                }
            } while (sw == 2);
        }

    }

    public static void main(String[] args) {
        nRecur(3);
    }
}
