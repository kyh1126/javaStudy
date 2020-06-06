package _14_lambdaExpression._3_functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

// Function 함수적 인터페이스: 매개값과 리턴값이 있는 applyXX()메소드를 가지고 있다. 이 메소드들은 매개값을 리턴값으로 매핑(타입 변환)하는 역할을 한다.
// -------------------------------------------------------------------------------
// 인터페이스명                   추상 메소드                      설명
// -------------------------------------------------------------------------------
// Function<T, R>           R apply(T t)                    객체 T를 객체 R로 매핑
// BiFunction<T, U, R>      R apply(T t, U u)               객체 T와 U를 객체 R로 매핑
// DoubleFunction<R>        R apply(double val)             double 을 객체 R로 매핑
// IntFunction<R>           R apply(int val)                int 를 객체 R로 매핑
// IntToDoubleFunction      double applyAsDouble(int val)   int 를 double 로 매핑
// IntToLongFunction        long applyAsLong(int val)       int 를 long 으로 매핑
// LongToDoubleFunction     double applyAsDouble(long val)  long 을 double 로 매핑
// LongToIntFunction        int applyAsInt(long val)        long 을 int 로 매핑
// ToDoubleBiFunction<T, U> double applyAsDouble(T t, U u)  객체 T와 U를 double 로 매핑
// ToDoubleFunction<T>      double applyAsDouble(T t)       객체 T를 double 로 매핑
// ToIntBiFunction<T, U>    int applyAsInt(T t, U u)        객체 T와 U를 int 로 매핑
// ToIntFunction<T>         int applyAsInt(T t)             객체 T를 int 로 매핑
// ToLongBiFunction<T, U>   long applyAsLong(T t, U u)      객체 T와 U를 long 으로 매핑
// ToLongFunction<T>        long applyAsLong(T t)           객체 T를 long 으로 매핑
// -------------------------------------------------------------------------------
public class FunctionEx4 {
    private static List<Student> list = Arrays.asList(
            new Student("사람1", 90, 96),
            new Student("사람2", 80, 98)
    );

    public static void printString(Function<Student, String> function) {
        for (Student student : list) {
            System.out.println(function.apply(student) + " ");
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Student> function) {
        for (Student student : list) {
            System.out.println(function.applyAsInt(student) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("[학생 이름]");
        printString(t -> t.getName());

        System.out.println("[영어 점수]");
        printInt(t -> t.getEnglishScore());

        System.out.println("[수학 점수]");
        printInt(t -> t.getMathScore());
    }
}
