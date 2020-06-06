package _8_interface._1_interface;

public class UseAbstractMethodEx4 {
    public static void main(String[] args) {
        RemoteControl rc = new Tv();
        rc.turnOn();
        rc.setMute(true);

        rc = new Audio();
        rc.turnOn();
    }
}
