package _8_interface._1_interface;

public class Tv implements RemoteControl {
    private int volume;

    // 인터페이스에 선언된 추상 메소드에 대앙하는 실체 메소드를 구현 클래스가 작성하지 않으면 구현 클래스는 자동적으로 추상 클래스가 된다.
    // 그렇기 때문에 선언부에 abstract 키워드를 추가해야 한다.
    @Override
    public void turnOn() {
        System.out.println("TV on!");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("현재 볼륨은? " + volume);
    }
}
