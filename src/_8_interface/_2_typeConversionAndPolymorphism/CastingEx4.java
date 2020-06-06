package _8_interface._2_typeConversionAndPolymorphism;

// 강제 타입 변환(Casting): 구현 클래스에 선언된 필드와 메소드를 사용해야 할 경우, 강제 타입 변환을 해서 다시 구현 클래스 타입으로 변환한다.

// 객체 타입 확인(instanceof): 구현 객체가 인터페이스 타입으로 변환되어 있는지 확인하는 방법.
public class CastingEx4 {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();
        vehicle.run();

        if (vehicle instanceof Bus) {
            // 강제 타입 변환
            Bus bus = (Bus) vehicle;
            bus.run();
            bus.checkFare();
        }
    }
}
