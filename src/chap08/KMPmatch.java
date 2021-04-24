package chap08;

public class KMPmatch {

    static int kmpMatch(String txt, String pat) {
        int pt = 1; // pt가 0인 이유는 pat 배열의 첫번째 요소를 pp와 비교하기 위함
        int pp = 0;

        int[] skip = new int[pat.length() + 1];
        // 건너뛰기 표를 만듭니다.

        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }


//        System.out.printf("SKIP : ");
//        for (int i = 0; i < skip.length; i++) {
//            System.out.printf("%3s%c", skip[i], (i != skip.length - 1) ? ' ' : '\n');
//        }

        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {

            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
        }

        if (pp == pat.length())
            return pt - pp;
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "ABCRFJFHDGHABCDJFDGJGUABCDFAF";
        String s2 = "ABCGGABCJJFABCIOUU";

        kmpMatch(s1, s2);
    }
}
