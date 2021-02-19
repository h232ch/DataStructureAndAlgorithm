package chap03;

public class GenericClassTester {
    
    static class GenericClass<T> {
        private T xyz;
        public GenericClass(T t) { // 생성자 타입을 T로 받기 때문에 자료형에 의존하지 않으면서 안전하게 사용 가능
            this.xyz = t;
        }
        T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args){
        GenericClass<String> s = new GenericClass<>("ABC");
        GenericClass<Integer> n = new GenericClass<>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
