package practice_all;

public class Prime {



    static int primeV1(int n) {
        int[] prime = new int[500];
        int ptr = 0;
        int count = 0;

        for (int i = 2; i < n; i++) {
            int j;
            for (j = 2; j < i; j++) {
                count++;
                if (i % j == 0) {
                    break;
                }
            }
            if (j == i) {
                prime[ptr++] = i;
            }
        }
        return count;
    }

    static int primeV2(int n) {
        int[] prime = new int[500];
        int ptr = 0;
        int count = 0;

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int i = 5; i < n; i += 2) {
            int j;
            for (j = 1; j < ptr; j++) {
                count++;
                if (i % prime[j] == 0) {
                    break;
                }
            }
            if (j == ptr) {
                prime[ptr++] = i;
            }
        }
        return count;
    }

    static int primeV3(int n) {
        int[] prime = new int[500];
        int ptr = 0;
        int count = 0;

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int i = 5; i < n; i += 2) {
            boolean flag = false;
            for (int j = 1; i >= prime[j] * prime[j]; j++) {
                count += 2;
                if (i % prime[j] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
                prime[ptr++] = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(primeV1(1000));
        System.out.println(primeV2(1000));
        System.out.println(primeV3(1000));
    }
}
