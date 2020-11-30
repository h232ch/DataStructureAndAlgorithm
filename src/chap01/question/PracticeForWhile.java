package chap01.question;

import java.util.Scanner;

public class PracticeForWhile {

    // Q7 : 정수의 합
    static int sumNum(int n) {

        int sum=0;
        int i=1;
        while (i<=n) {
            sum += i;
            i++;
        }
        return sum;
    }

    // Q8 가우스의 덧셈
    static int gaussSum(int n){
        return ((n+1)*n)/2;
    }

    // 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하시오
    static int sumOf(int a, int b){
        int sum=0;
        int temp=0;
        if(a>b){
            temp = a;
            a = b;
            b = temp;
        }else if(a==b){
            return a;
        }
        for(int i=a;i<=b;i++){
            sum+=i;
        }
        return sum;
    }



    public static void main(String[] args){

        System.out.println("숫자의 합 : "+sumNum(60));
        System.out.println("가우스의 합 : "+gaussSum(60));
        System.out.println("값의 크기와 상관없이 합구하기 : "+sumOf(50,1));

        // 양의 정수만 받기

        Scanner stdIn = new Scanner(System.in);
        int sum=0;
        int n;
        do{
            System.out.println("N의 값을 입력하시오 : ");
            n = stdIn.nextInt();
        }while(n<=0); // n이 0보다 같거나 클때까지 반복

        for (int i = 1; i<=n; i++){
            sum += i;
        }
        System.out.println("N의 합계는 : "+sum);


    }
}
