package _8_interface._1_interface;

// 인터페이스는 클래스의 필드, 생성자 또는 메소드의 매개 변수, 생성자 또는 메소드의 로컬 변수로 선언될 수 있다.
public class InterfaceUseEx3 {
    // 필드
    RemoteControl rc = new Tv();

    // 생성자
    InterfaceUseEx3(RemoteControl rc) {
        this.rc = rc;
    }

    // 메소드
    void methodA() {
        // 로컬 변수
        RemoteControl rc = new Audio();
    }

    void methodB(RemoteControl rc) {
    }
}
