package chap04;

import java.util.Scanner;

public class IntStackTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        IntStack<Integer> s = new IntStack<Integer>(Integer.class,5); // 최대 64개를 푸시할 수 있는 스택

        IntStack s = new IntStack(5);
        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1)Push (2)Pop (3)Peek (4)Dump (5)Search Number " +
                    "(6)Delete All (7)Stack Capacity (8)Stack is Full? (9)Stack is Empty? " +
                    "(10)Pointer Location (0)Exit : ");

            int menu = sc.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try{
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    try{
                        System.out.print("Input Searching Number : ");
                        int fNum = sc.nextInt();
                        int idx = s.indexOf(fNum);
                        if (idx != -1)
                            System.out.println("The number is Stack ["+idx+"].");
                        else
                            System.out.println("The number is not existed.");

                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("Stack is Empty.");
                    }
                    break;

                case 6:
                    System.out.println("All Data is Deleted");
                    s.clear();
                    break;

                case 7:
                    System.out.println("Stack Capacity : " + s.capacity());
                    break;

                case 8:
                    boolean st1 = s.isFull();
                    if (st1)
                        System.out.println("Stack is Full.");
                    else
                        System.out.println("Stack is not Full.");
                    break;

                case 9:
                    boolean st2 = s.isEmpty();
                    if (st2)
                        System.out.println("Stack is Empty.");
                    else
                        System.out.println("Stack is not Empty");
                    break;

                case 10:
                    System.out.println("Pointer Location : " + s.peek());
                    break;
            }

        }
    }
}
