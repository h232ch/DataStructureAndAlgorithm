package practice_all;

public class ReverseArray {

    static int[] revNum(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - (i + 1)];
            arr[arr.length - (i + 1)] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,66,7,7,8,8,6,5,4,5,65,6,7,8,8};
        revNum(arr);

        for (int temp : arr) {
            System.out.printf("%s ", temp);
        }
    }
}
