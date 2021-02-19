package practice_all;

public class StkTest {

    private int ptr;
    private int max;
    private int[] stk;

    class ExceptionOverflow extends RuntimeException {
    }

    class ExceptionEmpty extends RuntimeException {

    }

    public StkTest(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }

    public int push(int n) {
        if (ptr >= max) {
            throw new ExceptionOverflow();
        }
        return stk[ptr++] = n;
    }

    public int pop() {
        if (ptr <= 0) {
            throw new ExceptionEmpty();
        }
        return stk[--ptr];
    }

    public int indexOf(int n) {
        if (ptr <= 0) {
            throw new ExceptionEmpty();
        }
        for (int i = 0; i < ptr; i++) {
            if (stk[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public int peek() {
        return stk[ptr - 1];
    }

    public static void main(String[] args) {
        StkTest stk = new StkTest(5);
        stk.push(10);
        stk.push(10);
        stk.push(10);
        stk.push(10);

        stk.pop();
        stk.pop();
        stk.pop();

        System.out.println(stk.peek());
    }
}
