package chap05.question;

public class q5 {


    static void recur3(int n) {
        if (n > 0) {
            recur3(n - 1);
            recur3(n - 2);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {

        recur3(3);

    }
}
