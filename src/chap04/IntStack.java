package chap04;

import java.lang.reflect.Array;
import java.util.Objects;

public class IntStack<T> {

    private int max; // stack size
    private int ptr; // stack pinter
    private T[] stk; // stack

    // 실행 시 예외 : 스택이 비어 있음
    public static class EmptyIntStackException extends RuntimeException { //
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public static class OverflowIntStackException extends RuntimeException { //
        public OverflowIntStackException() {}
    }
    
    // 생성자
    public IntStack(Class<T>dataType, int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (T[]) Array.newInstance(dataType, capacity); // 스택 본체 배열 생성
            // Generic Type 사용시 (T[]) Array.newInstance(dataType, capacity) 로 변경
        } catch (OutOfMemoryError error) { // 생성 불가
            max = 0;
        }
    }

    // 스택에 x를 푸시
    public T push(T x) throws OverflowIntStackException {
        if (ptr >= max)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public T pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }


    // 스택에서 데이터를 피크(정상에 있는 데이터를 들여다 봄)
    public T peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 스택의 특정값 검색 (먼저 pop되는 상위부터)
    public int indexOf(T x) {
        for (int i = ptr -1; i >= 0; i--)
            if (stk[i] == x)
                return i;
        return -1;
    }

    // 스택을 비움
    public void clear() {
        ptr = 0;
    }

    // 스택의 용량을 반환
    public int capacity() {
        return max;
    }

    // 스택에 쌓인 테이터 수를 반환
    public int size() {
        return ptr;
    }

    // 스택이 비어있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
    }

    public int ptrLocation(){
        return ptr;
    }

}
