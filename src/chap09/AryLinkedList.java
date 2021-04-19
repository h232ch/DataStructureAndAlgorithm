package chap09;

import java.util.Comparator;

public class AryLinkedList<E> {

    // 노드
    static class Node<E> {
        private E data; // 데이터
        private int next; // 리스트의 뒤쪽 포인터
        private int dnext; // free 리스트의 뒤쪽 포인터
        
        // data와 next를 설정
        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n; // 리스트 본체
    private int size; // 리스트의 용량 (가장 큰 데이터 수)
    private int max; // 사용중인 꼬리 레코드
    private int head; // 머리 노드
    private int crnt; // 선택 노드
    private int deleted; // free 리스트의 머리노드
    private static final int NULL = -1; // 다음노드 없음 / 리스트가 가득참

    // 생성자
    public AryLinkedList(int capacity) {
        head = crnt = max = deleted = NULL;
        try {
            n = new Node[capacity];
            for (int i = 0; i < capacity; i++)
                n[i] = new Node<E>();
            size = capacity;
        }
        catch (OutOfMemoryError error) {
            size = 0;
        }
    }

    // 다음에 삽입하는 record의 인덱스를 구함
    private int getInsertIndex() {
        if (deleted == NULL) { // 삭제할 레코드가 없음
            if (max < size)
                return ++max; // 새 레코드를 사용
            else
                return NULL; // 용량 넘침
        } else {
            int rec = deleted; // free 리스트에서 머리 rec을 꺼냄
            deleted = n[rec].dnext; // 이후 머리 rec의 dnext값을 deleted로 변환
            return rec;
        }
    }

    // record idx를 free 리스트에 등록
    private void deleteIndex(int idx) {
        if (deleted == NULL) { // 삭제할 레코드가 없음 (삭제된 데이터가 없어 deleted가 비어있는 경우)
            deleted = idx; // idx를 deleted에 등록해줌
            n[idx].dnext = NULL; // n[idx].dnext는 존재하지 않음으로 널을 입력함
        } else {
            int rec = deleted; // deleted 값을 rec에 넣고
            deleted = idx; // 신규 idx값으로 변경후
            n[idx].dnext = rec;  // 신규 deleted의 dnext값을 red(기존deleted)로 변경
        }
    }

    // 노드를 검색
    public E search(E obj, Comparator<? super E> comparator) {
        int ptr = head;
        while (ptr != NULL) {
            if (comparator.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
            ptr = n[ptr].next;
        }
        return null;
    }

    // 머리에 노드를 삽입
    public void addFirst(E obj) {
        int ptr = head; // 삽입 전의 머리 노드
        int rec = getInsertIndex();
        if (rec != NULL) {
            head = crnt = rec; // 인덱스 rec인 record에 삽입
            n[head].set(obj, ptr);
        }
    }

    // 꼬리에 노드를 삽입
    public void addLast(E obj) {
        if (head == NULL) // 리스트가 비어있으면 머리에 삽입
            addFirst(obj); // 머리에 삽입
        else {
            int ptr = head;
            while (n[ptr].next != NULL)
                ptr = n[ptr].next;
            int rec = getInsertIndex();
            if (rec != NULL) { // 인덱스 rec인 record에 삽입
                n[ptr].next = crnt = rec;
                n[rec].set(obj, NULL);
            }
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        if (head != NULL) { // 리스트가 비어있지 않으면
            int ptr = n[head].next;
            deleteIndex(head);
            head = crnt = ptr;
        }
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != NULL) {
            if (n[head].next == NULL) // 노드가 하나인경우
                removeFirst(); // 머리 노드를 삭제
            else {
                int ptr = head; // 스캔중인 노드
                int pre = head; // 스캔중인 노드의 앞쪽 노드

                while (n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = NULL; // pre는 삭제 후의 꼬리 노드
                deleteIndex(ptr); // 고쳐야 하는 코드;
                crnt = pre;
            }
        }
    }

    // 레코드 P를 삭제
    public void remove(int p) {
        if (head != NULL) {
            if (p == head)
                removeFirst(); // 헤드가 p라면 removeFirst 호출
            else {
                int ptr = head;
                while (n[ptr].next != p) { // ptr.next가 p와 일치할때까지 ptr 증가
                    ptr = n[ptr].next;
                    if (ptr == NULL) {
                        System.out.println("p 데이터가 없음");
                        return; // p가 리스트에 없습니다.
                    }
                }
                n[ptr].next = NULL; // p와 일치하는 ptr.next 삭제
                deleteIndex(p); // 고쳐야하는 코드
                n[ptr].next = n[p].next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != NULL)
            removeFirst();
        crnt = NULL;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == NULL || n[crnt].next == NULL)
            return false;

        crnt = n[crnt].next;
        return true;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (crnt == NULL)
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(n[crnt].data);

    }

    // 모든 노드를 출력
    public void dump() {
        int ptr = head;

        while (ptr != NULL) {
            System.out.println(n[ptr].data);
            ptr = n[ptr].next;
        }
        System.out.println();

        for (int i = 0; i < n.length; i++) {
            System.out.println("[" + i + "] " + n[i].data + "  " + n[i].next + "  " + n[i].dnext + "  " + deleted);
        }


        System.out.println();
    }
}
