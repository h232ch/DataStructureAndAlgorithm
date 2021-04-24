package chap09;

import java.util.Comparator;

public class LinkedList<E> {

    // 노드
    class Node<E> {
        private E data;
        private Node<E> next;
        // 생성자
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head; // 현재 스캔중인 노드
        
        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) { // 검색성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }
    
    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            Node<E> ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<>(obj, null);
        }
    }
    
    //머리 노드를 삭제
    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null) // 노드가 하나만 있으면
                removeFirst(); // 머리 노드를 삭제
            else {
                Node<E> ptr = head; // 스캔중인 노드
                Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null; // pre 삭제 후의 꼬리노드 (pre 앞은 꼬리 노드인 ptr이 존재함)
                crnt = pre;
            }
        }
    }

    // 노드 p를 삭제
    public void remove(Node<E> p) {
        if (head != null) {
            if (p == head)
                removeFirst();
            else {
                Node<E> ptr = head;
                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return;
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 현재 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false; // 이동불가 (비어있거나 마지막 노드인 경우)
        crnt = crnt.next;
        return true;
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != null) // 노드에 아무것도 없을때까지
            removeFirst(); // 머리 노드를 삭제함 (Head -> next -> next -> null)
        crnt = null;
    }

    // 모든 노드를 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) { // 마지막 노드까지 출력
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
    
}
