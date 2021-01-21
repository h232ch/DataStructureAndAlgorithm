package chap08.practice;

public class test {

    public static void main(String[] args) {

        int idx = 4;
        String s1 = "가나다라";
        int len = 0;
        for (int i = 0; i < idx; i++) {
            System.out.println(s1.substring(i, i+1).getBytes().length);
            len += s1.substring(i, i + 1).getBytes().length;
        }

        System.out.println(len);
    }
}
