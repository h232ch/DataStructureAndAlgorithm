package chap06.practice;

public class Q7 {

    public static void insertionSort(int[] arr){
        int leng = arr.length;
        for (int i = 2; i < leng; i++) {
//            int j;
//            int temp = arr[i];
//            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
//                arr[j] = arr[j - 1];
//            }

            int k = i;
            int sw = i;
            int temp = arr[i];
            while (true) {
                if (arr[k - 1] > temp && arr[k - 1] != -1) {
                    arr[k] = arr[k - 1];
                    sw = k - 1;
                } else {
                    break;
                }
                k--;
            }
            arr[sw] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {-1,23,5,3};
        insertionSort(arr);

        for (int temp : arr) {
            System.out.printf("%3d", temp);
        }
    }
}
