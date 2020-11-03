package chap02;

import java.util.Scanner;

public class Q6 {

    static int convRev(int a, int b, char[] c){

        int sw = 31; char edge;
        String dchar = "0123456789ABCDEFGHIJKLNMOPQRSTUVWXYZ";

        System.out.println(b+"\t|"+"\t"+a);
        do {
            edge = dchar.charAt(a % b);
            c[sw--] = dchar.charAt(a % b);
            a /= b;

            if(a!=0) {
                System.out.println("\t+ ------");
                System.out.println(b+"\t|"+"\t"+a+"\t -> "+edge);
            }
            else {
                System.out.println("\t+ ------");
                System.out.println(" \t "+"\t"+a+"\t -> "+edge);
            }

        } while(a != 0);
        return sw;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num; int cd;

        System.out.print("1. input number : ");
        num = sc.nextInt();
        System.out.print("2. input number : ");
        cd = sc.nextInt();
        System.out.println();

        char[] sw = new char[32];
        int result = convRev(num, cd, sw);
        int i;
        System.out.println();
        System.out.print("+ RESULT : ");
        for (i = 31; i > result; i--){
//            System.out.print(i+" ");
            System.out.print(sw[i]+" ");
        }
        System.out.println();
    }
}
