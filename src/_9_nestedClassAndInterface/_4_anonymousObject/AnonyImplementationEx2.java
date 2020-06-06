package _9_nestedClassAndInterface._4_anonymousObject;

// 익명 구현 객체 생성: 필드와 메소드를 선언할 수는 있지만, 실체 메소드에서만 사용이 가능하고 외부에서는 사용하지 못한다.
public class AnonyImplementationEx2 {
    public static void main(String[] args) {
        Anonymous2 anonymous2 = new Anonymous2();
        // 익명 객체 필드 사용
        anonymous2.rc.turnOn();
        // 익명 객체 로컬 변수 사용
        anonymous2.method1();
        // 익명 객체 매개값 사용
        anonymous2.method2(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("스마트티비 킴");
            }

            @Override
            public void turnOff() {
                System.out.println("스마트티비 끔");
            }
        });
    }
}
