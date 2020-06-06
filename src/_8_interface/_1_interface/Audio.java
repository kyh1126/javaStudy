package _8_interface._1_interface;

public class Audio implements RemoteControl {
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("Audio on!");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("audio 현재 볼륨은? " + volume);
    }
}
