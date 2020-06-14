package _11_basicAPIClass._3_object;

import java.util.HashMap;

// Object 클래스: extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속하게 된다.
//              따라서 자바의 모든 클래스는 Object 클래스의 자식이거나 자손 클래스이다. Object 는 자바의 최상위 부모 클래스.
//              Object 클래스는 필드가 없고, 메소드들로 구성되어 있다.
// 1. 객체 비교(equals()): 두 객체가 동일한 객체라면 true, 그렇지 않으면 false 리턴한다.
//                      String equals() 메소드는 객체의 번지를 비교하는 것이 아니고, 그 값이 동일한지 비교한다.(오버이딩함)
//                      Member 객체는 다르지만 id 같으면 논리적으로 동등한 객체로 취급하고 싶을 경우 Object 의 equals() 메소드를 재정의해서 id
//                      값이 같음을 비교하면 된다. 재정의할 때에는 매개값(비교 객체)이 기준 객체와 동일한 타입의 객체인지 먼저 확인해야 한다.
//                      instanceof 연산잘로 기준 객체와 동일한 타입인지 제일 먼저 확인해야 한다.
// 2. 객체 해시코드(hashCode()): 객체 해시코드란 객체를 식별할 하나의 정수값을 말한다. hashCode() 메소드는 객체의 메모리 번지를 이용해서 해시코드를
//                           만들어 리턴하기 때문에 객체마다 다른 값을 가지고 있다. 논리적 동등 비교 시 hashCode()를 오버라이딩 해야 하는데,
//                           HashSet, HashMap, Hashtable 은 (hashCode() 값 -> equals() 값) 방법으로 두 객체가 동등한지 비교한다.
// 3. 객체 문자 정보(toString()): 객체의 문자 정보를 리턴한다. 객체의 문자 정보란 객체를 문자열로 표현한 값. 클래스명@16진수해시코드 문자 정보 리턴.
//                             System.out.println() 매개값에 객체를 주면 객체의 toString() 메소드를 호출해서 리턴값을 출력한다.
// 4. 객체 복제(clone()): 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것. Object 의 clone() 메소드는 자신과 동일한 필드값을 가진
//                      얕은 복제된 객체를 리턴한다. 이 메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현하고
//                      있어야 한다. 메소드 선언이 없음에도 불구하고 Cloneable 인터페이스를 명시적으로 구현하는 이유는 클래스 설계자가 복제를 허용
//                      한다는 의도적인 표시를 하기 위해서이다. 이를 구현하지 않고 clone()하면 예외 발생.
//  - 얕은 복제(thin clone): 단순히 필드값을 복사해서 객체를 복제하는 것. 필드값만 복제하기 때문에 필드가 기본 타입일 경우 값 복사가 일어나고,
//                         참조 타입일 경우 객체의 번지가 복사된다.
//  - 깊은 복제(deep clone): 참조하고 있는 객체도 복제한다. Object 의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 작성해야 한다.
// 5. 객체 소멸자(finalize()): 참조하지 않는 배열이나 객체는 쓰레기 수집기(Garbage Collector)가 힙 영역에서 자동적으로 소멸시킨다. 쓰레기 수집기는
//                          객체를 소멸하기 직전에 마지막으로 객체의 소멸자(finalize())를 실행시킨다. 객체가 소멸되기 전에 마지막으로 사용했던
//                          자원을 닫고 싶거나 중요한 데이터를 저장하고 싶다면 Object 의 finalize()를 재정의할 수 있다.
//                          순서대로 소멸시키지 않고, 전부 소멸시키는 것이 아니라 메모리 상태 보고 일부만 소멸시킨다. 쓰레기 수집기는 메모리가 부족할
//                          때 그리고 CPU 가 한가할 때에 JVM 에 의해서 자동 실행된다. 그렇기 때문에 finalize()가 호출되는 시점은 명확하지 않다.
//                          프로그램이 종료될 때 즉시 자원을 해제하거나 즉시 데이터를 최종 저장해야 한다면, 일반 메소드에서 작성하고 프로그램이 종료될
//                          때 명시적으로 메소드를 호출하는 것이 좋다.
public class ObjectClassEx1 {
    public static void main(String[] args) {
        // 1
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.equals(o2) == (o1 == o2));

        Member m1 = new Member("blue");
        Member m2 = new Member("blue");
        Member m3 = new Member("red");

        if (m1.equals(m2)) {
            System.out.println("m1, m2는 동등(equals)합니다");
        } else {
            System.out.println("m1, m2는 동등(equals)하지 않습니다");
        }

        // 2
        // Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
        HashMap<Key, String> hashMap = new HashMap<>();

        // 식별키 "new Key(1)"로 "홍길동"을 저장함
        hashMap.put(new Key(1), "홍길동");

        // 식별키 "new Key(1)"로 "홍길동"을 읽어옴, hashCode() 메소드에서 리턴하는 해시코드가 다르기 때문에 new Key(1) 을 다르게 인식한다.
        // Key 의 hashCode 를 재정의하면 이제 값을 찾아올 수 있다.
        System.out.println(hashMap.get(new Key(1)));

        // 3
        SmartPhone s = new SmartPhone("구글", "안드로이드");
        System.out.println(s.toString());
        System.out.println(s);

        // 4
        Member m = new Member("1126", new Key(1126));
        Member clone = m.getMember();
        clone.id = "2246";
        clone.k.number = 2246;
        System.out.println(m.id);
        System.out.println(clone.id);
        System.out.println(m.k);
        System.out.println(clone.k);    // 깊은 복제 전후로 결과가 달라진다.

        // 5
        Counter c = null;
        for (int i = 0; i < 50; i++) {
            c = new Counter(i);
            // Counter 객체를 쓰레기로 만듬
            c = null;
            // 쓰레기 수집기 실행 요청
            System.gc();
        }
    }
}
