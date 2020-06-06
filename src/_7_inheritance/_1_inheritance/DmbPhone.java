package _7_inheritance._1_inheritance;

public class DmbPhone extends Phone {
    int channel;

    public DmbPhone(String model, String color, int channel) {
        this.model = model;
        this.color = color;
        this.channel = channel;
    }

    // 생성자가 명시적으로 선언되지 않았다면 컴파일러는 다음과 같은 기본 생성자를 생성해낸다.
//    DmbPhone() {
//        // 부모의 기본 생성자를 호출한다.
//        super();
//    }

    @Override
    public void bell() {
        System.out.println("삐리비리빅");
    }

    void turnOnDmb() {
        System.out.println("채널 " + channel + "번 방송을 킵니다.");
    }

    void changeChannel(int channel) {
        this.channel = channel;
        System.out.println("채널 " + channel + "번으로 바꿉니다.");
    }

    void turnOffDmb() {
        System.out.println("방송을 끕니다.");
    }
}
