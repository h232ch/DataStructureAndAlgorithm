package practice_all;

public enum EnumTest {

    BUS(1500), AIRPLANE(300000), TAXI(300);
    // BUS, AIRPLANE, TAXI...는 EnumTest 객체이다.
    //

    private int price;
    EnumTest(int price) {
        this.price = price;
    }
}
