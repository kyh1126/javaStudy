package _8_interface._4_defaultMethodAndInterfaceExtension;

// 디폴트 메소드: 인터페이스에 선언된 인스턴스 메소드. 구현 객체가 있어야 사용할 수 있다.
//             기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서. 기존 인터페이스의 이름과 추상 메소드의 변경 없이 디폴트 메소드만 추가할 수 있기
//             때문에 이전에 개발한 구현 클래스를 그대로 사용할 수 있으면서 새롭게 개발하는 클래스는 디폴트 메소드를 활용할 수 있다.
//             (디폴트 메소드는 재정의해서 써도 되고 아니어도 된다)
public class DefaultMethodEx1 {
    public static void main(String[] args) {
        Fruit f1 = new Apple();
        f1.name();
        f1.run();
        System.out.println();

        Fruit f2 = new Kiwi();
        f2.name();
        f2.run();
    }
}
