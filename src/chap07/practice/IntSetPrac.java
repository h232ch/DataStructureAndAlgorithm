package chap07.practice;

import chap07.IntSet;

public class IntSetPrac {

    public int max;
    public int num;
    private int[] set;

    public IntSetPrac(int capacity) {
        max = capacity;
        num = 0;
        try {
            set = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int capacity() { return max;}

    public int size() { return num;}

    public int indexOf(int n) {
        intSortedSet();
        int pl = 0;
        int pr = num;

        do {
            int pc = (pl + pr) / 2;
            if (set[pc] == n) return pc;
            else if (n > set[pc]) pl = pc + 1;
            else pr = pc - 1;
        } while (pl <= pr);

        return -1;
    }

    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    public void intSortedSet() {
        for (int i = 1; i < num; i++) {
            int temp = set[i];
            int j;
            for (j = i; j > 0 && set[j - 1] > temp; j--) {
                set[j] = set[j - 1];
            }
            set[j] = temp;
        }
    }

    public boolean add(int n) {
        if (num >= max || contains(n) == true)
            return false;
        else {
            set[num++] = n;
            return true;
        }
    }

    public void copyTo(IntSetPrac s) {
        int n = (s.max < num) ? s.max : num;
        for (int i = 0; i < n; i++)
            s.set[i] = set[i];
        s.num = n;
    }

    public void copyFrom(IntSetPrac s) {
        int n = (max < s.num) ? max : s.num;
        for (int i = 0; i < n; i++)
            set[i] = s.set[i];
        num = n;
    }

    public boolean equalTo(IntSetPrac s) {

        if (num != s.num)
            return false;

        for (int i = 0; i < num; i++) {
            int j;
            for (j = 0; j < s.num; j++)
                if (set[i] == s.set[j]) break;
            if (j == s.num) return false;
        }
        return true;
    }

    public boolean remove(int n) {
        int idx;

        if (num <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else {
            set[idx] = set[--num]; // idx에 set의 마지막 요소를 넣어주고 num을 1 감소시킴
            return true;
        }
    }

    public void unionOf(IntSetPrac s1, IntSetPrac s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++)
            add(s2.set[i]);
    }

    public String toString() {
        StringBuffer st = new StringBuffer("{ ");
        for (int i = 0; i < num; i++)
            st.append(set[i] + " ");
        st.append("}");
        return st.toString();
    }

    public boolean isEmpty() {
        return (num == 0) ? true : false;
    }

    public boolean isFull() {
        return (num >= max) ? true : false;
    }

    public void clear() {
        num = 0;
    }

    public boolean retain(IntSetPrac s) {
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if (!s.contains(set[i])) {
                remove(set[i]);
                flag = true;
            }
        return flag;
    }

    public boolean cRemove(IntSetPrac s) {
        boolean flag = false;
        for (int i = 0; i < s.num; i++) {
            int j = 0;
            for (; j < num; j++) {
                if (s.set[i] == set[j]) {
                    remove(set[j]);
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean cRemove2(IntSetPrac s) {
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if (s.contains(set[i]) == true) {
                remove(set[i]);
                flag = true;
            }
        return flag;
    }

    public boolean isSubsetOf (IntSetPrac s) {
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if (contains(s.set[i])) flag = true;
        return flag;
    }

    public boolean isProperSubsetOf (IntSetPrac s) {
        int cnt = 0;
        for (int i = 0; i < s.num; i++)
            if (contains(s.set[i])) cnt++;
        return cnt == s.num;
    }

    public void intersectionOf(IntSetPrac s1, IntSetPrac s2) {
        clear();
        for (int i = 0; i < s2.num; i++)
            if (s1.contains(s2.set[i])) add(set[i]);
    }

    public void differenceOf(IntSetPrac s1, IntSetPrac s2) {
        clear();
        int n = Math.max(s1.num, s2.num);
        for (int i = 0; i < s2.num; i++) {
            if (!s1.contains(s2.set[i]) || !s2.contains(s1.set[i])) add(set[i]);
        }
    }
}
