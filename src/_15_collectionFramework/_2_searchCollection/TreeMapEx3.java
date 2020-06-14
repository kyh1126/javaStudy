package _15_collectionFramework._2_searchCollection;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeSet;

// TreeMap: 이진 트리를 기반으로한 Map 컬렉션. 하나의 노드는 노드값인 Map.Entry value 와 왼쪽, 오른쪽 자식 노드를 참조하기 위한 두개의 변수로 구성된다.
//          키 값이 낮은 것은 왼쪽 자식 노드, 높은 것은 오른쪽 자식 노드.
// TreeMap 이 가지고 있는 검색 관련 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입            메소드명                설명
// -------------------------------------------------------------------------------
// Map.Entry<K, V>  firstEntry()        제일 낮은 Map.Entry 를 리턴.
// Map.Entry<K, V>  lastEntry()         제일 높은 Map.Entry 를 리턴.
// Map.Entry<K, V>  lowerEntry(E e)     주어진 키보다 바로 아래 Map.Entry 를 리턴.
// Map.Entry<K, V>  higherEntry(E e)    주어진 키보다 바로 위 Map.Entry 를 리턴.
// Map.Entry<K, V>  floorEntry(E e)     주어진 키와 동등한 키가 있으면 해당 Map.Entry 리턴, 없다면 주어진 키의 바로 아래 Map.Entry 리턴.
// Map.Entry<K, V>  ceilingEntry(E e)   주어진 객체와 동등한 키가 있으면 해당 Map.Entry 리턴, 없다면 주어진 키의 바로 위 Map.Entry 리턴.
// Map.Entry<K, V>  pollFirstEntry()    제일 낮은 Map.Entry 를 꺼내오고 컬렉션에서 제거함.
// Map.Entry<K, V>  pollLastEntry()     제일 높은 Map.Entry 를 꺼내오고 컬렉션에서 제거함.
// -------------------------------------------------------------------------------

// TreeMap 이 가지고 있는 정렬 관련 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입            메소드명                설명
// -------------------------------------------------------------------------------
// NavigableSet<E>  descendingKeySet()  내림차순으로 정렬된 키의 NavigableSet 을 리턴.
// NavigableMap<E>  descendingMap()     내림차순으로 정렬된 Map.Entry 의 NavigableMap 을 리턴.
// -------------------------------------------------------------------------------


// TreeMap 이 가지고 있는 범위 관련 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입                메소드명                설명
// -------------------------------------------------------------------------------
// NavigableMap<K, V>   headMap(K toKey,        주어진 키보다 낮은 Map.Entry 들을 NavigableMap 으로 리턴.
//                      boolean inclusive)      주어진 키의 Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐.
// NavigableMap<K, V>   tailMap(K fromKey,      주어진 키보다 높은 Map.Entry 들을 NavigableMap 으로 리턴.
//                      boolean inclusive)      주어진 키의 Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐.
// NavigableMap<K, V>   subMap(K fromKey,       시작과 끝으로 주어진 키 사이의 Map.Entry 들을 NavigableMap 으로
//                      boolean fromInclusive,  리턴. 시작과 끝 키의 Map.Entry 포함 여부는 2,4번째 매개값에 따라 달라짐.
//                      K toKey,
//                      boolean toInclusive)
// -------------------------------------------------------------------------------

public class TreeMapEx3 {
    public static void main(String[] args) {
        // Map 인터페이스 변수에 대입해도 되지만 객체를 찾거나 범위 검색과 관련된 메소드를 사용하기 위해.
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(87, "사람7");
        scores.put(98, "사람8");
        scores.put(75, "사람5");
        scores.put(95, "사람5");

        System.out.println("가장 낮은 점수: " + scores.firstEntry());
        System.out.println("가장 높은 점수: " + scores.lastEntry());
        System.out.println("95점 아래 점수: " + scores.lowerEntry(95));
        System.out.println("95점 위 점수: " + scores.higherEntry(95));
        System.out.println("94점 이거나 바로 아래 점수: " + scores.floorEntry(94));
        System.out.println("94점 이거나 바로 위 점수: " + scores.ceilingEntry(94));

//        while (!scores.isEmpty()) {
//            System.out.println("(" + scores.pollFirstEntry().getKey() + ") 남은 객체 수:" + scores.size());
//        }
        NavigableMap<Integer, String> desc = scores.descendingMap();
        for (Map.Entry<Integer, String> e : desc.entrySet()) {
            System.out.print(e.getKey() + "-" + e.getValue() + " ");
        }
        System.out.println();
        for (Map.Entry<Integer, String> e : desc.descendingMap().entrySet()) {
            System.out.print(e.getKey() + "-" + e.getValue() + " ");
        }

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("apple", 10);
        treeMap.put("forever", 10);
        treeMap.put("description", 10);
        treeMap.put("ever", 10);
        treeMap.put("zoo", 10);
        treeMap.put("base", 10);
        treeMap.put("guest", 10);
        treeMap.put("cherry", 10);

        System.out.println("[c-f 사이 단어]: ");
        treeMap.subMap("c", true, "f", true).entrySet().forEach(System.out::println);
    }
}
