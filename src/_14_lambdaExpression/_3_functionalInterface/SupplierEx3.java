package _14_lambdaExpression._3_functionalInterface;

import java.util.function.IntSupplier;

// Supplier 함수적 인터페이스: 매개변수가 없고 리턴값이 있는 getXX()메소드를 가지고 있다. 이 메소드들은 실행 후 호출한 곳으로 데이터를 리턴하는 역할을 한다.
// -------------------------------------------------------------------------------
// 인터페이스명           추상 메소드              설명
// -------------------------------------------------------------------------------
// Supplier<T>      T get()                 T 객체를 리턴
// BooleanSupplier  boolean getAsBoolean()  boolean 값을 리턴
// DoubleSupplier   double getAsDouble()    double 값을 리턴
// IntSupplier      int getAsInt()          int 값을 리턴
// LongSupplier     long getAsLong()        long 값을 리턴
// -------------------------------------------------------------------------------
public class SupplierEx3 {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> (int) (Math.random() * 6) + 1;
        System.out.println("눈의 수: " + intSupplier.getAsInt());
    }
}
