package practice_all;

public class GenericClass {

    static class GenericInnerClass<T> {
        private T var;
        public GenericInnerClass(T var) {
            this.var = var;
        }

        public T getVar() {
            return var;
        }
    }

    class GenericInner2Class<T> {
        private T var;
        public GenericInner2Class(T var) {
            this.var = var;
        }

        public T getVar() {
            return var;
        }
    }

    public static void main(String[] args) {
        GenericClass ge = new GenericClass();
        GenericInner2Class<Integer> ge3 = ge.new GenericInner2Class(15);
        GenericInnerClass<Integer> ge2 = new GenericInnerClass<>(15);

        System.out.println(ge3.getVar());
        System.out.println(ge2.getVar());


    }

}
