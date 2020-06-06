package _7_inheritance._4_typeConversionAndPolymorphism;

// 강제 타입 변환(Casting): 부모 타입을 자식 타입으로 변환하는 것.
//                       모든 부모 타입을 자식 클래스 타입으로 강제 변환할 수 있는 것은 아니다.
//                       자식 타입이 부모 타입으로 자동 변환한 후, 다시 자식 타입으로 변환할 때 강제 타입 변환을 사용할 수 있다.
public class CastingEx3 {
    public static void main(String[] args) {
        // 자동 타입 변환
        Vehicle vehicle = new Bus();
        vehicle.run();

        // 강제 타입 변환
//        Bus bus = (Bus) new Vehicle();    // 이렇게는 안된다.
        Bus bus = (Bus) vehicle;
        bus.optional = "aa";
        System.out.println(bus.optional);
    }
}
