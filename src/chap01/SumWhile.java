package chap01;

import java.util.Scanner;

public class SumWhile {
    public static void main(String[] args){

        Scanner stdIn = new Scanner(System.in);
        System.out.println("n을 입력해주세요 : ");
        int n = stdIn.nextInt();
        System.out.println("1부터 "+n+"까지의 합을 구합니다.");

        int sum = 0;
        int i = 1;
        while (i<=n){
            sum += i;
            i++;
        }
        System.out.println(i);
        System.out.println("1부터 "+n+"까지의 합 : "+sum);
    }
}
