package chap09;

import java.util.Comparator;

public class DblLinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        // Constructor
        Node() {
            data = null;
            prev = next = this;
        }

        // Constructor
        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DblLinkedList() {
        head = crnt = new Node<E>();
    }

    // is the list empty?
    public boolean isEmpty() {
        return head.next == head;
    }

    // Searching Node
    public E search(E obj, Comparator<? super E> comparator) {
        Node<E> ptr = head.next; // Current Node

        while (ptr != head) {
            if (comparator.compare(obj, ptr.data) == 0) { // searching finished
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next; // next node
        }
        return null; // searching failed
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (isEmpty()) {
            System.out.println("선택 노드가 업습니다.");
        } else {
            System.out.println(crnt.data);
        }
    }

    // 모든 노드를 출력
    public void dump() {
        Node<E> ptr = head.next;
        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    // 모든 노드를 거꾸로 출력
    public void dumpReverse() {
        Node<E> ptr = head.prev;
        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (isEmpty() || crnt.next == head) {
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    // 선택 노드를 하나 앞쪽으로 이동
    public boolean prev() {
        if (isEmpty() || crnt.prev == head) {
            return false;
        }
        crnt = crnt.prev;
        return true;
    }

    // crnt 노드의 바로 뒤에 노드를 삽입
    public void add(E obj) {
        Node<E> node = new Node<>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    // 머리에 노드를 삽입
    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    // 꼬리에 노드를 삽입
    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    // 현재 노드를 삭제함
    private void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head) {
                crnt = head.next;
            }
        }
    }

    public void remove(Node p) {
        if (!isEmpty()) {
            Node<E> ptr = head.next;
            while (ptr != head) {
                if (ptr == p) {
                    crnt = p;
                    removeCurrentNode();
                    break;
                }
            }
        }
    }

    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    public void clear() {
        while (!isEmpty()) { // 텅 빌때까지
            removeFirst(); // 머리 노드를 삭제
        }
    }
}
