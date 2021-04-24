package chap04;

import java.util.Queue;

public class IntQueue {

    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public static class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    public static class OverflowIntQueueException extends RuntimeException {
        OverflowIntQueueException() {};
    }

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(int x) {
        if (num >= max)
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;

        if (rear == max)
            rear = 0;
        return x;
    }

    public int deque() {
        if (num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public int peek() { // throws의 경우 예외를 전가하는 역할, throw의 경우 예외를 직접 처리하는 역할을 함
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num <= 0;
    }

    public boolean isFull(){
        return num >= max;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("Que is empty");
        else
            for (int i = 0; i < num; i++){
                System.out.print(que[(i+front) % max]  + " ");
            }
            System.out.println();
    }


    /* Q5 클래스 IntQueueㅇ[ 임의의 데이터를 검색하는 아래의 메서드 추가
    메서드는 indexOf처럼 찾은 위치의 배열 인덱스를 변환하는것이 아니라 큐 안에 몇번째에 있는가를  양수로 반환 */
}
