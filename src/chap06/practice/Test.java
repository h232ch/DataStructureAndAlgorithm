package chap06.practice;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int cnt = 1;

        st.push(1);
        st.push(2);

        System.out.println(st.elementAt(1));
        System.out.println(st.size());


        for (int i = st.size() - 1; i >= 0; i--) {
            if (i == st.size() - 1) System.out.println("Phase [" + cnt++ + "]");
            System.out.printf("| %2d , %2d | %c", st.elementAt(i), st.elementAt(i), '\n');
        } System.out.println("-----------");

        for (int i = st.size() - 1; i >= 0; i--) {
            if (i == st.size() - 1) System.out.println("Phase [" + cnt++ + "]");
            System.out.printf("| %2d , %2d | %c", st.elementAt(i), st.elementAt(i), '\n');
        } System.out.println("-----------");
    }
}
