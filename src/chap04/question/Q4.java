package chap04.question;

import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Queue Size : ");
        int queSize = sc.nextInt();
        Q4Queue que = new Q4Queue(queSize);

        while (true) {
            System.out.print("(1)EnQueue (2)DeQueue (3)Dump " +
                    "(4)Clear (5)Queue Size (6)Data Size" +
                    " (7)isFull? (8)isEmpty? " +
                    "(0)Exit : ");
            int sw = sc.nextInt();
            if (sw == 0) break;
            switch (sw) {
                case 1:
                    try {
                        System.out.print("Input Data : ");
                        int tmp = sc.nextInt();
                        que.enQueue(tmp);
                    } catch (Q4Queue.FullDataException e) {}
                    break;

                case 2:
                    try {
                        System.out.println("DeQueue Number que[0] : " + que.deQueue());
                    } catch (Q4Queue.EmptyDataException e) {}
                    break;

                case 3:
                    try {
                        que.dump();
                    } catch (Q4Queue.EmptyDataException e) {}
                    break;

                case 4:
                    que.clearQueue();
                    break;

                case 5:
                    System.out.println(que.getQueueSize());
                    break;

                case 6:
                    try {
                        System.out.println(que.getDataSize());
                    } catch (Q4Queue.EmptyDataException e) {}
                    break;

                case 7:
                    que.isFull();
                    break;

                case 8:
                    que.isEmpty();
                    break;
            }
        }


    }
}
