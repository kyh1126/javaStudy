package _5_referenceType._3_enumType;

// 열거 타입: 한정된 값만 갖는다. 몇 개의 열거 상수 중 하나의 상수를 저장하는 데이터 타입
//          참조 타입이기 때문에 null 저장 가능.
// 열거 객체: 열거 상수의 문자열을 내부 데이터로 가지고 있다. 힙 영역에 생성된다.
//          Enum 클래스에 선언된 아래 메소드들을 사용할 수 있는데, 모든 열거 타입은 컴파일 시에 Enum 클래스를 상속하게 되어 있기 때문이다.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드(매개 변수)          설명
// -------------------------------------------------------------------------------
// String     name()                열거 객체의 문자열을 리턴
// int        ordinal()             열거 객체의 순번(0부터 시작)을 리턴
// int        compareTo()           열거 객체를 비교해서 순번 차이를 리턴
// 열거 타입    valueOf(String name)  주어진 문자열의 열거 객체를 리턴
// 열거 배열    values()              모든 열거 객체들을 배열로 리턴

// LocalDateTime: 자바 8부터 지원하는 API
public class EnumEx1 {
    public static void main(String[] args) {
        // 참조 타입 변수는 객체를 참조하는 변수인데, 열거 상수도 객체이다.
        // 열거 변수    열거 상수
        // 스택 영역    열거 상수(메소드 영역)의 참조하는 객체 주소 복사해서 같은 열거 객체 참조(힙 영역)
        Week today = Week.FRIDAY;
        System.out.println("today == Week.FRIDAY: " + (today == Week.FRIDAY));

        System.out.println("Week.SUNDAY.name(): " + Week.SUNDAY.name());
        System.out.println("Week.SUNDAY.ordinal(): " + Week.SUNDAY.ordinal());
        // Week.FRIDAY(4) 기준으로 Week.SUNDAY(6) 의 상대적 위치를 리턴
        System.out.println("Week.SUNDAY.compareTo(Week.FRIDAY): " + Week.SUNDAY.compareTo(Week.FRIDAY));
        System.out.println("Week.valueOf(\"FRIDAY\"): " + Week.valueOf("FRIDAY"));

        for (Week day : Week.values()) {
            System.out.println(day.ordinal() + "::" + day);
        }
    }
}
