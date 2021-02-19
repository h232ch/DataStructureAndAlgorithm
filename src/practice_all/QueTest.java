package practice_all;

public class QueTest {

    private int front;
    private int rear;
    private int max;
    private int num;
    private int[] que;

    class ExceptionOverflow extends RuntimeException{
        @Override
        public String getMessage() {
            return "Overflow Occurred!";
        }
    }

    class ExceptionEmpty extends RuntimeException {

    }

    public QueTest(int capacity) {
        front = rear = num = 0;
        max = capacity;
        que = new int[max];
    }

    public void enque(int n) {
        if (num >= max) {
            throw new ExceptionOverflow();
        }
        num++;
        que[rear++] = n;
        if (rear >= max) {
            rear = 0;
        } // Cycle
    }

    public int deque() {
        if (num <= 0) {
            throw new ExceptionEmpty();
        }
        num++;
        int n = que[front++];
        if (front == max) {
            front = 0;
        }
        return n;
    }

    public static void main(String[] args) {
        QueTest q1 = new QueTest(6);
        q1.enque(5);
        q1.enque(5);
        q1.enque(5);
        q1.enque(5);
        q1.enque(5);
        q1.enque(5);
        q1.enque(5);
    }
}
