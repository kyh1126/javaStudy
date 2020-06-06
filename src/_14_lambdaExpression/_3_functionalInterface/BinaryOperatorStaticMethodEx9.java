package _14_lambdaExpression._3_functionalInterface;

import java.util.function.BinaryOperator;

// BinaryOperator<T> 함수적 인터페이스는 minBy()와 maxBy() 정적 메소드를 제공한다. 이 두 메소드는 매개값으로 제공되는 Comparator 를 이용해서
// 최대 T와 최소 T를 얻는 BinaryOperator<T>를 리턴한다.
// -------------------------------------------------------------------------------
// 리턴 타입                정적 메소드
// -------------------------------------------------------------------------------
// BinaryOperator<T>    minBy(Comparator<? super T> comparator)
// BinaryOperator<T>    maxBy(Comparator<? super T> comparator)
// -------------------------------------------------------------------------------

// Comparator<T> 는 o1이 작으면 음수, 동일하면 0, o1이 크면 양수를 리턴하는 compare()메소드가 선언되어 있는 함수적 인터페이스이다.
// Comparator<T>를 타겟 타입으로 하는 람다식: (o1, o2) -> { ..; return int값; }
public class BinaryOperatorStaticMethodEx9 {
    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.price, f2.price));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
        System.out.println(fruit.name);

        binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.price, f2.price));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
        System.out.println(fruit.name);
    }
}
