package chap08;

public class BMmatch {

    static int bmMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        // 건너뛰기 표 만들기;
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }

        System.out.print("Skip Table : ");
        for (pt = 0; pt < patLen - 1; pt++) {
            skip[pat.charAt(pt)] = patLen - pt - 1; //pt == patLen - 1;
            System.out.printf("%3c %3d %c",pat.charAt(pt) , skip[pat.charAt(pt)], (pt == patLen - 2) ? '\n' : ' ');
        }

        while (pt < txtLen) {

            pp = pat.length() - 1;
            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) return pt;
                pt--;
                pp--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "ABCKDJFJSDHSUSUYFJSKD";
        String s2 = "DHSU";

        System.out.println("Matching PT Number : " + bmMatch(s1, s2));
    }
}