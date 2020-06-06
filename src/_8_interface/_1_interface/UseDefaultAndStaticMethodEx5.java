package _8_interface._1_interface;

// 디폴트 메소드: 인터페이스에 선언되지만, 인터페이스에서 바로 사용할 수 없다.
//             추상 메소드가 아닌 인스턴스 메소드이므로 구현 객체가 있어야 사용할 수 있다.
//             인터페이스의 모든 구현 객체가 가지고 있는 기본 메소드라고 생각하면 된다. 오버라이딩 가능.

// 정적 메소드: 인터페이스로 바로 호출이 가능하다.
public class UseDefaultAndStaticMethodEx5 {
    public static void main(String[] args) {
        RemoteControl rc = new Tv();
        rc.setMute(true);

        RemoteControl.changeBattery();
    }
}
