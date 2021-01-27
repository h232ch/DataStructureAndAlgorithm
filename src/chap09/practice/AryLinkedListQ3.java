package chap09.practice;

import java.util.Comparator;

public class AryLinkedListQ3<E> {


    static class Node<E> {
        private E data;
        private int next;
        private int dnext;

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;
    private int head;
    private int crnt;
    private int max;
    private int size;
    private int deleted;
    final static private int NULL = -1;


    public AryLinkedListQ3(int capacity) {

        head = crnt = max = deleted = NULL;
        size = capacity;

        try {
            n = new Node[size];
            for (int i = 0; i < size; i++) {
                n[i] = new Node<>();
            }
        } catch (OutOfMemoryError error) {
            size = 0;
        }
    }

    private int insertIndex() {
        if (deleted == NULL) {
            if (max < size - 1) {
                return ++max;
            } else {
                return NULL;
            }
        } else {
            int rec = deleted;
            deleted = n[rec].dnext;
            n[rec].dnext = NULL;
            return rec;
        }
    }

    private void deleteIndex(int idx) {
        if (deleted == NULL) {
            deleted = idx;
            n[idx].dnext = -1;
        } else {
            n[idx].dnext = deleted;
            deleted = idx;
        }
    }

    public E search(E obj, Comparator<? super E> comparator) {
        if (head == NULL) {
            System.out.println("There is no data in this array");
        } else {
            int ptr = head;
            while (ptr != NULL) {
                if (comparator.compare(obj, n[ptr].data) == 0) {
                    crnt = ptr;
                    return n[crnt].data;
                }
            }
        }
        return null;
    }

    public void addFirst(E obj) {
        int idx = insertIndex();
        if (idx != NULL) {
            n[idx].set(obj, head);
            head = crnt = idx;
        }
    }

    public void addLast(E obj) {
        if (head == NULL) {
            addFirst(obj);
        } else {
            int idx = insertIndex();
            if (idx != NULL) {
                int ptr = head;
                while (n[ptr].next != NULL) {
                    ptr = n[ptr].next;
                }
                n[idx].set(obj, NULL);
                n[ptr].next = idx;
                crnt = idx;
            }
        }
    }

    public void firstRemove() {
        if (head == NULL) {
            System.out.println("There is no data");
        } else {
            int ptr = n[head].next;
            deleteIndex(head);
            head = crnt = ptr;
        }
    }

    public void lastRemove() {
        if (head == NULL) {
            System.out.println("There is no data");
        } else {
            if (n[head].next == NULL) {
                firstRemove();
            } else {
                int ptr = n[head].next;
                int pre = head;

                while (ptr != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }

                n[pre].next = NULL;
                deleteIndex(ptr);
                crnt = pre;
            }
        }
    }

    public void remove(int p) {
        if (head == NULL) {
            System.out.println("There is no data");
        } else {
            if (p == head) {
                firstRemove(); // 복습
            } else {
                int ptr = head;
                while (n[ptr].next != p) {
                    ptr = n[ptr].next;
                    if (ptr == NULL) {
                        System.out.println("There is no data");
                        return; // 복습
                    }
                }
                n[ptr].next = n[p].next;
                deleteIndex(p);
                crnt = ptr;
            }

        }
    }


}






















