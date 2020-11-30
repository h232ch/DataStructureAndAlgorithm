package chap04.question;

public class Q4Queue {

    public static class EmptyDataException extends RuntimeException {
        public EmptyDataException() {
            System.out.println("Data is Empty.");
        };
    }

    public static class FullDataException extends RuntimeException {
        public FullDataException() {
            System.out.println("The Queue is Full.");
        }
    }

    private int max; // 큐 용량
    private int num; // 현재 테이터 수
    private int[] que; // 큐본체


    public Q4Queue (int max) {
        this.max = max;
        this.num = 0;
        this.que = new int[max];
    }

    public int enQueue(int data) {
        if (num >= max)
            throw new FullDataException();
        else
            return que[num++] = data;
    }

    public int deQueue() {
        int dNum = que[0];
        if (num == 0)
            throw new EmptyDataException();
        else
            for (int i = 0; i < num; i++) {
                if (i == num-1)
                    que[i] = 0;
                else
                    que[i] = que[i+1];
            }
            num--;
            return dNum;
    }

    public void clearQueue() {
//        for (int i = 0; i < num; i++) {
//            que[i] = 0;
//        }
        num = 0;
        System.out.println("Data is Clear");
    }

    public int getQueueSize() {
        return max;
    }

    public int getDataSize() {
        if (num == 0)
            throw new EmptyDataException();
        else
            return num;
    }

    public void isFull() {
        if (max == num)
            System.out.println("Queue is Full");
        else
            System.out.println("Queue is Not Full");
    }

    public void isEmpty() {
        if (que[0] == 0)
            System.out.println("Queue is Empty");
        else
            System.out.println("Queue is Not Empty");
    }

    public void dump() {
        if (num == 0)
            throw new EmptyDataException();
        else
            System.out.print("QUEUE DATA : ");
            for (int i = 0; i < num; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println();
    }
}
