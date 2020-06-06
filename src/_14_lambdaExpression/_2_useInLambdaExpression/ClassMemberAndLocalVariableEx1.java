package _14_lambdaExpression._2_useInLambdaExpression;

// 클래스 멤버, 로컬 변수 사용: 람다식의 실행 블록에는 클래스의 멤버(필드와 메소드) 및 로컬 변수를 사용할 수 있다.
//                        클래스 멤버는 제약없이 사용 가능하지만, 로컬 변수는 제약 사항이 따른다.

// 1. 클래스의 멤버 사용:
// 일반적으로 익명 객체 내부에서 this 는 익명 객체의 참조이지만, 람다식에서 this 는 내부적으로 생성되는 익명 객체 참조가 아니라 람다식을 실행한 객체의 참조이다.

// 2. 로컬 변수 사용:
// (익명 객체의 로컬 변수 사용) 메소드의 매개 변수 또는 로컬 변수를 사용하면 이 두 변수는 final 특성을 가져야 한다.
// 매개변수 또는 로컬 변수를 람다식에서 읽는 것은 허용되지만, 람다식 내부 또는 외부에서 변경할 수 없다.
public class ClassMemberAndLocalVariableEx1 {
    public static void main(String[] args) {
        // 1
        UsingThis usingThis = new UsingThis();
        UsingThis.Inner inner = usingThis.new Inner();
        inner.method();

        // 2
        UsingLocalVariable ulv = new UsingLocalVariable();
        ulv.method(10);
    }
}
