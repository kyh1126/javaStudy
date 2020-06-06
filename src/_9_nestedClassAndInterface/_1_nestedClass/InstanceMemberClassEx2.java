package _9_nestedClassAndInterface._1_nestedClass;

// 인스턴스 멤버 클래스: static 키워드 없이 선언된 클래스. 멤버 클래스는 인스턴스 필드와 메소드만 선언이 가능하고 정적 필드와 메소드는 선언할 수 없다.
public class InstanceMemberClassEx2 {
    public static void main(String[] args) {
        // InstanceMemberA 클래스 외부에서 인스턴스 멤버 클래스 B의 객체를 생성하려면 먼저 A 객체를 생성하고 B 객체를 생성해야 한다.
        InstanceMemberA a = new InstanceMemberA();
        InstanceMemberA.B b = a.new B();
        System.out.println(b.field1);
        b.method1();
    }
}
