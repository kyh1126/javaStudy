package _14_lambdaExpression._3_functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;

// 디폴트 및 정적 메소드는 추상 메소드가 아니기 때문에 함수적 인터페이스에 선언되어도 여전히 함수적 인터페이스의 성질을 잃지 않는다.
// 함수적 인터페이스의 성질이란 하나의 추상 메소드를 가지고 있고, 람다식으로 익명 구현 객체를 생성할 수 있는 것.
// Consumer, Function, Operator 종류의 함수적 인터페이스는 andThen(), compose() 디폴트 메소드를 가지고 있다.
// 2개의 함수적 인터페이스를 순차적으로 연결하고, 첫 번째 처리 결과를 두 번째 매개값으로 제공해서 최종 결과값을 얻을 때 사용한다.
// andThen(): 인터페이스AB = 인터페이스A.andThen(인터페이스B);
//            최종결과 = 인터페이스AB.method();  // 인터페이스A 처리하고 인터페이스B 매개값으로 제공한다.
// compose(): 인터페이스AB = 인터페이스A.compose(인터페이스B);
//            최종결과 = 인터페이스AB.method();  // 인터페이스B 처리하고 인터페이스A 매개값으로 제공한다.
// -------------------------------------------------------------------------------
// 종류           함수적 인터페이스       andThen()   compose()
// -------------------------------------------------------------------------------
// Consumer     Consumer<T>             O
//              BiConsumer<T, U>        O
//              DoubleConsumer          O
//              IntConsumer             O
//              LongConsumer            O
// -------------------------------------------------------------------------------
// Function     Function<T, R>          O           O
//              BiFunction<T, U, R>     O
// -------------------------------------------------------------------------------
// Operator     BinaryOperator<T>       O
//              DoubleUnaryOperator     O           O
//              IntUnaryOperator        O           O
//              LongUnaryOperator       O           O
// -------------------------------------------------------------------------------
// 1. Consumer 의 순차적 연결: Consumer 종류의 함수적 인터페이스는 처리 결과를 리턴하지 않기 때문에 andThen() 디폴트 메소드는 함수적 인터페이스의 호출 순서만 정한다.
// 2. Function 의 순차적 연결: Function 과 Operator 종류의 함수적 인터페이스는 먼저 실행한 함수적 인터페이스의 결과를 다음 함수적 인터페이스의 매개값으로 넘겨주고,
//                          최종 처리 결과를 리턴한다.
public class ConsumerFunctionOperatorDefaultMethodEx7 {
    public static void main(String[] args) {
        // 1
        Consumer<Member> consumerA = (m) -> System.out.println("consumerA: " + m.getName());
        Consumer<Member> consumerB = (m) -> System.out.println("consumerB: " + m.getId());

        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
        consumerAB.accept(new Member("사람", "saram", null));

        // 2
        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;
        String city;

        functionA = (m) -> m.getAddress();
        functionB = (a) -> a.getCity();

        // 모두 functionA부터 실행하고 functionB를 나중에 실행한다.
        functionAB = functionA.andThen(functionB);
        city = functionAB.apply(new Member("사람", "saram", new Address("한국", "서울")));
        System.out.println("거주 도시: " + city);

        functionAB = functionB.compose(functionA);
        city = functionAB.apply(new Member("사람", "saram", new Address("한국", "서울")));
        System.out.println("거주 도시: " + city);
    }
}
