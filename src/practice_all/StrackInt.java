package practice_all;

import chap04.IntQueue;
import chap04.IntStack;


public class StrackInt {

    private int ptr;
    private int max;
    private int[] stk;

    public class ExcpetionStack extends RuntimeException {
    }

    public StrackInt(int capacity) {
        try {
            ptr = 0;
            max = capacity;
            stk = new int[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }

    public int push(int n) {
        if (ptr >= max) {
            throw new ExcpetionStack();
        }
        return stk[ptr++] = n;
    }

    public int pop(int n) {
        if (ptr <= 0) {
            throw new ExcpetionStack();
        }
        return stk[--ptr];
    }

    public int peek() {
        return stk[ptr];
    }

    public int indexOf(int n) {
        if (ptr <= 0) {
            throw new ExcpetionStack();
        }
        int pl = 0;
        int pr = ptr - 1;

        do {
            int pc = (pl + pr) / 2;
            if (stk[pc] == n) {
                return pc;
            } else if (stk[pc] < n) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1;
    }


    public static void main(String[] args) {
        StrackInt stk = new StrackInt(5);
        stk.push(1);
        stk.push(12);
        stk.push(13);
        stk.push(15);
        stk.push(17);

        System.out.println(stk.indexOf(17));
    }
}
