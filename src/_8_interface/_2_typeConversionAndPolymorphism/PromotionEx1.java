package _8_interface._2_typeConversionAndPolymorphism;

// 자동 타입 변환(Promotion): 구현 객체가 인터페이스 타입으로 변환되는 것. 프로그램 실행 도중에 자동적으로 타입 변환이 일어나는 것.

// 다형성: 하나의 타입에 대입되는 객체에 따라서 실행 결과가 다양한 형태로 나오는 성질.
// 필드의 다형성: run() 메소드 수정 없이도 다양한 roll() 메소드의 실행 결과를 얻을 수 있게 되는 것.
public class PromotionEx1 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        myCar.frontLeftTire = new KumhoTire();
        myCar.frontRightTire = new KumhoTire();

        myCar.run();
    }
}
