package _9_nestedClassAndInterface._2_nestedClassAccessLimit;

// 바깥 필드와 메소드에서 사용 제한
// 1. 인스턴스 멤버 클래스: 바깥 클래스의 인스턴스 필드의 초기값이나 인스턴스 메소드에서 객체를 생성할 수 있으나,
//                     정적 필드의 초기값이나 정적 메소드의 객체를 생성할 수 없다.
// 2. 정적 멤버 클래스: 모든 필드의 초기값이나 모든 메소드에서 객체를 생성할 수 있다.

// 멤버 클래스에서 사용 제한
// 3. 인스턴스 멤버 클래스 안에서는 바깥 클래스의 모든 필드, 메소드에 접근 가능.
// 4. 정적 멤버 클래스 안에서는 바깥 클래스의 정적 필드, 메소드에만 접근할 수 있고 인스턴스 필드, 메소드는 접근할 수 없다.

// 로컬 클래스에서 사용 제한
// 5. 로컬 클래스 내부에서는 바깥 클래스의 필드나 메소드를 제한 없이 사용할 수 있다. 문제는 메소드의 매개 변수나 로컬 변수를 로컬 클래스에서 사용할 때이다.
//    로컬 클래스의 객체는 메소드 실행이 끝나도 힙 메모리에 존재해서 계속 사용될 수 있다.
//    매개 변수나 로컬 변수는 메소드 실행이 끝나면 스택 메모리에서 사라지므로 로컬 객체에서 사용할 경우 문제가 발생한다.
//    자바는 이 문제를 해결하기 위해 컴파일 시 로컬 클래스에서 사용하는 매개 변수나 로컬 변수의 값을 로컬 클래스 내부에 복사해 두고 사용한다. 그리고
//    매개 변수, 로컬 변수가 수정되어 값이 변경되면 로컬 클래스에 복사해 둔 값과 달라지는 문제를 해결하기 위해 매개 변수, 로컬 변수를 final 선언해 수정을 막는다.
//    결론적으로 로컬 클래스에서 사용 가능한 것은 final 선언된 매개 변수, 로컬 변수다.
//    자바 7 이전까지는 final 아닌 매개 변수, 로컬 변수를 로컬 클래스에서 사용시 컴파일 에러가 발생했으나, 자바 8부터는 final 키워드 없이 선언된 매개
//    변수와 로컬 변수를 사용해도 컴파일 에러가 나지 않는다. final 선언을 하지 않아도 여전히 값을 수정할 수 없는 final 특성을 갖는다.
//    final 키워드 존재 여부의 차이점은 로컬 클래스의 복사 위치이다. final 키워드가 있다면 로컬 클래스의 메소드 내부에 지역 변수로 복사되지만,
//    final 키워드가 없다면 로컬 클래스의 필드로 복사된다.
public class AccessLimitEx1 {
    // 5
    void outMethod(final int arg1, int arg2) {
        final int var1 = 1;
        int var2 = 2;

        class LocalClass {
            void method() {
                int result = arg1 + arg2 + var1 + var2;
            }
        }
//        class LocalClass {
//            int arg2 = 매개값;
//            int var2 = 2;
//            void method() {
//                int arg1 = 매개값;
//                int var1 = 1;
//                int result = arg1 + arg2 + var1 + var2;
//            }
//        }
    }

    public void method2(int arg) {
        int localVariable = 1;
        // 자바 8부터는 붙이지 않아도 final 특성을 갖고 있다.
//        arg = 100;
        class Inner {
            public void method() {
                int result = arg + localVariable;
            }
        }
    }

    public static void main(String[] args) {
        // 1
        A a = new A();
        System.out.println("a.field1: " + a.field1);
        a.method1();

        // 2
        System.out.println("a.field2: " + a.field2);
        System.out.println("A.field4: " + A.field4);
        a.method1();
        A.method2();

        // 3
        A.B b = a.new B();
        b.method();

        // 4
        A.C c = new A.C();
        c.method();
    }
}
