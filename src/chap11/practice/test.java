package chap11.practice;

public class test<K> {

    static class TestClass<K> {
        K data;

        TestClass(K data) {
            this.data = data;
        }

        public TestClass() {
            super();
        }

        public int hashCode() {
            return data.hashCode();
        }
    }

    public static void main(String args) {

        TestClass<Integer> t = new TestClass<>(10);
        System.out.println(t.hashCode());
    }


}
