package chap06.practice;

public class Q6 {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        int leng = arr.length;
        for (int i = 0; i < leng - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < leng; j++) {
                if (arr[temp] > arr[j]){
                    temp = j;
                }
            }
            for (int z = 0; z < leng; z++) {
                System.out.printf("%3c %c", (z == i) ? '*' : (z == temp) ? '+' : ' ', (z == leng - 1) ? '\n' : ' ');

//                if (z == i)
//                    System.out.printf("%3c %c", '*', (z == leng - 1) ? '\n' : ' ');
//                else if (z == temp)
//                    System.out.printf("%3c %c", '+', (z == leng - 1) ? '\n' : ' ');
//                else
//                    System.out.printf("%3c %c", ' ', (z == leng - 1) ? '\n' : ' ');
            }

            for (int k = 0; k < leng; k++) {
                System.out.printf("%3d %c", arr[k], (k == leng - 1) ? '\n' : ' ');
            }
            swap(arr, i, temp);
        }
    } 

    public static void main(String[] args) {
        int[] testArr = {10,3,5,22,1,2,1};
        selectionSort(testArr);
    }
}
