package chap08.practice;

public class Q1 {

    static int bfMatchLast(String txt, String pat) {
        int pt = 0;
        int pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if (pp == pat.length())
            return pt - pp + pp - 1;
        return -1;
    }

    static int bfMatch(String txt, String pat) {
        int pt = 0;
        int pp = 0;

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {

                System.out.println(txt);
                int len = 0;
                int len2 = txt.substring(0, pt - pp).getBytes().length;
                for (int i = 0; i < pt; i++)
                    len += txt.substring(i, i + 1).getBytes().length;
                System.out.printf(String.format("%%%ds\n", len + 1), "+");
                System.out.printf(String.format("%%%ds\n", len2 + 2), pat);

                pt++;
                pp++;
            } else {
                System.out.println(txt);
                int len = 0;
                int len2 = txt.substring(0, pt).getBytes().length;
                for (int i = 0; i < pt; i++)
                    len += txt.substring(i, i + 1).getBytes().length;
                System.out.printf(String.format("%%%ds\n", len + 1), "-");
                System.out.printf(String.format("%%%ds\n", len2 + 2), pat);

                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if (pp == pat.length())
            return pt - pp;
        return -1;
    }

    public static void main(String[] args) {
        String txt = "ABCDEFGHIJKLNM";
        String pat = "GHIJ";

        int result = bfMatch(txt, pat);

        System.out.println(result);
        if (result == -1)
            System.out.println("There is no string in the text");
        else {
//            System.out.println(txt);
//            int len = 1;
//            for (int i = 0; i < result; i++)
//                len += txt.substring(i, i + 1).getBytes().length;
//            System.out.printf(String.format("%%%ds\n", len + 1), pat);
        }

        System.out.println(bfMatchLast(txt, pat));

    }
}
