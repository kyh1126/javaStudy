package _14_lambdaExpression._4_methodReferences;

import _14_lambdaExpression._3_functionalInterface.Member;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;

// 메소드 참조: 메소드를 참조해서 매개 변수의 정보 및 리턴 타입을 알아내어, 람다식에서 불필요한 매개 변수를 제거하는 것이 목적이다.
//           람다식은 종종 기존 메소드를 단순히 호출만 하는 경우가 많다. 메소드 참조도 람다식과 마찬가지로 인터페이스의 익명 구현 객체로 생성되므로
//           타겟 타입인 인터페이스의 추상 메소드가 어떤 매개 변수를 가지고, 리턴 타입이 무엇인가에 따라 달라진다.
//           메소드 참조는 정적 또는 인스턴스 메소드를 참조할 수 있고, 생성자 참조도 가능하다.

// 1. 정적 메소드와 인스턴스 메소드 참조:
// 정적 메소드를 참조할 경우에는 클래스 이름 뒤에 :: 기호를 붙이고 정적 메소드 이름을 기술하면 된다.
// 인스턴스 메소드일 경우에는 먼저 객체를 생성한 다음 참조변수 뒤에 :: 기호를 붙이고 인스턴스 메소드 이름을 기술하면 된다.
// 2. 매개 변수의 메소드 참조:
// 메소드는 람다식 외부의 클래스 멤버일 수도 있고, 람다식에서 제공되는 매개 변수의 멤버일 수도 있다.
// 3. 생성자 참조:
// 생성자를 참조한다는 것은 객체 생성을 의미한다. 단순히 메소드 호출로 구성된 람다식을 메소드 참조로 대치할 수 있듯이, 단순히 객체를 생성하고 리턴하도록
// 구성된 람다식은 생성자 참조로 대치할 수 있다. 클래스 이름 뒤에 :: 기호를 붙이고 new 연산자를 기술하면 된다.
// 생성자가 오버로딩 되어 여러 개가 있을 경우, 컴파일러는 함수적 인터페이스의 추상 메소드와 동일한 매개 변수 타입과 개수를 가지고 있는 생성자를 찾아 실행한다.
// 만약 해당 생성자가 존재하지 않으면 컴파일 오류가 발생한다.
public class MethodReferencesEx1 {
    public static void main(String[] args) {
        // 2
        ToIntBiFunction<String, String> function;

        function = (a, b) -> a.compareToIgnoreCase(b);
        System.out.println(function.applyAsInt("Java8", "Java8"));

        function = String::compareToIgnoreCase;
        System.out.println(function.applyAsInt("Java8", "Java8"));

        // 3
        Function<String, Member> function1 = Member::new;
        Member member1 = function1.apply("사람");

        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("사람", "saram");
    }
}
