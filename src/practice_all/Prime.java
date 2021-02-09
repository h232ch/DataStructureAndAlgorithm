package practice_all;

public class Prime {

    static void primeNumber(int n) {

        int count = 0;
        for (int i = 2; i < n; i++) {
            int j;

            for (j = 2; j < i; j++) {
                count++;
                if (i % j == 0) {
                    break;
                }
            }
        }
        System.out.println("Count Number : " + count);
    }


    static void primeNumber2(int n) {
        int ptr = 0;
        int count = 0;
        int[] primeNum = new int[500];

        primeNum[ptr++] = 2;
        for (int i = 3; i < n; i+=2) {
            int j;
            for (j = 1; j < ptr; j++) {
                count++;
                if (i % primeNum[j] == 0) {
                    break;
                }
            }
            if (j == ptr) {
                primeNum[ptr++] = i;
            }
        }
        System.out.println("Count Number : " + count);
    }

    static void primeNumber2Prac(int n) {
        int count = 0;
        int ptr = 0;
        int[] prime = new int[500];
        prime[ptr++] = 2;

        for (int i = 3; i < n; i+=2) {
            int j;
            for (j = 1; j < ptr; j++) {
                count++;
                if (i % prime[j] == 0) {
                    break;
                }
            }
            if (ptr == j) {
                prime[ptr++] = i;
            }
        }
        System.out.println("Count Number : " + count);
    }


    static void primeNumber3(int n) {
        int count = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int i = 5; i < n; i += 2) {
            boolean sw = false;
            for (int j = 1; prime[j] * prime[j] <= i; j++) {
                count+=2;
                if (i % prime[j] == 0) {
                    sw = true;
                    break;
                }
            }

            if (sw == false) {
                prime[ptr++] = i;
                count++;
            }

        }
        System.out.println("Count Number : " + count);
    }

    public static void main(String[] args) {
        primeNumber(1000);
        primeNumber2(1000);
        primeNumber2Prac(1000);
        primeNumber3(1000);
    }
}
