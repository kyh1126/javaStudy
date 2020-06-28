package _16_streamAndParallel._1_stream;

import java.util.Arrays;

// 매칭: 스트림 클래스는 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사할 수 있도록 3가지 매칭 메소드를 제공하고 있다.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드(매개 변수)                                                      제공 인터페이스
// -------------------------------------------------------------------------------
// boolean  allMatch(Predicate<T>/IntPredicate/LongPredicate/DoublePredicate)   Stream/IntStream/LongStream/
//          anyMatch(")                                                         DoubleStream
//          noneMatch(")
// -------------------------------------------------------------------------------

public class MatchingEx8 {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6};
        boolean b = Arrays.stream(intArr).allMatch(a -> a % 2 == 0);
        System.out.println("모두 2의 배수인가? " + b);

        boolean b2 = Arrays.stream(intArr).anyMatch(a -> a % 2 == 0);
        System.out.println("하나라도 2의 배수인가? " + b2);

        boolean b3 = Arrays.stream(intArr).noneMatch(a -> a % 2 == 0);
        System.out.println("2의 배수가 없나? " + b3);

    }
}
