package _7_inheritance._4_typeConversionAndPolymorphism;

// instanceof: 부모 변수가 참조하는 객체가 부모 객체인지 자식 객체인지 확인하는 방법.
//             체크 후 강제 타입 변환 시도해야 ClassCastException 발생 안한다.
public class TypeCheckEx4 {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Bus b = new Bus();

        //                          좌항(객체)          우향(타입)
        System.out.println("result: " + (b instanceof Vehicle));
        System.out.println("result: " + (v instanceof Vehicle));
        System.out.println("result: " + (v instanceof Bus));
    }
}
