package _7_inheritance._5_abstractClass;

public abstract class Phone {
    public String owner;
    private String p = "이것은 프라이빗이여";

    public Phone(String owner) {
        this.owner = owner;
    }

    public void turnOn() {
        System.out.println("폰 전원을 켠다.");
    }

    public void turnOff() {
        System.out.println("폰 전원을 끈다.");
    }

    public abstract void pickUp();

    public String getP() {
        return p;
    }
}
