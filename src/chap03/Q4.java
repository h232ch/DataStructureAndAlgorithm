package chap03;

import java.util.Scanner;

public class Q4 {


    static int binSearch(int[] arr, int key){


        System.out.print("  | ");
        for (int i = 0; i < arr.length; i++){
            if (arr.length-1 == i)
                System.out.println(i + " ");
            else
                System.out.print(i + " ");
        }
        System.out.println("--+------------------");


        int st = 0;
        int la = arr.length-1;

        do {
            int mid = (st + la) / 2;
//            System.out.println("ST:"+ st +" LA:"+la+" MID:"+mid);
            System.out.print("  | ");
            for (int i = 0; i < arr.length; i++){
                if (i == mid)
                    System.out.print("+");
                else if (i == st)
                    System.out.print("<-");
                else if (i == la)
                    System.out.print("->");
                else
                    System.out.print("  ");
            }
            System.out.println();

            System.out.print(mid+" | ");
            for (int i = 0; i < arr.length; i++){
                if (i == arr.length-1)
                    System.out.println(arr[i] + " ");
                else
                    System.out.print(arr[i] + " ");
            }

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                st = mid + 1;
            else
                la = mid - 1;

        } while (st <= la);
        return -1;
    }

    public static void main(String[] args){

        int[] arr = {1,2,3,5,6,8,9};
        int key = 5;

        System.out.println(key+"는 x["+binSearch(arr,key)+"]에 있습니다.");

    }
}
