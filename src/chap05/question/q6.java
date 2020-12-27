package chap05.question;

public class q6 {

    public static void hainoq(int num, int src, int dst) {

        char a = 'A';
        char b = 'B';
        char c = 'C';

        if (num > 0) {
            hainoq(num - 1, src, 6 - src - dst);

            if (src == 1)
                System.out.print(num + " 을 " + a + "에서 ");

            else if (src == 2)
                System.out.print(num + " 을 " + b + "에서 ");

            else
                System.out.print(num + " 을 " + c + "에서 ");

            if (dst == 1)
                System.out.println(a + "로 옮깁니다.");

            else if (dst == 2)
                System.out.println(b + "로 옮깁니다.");

            else
                System.out.println(c + "로 옮깁니다.");

            hainoq(num - 1, 6 - src - dst, dst);
        }
    }


    public static void main (String[] args) {
        hainoq(3,1,3);
    }
}
