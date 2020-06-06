package _9_nestedClassAndInterface._4_anonymousObject;

public class Anonymous2 {
    // 필드 초기값으로 대입
    RemoteControl rc = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("티비킴");
        }

        @Override
        public void turnOff() {
            System.out.println("티비끔");
        }
    };

    void method1() {
        // 로컬 변수값으로 대입
        RemoteControl rc = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("method1 킴");
            }

            @Override
            public void turnOff() {
                System.out.println("method1 끔");
            }
        };
        // 로컬 변수 사용
        rc.turnOn();
    }

    void method2(RemoteControl rc) {
        rc.turnOn();
    }
}
