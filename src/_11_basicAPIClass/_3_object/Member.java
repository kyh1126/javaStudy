package _11_basicAPIClass._3_object;

public class Member implements Cloneable {
    public String id;
    public Key k;

    public Member(String id) {
        this.id = id;
    }

    public Member(String id, Key k) {
        this.id = id;
        this.k = k;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Member cloned = (Member) super.clone();
        // Key 를 깊은 복제한다.
        cloned.k = new Key(this.k.number);
        return cloned;
    }

    public Member getMember() {
        Member cloned = null;
        try {
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) {
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Member) {
            Member m = (Member) o;
            if (id.equals(m.id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        // id 가 동일한 문자열인 경우 같은 해시 코드를 리턴.
        return id.hashCode();
    }
}
