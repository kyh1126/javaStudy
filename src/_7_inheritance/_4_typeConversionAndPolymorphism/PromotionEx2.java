package _7_inheritance._4_typeConversionAndPolymorphism;

// 자동 타입 변환(Promotion): 프로그램 실행 도중에 자동적으로 타입 변환이 일어나는 것.
//                         부모 타입으로 자동 타입 변환된 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.
//                         메소드가 오버라이딩 되었다면 자식 클래스의 메소드가 대신 호출된다.

// 필드의 다형성 뿐만 아니라, 매개 변수의 다형성도 가능하다.
// 매개 변수의 타입이 클래스일 경우, 해당 클래스의 객체 뿐만 아니라 자식 객체까지도 매개값으로 사용할 수 있다.
public class PromotionEx2 {
    public static void main(String[] args) {
        Driver driver = new Driver();
        // 매개 변수의 다형성도 가능하다. 자동 타입 변환 발생.
        driver.drive(new Bus());
    }
}
