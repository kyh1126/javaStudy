package _16_streamAndParallel._2_streamCollect;

import _16_streamAndParallel._1_stream.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 요소를 그룹핑해서 수집: collect()는 요소를 수집하는 기능 외에 컬렉션 요소들을 그룹핑해서 Map 객체를 생성하는 기능도 제공한다.
// -------------------------------------------------------------------------------
// 리턴 타입                        Collectors 의 정적 메소드                 설명
// -------------------------------------------------------------------------------
// Collector<T,?,               groupingBy(Function<T,K> classifier) | T를 K로 매핑하고 K키에 저장된 List 에 T를 저장한 Map 생성.
//  Map<K,List<T>>>                                                  |
// ------------------------------------------------------------------|
// Collector<T,?,               groupingByConcurrent(                |
//  ConcurrentMap<K,List<T>>>       Function<T,K> classifier)        |
// -------------------------------------------------------------------------------
// Collector<T,?,Map<K,D>>      groupingBy(Function<T,K> classifier, | T를 K로 매핑하고 K키에 저장된 D 객체에 T를 누적한 Map 생성.
//                                  Collector<T,A,D> collector)      |
// ------------------------------------------------------------------|
// Collector<T,?,               groupingByConcurrent(                |
//  ConcurrentMap<K,D>>             Function<T,K> classifier,        |
//                                  Collector<T,A,D> collector)      |
// -------------------------------------------------------------------------------
// Collector<T,?,Map<K,D>>      groupingBy(                          | T를 K로 매핑하고 Supplier 가 제공하는 Map 에서 K키에 저장된
//                                  Function<T,K> classifier,        | D 객체에 T를 누적.
//                                  Supplier<Map<K,D>> mapFactory,   |
//                                  Collector<T,A,D> collector)      |
// ------------------------------------------------------------------|
// Collector<T,?,               groupingByConcurrent(                |
//  ConcurrentMap<K,D>>             Function<T,K> classifier,        |
//                                  Supplier<ConcurrentMap<K,D>>     |
//                                  mapFactory,                      |
//                                  Collector<T,A,D> collector)      |
// -------------------------------------------------------------------------------
public class GroupingByEx3 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍", 92, Student.Course.KOREAN, Student.City.SEOUL),
                new Student("길", 96, Student.Course.MATH, Student.City.PUSAN),
                new Student("길2", 96, Student.Course.KOREAN, Student.City.PUSAN),
                new Student("동", 88, Student.Course.MATH, Student.City.SEOUL)
        );

        Map<Student.Course, List<Student>> mapByCourse = list.stream().collect(Collectors.groupingBy(Student::getCourse));

        Map<Student.City, List<String>> mapByCity = list.stream().collect(
                Collectors.groupingBy(Student::getCity, Collectors.mapping(Student::getName, Collectors.toList()))
        );
        mapByCity.keySet().stream()
                .peek(k -> System.out.println("key: " + k))
                .map(mapByCity::get).forEach(System.out::println);
    }
}
