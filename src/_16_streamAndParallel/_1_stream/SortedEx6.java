package _16_streamAndParallel._1_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

// 정렬: 스트림은 요소가 최종 처리되기 전에 중간 단계에서 요소를 정렬해서 최종 처리 순서를 변경할 수 있다.
// -------------------------------------------------------------------------------
// 리턴 타입       메소드(매개 변수)           설명
// -------------------------------------------------------------------------------
// Stream<T>     sorted()               객체를 Comparable 구현 방법에 따라 정렬
// Stream<T>     sorted(Comparator<T>)  객체를 주어진 Comparator 에 따라 정렬
// DoubleStream  sorted()               double 요소를 오름차순으로 정렬
// IntStream     sorted()               int 요소를 오름차순으로 정렬
// LongStream    sorted()               long 요소를 오름차순으로 정렬
// -------------------------------------------------------------------------------

public class SortedEx6 {
    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[]{5, 1, 2, 3, 4});
        intStream.sorted().forEach(System.out::println);

        List<String> strings = Arrays.asList("a", "c", "d", "b", "e");
        strings.stream()
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // (a,b) -> a.compareTo(b), Comparator.naturalOrder()  : a,b,c,d,e
        // (a, b) -> b.compareTo(a), Comparator.reverseOrder() : e,d,c,b,a
    }
}
