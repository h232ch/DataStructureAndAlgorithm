package chap05.question;

public class q3 {

    public static int gcbArray(int[] a) {
        if (a.length < 2) {
            System.out.println("2개 이상의 인수를 입력해 주세요.");
            return -1;
        } else {
            int result = gcb(a[0], a[1]);
            for (int i = 2; i < a.length; i++) {
                result = gcb(result, a[i]);
            } return result;
        }
    }

    public static int gcb(int a, int b) {
        if (b == 0) return a;
        else return gcb(b, a % b);
    }

    public static void main(String[] args) {
        int[] arr = {24,36};
        System.out.println(gcbArray(arr));
    }
}
