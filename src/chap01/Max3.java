package chap01;

import java.util.Scanner;

public class Max3 {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("A의 값: "); int a = stdIn.nextInt();
        System.out.println("B의 값: "); int b = stdIn.nextInt();
        System.out.println("C의 값: "); int c = stdIn.nextInt();

        int max = a;
        if(b>max) max=b;
        if(c>max) max=c;

        System.out.println(max);
    }
}
