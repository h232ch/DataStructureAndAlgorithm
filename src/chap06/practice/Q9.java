package chap06.practice;

public class Q9 {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
                cnt++;
            }
            arr[j] = temp;
        }
        System.out.println("Count Number is " + cnt);
    }

    public static void shellSortV1(int[] arr) {
        int cnt = 0;
        int n = arr.length;
        for (int h = n / 2; h > 0; h /= 2) {
            if (h % 2 == 0) h++; // 짝수를 홀수로 만들어주는 로직 추가
            for (int i = h; i < n; i++) {
                int j;
                int temp = arr[i];
                for (j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j + h] = arr[j];
                    cnt++;
                }
                arr[j + h] = temp;
            }
        }
        System.out.println("Count Number is " + cnt);

    }

    public static void shellSortV2(int[] arr) {
        int n = arr.length;
        int h;
        int cnt = 0;
        for (h = 1; h < n / 9; h = h * 3 + 1)
            ;

        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = arr[i];
                for (j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j + h] = arr[j];
                    cnt++;
                }
                arr[j + h] = temp;
            }
        }

        System.out.println("Count Number is " + cnt);
    }

    public static void main(String[] args) {
        int arr[] = {123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5};
        int tarr[] = {123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5};
        int carr[] = {123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5,123,5,3,5,56,7,7,3,23,4,5,64,7,4637,3647,8,9,9,64,564,654,6,6,5};
        shellSortV1(arr);
        insertionSort(tarr);
        shellSortV2(carr);

    }
}
