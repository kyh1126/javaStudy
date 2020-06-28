package _16_streamAndParallel._1_stream;

import java.util.Arrays;
import java.util.List;

// 필터링: 중간 처리 기능으로 요소를 걸러내는 역할. Stream 의 경우 Object.equals(Object) 가 true 이면 동일한 객체로 판단.
//       IntStream, LongStream, DoubleStream 은 동일값일 경우 중복 제거.
// -------------------------------------------------------------------------------
// 리턴 타입        메소드(매개 변수)                              설명
// -------------------------------------------------------------------------------
// Stream        distinct()                                 중복 제거
// IntStream     filter(Predicate), filter(IntPredicate),   조건 필터링
// LongStream    filter(LongPredicate),
// DoubleStream  filter(DoublePredicate)
// -------------------------------------------------------------------------------

public class FilteringEx4 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("제", "니", "이", "즈", "백", "제", "니", "이");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        names.stream()
                .filter(n -> n.startsWith("제"))
                .forEach(System.out::println);
    }
}
