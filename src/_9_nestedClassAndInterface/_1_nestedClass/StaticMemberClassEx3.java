package _9_nestedClassAndInterface._1_nestedClass;

// 정적 멤버 클래스: static 키워드로 선언된 클래스. 모든 종류의 필드와 메소드를 선언할 수 있다.
public class StaticMemberClassEx3 {
    public static void main(String[] args) {
        // StaticMemberA 클래스 외부에서 정적 멤버 클래스 C의 객체를 생성하기 위해서는
        // StaticMemberA 객체를 생성할 필요가 없고, 다음과 같이 C 객체를 생성하면 된다.
        StaticMemberA.C c = new StaticMemberA.C();
        c.field1 = 3;
        c.method1();
        StaticMemberA.C.field2 = 5;
        StaticMemberA.C.method2();

        System.out.println(StaticMemberA.C.field2);
    }
}
