package chap05;

import chap04.IntStack;

import java.util.Stack;

public class RecursX2 {
    static void recur(int n) {
//        IntStack s = new IntStack(Integer.class, n);
        Stack<Integer> s = new Stack<>();
        while (true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }

            if (s.isEmpty() != true) {
                n = (int) s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        recur(4);
    }
}
