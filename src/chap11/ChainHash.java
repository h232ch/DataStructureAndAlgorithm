package chap11;

public class ChainHash<K, V> {

    // 자기 참조형 클래스
    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;


        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }

    }

    private int size;
    private Node<K, V>[] table;

    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError error) {
            size = 0;
        }
    }

    // 해시값을 구함
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public V search(K key) {
        int hash = hashValue(key); // 검색할 데이터의 해시값
        Node<K, V> p = table[hash]; // 선택 노드

        while (p != null) {
            if (p.getKey().equals(key)) {
                return p.getValue();
            }
            p = p.next;
        }
        return null; // 검색 실패
    }

    // 키 값 key, 데이터 data를 갖는 요소의 추가
    public int add(K key, V data) {
        int hash = hashValue(key); // 추가할 데이터의 해시값
        Node<K, V> p = table[hash]; // 선택 노드

        while (p != null) { // 동일 키값이 존재하는지 검증
            if (p.getKey().equals(key)) { // 이 키값은 이미 등록됨
                return 1;
            }
            p = p.next; // 다음노드에 주목
        }

        Node<K, V> temp = new Node<>(key, data, table[hash]); // 기존 노드를 바라봄
        table[hash] = temp; // 신규 노드를 table[hash]에 넣어줌
        return 0;
    }

    // 키 값 key를 갖는 요소의 삭제
    public int remove (K key) {
        int hash = hashValue(key); // 삭제할 데이터의 해시 값
        Node<K, V> p = table[hash]; // 테이블의 해시값에 저장되어있는 노드 로드
        Node<K, V> pp = null;

        while (p != null) {
            if (p.getKey().equals(key)) { // 찾으면
                if (pp == null) {
                    table[hash] = p.next;
                } else {
                    pp.next = p.next;
                }
                return 0;
            }
            pp = p;
            p = p.next;
        }
        return 1; // 그 키값이 없습니다.
    }

    // 해시 테이블을 덤프
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d ", i);
            while (p != null) {
                System.out.printf("-> %s (%s) ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }

}
