package chap08;

import java.util.Scanner;

public class BFmatch {

    static int bfMatch(String txt, String pat) {
        
        // txt = 원본, pat = 문자열
        int pt = 0; // txt 커서
        int pp = 0; // pat 커서

        while (pt != txt.length() && pp != pat.length()) { // pt가 가득차거나 (실패), pp가 가득찰때까지 (성공) 반복문 수행
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1; // pt, pp를 움직인 만큼 빼고 +1을 하여 다음칸으로 이동후 비교를 계속함
                pp = 0;
            }
        }

        if (pp == pat.length())
            return pt  - pp; // pp가 가득찬 상태로 끝났기 때문에 pt - pp는 pp의 시작 위치를 의미함
        return -1; // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("텍스트 : "); // 텍스트용 문자열 s1
        String s1 = sc.next();

        System.out.println("패턴 : "); // 패턴용 문자열 s2
        String s2 = sc.next();

        int idx = bfMatch(s1, s2); // 문자열 s1에서 문자열 s2를 검색
        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패턴 : %%%ds\n",len), s2); // %%%ds -> len = 4 -> %4s, s2

        }
    }
}
