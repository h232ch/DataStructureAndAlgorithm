package chap06.practice;

public class Counter {

    static int[] counter(int[] arr) {

        int[] idx = new int[50];
        boolean[] idx_ck = new boolean[50];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i && idx_ck[arr[i]] == false; j--) {
                if (idx[arr[i]] == 0 && arr[i] == arr[j]) {
                    idx[arr[i]] = 2;
                } else if (arr[i] == arr[j]) {
                    idx[arr[i]]++;
                } else if (j == i + 1 && idx[arr[i]] == 0) {
                    idx[arr[i]]++;
                }
            }
            idx_ck[arr[i]] = true;
        }
        return idx;
    }

    static int[] counterV2(int[] arr) {
        int[] idx = new int[50];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 10) {
                idx[arr[i]%10]++;
            } else if (arr[i] > 10 && arr[i] < 100) {
                idx[arr[i]%100]++;
            }
        }
        return idx;
    }

    static int[] counterV3(int[] arr) {
        int[] idx = new int[50];
        for (int i = 0; i < arr.length; i++) {
            idx[arr[i]]++;
        }
        return idx;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,7,3,4,2,1,1,3,4,2,4,5,3,23,2,4,4,1};
        int[] idx = counterV3(arr);
        for (int i = 0; i < idx.length; i++) {
            if (idx[i] != 0) {
                System.out.printf("%d: %2d  ", (i), idx[i]);
            }
        }

    }
}
