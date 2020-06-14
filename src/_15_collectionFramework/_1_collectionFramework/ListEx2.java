package _15_collectionFramework._1_collectionFramework;

import java.util.*;

// List 컬렉션: 객체를 일렬로 늘어놓은 구조. 객체를 인덱스로 관리하기 때문에 객체를 저장하면 자동 인덱스가 부여되고 인덱스로 검색, 삭제할 수 있는 기능을 제공한다.
//            객체 자체를 저장하는 것이 아니라 객체의 번지를 참조한다. 동일한 객체를 중복 저장할 수 있는데, 이 경우 동일한 번지가 참조된다. null 도 저장이
//            가능한데, 이 경우 해당 인덱스는 객체를 참조하지 않는다.
// -------------------------------------------------------------------------------
// 기능   메소드                             설명
// -------------------------------------------------------------------------------
// 객체   boolean add(E e)                주어진 객체를 맨 끝에 추가
// 추가   void add(int index, E e)        주어진 인덱스에 객체를 추가
//       E set(int index, E e)           주어진 인덱스에 저장된 객체를 주어진 객체로 바꿈
// -------------------------------------------------------------------------------
// 객체   boolean contains(Object o)      주어진 객체가 저장되어 있는지 여부
// 검색   E get(int index)                주어진 인덱스에 저장된 객체를 리턴
//       boolean isEmpty()               컬렉션이 비어 있는지 조사
//       int size()                      저장되어 있는 전체 객체 수를 리턴
// -------------------------------------------------------------------------------
// 객체   void clear()                    저장된 모든 객체를 삭제
// 삭제   E remove(int index)             주어진 인덱스에 저장된 객체를 삭제
//       boolean remove(Object o)        주어진 객체를 삭제
// -------------------------------------------------------------------------------

// 1. ArrayList
// List 인터페이스의 구현 클래스. ArrayList 에 객체를 추가하면 객체가 인덱스로 관리된다. 일반 배열과 인덱스로 객체를 관리한다는 점에서는 유사하지만,
// 배열은 생성할 때 크기가 고정되고 사용 중에 크기를 변경할 수 없지만, ArrayList 는 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이
// 늘어난다. 자바 5부터 제네릭을 도입하여 ArrayList 객체를 생성할 때 타입 파라미터로 저장할 객체의 타입을 지정함으로써 불필요한 타입 변환을 하지 않도록 했다.
// ArrayList 에 객체를 추가하면 인덱스 0부터 차례대로 저장된다. ArrayList 에서 특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두
// 앞으로 1씩 당겨지는 모습을 보여준다. 따라서 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 ArrayList 사용이 바람직하지 않다.(LinkedList 가 더 좋다)
// 그러나 인덱스 검색이나 맨 마지막에 객체를 추가하는 경우에는 ArrayList 가 더 좋은 성능을 발휘한다.
// ArrayList 를 생성하고 런타임 시 필요에 의해 객체들을 추가하는 것이 일반적이지만, 고정된 객체들로 구성된 List 를 생성할 때도 있다.(Arrays.asList(T... a))

// 2. Vector
// ArrayList 와 동일한 내부 구조를 가지고 있다. Vector 를 생성하기 위해서는 저장할 객체 타입을 타입 파라미터로 표기하고 기본 생성자를 호출하면 된다.
// ArrayList 와 다른 점은 Vector 는 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티스레드가 동시에 이 메소드들을 실행할 수 없고, 하나의
// 스레드가 실행을 완료해야만 다른 스레들를 실행할 수 있다. 그래서 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제할 수 있다. 이것을 스레드가 안전(Thread Safe)
// 하다라고 말한다.

// 3. LinkedList
// List 구현 클래스로 ArrayList 와 사용 방법은 똑같지만 내부 구조는 다르다. ArrayList 는 내부 배열에 객체를 저장해서 인덱스로 관리하지만,
// LinkedList 는 인접 참조를 링크해서 체인처럼 관리한다. 특정 인덱스의 객체를 제거하면 앞뒤 링크만 변경되고 나머지 링크는 변경되지 않는다. 특정 인덱스에
// 객체를 삽입할 때에도 마찬가지다. 빈번한 객체 삭제, 삽입이 일어나는 곳에서는 ArrayList 보다 LinkedList 가 좋은 성능을 발휘한다.
// 끝에서부터(순차적으로) 추가/삭제하는 경우는 ArrayList 가 빠르지만, 중간에 추가, 삭제할 경우는 앞뒤 링크 정보만 변경하면 되는 LinkedList 가 더 빠르다.
// ArrayList 는 뒤쪽 인덱스들을 모두 1씩 증가 또는 감소시키는 시간이 필요하므로 처리 속도가 느리다.
public class ListEx2 {
    public static void main(String[] args) {
        // 1
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Servlet/JSP");
        list.add(1, "Database");
        list.add("MyBatis");

        System.out.println("총 객체수: " + list.size());
        System.out.println("1: " + list.get(1));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
        list.remove(1);
        list.remove("MyBatis");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
        Arrays.asList("A", "B", "C").forEach(System.out::println);

        // 2
        List<Board> bList = new Vector<>();
        bList.add(new Board("제목1", "내용1", "글쓴1"));
        bList.add(new Board("제목2", "내용2", "글쓴2"));
        bList.add(new Board("제목3", "내용3", "글쓴3"));
        bList.add(new Board("제목4", "내용4", "글쓴4"));
        bList.add(new Board("제목5", "내용5", "글쓴5"));

        bList.remove(2);
        bList.remove(3);

        for (int i = 0; i < bList.size(); i++) {
            System.out.println(bList.get(i).subject + "\t" + bList.get(i).content);
        }

        // 3
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            list1.add(0, String.valueOf(i));
        }
        System.out.println("ArrayList 걸린 시간(ns): " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            list2.add(0, String.valueOf(i));
        }
        System.out.println("LinkedList 걸린 시간(ns): " + (System.nanoTime() - startTime));

        list2.forEach(System.out::print);
        System.out.println("size: " + list2.size());
        list2.remove(5);
        list2.forEach(System.out::print);
        System.out.println("size: " + list2.size());
    }
}
