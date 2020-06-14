package _15_collectionFramework._2_searchCollection;

import java.util.NavigableSet;
import java.util.TreeSet;

// TreeSet: 이진 트리를 기반으로한 Set 컬렉션. 하나의 노드는 노드값인 value 와 왼쪽, 오른쪽 자식 노드를 참조하기 위한 두개의 변수로 구성된다.
// TreeSet 이 가지고 있는 검색 관련 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드명        설명
// -------------------------------------------------------------------------------
// E         first()        제일 낮은 객체를 리턴.
// E         last()         제일 높은 객체를 리턴.
// E         lower(E e)     주어진 객체보다 바로 아래 객체를 리턴.
// E         higher(E e)    주어진 객체보다 바로 위 객체를 리턴.
// E         floor(E e)     주어진 객체와 동등한 객체가 있으면 리턴, 없다면 주어진 객체의 바로 아래 객체를 리턴.
// E         ceiling(E e)   주어진 객체와 동등한 객체가 있으면 리턴, 없다면 주어진 객체의 바로 위 객체를 리턴.
// E         pollFirst()    제일 낮은 객체를 꺼내오고 컬렉션에서 제거함.
// E         pollLast()     제일 높은 객체를 꺼내오고 컬렉션에서 제거함.
// -------------------------------------------------------------------------------

// TreeSet 이 가지고 있는 정렬 관련 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입            메소드명                설명
// -------------------------------------------------------------------------------
// Iterator<E>      descendingIterator()    내림차순으로 정렬된 Iterator 를 리턴
// NavigableSet<E>  descendingSet()         내림차순으로 정렬된 NavigableSet 을 반환.
// -------------------------------------------------------------------------------

// TreeSet 이 가지고 있는 범위 관련 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입            메소드명                설명
// -------------------------------------------------------------------------------
// NavigableSet<E>  headSet(E toElement,    주어진 객체보다 낮은 객체들을 NavigableSet 으로 리턴.
//                    boolean inclusive)    주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐.
// NavigableSet<E>  tailSet(E fromElement,  주어진 객체보다 높은 객체들을 NavigableSet 으로 리턴.
//                    boolean inclusive)    주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐.
// NavigableSet<E>  subSet(E fromElement,   시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet 으로
//                    boolean fromInclusive,리턴. 시작과 끝 객체의 포함 여부는 2,4번째 매개값에 따라 달라짐.
//                    E toElement,
//                    boolean toInclusive)
// -------------------------------------------------------------------------------
public class TreeSetEx2 {
    public static void main(String[] args) {
        // Set 인터페이스 변수에 대입해도 되지만 객체를 찾거나 범위 검색과 관련된 메소드를 사용하기 위해.
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);

        System.out.println("가장 낮은 점수: " + scores.first());
        System.out.println("가장 높은 점수: " + scores.last());
        System.out.println("95점 아래 점수: " + scores.lower(95));
        System.out.println("95점 위 점수: " + scores.higher(95));
        System.out.println("94점 이거나 바로 아래 점수: " + scores.floor(94));
        System.out.println("94점 이거나 바로 위 점수: " + scores.ceiling(94));

//        while (!scores.isEmpty()) {
//            System.out.println("(" + scores.pollFirst() + ") 남은 객체 수:" + scores.size());
//        }
        NavigableSet<Integer> desc = scores.descendingSet();
        for (Integer score : desc) {
            System.out.print(score + " ");
        }
        System.out.println();
        for (Integer score : desc.descendingSet()) {
            System.out.print(score + " ");
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("apple");
        treeSet.add("forever");
        treeSet.add("description");
        treeSet.add("ever");
        treeSet.add("zoo");
        treeSet.add("base");
        treeSet.add("guest");
        treeSet.add("cherry");

        System.out.println("[c-f 사이 단어]: ");
        treeSet.subSet("c", true, "f", true).forEach(System.out::println);
    }
}
