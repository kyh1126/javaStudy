package _14_lambdaExpression._3_functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Predicate 함수적 인터페이스: 매개변수와 boolean 리턴값이 있는 testXX()메소드를 가지고 있다. 이 메소드들은 매개값을 조사해서 true 또는 false 를 리턴하는 역할을 한다.
// -------------------------------------------------------------------------------
// 인터페이스명             추상 메소드                    설명
// -------------------------------------------------------------------------------
// Predicate<T>         boolean test(T t)           객체 T를 조사
// BiPredicate<T, U>    boolean test(T t, U u)      객체 T와 U를 조사
// DoublePredicate      boolean test(double val)    double 값을 조사
// IntPredicate         boolean test(int val)       int 값을 조사
// LongPredicate        boolean test(long val)      long 값을 조사
// -------------------------------------------------------------------------------
public class PredicateEx6 {
    private static List<Student> list = Arrays.asList(
            new Student("사람1", "M", 90),
            new Student("사람2", "W", 96),
            new Student("사람3", "M", 80),
            new Student("사람4", "M", 90)
    );

    public static double avg(Predicate<Student> predicate) {
        int count = 0, sum = 0;
        for (Student student : list) {
            if (predicate.test(student)) {
                count++;
                sum += student.getMathScore();
            }
        }
        return (double) sum / count;
    }

    public static void main(String[] args) {
        System.out.println("남자 평균 점수: " + avg(t -> t.getSex() == Sex.MAN));
        System.out.println("여자 평균 점수: " + avg(t -> t.getSex() == Sex.WOMAN));
    }
}
