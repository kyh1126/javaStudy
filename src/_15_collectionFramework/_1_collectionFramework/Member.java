package _15_collectionFramework._1_collectionFramework;

public class Member implements Comparable<Member> {
    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 아래와 같이 만들면 인스턴스가 달라도 이름과 나이가 동일하다면 동일한 객체로 간주하여 중복 저장되지 않는다.
    @Override
    public int hashCode() {
//        return super.hashCode();
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member m = (Member) obj;
            return m.name.equals(name) && m.age == age;
        }
        return false;
//        return super.equals(obj);
    }

    @Override
    public int compareTo(Member o) {
        if (age < o.age) return -1;
        else if (age > o.age) return 1;
        return 0;
    }
}
