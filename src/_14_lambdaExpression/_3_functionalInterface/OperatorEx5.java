package _14_lambdaExpression._3_functionalInterface;

import java.util.function.IntBinaryOperator;

// Operator 함수적 인터페이스: Function 과 동일하게 매개변수와 리턴값이 있는 applyXX()메소드를 가지고 있다. 이 메소드들은 매개값을 리턴값으로 매핑(타입 변환)하는
//                        역할보다는 매개값을 이용해서 연산을 수행한 후 동일한 타입으로 리턴값을 제공하는 역할을 한다.
// -------------------------------------------------------------------------------
// 인터페이스명               추상 메소드                          설명
// -------------------------------------------------------------------------------
// BinaryOperator<T>      T apply(T t, T t)                 T와 T를 연산한 후 T 리턴
// UnaryOperator<T>       T apply(T t)                      T를 연산한 후 T 리턴
// DoubleBinaryOperator   double applyAsDouble(double d1,   두 개의 double 연산
//                                             double d2)
// DoubleUnaryOperator    double applyAsDouble(double d1)   한 개의 double 연산
// IntBinaryOperator      int applyAsInt(int i1, int i2)    두 개의 int 연산
// IntUnaryOperator       int applyAsInt(int i1)            한 개의 int 연산
// LongBinaryOperator     long applyAsLong(long l1, long l2)두 개의 long 연산
// LongUnaryOperator      long applyAsLong(long l1)         한 개의 long 연산
// -------------------------------------------------------------------------------
public class OperatorEx5 {
    private static int[] scores = {92, 95, 87};

    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for (int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        int max = maxOrMin((a, b) -> {
            if (a <= b) return a;
            return b;
        });
        System.out.println("최소값: " + max);
    }
}
