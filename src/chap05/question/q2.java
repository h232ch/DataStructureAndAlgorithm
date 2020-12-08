package chap05.question;

public class q2 {
    public static int gcd(int x, int y) {
        int result;
        do {
            result = x % y;
            if (result == 0) {
                return y;
            } else {
                x = y;
                y = result;
            }
        } while (true);
    }

    public static void main(String[] args) {
        System.out.println(gcd(24, 36));
    }
}
