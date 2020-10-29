package chap01;
import java.util.Scanner;

public class Digit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no;

        System.out.println("2자리의 정수를 입력하세요.");
        no = sc.nextInt();
        do {
            System.out.println("입력 : ");
            no = sc.nextInt();
        } while (no<10 || no>99); // 계속조건
//        while !(no >= 10 && no <= 99) // 드모르간 법칙 (조건절이 아닐경우 True를 return함) // 종료조건
//        각 조건을 부정하고 논리곱을 논리합으로, 논리합을 논리곱으로 바꾸고 다시 전체를 부정하면 원래의 조건과 같다
//        x && y와 !(!x || !y)는 같다.
//        x || y와 !(!x && !y)는 같다.

        System.out.println("변수 no의 값은 " + no + "가(이) 되었습니다.");
    }
}
