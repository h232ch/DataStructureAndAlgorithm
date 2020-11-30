package chap04.question;

import chap04.IntQueue;

import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {

//        Q6GenericQue<Integer> que = new Q6GenericQue<Integer>(6);
//        System.out.println(que.save(1));
//        System.out.println(que.get(0));

        Q6GenericQue<Integer> que = new Q6GenericQue<>(Integer.class, 3);
        Scanner sc = new Scanner(System.in);
        int x;
        int temp;
        while (true){
            System.out.println("데이터 : " + que.getSize() + " / " + que.getMax());
            System.out.print("(1)인큐 (2)디큐 (3)서치 (4)덤프 (0)종료 : ");
            x = sc.nextInt();
            if (x == 0) break;
            switch (x) {
                case 1:
                    try {
                        System.out.print("데이터 : ");
                        temp = sc.nextInt();
                        System.out.println("데이터 " + que.enque(temp) +"를 입력했습니다.");
                    } catch (Q6GenericQue.FullErrorException e) {

                    }
                    break;

                case 2:
                    try {
                        System.out.println("데이터 " + que.deque() +"를 내보냈습니다.");
                    } catch (Q6GenericQue.EmptyErrorException e) {}
                    break;

                case 3:
                    try {
                        System.out.print("데이터 : ");
                        temp = sc.nextInt();
                        int result = que.searchOf(temp);
                        if (result != -1)
                            System.out.println("찾는 데이터는 큐[" + result +"]에" +
                                "위치하고 있습니다.");
                        else
                            System.out.println("찾는 데이터가 존재하지 않습니다.");
                    } catch (Q6GenericQue.EmptyErrorException e) {}
                    break;

                case 4:
                    try {
                        System.out.print("덤프 데이터 : ");
                        que.dump();
                    } catch (Q6GenericQue.EmptyErrorException e) {}
                    break;
            }
        }

    }
}
