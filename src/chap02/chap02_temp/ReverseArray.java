package chap02.chap02_temp;

import java.util.Random;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Number of Array");
        int num = sc.nextInt();

        int a[] = new int[num];
        Random random = new Random();

        System.out.println("Origin Array Members : ");
        for(int i = 0; i < a.length; i++){
            a[i] = random.nextInt(90);
            System.out.print(a[i]+" ");
        }
        System.out.println();

        int temp;
        System.out.println("Reversed Array Members : ");
        for(int i = 0; i < a.length/2; i++){
            temp = a[i];
            a[i] = a[a.length-(i+1)];
            a[a.length-(i+1)] = temp;
            System.out.println("a["+i+"] And a["+(a.length-(i+1))+"] Value Changed");
        }

        for(int n : a){
            System.out.print(n+" ");
        }
    }
}
