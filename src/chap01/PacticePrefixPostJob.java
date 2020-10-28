package chap01;

import java.util.Scanner;

public class PacticePrefixPostJob {

    // Do while을 이용하여 Sub 구현
    static int sub(){
        Scanner stdIn = new Scanner(System.in);
        int a;
        int b;

        do{
            System.out.println("A의 값을 입력하세요.");
            a = stdIn.nextInt();
            System.out.println("B의 값을 입력하세요.");
            b = stdIn.nextInt();
            if(a<b){
                System.out.println("A의 값보다 작은 값을 입력하세요!");
                System.out.println("B의 값을 입력하세요.");
                b = stdIn.nextInt();
            }
        }while(a<b);
        int result = a-b;
        System.out.println("A-B의 값은 : "+result);
        return result;
    }

    // 양의 정수의 자릿수 구하기
    static String numberCheck(int a){
        return "그 수는 "+(int)(Math.log10(a)+1)+"자리 입니다.";
    }


    public static void main(String[] args){
//        System.out.println(sub());
        System.out.println(numberCheck(10));
    }
}
