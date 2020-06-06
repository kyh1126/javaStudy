package _9_nestedClassAndInterface._1_nestedClass;

// 로컬 클래스: 메소드 내에서 선언된 중첩 클래스. 로컬 클래스는 접근 제한자(public, private) 및 static 을 붙일 수 없다.
//           메소드 내부에서만 사용되므로 접근을 제한할 필요가 없기 때문. 인스턴스 필드, 메소드만 선언 가능. 정적 필드, 메소드는 선언 불가.
public class LocalClassEx4 {
    void method() {
        class D {
            D() {
            }                       // 생성자

            int field1;             // 인스턴스 필드
//            static int field2;      // 정적 필드(x)

            void method1() {
                System.out.println("method1 !");
            }        // 인스턴스 메소드

//            static void method2(){} // 정적 메소드(x)
        }
        D d = new D();
        d.field1 = 3;
        d.method1();
    }

    public static void main(String[] args) {
        // 로컬 클래스는 메소드가 실행될 때 메소드 내에서 객체를 생성하고 사용해야 한다.
        // 비동기 처리를 위해 스레드 객체를 만들 때 사용.
        LocalClassEx4 local = new LocalClassEx4();

        // 로컬 클래스 객체 생성을 위한 메소드 호출
        local.method();
    }
}
