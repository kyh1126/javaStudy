package _11_basicAPIClass._4_objects;

import java.util.Arrays;
import java.util.Objects;

// Objects 클래스: 객체 비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 Object 의 유틸리티 클래스.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드(매개 변수)                          설명
// -------------------------------------------------------------------------------
// int      compare(T a, T b, Comparator<T> c)      두 객체 a, b를 Comparator 사용해서 비교.
//                                                  a가 b보다 작으면 음수, 크면 양수, 같으면 0 리턴하도록 구현 클래스를 만들어야 한다.
// boolean  deepEquals(Object a, Object b)          두 객체의 깊은 비교(배열의 항목까지 비교). 둘 다 null 이면 true 리턴한다.
//                                                  a, b가 배열인 경우, 항목 값이 모두 같다면 true 리턴. Arrays.deepEquals 와 동일.
// boolean  equals(Object a, Object b)              두 객체의 얕은 비교(번지만 비교). 둘 다 null 이면 true 리턴한다.
// int      hash(Object... values)                  매개값이 저장된 배열을 생성하고 Arrays.hashCode(Object[]) 호출해서 해시코드 리턴.
//                                                  클래스가 hashCode()를 재정의할 때 리턴값을 생성하기 위해 사용하면 좋다.
// int      hashCode(Object o)                      객체의 해시코드 생성
// boolean  isNull(Object o)                        객체가 null 인지 조사
// boolean  nonNull(Object o)                       객체가 null 이 아닌지 조사
// T        requireNonNull(T obj)                   객체가 null 인 경우 예외 발생
// T        requireNonNull(T obj, String msg)       객체가 null 인 경우 예외 발생(주어진 예외 메시지 포함)
// T        requireNonNull(T obj,                   객체가 null 인 경우 예외 발생(람다식이 만든 예외 메시지 포함)
//              Supplier<String> msgSupplier)
// String   toString(Object o)                      객체의 toString() 리턴값 리턴
// String   toString(Object o, String nullDefault)  객체의 toString() 리턴값 리턴. 첫번째 매개값이 null 일 경우 두번째 매개값 리턴.
// -------------------------------------------------------------------------------
public class ObjectsEx1 {
    public static void main(String[] args) {
        // deepEquals, equals
        Integer[] arr1 = {1, 2};
        Integer[] arr2 = {1, 2};
        System.out.println(Objects.equals(arr1, arr2));
        System.out.println(Objects.deepEquals(arr1, arr2));
        System.out.println(Arrays.deepEquals(arr1, arr2));

        // hash, hashCode
        Student s1 = new Student(1, "홍길동");
        Student s2 = new Student(1, "홍길동");
        System.out.println(s2.hashCode());
        System.out.println(Objects.hashCode(s1));
        System.out.println(s1.equals(s2));

        // toString
        String str1 = "홍길동";
        String str2 = null;
        System.out.println(Objects.toString(str1));
        System.out.println(Objects.toString(str2));
        System.out.println(Objects.toString(str2, "이름이 없습니다."));
    }

    static class Student {
        int sno;
        String name;

        public Student(int sno, String name) {
            this.sno = sno;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sno, name);
        }
    }
}
