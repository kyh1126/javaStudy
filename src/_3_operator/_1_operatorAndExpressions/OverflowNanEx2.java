package _3_operator._1_operatorAndExpressions;

// 오버플로우: 저장될 수 있는 값의 범위를 초과하면 쓰레기 값으로 얻을 수 있다.
// NaN과 Infinity 연산: 정수를 0으로 나누면 실행 시점에 예외 발생.
//                    실수 타입인 0.0 또는 0.0f로 나누면 예외대신 / 결과는 Infinity, % 결과는 NaN(Not a Number) 가진다.
//                    연산 결과가 Infinity 또는 NaN인지 확인하려면 Double.isInfinite(), Double.isNaN()을 이용하면 된다.
public class OverflowNanEx2 {
    public static void main(String[] args) {
        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;

        double res = apple - number * pieceUnit;

        // 0.29999999999999993
        // 이진 포맷의 가수를 사용하는 부동소수점 타입(float, double)은 0.1을 정확히 표현할 수 없어 근사치로 처리.
        System.out.println("사과 한 개에서 0.7 조각을 빼면 " + res);
        // 정확한 계산이 필요하면 정수 연산으로 변경해야 한다.
        res = (apple * 10 - number) / 10.0;
        System.out.println(res);

        // NaN은 != 연산자를 제외한 모든 비교 연산자에 false 값 리턴한다. 그래서 비교가 안된다.
        double val = Double.valueOf("NaN");
        System.out.println("val == NaN? " + (val == Double.valueOf("NaN")));
        System.out.println("val != NaN? " + (val != Double.valueOf("NaN")));    // true
        if (Double.isNaN(val)) {
            System.out.println("NaN!!");
        }

        // 문자열 연결 연산자 사용시 주의해야 한다.
        System.out.println(3 + 3.0 + "String");

        // 비교 연산 수행 전 타입 변환을 통해 피연산자의 타입을 일치시킨다.
        // 이진 포맷의 가수를 사용하는 모든 부동소수점 타입은 0.1을 정확히 표현할 수 없어 0.1f는 0.1의 근사값으로 표현되어 0.1보다 큰 값이 되어버린다.
        // 피연산자를 모두 float 타입으로 강제 타입 변환 후 연산하거나 정수로 변환 후 비교하면 된다.
        System.out.println("0.1 == 0.1f: " + (0.1 == 0.1f));

        String str1 = "a";
        String str2 = new String("a");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == 'a': " + (str1 == "a"));
        System.out.println("str2 == 'a': " + (str2 == "a"));
        System.out.println("str2 equals 'a': " + (str2.equals("a")));

    }
}
// 컴파일러는 각 클래스별로 가상 메소드 테이블(룩업테이블)을 작성하고 생성자에 가상테이블 포인터를 초기화하는 숨겨진 코드를 생성한다. (메소드 영역?)
// 객체가 생성되면 가상 테이블 포인터(vpointer)가 이 객체의(힙) 숨겨진 멤버로 추가된다. 이 멤버를 통해 vtable 주소를 페치하여 메소드 호출이 수행된다.
// JIT 컴파일 된 코드에서는 보통 vtable calling sequence 가 사용되지 않는다.
// HotSpot 은 inline caching 수행한다. (코드는 가상 메소드의 대상이 항상 동일한 구현을 가리킴을 가정)
// 이 경우 가정이 실제로 유지되는지 (즉, 목표가 변경되지 않았는지) 확인하기 위해 코드에 검사가 삽입된 후 제어 방법은 vtable 조회를 포함하지 않고 목표
// 메소드에 직접 전달된다. 소위 '연결되지 않은'콜 사이트가 작동합니다. 이 가정이 충분한 시간에 실패하면, 코드는 긴 와인딩 vtable 조회 접근법 수행한다.