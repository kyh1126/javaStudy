package _15_collectionFramework._4_synchronizedCollection;

import java.util.*;

// 컬렉션 프레임워크 대부분 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다. 그래서 여러 스레드가 동시에 컬렉션 접근하면 의도하지 않게 요소가 변경될
// 수 있는 불안전한 상태가 된다. Vector, Hashtable 은 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드 환경에서 안전하게 요소를 처리할 수 있지만,
// ArrayList, HashSet, HashMap 은 멀티 스레드 환경에서 안전하지 않다. 이를 멀티 스레드 환경으로 전달할 필요도 있을 것이다.
// 이를 대비해 비동기화된 메소드를 동기화된 메소드로 래핑하는 Collections.synchronizedXXX() 메소드를 제공하고 있다.
// -------------------------------------------------------------------------------
// 리턴 타입        메소드(매개 변수)                  설명
// -------------------------------------------------------------------------------
// List<T>      synchronizedList(List<T> list)  List 를 동기화된 List 로 리턴
// Map<K, V>    synchronizedMap(Map<K, V> m)    Map 을 동기화된 Map 으로 리턴
// Set<T>       synchronizedSet(Set<T> s)       Set 을 동기화된 Set 으로 리턴
// -------------------------------------------------------------------------------
public class SynchronizedCollectionEx1 {
    public static void main(String[] args) {
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
    }
}
