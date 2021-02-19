package practice_all;

public class hanoi {

    static void hanoi(int n, int srt, int dst) {
        if (n > 0) {
            hanoi(n - 1, srt, 6 - srt - dst);
            System.out.println("[" + n + "]을 " + srt + "에서 " + dst + "로 이동합니다.");
            hanoi(n - 1, 6 - srt - dst, dst);
        }
    }

    public static void main(String[] args) {
        hanoi(3, 1, 3);
    }
}
