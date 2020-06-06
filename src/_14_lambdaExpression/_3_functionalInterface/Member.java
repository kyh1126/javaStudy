package _14_lambdaExpression._3_functionalInterface;

public class Member {
    private String name;
    private String id;
    private Address address;

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Member(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}
