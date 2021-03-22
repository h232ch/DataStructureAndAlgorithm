package practice_all;

public class QueTest2 {

    private int front;
    private int rear;
    private int max;
    private int num;
    private int[] que;

    class ExceptionOverflow extends RuntimeException {
    }

    class ExceptionEmpty extends RuntimeException {
    }

    public QueTest2(int capacity) {
        front = rear = num = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }

    public void enque(int n) {
        if (num >= max) {
            throw new ExceptionOverflow();
        }
        num++;
        que[rear++] = n;
        if (rear == max) {
            rear = 0;
        }
    }

    public int deque() {
        if (num <= 0) {
            throw new ExceptionEmpty();
        }
        num--;
        int n = que[front++];
        if (front == max) {
            front = 0;
        }
        return n;
    }

    public int indexOf(int n) {
        if (num <= 0) {
            throw new ExceptionEmpty();
        }
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == n) {
                return idx;
            }
        }
        return -1;
    }

    public int peek() {
        if (num <= 0) {
            throw new ExceptionEmpty();
        }
        return que[front];
    }

    public void clear() {
        front = rear = num = 0;
    }

    public static void main(String[] args) {
        QueTest2 q1 = new QueTest2(5);
        q1.enque(10);
        q1.enque(10);
        q1.enque(10);
        q1.enque(10);

        q1.deque();
        q1.deque();
        q1.deque();

        System.out.println(q1.peek());

        q1.enque(29);
        q1.enque(29);
        q1.enque(29);

        System.out.println(q1.indexOf(29));
    }
}
