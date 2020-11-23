package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    static int weFind(int[] array, int fNum){

        System.out.print("  | ");
        for (int j = 0; j < array.length; j++){
            System.out.print(" "+j+" ");
        }
        System.out.println();
        System.out.println("--+-----------------");

        for (int i = 0; i < array.length; i++){
            System.out.print("  | ");
            for (int y = 0; y < array.length; y++){
                if(y == i)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();

            System.out.print(i+" | ");
            for (int k = 0; k < array.length; k++){

                if (k == array.length-1)
                    System.out.println(array[k]);
                else
                    System.out.print(array[k]+" ");
            }
            if(array[i] == fNum)
                return i;
        }
        return -1;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.printf("Input Number Size : ");
        int size = sc.nextInt();

        int[] numArray = new int[size];
        for (int i = 0; i < size; i++){
            System.out.printf("Input Number : ");
            numArray[i] = sc.nextInt();
        }

        System.out.printf("Array Number : ");
        for (int z : numArray){
            System.out.print(z+" ");
        }
        System.out.println();
        System.out.printf("Input Finding Number : ");
        int fNum = sc.nextInt();
        int idx = weFind(numArray, fNum);

        if(idx == -1)
            System.out.println("Number is not here");
        else
            System.out.println("The finding number : " + numArray[idx]);
    }
}
