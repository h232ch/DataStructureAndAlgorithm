package chap01;

import java.util.Scanner;

public class Q12 {
    public static void main(String[] args){
        // Q12 위쪽과 왼쪽에 곱하는수가 있는 곱센표를 출력
        System.out.println(" |\t1\t2\t3\t4\t5\t6\t7\t8\t9");
        System.out.println("--+------------------------------------");
        for(int i=1; i<=9; i++){
            System.out.print(i+"|\t");
            for(int j=1; j<=9; j++){
                System.out.print(i*j+"\t");
            }
            System.out.println();
        }


        // Q13 덧셈을 출력하는 프로그램 작성
        System.out.println();
        System.out.println(" |\t1\t2\t3\t4\t5\t6\t7\t8\t9");
        System.out.println("--+------------------------------------");
        for(int i=1; i<=9; i++){
            System.out.print(i+"|\t");
            for(int j=1; j<=9; j++){
                System.out.print(i+j+"\t");
            }
            System.out.println();
        }
        
        // Q14 입력한 수를 한변으로 하는 정사각형을 *로 출력
        Scanner sc = new Scanner(System.in);
        System.out.println("사각형을 출력합니다.");
        System.out.println("단 수 : ");
        int num = sc.nextInt();

        for (int i=0;i<num;i++){
            for (int j=0; j<num;j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
