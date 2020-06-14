package _15_collectionFramework._1_collectionFramework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

// Map 컬렉션: 키와 값으로 구성된 Entry 객체를 저장하는 구조를 가지고 있다. 키와 값은 모두 객체이다. 공통적으로 사용 가능한 Map 인터페이스의 메소드들.
// -------------------------------------------------------------------------------
// 기능   메소드                             설명
// -------------------------------------------------------------------------------
// 객체   V put(K key, V value)           주어진 키로 값을 저장. 새로운 키일 경우 null 리턴하고
// 추가                                   동일한 키가 있을 경우 값을 대체하고 이전 값을 리턴
// -------------------------------------------------------------------------------
// 객체   boolean containsKey(Object k)   주어진 키가 있는지 여부
// 검색   boolean containsValue(Object v) 주어진 값이 있는지 여부
//       Set<Map.Entry<, V>> entrySet()  키와 값의 쌍으로 구성된 Map.Entry 객체를 Set 에 담아서 리턴
//       V get(Object key)               주어진 키가 있는 값을 리턴
//       boolean isEmpty()               컬렉션이 비어 있는지 여부
//       Set<K> keySet()                 모든 키를 Set 객체에 담아서 리턴
//       int size()                      저장된 키의 총 수를 리턴
//       Collection<V> values()          저장된 모든 값을 Collection 에 담아서 리턴
// -------------------------------------------------------------------------------
// 객체   void clear()                    모든 Map.Entry(키와 값)를 삭제
// 삭제   V remove(Object key)            주어진 키와 일치하는 Map.Entry 를 삭제하고 값을 리턴
// -------------------------------------------------------------------------------

// 1. HashMap
// Map 인터페이스를 구현한 대표적인 Map 컬렉션. HashMap 의 키로 사용할 객체는 hashCode(), equals() 메소드를 재정의해서 동등 객체가 될 조건을 정해야 한다.
// 주로 키 타입은 String 을 많이 사용하는데, String 은 문자열이 같을 경우 동등 객체가 될 수 있도록 hashCode()와 equals()메소드가 재정의되어 있다.
// 키와 값의 타입은 기본 타입을 사용할 수 없고 클래스 및 인터페이스 타입만 가능하다.
// 2. Hashtable
// HashMap 과 동일한 내부 구조를 가지고 있다. 차이점은 Hashtable 은 동기화된(synchronized)메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드들을
// 실행할 수는 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다.
// 3. LinkedHashMap
// 4. Properties
// Hashtable 의 하위 클래스이기 때문에 Hashtable 의 모든 특징을 그대로 가지고 있다. 차이점은 Hashtable 은 키와 값을 다양한 타입으로 지정이 가능한데 비해
// Properties 는 애플리케이션의 옵션 정보, 디비연결 정보, 국제화(다국어) 정보가 저장된 프로퍼티(~.properties) 파일을 읽을 때 주로 사용한다.
// 키와 값이 =로 연결되어 있는 텍스트 파일. ISO 8859-1 문자셋으로 저장된다. 이 문자셋으로 직접 표현할 수 없는 한글은 유니코드로 변환되어 저장된다.
// 5. TreeMap
public class MapEx4 {
    public static void main(String[] args) {
        // 1
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        // 저장된 전체 객체를 대상으로 하나씩 얻고 싶을 경우,
        // 1. keySet()메소드로 모든 키를 Set 컬렉션으로 얻어, 반복자를 통해 키를 하나씩 얻고 get().
        // 2. entrySet()메소드로 모든 Map.Entry 를 Set 컬렉션으로 얻어, 반복자를 통해 Map.Entry 를 하나씩 얻고 getKey(), getValue().
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        entrySet.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        map.clear();
        System.out.println("총 entry 수: " + map.size());

        Map<Student, Integer> sMap = new HashMap<>();
        sMap.put(new Student(1, "사람1"), 95);
        sMap.put(new Student(1, "사람1"), 95);
        sMap.put(new Student(2, "사람1"), 95);
        System.out.println("총 Entry 수: " + sMap.size());

        // 4
        Properties properties = new Properties();
        // 프로퍼티 파일은 일반적으로 클래스 파일과(.class) 함께 저장된다.
        // getResource(): 주어진 파일의 상대 경로를 URL 객체로 리턴.
        String path = MapEx4.class.getResource("database.properties").getPath();
        try {
            path = URLDecoder.decode(path, "utf-8");
            // load(): 프로퍼티 파일로부터 데이터를 읽기 위해 FileReader 객체를 매개값으로 받는다.
            properties.load(new FileReader(path));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

    }
}
