package _11_basicAPIClass._3_object;

public class SmartPhone {
    private String company;
    private String os;

    public SmartPhone(String company, String os) {
        this.company = company;
        this.os = os;
    }

    @Override
    public String toString() {
        return "company='" + company + '\'' + ", os='" + os + '\'';
    }
}
