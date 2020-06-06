package _9_nestedClassAndInterface._1_nestedClass;

public class InstanceMemberA {
    // 인스턴스 멤버 클래스
    class B {
        B() {
        }               // 생성자

        int field1;         // 인스턴스 필드

        //        static int field2;  // 정적 필드 (x)
        void method1() {
        }    // 인스턴스 메소드
//        static void method2(){} // 정적 메소드 (x)
    }
}
