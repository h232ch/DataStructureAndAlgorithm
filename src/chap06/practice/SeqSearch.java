package chap06.practice;

import java.util.Scanner;

public class SeqSearch {


    public static int seqSearch(int[] arr, int oNum) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oNum) return i;
        }
        return -1;
    }

    public static int seqSearchSentinel(int[] arr, int oNum) {
        int i = 0;
        while (true) {
            if (arr[i] == oNum) break;
            i++;
        }
        return (i != arr.length-1) ? i : -1;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("What's the number you want to search? ");
        int temp = sc.nextInt();
        int[] arr = {2,31,4,5,3,5,36,2,temp};

//        int result = seqSearch(arr, temp);
        int result = seqSearchSentinel(arr, temp);
        if (result != -1) System.out.println("The number's index is " + result + "..");
        else System.out.println("The number is not in there..");
    }
}
