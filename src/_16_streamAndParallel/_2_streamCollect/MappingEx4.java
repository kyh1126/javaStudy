package _16_streamAndParallel._2_streamCollect;

import _16_streamAndParallel._1_stream.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 그룹핑 후 매핑 및 집계: 그룹핑 후, 매핑이나 집계(평균, 카운팅, 연결, 최대, 최소, 합계)를 할 수 있도록 Collector 를 가질 수 있다.

// Collectors 가 제공하는 Collector 리턴 메소드들
// -------------------------------------------------------------------------------
// 리턴 타입                    메소드(매개 변수)                      설명
// -------------------------------------------------------------------------------
// Collector<T,?,R>           mapping(                          T를 U로 매핑한 후, U를 R에 수집
//                                Function<T,U> mapper,
//                                Collector<U,A,R> collector)
// -------------------------------------------------------------------------------
// Collector<T,?,Double>      averagingDouble(                  T를 Double 로 매핑한 후, Double 의 평균값을 산출
//                                ToDoubleFunction<T> mapper)
// -------------------------------------------------------------------------------
// Collector<T,?,Long>        counting()                        T의 카운팅 수를 산출
// -------------------------------------------------------------------------------
// Collector                  joining(CharSequence delimiter)   CharSequence 를 구분자로 연결한 String 산출
// <CharSequence,?,String>
// -------------------------------------------------------------------------------
// Collector<T,?,Optional<T>> maxBy(                            Comparator 를 이용해서 최대 T를 산출
//                                Comparator<T> comparator)
// -------------------------------------------------------------------------------
// Collector<T,?,Optional<T>> minBy(                            Comparator 를 이용해서 최소 T를 산출
//                                Comparator<T> comparator)
// -------------------------------------------------------------------------------
// Collector<T,?,Integer>     summingInt(ToIntFunction)         Int, Long, Double 타입의 합계 산출
//                            summingLong(ToLongFunction)
//                            summingDouble(ToDoubleFunction)
// -------------------------------------------------------------------------------

public class MappingEx4 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍", 92, Student.Course.KOREAN, Student.City.SEOUL),
                new Student("길", 96, Student.Course.MATH, Student.City.PUSAN),
                new Student("길2", 96, Student.Course.KOREAN, Student.City.PUSAN),
                new Student("동", 88, Student.Course.MATH, Student.City.SEOUL)
        );

        Map<Student.Course, Double> mapByCourse = list.stream()
                .collect(Collectors.groupingBy(Student::getCourse, Collectors.averagingDouble(Student::getScore)));

        System.out.println(mapByCourse.get(Student.Course.MATH));

        Map<Student.Course, String> mapByName = list.stream().collect(Collectors.groupingBy(
                Student::getCourse,
                Collectors.mapping(Student::getName, Collectors.joining("//"))
        ));
        System.out.println(mapByName.get(Student.Course.MATH));
    }
}
