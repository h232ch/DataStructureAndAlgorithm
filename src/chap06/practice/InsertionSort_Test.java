package chap06.practice;

public class InsertionSort_Test {

    public static void insertionSort(int[] arr) {


        int leng = arr.length;
        for (int i = 1; i < leng; i++) {

            int sw = -1;
            int temp = arr[i];
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    sw = j - 1;
                }
            }
            if (sw != -1) arr[sw] = temp;
        }
    }

    public static void main(String[] args) {
        int[] tempArr = {3,2,1,6,3,4,123,454,546,5,32,43,32,2,45,23,134,13,23,2,23,3,3,2,2,2,3,3,4,4,5,5,56,6,23,45,43,1};
        insertionSort(tempArr);

        int chkNum = 0;
        for (int temp: tempArr) {
            System.out.println("arr["+chkNum+"] : " + temp);
            chkNum++;
        }
    }
}
