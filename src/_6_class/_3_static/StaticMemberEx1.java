package _6_class._3_static;

// static 멤버: 클래스에 고정된 멤버. 객체를 생성하지 않고 사용할 수 있는 필드와 메소드.
//             객체(인스턴스)에 소속된 멤버가 아니라 클래스에 소속된 멤버이기 때문에 클래스 멤버라고도 한다.

// 클래스 로더가 클래스(바이트 코드)를 로딩해서 메소드 메모리 영역에 적재할 때 클래스별로 관리된다. 클래스의 로딩이 끝나면 바로 사용할 수 있다.
// 메소드 영역에 정적 필드, 정적 메소드가 올라간다.
// 객체마다 가지고 있어야 할 데이터면 인스턴스 필드로, 공용적인 데이터라면 정적 필드로 선언하는 것이 좋다.
// 인스턴스 필드를 이용해서 실행해야 한다면 인스턴스 메소드로, 외부 매개값들을 가지고 수행하면 정적 메소드로 선언한다.

// 인스턴스 필드와 달리, 정적 필드는 객체 생성 없이도 사용해야 하므로 생성자에서 초기화 작업을 할 수 없다.
// 정적 블록(static block)에서 초기화 작업을 할 수 있다.
// 정적 블록은 클래스가 메모리로 로딩될 때 자동 실행된다. 클래스 내부에 여러 개가 선언되어도 상관없다. 클래스가 메모리로 로딩될 때 선언된 순서대로 실행된다.
// 정적 내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없다. 객체 자신의 참조인 this 키워드도 사용이 불가능하다.
// 인스턴스 멤버 사용하고 싶으면 정적 내부에 객체를 먼저 생성하고 참조 변수로 접근해야 한다.
public class StaticMemberEx1 {
    void run(){
        System.out.println("run!!");
    }
    public static void main(String[] args) {
        System.out.println("5+3 = " + Calculator.plus(3, 5));
        System.out.println("pi*3 = " + (Calculator.pi + 3));
        System.out.println("res = " + Calculator.res);

        // main 도 static 메소드이기 때문에 객체 생성 후 사용가능 하다.
//        run();
        StaticMemberEx1 sme = new StaticMemberEx1();
        sme.run();
    }
}
