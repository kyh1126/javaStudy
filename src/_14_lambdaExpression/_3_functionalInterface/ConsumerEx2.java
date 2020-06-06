package _14_lambdaExpression._3_functionalInterface;

import _13_generic._1_whyGeneric.Product;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Consumer 함수적 인터페이스: 리턴값이 없는 accept()메소드를 가지고 있다. accept()메소드는 단지 매개값을 소비(사용만 하고 리턴값이 없다)하는 역할만 한다.
// -------------------------------------------------------------------------------
// 인터페이스명               추상 메소드                      설명
// -------------------------------------------------------------------------------
// Consumer<T>          void accept(T t)                객체 T를 받아 소비
// BiConsumer<T, U>     void accept(T t, U u)           객체 T와 U를 받아 소비
// DoubleConsumer       void accept(double val)         double 값을 받아 소비
// IntConsumer          void accept(int val)            int 값을 받아 소비
// LongConsumer         void accept(long val)           long 값을 받아 소비
// ObjDoubleConsumer<T> void accept(T t, double val)    객체 T와 double 값을 받아 소비
// ObjIntConsumer<T>    void accept(T t, int val)       객체 T와 int 값을 받아 소비
// ObjLongConsumer<T>   void accept(T t, long val)      객체 T와 long 값을 받아 소비
// -------------------------------------------------------------------------------
public class ConsumerEx2 {
    public static void main(String[] args) {
        Consumer<String> consumer = t -> System.out.println(t + "8");
        consumer.accept("3");

        BiConsumer<Product, Product> biConsumer = (t, u) -> System.out.println(t.getKind() + "" + u);
        biConsumer.accept(new Product(), new Product());
    }
}
