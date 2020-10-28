package chap01;

import java.util.Scanner;

public class JudgeSign {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요 : ");
        int n = sc.nextInt();

        if(n>0)
            System.out.println("이 수는 양수입니다.");
        else if(n<0)
            System.out.println("이 수는 음수입니다.");
        else
            System.out.println("이 수는 0입니다.");

        // 조건 판단과 분기
        if(n==1)
            System.out.println("이 수는 1입니다.");
        else if(n==2)
            System.out.println("이 수는 2입니다.");
        else if(n==3)
            System.out.println("이 수는 3입니다."); // 하단에 else;가 생략돼 있음 (아무것도 하지않음) -> 실제로는 4개의 조건으로 분기하고 있음

        // 연산자와 피연산자
        /*
        1. 단항 연산자 : 피연산자 1개 a++
        2. 이항 연산자 : 피연산자 2개 a<b
        3. 삼항 연산자 : 피연산자 3개 a?b:c
        특히 조건 연산자는 자바에서 유일한 3항 연산자이다. a ? b : c는 a가 true이면 b를 반환하고 false이면 c를 반환함
        a = (x>y) ? x:y;
        System.out.println((c==0)?"c는 0": "c는 0이 아님");
         */

    }
}
