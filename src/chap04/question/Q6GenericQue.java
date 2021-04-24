package chap04.question;

import java.lang.reflect.Array;

public class Q6GenericQue<E> {

    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    // 제네릭으로 배열의 생성자를 만드는 방법 1

    public Q6GenericQue(Class<E> eClass, int max) {
        this.que = (E[]) Array.newInstance(eClass, max);
        this.max = max;
        front = rear = num = rear = 0;
    }


    /* 제네릭으로 배열의 생성자를 만드는 방법 2
    private Object[] a;

    public Q6GenericQue(int s) {
        a = new Object[s];
    }

    public E save (int x) {
        a[0] = x;
        return (E) a[0];
    }

    public E get(int i) {
        return (E) a[i];
    }
     */

    public static class EmptyErrorException extends RuntimeException {
        public EmptyErrorException() {
            System.out.println("큐가 비어있습니다.");
        }
    }

    public static class FullErrorException extends RuntimeException {
        FullErrorException () {
            System.out.println("큐가 가득 차있습니다.");
        }
    }

    public E enque(E x) {
        if (num >= max)
            throw new FullErrorException();
        else
            num++;
            if (rear == max)
                rear = 0;
            return que[rear++] = x;
    }

    public E deque() {
        if (num <= 0)
            throw new EmptyErrorException();
        else
            num--;
            if (front == max)
                front= 0;
            return que[front++];
    }

    public int searchOf(E x) {
        if (num <= 0)
            throw new EmptyErrorException();
        else
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % max;
                if (que[idx] == x)
                    return idx;
            }
        return -1;
    }

    public void dump() {
        if (num <= 0)
            throw new EmptyErrorException();
        else
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % max;
                System.out.print(que[idx] + " ");
            }
            System.out.println();
    }

    public int getSize() {
        return num;
    }

    public int getMax() {
        return max;
    }
}
