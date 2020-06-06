package _9_nestedClassAndInterface._4_anonymousObject;

// 익명 객체: 이름이 없는 객체. 단독으로 생성할 수 없고 클래스를 상속하거나 인터페이스를 구현해야만 생성할 수 있다.
//          필드의 초기값이나 로컬 변수의 초기값, 매개 변수의 매개값으로 주로 대입된다. 스레드 객체를 간편하게 생성할 목적으로 많이 활용된다.
// 익명 자식 객체 생성: 새롭게 정의된 필드와 메소드는 익명 자식 객체 내부에서만 사용되고, 외부에서는 필드와 메소드에 접근할 수 없다.
//                  익명 자식 객체는 부모 타입 변수에 대입되므로 부모 타입에 선언된 것만 사용할 수 있기 때문이다.
public class ChildAnonymousEx1 {
    public static void main(String[] args) {
        Anonymous anony = new Anonymous();
        // 익명 객체 필드 사용
        anony.field.wake();
        // 익명 객체 로컬 변수 사용
        anony.method1();
        // 익명 객체 매개값 사용
        anony.method2(new Person() {
            @Override
            void wake() {
                System.out.println("8시 기상!");
                study();
            }

            private void study() {
                System.out.println("공부할려고~");
            }
        });
    }
}
