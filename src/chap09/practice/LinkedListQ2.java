package chap09.practice;

import chap09.LinkedList;

import java.util.Comparator;

public class LinkedListQ2<E> {

    class Node2<E> { // node class which can have a data and next node
        private E data;
        private Node2<E> next;
        private Node2<E> tail;

        Node2(E data, Node2<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node2<E> head;
    public Node2<E> crnt;
    public Node2<E> tail;

    LinkedListQ2 () {
        head = crnt = tail = null;
    }

    public E search(E data, Comparator<? super E> comparator) {
        Node2<E> ptr = head;
        while (ptr != null) {
            if (comparator.compare(ptr.data, data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void addFirst(E obj) {
        boolean empty = (tail == null);
        Node2<E> ptr = head;
        head = crnt = new Node2<E>(obj, ptr);
        if (empty) tail = crnt;
    }

    public void addFirst2(E data) {
        Node2<E> ptr = head;
        head = crnt = new Node2<>(data, ptr);
    }

    public void addLast(E data) {
        if (head == null)
            addFirst(data);
        else {
            Node2<E> ptr = head;
            while (ptr.next != null) ptr = ptr.next;
            ptr.next = crnt = new Node2<>(data, null);

            // tail.next = crnt = new Node2<>(data, null);
            tail = crnt;
        }
    }

    public boolean removeFirst() {
        if (head != null) {
            head = crnt = head.next;
            return true;
        }
        return false;
    }

    public boolean removeLast() {
        if (head != null) {
            if (head.next == null)
                removeFirst();
            else {
                Node2<E> pre = head;
                Node2<E> ptr = head;
                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = tail = pre;
                return true;
            }
        }
        return false;
    }

    public boolean remove(Node2<E> p){
        if (head != null) {
            if (head == p) removeFirst();
            else {
                Node2<E> ptr = head;
                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return false;
                }
                ptr.next = p.next;
                crnt = ptr;
                return true;
            }
        }
        return false;
    }

    public boolean removeCurrentNode() {
        if (crnt == null) {
            return false;
        } else {
            remove(crnt);
            return true;
        }
    }

    public void clear() {
        while (head != null)
            removeFirst();
        crnt = null;
    }

    public void next() {
        if (crnt != null && crnt.next != null)
            crnt = crnt.next;
    }

    public void printCurrentNode() {
        if (crnt != null)
            System.out.println(crnt.data);
    }

    public void dump() {
        Node2<E> ptr = head;

        while (ptr != null) { // 마지막 노드까지 출력
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    public void purge(Comparator <? super E> comparator) {
        if (head != null) {
            Node2<E> ptr = head;
            Node2<E> temp = head;
            while (ptr != null) {
                int cnt = 0;
                Node2<E> comp = ptr.next;
                while (comp != null) {
                    if(comparator.compare(ptr.data, comp.data) == 0) {
                        remove(comp);
                        cnt++;
                    }
                    comp = comp.next;
                }
                if (cnt == 0)
                    ptr = ptr.next;
                else {
                    temp = ptr;
                    remove(ptr);
                    ptr = temp.next;
                }
            }
        }
        crnt = head;
    }

    public void purge2(Comparator<? super E> c) {
        Node2<E> ptr = head;

        while (ptr != null) {
            int count = 0;
            Node2<E> ptr2 = ptr;
            Node2<E> pre = ptr;

            while (pre.next != null) {
                ptr2 = pre.next;
                if (c.compare(ptr.data, ptr2.data) == 0) {
                    System.out.println(pre.data + " " + ptr2.data);
                    
                    pre.next = ptr2.next; // pre.next = 2 (0, 1, 2)에서 1을 삭제
                    count++;
                } else
                    pre = ptr2;
            }
            if (count == 0)
                ptr = ptr.next;
            else {
                Node2<E> temp = ptr;
                remove(ptr);
                ptr = temp.next;
            }
        }
        crnt = head;
    }

    public E retrieve(int n) {

        if (head == null)
            return null;
        else {
            int size = 0;
            Node2<E> ptr = head;
            while (ptr != null) {
                ptr = ptr.next;
                size++;
            }

            crnt = head;
            if (n > size) return null;
            for (int i = 0; i < n; i++)
                next();
            return crnt.data;
        }
    }

    public E retrieve2(int n) {

        Node2<E> ptr = head;
        while (n >= 0 && ptr != null) {
            if (n-- == 0) {
                crnt = ptr;
                return crnt.data;
            }
            ptr = ptr.next;
        }
        return null;
    }


}
