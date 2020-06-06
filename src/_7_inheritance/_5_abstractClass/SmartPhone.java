package _7_inheritance._5_abstractClass;

public class SmartPhone extends Phone {
    public SmartPhone(String owner) {
        super(owner);
    }

    public void search() {
        System.out.println("인터넷 검색을 한다.");
    }

    @Override
    public void pickUp() {
        System.out.println("또각");
    }

    public String getPrivate() {
        return super.getP();
    }
}
