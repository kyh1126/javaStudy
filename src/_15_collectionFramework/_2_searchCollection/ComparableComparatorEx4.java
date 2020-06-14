package _15_collectionFramework._2_searchCollection;

import _15_collectionFramework._1_collectionFramework.Member;
import _15_collectionFramework._1_collectionFramework.Student;

import java.util.TreeSet;

// TreeSet, TreeMap 의 키는 저장과 동시에 자동 오름차순 정렬되는데, 숫자(Integer, Double)타입일 경우에는 값으로 정렬하고, 문자열(String)타입일
// 경우에는 유니코드로 정렬한다. 정렬을 위해 Comparable 을 구현한 객체를 요구하는데, Integer, Double, String 은 모두 comparable 인터페이스를
// 구현하고 있다. 사용자 정의 클래스도 Comparable 을 구현하면 자동 정렬이 가능하다.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드                 설명
// -------------------------------------------------------------------------------
// int      compareTo(T o)      주어진 객체와 같으면 0, 주어진 객체보다 작으면 음수, 크면 양수 리턴.
// -------------------------------------------------------------------------------

// TreeSet, TreeMap 의 키가 Comparable 구현하고 있지 않을 경우, 저장시 ClassCastException 발생.
// Comparable 비구현 객체를 정렬하는 방법은 생성자 매개값으로 정렬자(Comparator)를 제공하면 된다.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드                     설명
// -------------------------------------------------------------------------------
// int      compareTo(T o1, T o2)   o1과 o2가 같으면 0, o1이 o2보다 작으면 음수, 크면 양수 리턴.
// -------------------------------------------------------------------------------
public class ComparableComparatorEx4 {
    public static void main(String[] args) {
        TreeSet<Member> treeSet = new TreeSet<>();
        treeSet.add(new Member("saram2", 23));
        treeSet.add(new Member("saram3", 34));
        treeSet.add(new Member("saram1", 18));
        treeSet.forEach(m -> System.out.println(m.name + ":" + m.age));

        TreeSet<Student> studentSet = new TreeSet<>(new DescendingComparator());
        studentSet.add(new Student(36, "stu3"));
        studentSet.add(new Student(13, "stu1"));
        studentSet.add(new Student(25, "stu2"));
        studentSet.forEach(s -> System.out.println(s.sno + ":" + s.name));
    }
}
