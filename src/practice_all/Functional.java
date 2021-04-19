package practice_all;

@FunctionalInterface
public interface Functional {
    public boolean equals(Object obj); // Object에 Public으로 규정되어 있어
    // @FuntionalInterface 조건에 걸리지 않음
    public Object clone();
    // clone은 Object에서 Protected로 선언되어 있기 때문에
    // @FunctionalInterface 조건에 적용됨
}
