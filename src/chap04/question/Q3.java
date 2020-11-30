package chap04.question;


import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q3Stack st = new Q3Stack(5);

        while (true) {

            System.out.print("Select Stack (1) or (2) : ");
            int selSt = sc.nextInt();

            System.out.print("1.Push 2.Pop " +
                    "3.Dump 0.Exit : ");
            int sw = sc.nextInt();
            if (sw == 0) break;

            switch (sw){
                case 1:
                    try {
                        System.out.print("Input Number : ");
                        int data = sc.nextInt();
                        st.push(selSt, data);

                    } catch (Q3Stack.UserEmptyException | Q3Stack.DoubleStack e) {

                    }
                    break;

                case 2:
                    try {
                        int idx = st.pop(selSt);
                        System.out.println("Pop Data : Stack[" + idx +"]");
                    } catch (Q3Stack.UserEmptyException e) {
                        System.out.println("Stack is empty");
                    }
                    break;

                case 3:
                    st.dump();

            }

        }


    }
}
