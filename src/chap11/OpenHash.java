package chap11;

public class OpenHash<K, V> {

    // 버킷의 상태
    enum Status {OCCUPIED, EMPTY, DELETED}; // 데이터 저장, 비어있음, 삭제마침

    // 버킷
    static class Buecket<K, V> {
        private K key;
        private V data;
        private Status stat;

        Buecket() {
            stat = Status.EMPTY;
        }

        // 모든 필드에 값을 설정합니다.
        void Set(K key, V data, Status stat) {
            this.key = key;
            this.data = data;
            this.stat = stat;
        }

        void setStat(Status stat) {
            this.stat = stat;
        }

        // 키 값을 반환합니다.
        K getKey() {
            return key;
        }

        // 데이터를 반환합니다.
        V getValue() {
            return data;
        }

        // 키의 해시값을 반환합니다.
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size; // 해시 테이블의 크기
    private Buecket<K,V>[] table; // 해시 테이블

    // 생성자
    public OpenHash(int size) {
        try {
            table = new Buecket[size];
            for (int i = 0; i < size; i++) {
                table[i] = new Buecket<>();
            }
            this.size = size;
        } catch (OutOfMemoryError error) { // 해시 테이블을 생성할 수 없음
            this.size = 0;
        }
    }


    // 해시 값을 구함
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }
}
