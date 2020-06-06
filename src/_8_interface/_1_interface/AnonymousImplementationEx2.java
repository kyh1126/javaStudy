package _8_interface._1_interface;

// 익명 구현 객체: 일회성의 구현 객체를 만들기 위해 소스 파일을 만들고 클래스를 선언하는 것은 비효율적.
//              자바 8에서 지원하는 람다식은 인터페이스의 익명 구현 객체를 만든다. 하나의 실행문이므로 끝에는 세미콜론을 반드시 붙여야 한다.
//              new 연산자 뒤에는 클래스 이름이 와야 하는데 이름이 없다.
//              추가 필드, 메소드를 선언할 수 있지만 익명 객체 안에서만 사용할 수 있고 인터페이스 변수로 접근할 수 없다.
public class AnonymousImplementationEx2 {
    public static void main(String[] args) {
        RemoteControl rc = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("익명 구현 객체 켠다.");
            }

            @Override
            public void setVolume(int volume) {
                System.out.println("니가 설정하려는 볼륨이 이 볼륨이더냐?" + volume);
            }
        };
    }
}
