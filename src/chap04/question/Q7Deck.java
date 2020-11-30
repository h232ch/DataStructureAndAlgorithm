package chap04.question;

public class Q7Deck {

    public static class EmptyError extends RuntimeException {
        public EmptyError() {
            System.out.println("Que is emptry.");
        }
    }

    public static class FullError extends RuntimeException {
        public FullError() {
            System.out.println("Que is full.");
        }
    }

    private int[] que;
    private int front1;
    private int front2;
    private int rear1;
    private int rear2;
    private int max;
    private int num;

    public Q7Deck(int max) {
        this.que = new int[max];
        this.max = max;
        this.front1 = this.front2 = this.rear1 = this.num = this.rear2 = 0;
    }

    private int enqueData(int sw, int data) {
        num++;
        if (sw == 1) {
            que[rear1++] = data;
            if (rear1 == rear2) {
                rear1 = 0;
            }
        } else if (sw == 2) {
            que[rear2++] = data;
            if (rear1 == rear2) {
                rear2 = 0;
            }
        } else {
            data = -1;
        }
        return data;
    }

    private int dequeData(int sw) {
        if (sw == 1) {
            num--;
            return que[front1++];
        } else if (sw == 2) {
            num--;
            return que[front2++];
        } else {
            return -1;
        }
    }

    public int enque(int sw, int data) {
        if (num >= max)
            throw new FullError();
        return enqueData(sw, data);
    }

    public int deque(int sw) {
        if (num <= 0) throw new EmptyError();
        else
            return dequeData(sw);
    }

}
