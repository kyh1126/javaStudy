package _14_lambdaExpression._1_lambdaExpression;

import java.util.function.IntConsumer;

// 람다식: 함수적 프로그래밍은 병렬 처리와 이벤트 지향 프로그래밍에 적합하다. 자바는 함수적 프로그래밍을 위해 자바 8부터 람다식을 지원하고 있다.
//       람다식은 익명 함수를 생성하기 위한 식으로 객체지향 언어보다는 함수지향 언어에 가깝다. 람다식의 형태는 매개 변수를 가진 코드 블록이지만,
//       런타임 시에는 익명 구현 객체를 생성한다. (매개변수) -> {실행코드} 형태로 작성되고 런타임 시에 인터페이스의 익명 구현 객체로 생성된다.
//       어떤 인터페이스를 구현할 것인가는 대입되는 인터페이스가 무엇이냐에 달려있다.
public class LambdaExpressionEx1 {
    public static void main(String[] args) {
        IntConsumer c1 =
                // 타입 매개변수 는 오른쪽 중괄호 블록을 실행하기 위해 필요한 값을 제공하는 역할을 한다.
                // -> 기호는 매개변수를 이용해서 중괄호를 실행한다는 뜻이다.
                (int a) -> {
                    System.out.println(a);
                };

        IntConsumer c2 =
                // 매개변수 타입은 런타임 시에 대입되는 값에 따라 자동으로 인식될 수 있기 때문에 람다식에서는 매개변수의 타입을 일반적으로 언급하지 않는다.
                (a) -> {
                    System.out.println(a);
                };

        IntConsumer c3 =
                // 하나의 매개변수만 있다면 ()를 생략할 수 있고, 하나의 실행문만 있다면 중괄호도 생략 가능하다.
                a -> System.out.println(a);

        // 만약 매개변수가 없다면 람다식에서 매개변수 자리가 없어지므로 빈 괄호를 반드시 사용해야 한다.
        Runnable runnable = () -> System.out.println("hello");

        // 중괄호를 실행하고 결과값을 리턴해야 한다면 return 문으로 결과값을 지정할 수 있다.
//        (x, y) -> {
//            return x + y;
//        };
        // 중괄호에 return 문만 있을 경우, 람다식에서는 return 문을 사용하지 않는게 정석이다.
//        (x, y) -> x + y
    }
}
