package chap04.question;

public class Q3Stack {
    private int[] arr;
    private int max;
    private int ptrSt1;
    private int ptrSt2;

    public Q3Stack(int max) {
        this.max = max;
        this.ptrSt1 = 0;
        this.ptrSt2 = max - 1;
        this.arr = new int[max];
    }

    public static class UserEmptyException extends RuntimeException {
        public UserEmptyException() {
            System.out.println("Stack is full");
        }
    }

    public static class DoubleStack extends RuntimeException {
        public DoubleStack() {
            System.out.println("Double Stack");
        }
    }

    public int push(int st, int num) {
        if (ptrSt1 >= max || ptrSt2 < 0) {
            throw new UserEmptyException();
        }
        else if (ptrSt1 > ptrSt2)
            throw new DoubleStack();
        else if (st == 1)
            return arr[ptrSt1++] = num;
        else if (st == 2)
            return arr[ptrSt2--] = num;
        else
            return -1;
    }

    public int pop(int st) {
        if ((st == 1 && ptrSt1 <= 0) || (st == 2 && ptrSt2 >= max - 1))
            throw new UserEmptyException();
        else if (st == 1)
            return --ptrSt1;
        else if (st == 2)
            return ++ptrSt2;
        else
            return -1;
    }

    public void dump() {
        System.out.print("STACK 1 : ");
        for (int i = 0; i < ptrSt1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("STACK 2 : ");
        for (int i = ptrSt2+1; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


    }
}
