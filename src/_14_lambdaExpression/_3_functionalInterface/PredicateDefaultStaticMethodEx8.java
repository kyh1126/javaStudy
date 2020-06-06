package _14_lambdaExpression._3_functionalInterface;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

// Predicate 종류의 함수적 인터페이스는 and(), or(), negate() 디폴트 메소드를 가지고 있다. &&, ||, ! 과 대응된다.
// and(): 두 Predicate 가 모두 true 를 리턴하면 최종적으로 true 를 리턴하는 Predicate 를 생성한다.
// or(): 두 Predicate 중 하나만 true 를 리턴하더라도 최종적으로 true 를 리턴하는 Predicate 를 생성한다.
// negate(): 원래 Predicate 결과가 true 이면 false, false 이면 true 를 리턴하는 새로운 Predicate 를 생성한다.
// -------------------------------------------------------------------------------
// 종류           함수적 인터페이스       and()   or()    negate()
// -------------------------------------------------------------------------------
// Predicate    Predicate<T>        O       O       O
//              BiPredicate<T, U>   O       O       O
//              DoublePredicate     O       O       O
//              IntPredicate        O       O       O
//              LongPredicate       O       O       O
// -------------------------------------------------------------------------------

// isEqual(): Predicate<T> 함수적 인터페이스가 제공하는 정적 메소드.
//            test() 매개값인 sourceObject 와 isEqual()의 매개값인 targetObject 를 Objects 클래스의 equals() 매개값으로 제공하고,
//            Objects.equals(sourceObject, targetObject)의 리턴값을 얻어 새로운 Predicate<T>를 생성한다.
// -------------------------------------------------------------------------------
// sourceObject     targetObject    리턴값
// -------------------------------------------------------------------------------
// null             null            true
// not null         null            false
// null             not null        false
// not null         not null        sourceObject.equals(targetObject)의 리턴값
// -------------------------------------------------------------------------------
public class PredicateDefaultStaticMethodEx8 {
    public static void main(String[] args) {
        // 1. 디폴트 메소드
        IntPredicate predicateA = a -> a % 2 == 0;
        IntPredicate predicateB = a -> a % 3 == 0;

        IntPredicate predicateAB;
        boolean result;

        // and
        predicateAB = predicateA.and(predicateB);
        result = predicateAB.test(9);
        System.out.println("9는 2와 3의 배수? " + result);

        // or
        predicateAB = predicateA.or(predicateB);
        result = predicateAB.test(9);
        System.out.println("9는 2 또는 3의 배수? " + result);

        // negate
        predicateAB = predicateA.negate();
        result = predicateAB.test(9);
        System.out.println("9는 홀수? " + result);

        // 2. 정적 메소드
        Predicate<String> predicate;

        predicate = Predicate.isEqual(null);
        System.out.println("null, null: " + predicate.test(null));

        predicate = Predicate.isEqual("Java8");
        System.out.println("null, Java8: " + predicate.test(null));

        predicate = Predicate.isEqual(null);
        System.out.println("Java8, null: " + predicate.test("Java8"));

        predicate = Predicate.isEqual("Java8");
        System.out.println("Java8, Java7: " + predicate.test("Java7"));

    }
}
