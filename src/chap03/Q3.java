package chap03;

import java.util.Scanner;

public class Q3 {


    static int searchIdx(int[] a, int key, int[] idx){

        int sw = 0;
        for (int i = 0; i < a.length; i++){
            if(a[i] == key){
                idx[sw] = i;
                sw++;
            }
        }

        System.out.print("We Found The Key Index : ");
        for (int tmp : idx) {
            System.out.print(tmp+" ");
        }

        return idx.length;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Array Size : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int[] idx = new int[size];


        for (int i = 0; i < size; i++){
            System.out.print("Input Array Num : ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Input Key Value : ");
        int key = sc.nextInt();

        searchIdx(arr, key, idx);
    }
}
