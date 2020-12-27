package chap06.practice;

import java.util.Scanner;

public class Q1 {

    public static int dcnt = 0;
    public static int ccnt = 0;

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++){
            for (int j = arr.length-1; j > i; j--){
                if (arr[j-1] > arr[j])
                    swap(arr, j-1, j);
            }
        }
    }

    public static void bubbleSort2(int[] arr){

        for (int i = arr.length-1; i > 0 ; i--){
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }


    public static void bubbleSort3(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int exchg = 0;
            System.out.println("Pass : " + (i+1));
            for (int j = arr.length-1; j > i; j--) {
                dcnt++;
                for (int x = 0; x < arr.length-1; x++) {
                    System.out.printf("%3d %c", arr[x], (x!=j-1) ? ' ' : (arr[j-1] > arr[j]) ? '+' : '-');
                }
                System.out.printf("%3d\n", arr[arr.length-1]);

                if (arr[j-1] > arr[j]) {
                    ccnt++;
                    exchg++;
                    swap(arr, j-1, j);
                }
            }
            if (exchg == 0) break;

            for (int z = 0; z < arr.length; z++) {
                System.out.printf("%3d  ", arr[z]);
            }
            System.out.println();
        }
        System.out.println("비교를 " + dcnt + "회 했습니다.");
        System.out.println("교환을 " + ccnt + "회 했습니다.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수를 입력하세요 : ");
        int temp = sc.nextInt();
        int[] arr = new int[temp];

        for (int i = 0; i < temp; i++){
            System.out.print("x[" + i + "] : ");
            arr[i] = sc.nextInt();
        }

        bubbleSort3(arr);
        for (int i = 0; i < temp; i++){
            System.out.printf("%3d %s", arr[i], i != temp-1 ? "," : "\n");
        }
    }
}
