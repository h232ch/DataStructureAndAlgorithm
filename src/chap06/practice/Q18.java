package chap06.practice;

public class Q18 {


    static void fSort(int[] a, int n, int max) {

        int[] f = new int[max + 1];
        int[] b = new int[n];






        System.out.println("0 단계 A (원본배열) : ");
        for (int i = 0; i < n; i++) // 0단계 출력
            System.out.printf("%2d %c", a[i], (i == (n - 1)) ? '\n' : ',');

        for (int i = 0; i < n; i++) f[a[i]]++; // 1단계

        System.out.println("1 단계 F (도수분포표) : ");
        for (int i = 0; i < max + 1; i++) // 1단계 출력
            System.out.printf("%2d %c", f[i], (i == max) ? '\n' : ',');

        for (int i = 0; i < max; i++) f[i+1] += f[i]; // 2단계

        System.out.println("2 단계 F (누적도수분포표) : ");
        for (int i = 0; i < max + 1; i++) // 2단계 출력
            System.out.printf("%2d %c", f[i], (i == max) ? '\n' : ',');

        System.out.println("3 단계 B (목적배열) : ");
        for (int i = n - 1; i >= 0; i--) {
            b[--f[a[i]]] = a[i]; // 3단계
            for (int j = 0; j < n; j++) System.out.printf("%2d %c", b[j], (j == n - 1) ? '\n' : ',');
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%2d %c", b[i], (i == n - 1) ? '\n' : ',');
        }

        if (n >= 0) System.arraycopy(b, 0, a, 0, n); // 4단계

    }

    public static void main(String[] args) {

        int[] a = {4,5,6,3,2};
        int n = a.length;

        int max = a[0];
        for (int i = 1; i < n; i++)
            if (max < a[i]) max = a[i];

        fSort(a, n, max);
    }
}
