package chap02;

import java.util.Scanner;

public class Q8 {

    static int[][] mdays = {
            {31,28,31,30,31,30,31,31,30,31,30,31}, // 0 평년
            {31,29,31,30,31,30,31,31,30,31,30,31} // 1 윤년
    };

    static int isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1: 0;
    }

    static int dayOfYear(int y, int m, int d){

        int result = d; // Q8 dayOfYear를 변수 i와 days 없이 구현하시오 (while 사용)
        while (m>1){
            result += mdays[isLeap(y)][m-2];
            System.out.println(result);
            m--;
        }
        return result;
    }

    static int leftDayOfYear(int y, int m, int d){ // Q9 해당연도의 남은 일수를 출력

        int leftDays = 0;
        int sw = isLeap(y);
        System.out.println(sw==1?"윤년 입니다.":"평년 입니다.");

        for(int i = 0; i < mdays[sw].length; i++){
            leftDays += mdays[sw][i];
        }
        return leftDays-dayOfYear(y,m,d);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int retry;

        System.out.println("그 해 경과 일수를 구합니다.");
        do {
            System.out.print("년 : "); int year = sc.nextInt();
            System.out.print("월 : "); int month = sc.nextInt();
            System.out.print("일 : "); int day = sc.nextInt();

            System.out.printf("그 해 %d일째 입니다. \n", dayOfYear(year,month,day));
            System.out.printf("남은 일수는 %d일 입니다. \n", leftDayOfYear(year,month,day));
            System.out.print("한번 더 할까요? (1. 예 / 0. 아니오) : ");
            retry = sc.nextInt();
        } while (retry==1);
    }


}
