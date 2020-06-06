package _8_interface._2_typeConversionAndPolymorphism;

// 매개 변수의 다형성: 매개 변수의 타입이 인터페이스일 경우, 어떠한 구현 객체도 매개값으로 사용할 수 있고,
//                 어떤 구현 객체가 제공되느냐에 따라 메소드의 실행 결과는 다양해질 수 있다.
public class ParameterPolymorphismEx3 {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        // 자동 타입 변환
        driver.drive(bus);
        driver.drive(taxi);
    }
}
