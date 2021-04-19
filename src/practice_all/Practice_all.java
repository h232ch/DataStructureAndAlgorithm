package practice_all;

public class Practice_all {


    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
        return a;
    }

    static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(a, i, min);
            }
        }
        return a;
    }

    static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            int temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--) {
                a[j - 1] = a[j];
            }
            a[j] = temp;
        }
        return a;
    }

    static int[] shellSort(int[] a) {
        for (int h = a.length / 2; h > 0; h /= 2) {
            for (int i = h; i < a.length; i++) {
                int j;
                int temp = a[i];
                for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = temp;
            }
        }
        return a;
    }

    static int[] buff = new int[20];
    static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int j = 0;
            int p = 0;
            int k = left;
            int center = (left + right) / 2;

            mergeSort(a, left, center);
            mergeSort(a, center + 1, right);

            for (i = left; i <= center; i++) {
                buff[p++] = a[i];
            }

            while (i <= right && j < p) {
                a[k++] = buff[j] < a[i] ? buff[j++] : a[i++];
            }

            while (j < p) {
                a[k++] = buff[j++];
            }
        }
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = (left + right) / 2;

        do {
            while (a[pl] < a[x]) pl++;
            while (a[pr] > a[x]) pr--;
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(a, left, pr);
        }

        if (pl < right) {
            quickSort(a, pl, right);
        }
    }

    static void downHeap(int[] a, int left, int right) {
        int parent;
        int child;
        int temp = a[left];

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;

            child = (cr <= right && a[cr] >= a[cl]) ? cr : cl;
            if (temp >= a[child]) {
                break;
            }
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(a, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }


    static int bfMatch(String txt, String pat) {

        int pt = 0;
        int pp = 0;

        while (pt < txt.length() && pp < pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if (pp == pat.length()) {
            return pt - pp;
        }

        return -1;
    }

    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length() + 1];

        while (pt < pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp)) {
                skip[++pt] = ++pp;
            } else if (pp == 0) {
                skip[++pt] = pp;
            } else {
                pp = skip[pp];
            }
        }

        pt = pp = 0;
        while (pt < txt.length() && pp < pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else {
                pp = skip[pp];
            }
        }

        if (pp == pat.length()) {
            return pt - pp;
        }

        return -1;
    }


    static int bmMatch(String txt, String pat) {
        int pt = 0;
        int pp = 0;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for (int i = 0; i <= Character.MAX_VALUE; i++) {
            skip[i] = patLen;
        }

        for (int i = 0; i < patLen - 1; i++) {
            skip[pat.charAt(i)] = patLen - i - 1;
        }

        while (pt < txtLen) {
            pp = patLen - 1;
            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) {
                    return pt;
                }

                pt--;
                pp--;
            }

            pt += skip[txt.charAt(pt)] > patLen - pp ? skip[txt.charAt(pt)] : patLen - pp;
        }

        return -1;
    }


    public static void main(String[]args) {

        int[] a = {3, 54, 7, 7, 3, 22, 54, 54};
        heapSort(a, a.length);
        for (int temp : a) {
            System.out.printf("%3d", temp);
        }
        System.out.println();

        String txt = "ABCDEFABCGABDFABDC";
        String pat = "ABD";

        System.out.println(bmMatch(txt, pat));

    }
}
