package _9_nestedClassAndInterface._2_nestedClassAccessLimit;

public class A {
    // 인스턴스 필드
    B field1 = new B();
    C field2 = new C();

    int i1;
    static int i2;

    // 인스턴스 메소드
    void method1() {
        B var1 = new B();
        C var2 = new C();
    }

    // 정적 필드 초기화
//    static B field3 = new B();
    static C field4 = new C();

    // 정적 메소드
    static void method2() {
//        B var1 = new B();
        C var2 = new C();
    }

    // 인스턴스 멤버 클래스
    class B {
        void method() {
            i1 = 10;
            method1();
            i2 = 15;
            method2();
        }
    }

    // 정적 멤버 클래스
    static class C {
        void method() {
//            i1 = 10;
//            method1();
            i2 = 15;
            method2();
        }
    }
}
