package practice_all;

// 함수형 인테페이스

// 구현해야 할 추상 메서드가 1개인 경우
// 아래의 애노테이션을 적용하여 1개의 메서드를 강제할 수 있음 (2개일 경우 오류 발생)
@FunctionalInterface
public interface LambdaMatch {
    public int Calc(int first, int second);
}
