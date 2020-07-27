package _16_streamAndParallel._1_stream;

import java.util.Arrays;

// 집계: 최종 처리 기능. 요소들을 처리해서 카운팅, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 것.
//      대량의 데이터를 가공해서 축소하는 리덕션(Reduction).
// -------------------------------------------------------------------------------
// 리턴 타입            메소드(매개 변수)          설명
// -------------------------------------------------------------------------------
// long                 count()             요소 개수
// -------------------------------------------------------------------------------
// OptionalXXX          findFirst()         첫 번째 요소
// -------------------------------------------------------------------------------
// Optional<T>          max(Comparator<T>)  최대 요소
// OptionalXXX          max()
// -------------------------------------------------------------------------------
// Optional<T>          min(Comparator<T>)  최소 요소
// OptionalXXX          min()
// -------------------------------------------------------------------------------
// OptionalDouble       average()           요소 평균
// -------------------------------------------------------------------------------
// int, long, double    sum()               요소 총합
// -------------------------------------------------------------------------------

// Optional, OptionalDouble, OptionalInt, OptionalLong: 자바 8에 추가된 값을 저장하는 값 기반 클래스(value-based class)

public class AggregateEx9 {
    public static void main(String[] args) {
        long count = Arrays.stream(new int[]{1, 2, 3, 4, 5}).filter(n -> n % 2 == 0).count();
        System.out.println("2의 배수 갯수: " + count);
        int sum = Arrays.stream(new int[]{1, 2, 3, 4, 5}).filter(n -> n % 2 == 0).sum();
        System.out.println("2의 배수 합: " + sum);
        int min = Arrays.stream(new int[]{1, 2, 3, 4, 5}).filter(n -> n % 2 == 0).min().getAsInt();
        System.out.println("2의 배수 최소값: " + min);
    }
}
