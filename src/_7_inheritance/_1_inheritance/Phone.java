package _7_inheritance._1_inheritance;

public class Phone {
    String model;
    String color;

    protected Phone() {
    }

    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    public void bell() {
        System.out.println("벨이 울립니다.");
    }

    void sendVoice(String msg) {
        System.out.println("me: " + msg);
    }

    void receiveVoice(String msg) {
        System.out.println("you: " + msg);
    }

    void hangUp() {
        System.out.println("전화를 끊습니다.");
    }
}
