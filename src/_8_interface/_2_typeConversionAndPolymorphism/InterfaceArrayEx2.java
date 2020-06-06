package _8_interface._2_typeConversionAndPolymorphism;

// 인터페이스 배열로 구현 객체 관리: 구현 객체들을 배열로 관리하면 제어문에서 가장 많이 혜택을 본다.
public class InterfaceArrayEx2 {
    public static void main(String[] args) {
        Car2 myCar = new Car2();
        myCar.run();

        myCar.tires[0] = new KumhoTire();
        myCar.tires[1] = new KumhoTire();

        myCar.run();
    }
}
