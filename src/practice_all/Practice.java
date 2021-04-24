package practice_all;

public class Practice {


    static int[] a = new int[8];
    static int len = a.length;
    static boolean[] flag_a = new boolean[len];
    static boolean[] flag_b = new boolean[len * 2];
    static boolean[] flag_c = new boolean[len * 2];

    static void print(int[] a) {
        for (int i = 0; i < len; i++) {
            System.out.printf("%3d", a[i]);
        }
        System.out.println();
    }

    static void eightQueen(int n) {
        for (int i = 0; i < len; i++) {
            if (!flag_a[i] &&
            !flag_b[i + n] &&
            !flag_c[len - i + n]) {
                a[n] = i;
                if (n == len - 1) {
                    print(a);
                } else {
                    flag_a[i] = flag_b[i + n] = flag_c[len - i + n] = true;
                    eightQueen(n + 1);
                    flag_a[i] = flag_b[i + n] = flag_c[len - i + n] = false;
                }
            }
        }
    }

    static int gcd(int x, int y) {
        if (y == 0) {
            return x; // 재귀의 종료 (이 리턴값이 모든 재귀의 리턴값이 됨;
        } else {
            return gcd(y, x % y); // 재귀로 들어가는 단계 (종료 조건을 만족하지 않을경우 계속 들어감)
        }
    }

    static void hanoi(int n, int x, int y) {
        if (n > 1) {
            hanoi(n - 1, x, 6 - x - y);
        }

        System.out.println(n + "을 " + x + "에서 " + y + "로 이동합니다.");

        if (n > 1) {
            hanoi(n - 1, 6 - x - y, y);
        }
    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static int fibo(int n) { // 외우기
        if (n <= 1) {
            return n;
        } else {
            return fibo(n - 2) + fibo(n - 1);
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
        return a;
    }

    static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a, min, i);
            }
        }
        return a;
    }

    static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            int temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
        return a;
    }

    static int[] shellSort(int[] a) {
        for (int h = a.length / 2; h > 0; h /= 2) {
            for (int i = h; i < a.length; i++) {
                int j;
                int temp = a[i];
                for (j = i - h; j >= 0 && temp < a[j]; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = temp;
            }
        }
        return a;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = (pl + pr) / 2;

        do {
            while (a[pl] < a[x]) pl++;
            while (a[pr] > a[x]) pr--;
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(a, left, pr);
        }

        if (pl < right) {
            quickSort(a, pl, right);
        }
    }

    static int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }


    static int[] fsort(int[] a, int max) {
        int[] b = new int[a.length];
        int[] f = new int[max + 1];

        for (int i = 0; i < a.length; i++) {
            f[a[i]]++;
        }

        for (int i = 1; i < f.length; i++) {
            f[i] = f[i] + f[i - 1];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            b[--f[a[i]]] = a[i];
        }

        return b;
    }


    static int[] pos = new int[20];
    static void mergeSort(int[] a, int left, int right) {

        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            mergeSort(a, left, center);
            mergeSort(a, center + 1, right);

            for (i = left; i <= center; i++)
                pos[p++] = a[i];

            while (i <= right && j < p)
                a[k++] = (pos[j] <= a[i]) ? pos[j++] : a[i++];

            while (j < p)
                a[k++] = pos[j++];
        }
    }


    public static void main(String[] args) {
        eightQueen(0);
        System.out.println(gcd(100,42));
        hanoi(3, 1, 3);
        System.out.println(factorial(4));
        System.out.println(fibo(4));

        int[] a = {3, 4, 6, 7, 89, 9, 5, 4, 3, 2};
        mergeSort(a, 0, a.length - 1);
//        System.out.println(max(a));
//        quickSort(a, 0, a.length - 1);
        for (int temp : a) {
            System.out.printf("%3d", temp);
        }
        System.out.println();

    }
}
