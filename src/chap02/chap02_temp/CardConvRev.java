package chap02.chap02_temp;

import java.util.Scanner;

public class CardConvRev {

    static int cardConvR(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDRFGHIJKLMNOPQRSTUBWXYZ";
        do{
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);
        return digits;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cd;
        int no;
        int dno;
        int retry;
        char[] cno = new char[32];

        System.out.println("10진수를 기수 변환합니다.");
        do{
            do{
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = sc.nextInt();
            } while (no < 10);

            do{
                System.out.print("어떤 진수로 변환할까요? (2~32) : ");
                cd = sc.nextInt();
            } while (no < 0);

            dno = cardConvR(no, cd, cno);
            System.out.print(cd + "진수는 ");
            for(int i = dno -1; i>=0; i--){
                System.out.print(cno[i]+" ");
            }
            System.out.print("입니다.");
            System.out.println();
            System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
            retry = sc.nextInt();
        } while(retry == 1);

    }
}
