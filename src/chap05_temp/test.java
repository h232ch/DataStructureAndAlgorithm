package chap05_temp;

public class test {

    public static void takeThis() {

        int num = 3;
        int i = 0;
        while (true) {
            i++;
            while (num > 0) {
                num = num -1;
                System.out.println(num);
            }
            System.out.println(i);
            System.out.println(num);
            if (i > 10) break;
        }

    }

    public static void main(String[] args) {
        System.out.println((int)Math.pow(2,3));
    }
}
