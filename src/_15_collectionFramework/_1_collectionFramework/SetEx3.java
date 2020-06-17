package _15_collectionFramework._1_collectionFramework;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Set 컬렉션: List 컬렉션과 달리 저장 순서가 유지되지 않는다. 또한 객체를 중복해서 저장할 수 없고, 하나의 null 만 저장할 수 있다.
//           공통적으로 사용 가능한 Set 인터페이스의 메소드들.
// -------------------------------------------------------------------------------
// 기능   메소드                             설명
// -------------------------------------------------------------------------------
// 객체   boolean add(E e)                주어진 객체를 저장. 객체가 성공적으로 저장되면 true
// 추가                                   를 리턴하고 중복 객체면 false 를 리턴한다.
// -------------------------------------------------------------------------------
// 객체   boolean contains(Object o)      주어진 객체가 저장되어 있는지 여부
// 검색   boolean isEmpty()               컬렉션이 비어 있는지 조사
//       Iterator<E> iterator()          저장된 객체를 한 번씩 가져오는 반복자(Iterator 인터페이스를 구현한 객체) 리턴
//       int size()                      저장되어 있는 전체 객체 수를 리턴
// -------------------------------------------------------------------------------
// 객체   void clear()                    저장된 모든 객체를 삭제
// 삭제   boolean remove(Object o)        주어진 객체를 삭제
// -------------------------------------------------------------------------------

// Iterator 인터페이스에 선언된 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드명    설명
// -------------------------------------------------------------------------------
// boolean   hasNext()  가져올 객체가 있으면 true 리턴, 없으면 false 리턴.
// E         next()     컬렉션에서 하나의 객체를 가져온다.
// void      remove()   Set 컬렉션에서 객체를 제거한다.
// -------------------------------------------------------------------------------

// 1. HashSet
// Set 인터페이스의 구현 클래스. 객체들을 순서 없이 저장하고 동일한 객체는 중복 저장하지 않는다. HashSet 이 판단하는 동일한 객체란 꼭 같은 인스턴스를
// 뜻하지는 않는다. HashSet 은 객체를 저장하기 전에 먼저 객체의 hashCode() 메소드를 호출해서 해시코드를 얻어낸다. 이미 저장되어 있는 객체들의 해시코드와
// 비교하고, 동일 해시코드가 있다면 다시 equals()메소드로 두 객체를 비교해서 true 가 나오면 동일한 객체로 판단하고 중복 저장을 하지 않는다.
// 2. LinkedHashSet
// 3. TreeSet
public class SetEx3 {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        Collections.addAll(s, "a", "b", "c", "d");
        Iterator<String> iterator = s.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals("c")) {
                // Iterator 의 메소드지만, 실제 Set 컬렉션서 객체가 제거된다.
                iterator.remove();
            }
        }
        s.forEach(System.out::println);

        Set<Member> set = new HashSet<>();
        set.add(new Member("사람1", 10));
        set.add(new Member("사람1", 10));
        set.add(new Member("사람2", 15));

        System.out.println("size: " + set.size());
    }
}
