package _7_inheritance._5_abstractClass;

// 추상 클래스: 클래스들의 공통적인 특성을 추출해서 선언한 클래스 (실체 클래스:객체를 직접 생성할 수 있는 클래스)
//           추상 클래스가 부모이고 실체 클래스가 자식으로 구현되어 실체 클래스는 추상 클래스의 특성을 물려받고, 추가적인 특성(필드, 메소드)을 가질 수 있다.
//           추상 클래스는 객체를 직접 생성해서 사용할 수 없다.(new 연산자 사용해서 인스턴스 생성 불가)
//           새로운 실체 클래스를 만들기 위해 부모 클래스로만 사용된다.

// 추상 클래스의 용도
// 1. 실체 클래스들의 공통된 필드와 메소드의 이름을 통일할 목적
// 2. 실체 클래스를 작성할 때 시간을 절약

// 추상 메소드: 추상 클래스에서만 선언할 수 있다. 메소드의 선언부만 있고 메소드 실행 내용인 중괄호가 없는 메소드.
//           하위 클래스가 반드시 실행 내용을 채우도록 강요하고 싶은 메소드. (public, protected 만 가능)
public class AbstractClassEx1 {
    static void pickup(Phone phone) {
        phone.pickUp();
    }

    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone("폰주인");

        // 매개 변수의 다형성
        pickup(phone);

        // 부모 추상클래스 메소드 사용 가능
        phone.turnOn();
        phone.search();

        // private 은 상속이 안된다.
        System.out.println(phone.getPrivate());
    }
}
