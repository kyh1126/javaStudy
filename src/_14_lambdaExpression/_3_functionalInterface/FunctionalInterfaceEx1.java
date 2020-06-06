package _14_lambdaExpression._3_functionalInterface;

// 자바 8부터는 빈번하게 사용되는 함수적 인터페이스는 java.util.function 표준 API 패키지로 제공한다.
// 크게 Consumer, Supplier, Function, Operator, Predicate 로 구분된다.
// -------------------------------------------------------------------------------
// 종류           추상 메소드 특징
// -------------------------------------------------------------------------------
// Consumer     매개값은 있고, 리턴값은 없음.
// Supplier     매개값은 없고, 리턴값은 있음.
// Function     매개값도 있고, 리턴값도 있음. 주로 매개값을 리턴값으로 매핑(타입 변환)
// Operator     매개값도 있고, 리턴값도 있음. 주로 매개값을 연산하고 결과를 리턴.
// Predicate    매개값은 있고, 리턴 타입은 boolean. 매개값을 조사해서 true/false 리턴.
// -------------------------------------------------------------------------------
public class FunctionalInterfaceEx1 {
}
