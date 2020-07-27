package _16_streamAndParallel._2_streamCollect;

import _16_streamAndParallel._1_stream.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 수집(collect): 스트림은 요소들을 필터링, 매핑한 후 요소들을 수집하는 최종 처리 메소드 collect() 제공. 필요한 요소만 컬렉션으로 담을 수 있고,
//               요소들을 그룹핑한 후 집계(리덕션)할 수 있다.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드(매개 변수)                          인터페이스
// -------------------------------------------------------------------------------
// R        collect(Collector<T,A,R> collector)     Stream
// -------------------------------------------------------------------------------

// 매개값 Collector: 어떤 요소를 어떤 컬렉션에 수집할 것인지 결정. T는 요소, A는 누적기, R은 요소가 저장될 컬렉션.
// -------------------------------------------------------------------------------
// 리턴 타입                        Collectors 의 정적 메소드         설명
// -------------------------------------------------------------------------------
// Collector<T,?,List<T>>       toList()                        T를 List 에 저장
// Collector<T,?,Set<T>>        toSet()                         T를 Set 에 저장
// Collector<T,?,Collection<T>> toCollection(                   T를 Supplier 가 제공한 Collection 에 저장
//                                  Supplier<Collection<T>>)
// Collector<T,?,Map<K,U>>      toMap(Function<T,K> keyMapper,  T를 K와 U로 매핑해서 K를 키로, U를 값으로 Map 에 저장
//                                  Function<T,U> valueMapper)
// Collector<T,?,               toConcurrentMap(                T를 K와 U로 매핑해서 K를 키로, U를 값으로 ConcurrentMap 에 저장
//  ConcurrentMap<K,U>>             Function<T,K> keyMapper,
//                                  Function<T,U> valueMapper)
// -------------------------------------------------------------------------------

public class CollectEx1 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍", 92, Student.Course.KOREAN),
                new Student("길", 96, Student.Course.MATH),
                new Student("길2", 96, Student.Course.KOREAN),
                new Student("동", 88, Student.Course.MATH)
        );

        List<Student> maths = students.stream().filter(s -> s.getCourse() == Student.Course.MATH).collect(Collectors.toList());
        System.out.println();

        Set<Student> koreans = students.stream().filter(s -> s.getCourse() == Student.Course.KOREAN)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
