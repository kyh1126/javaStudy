package _16_streamAndParallel._1_stream;

import java.util.ArrayList;
import java.util.OptionalDouble;

// Optional 클래스: 단순히 집계 값만 저장하는 것이 아니라, 집계 값이 존재하지 않을 경우 디폴트 값을 설정할 수도 있고, 집계 값을 처리하는 Consumer 도
//                등록할 수 있다.
// -------------------------------------------------------------------------------
// 리턴 타입        메소드(매개 변수)              설명
// -------------------------------------------------------------------------------
// boolean      isPresent()                 값이 저장되어 있는지 여부
// -------------------------------------------------------------------------------
// T            orElse(T)                   값이 저장되어 있지 않을 경우 디폴트 값 지정
// double       orElse(double)
// int          orElse(int)
// long         orElse(long)
// -------------------------------------------------------------------------------
// void         ifPresent(Consumer)         값이 저장되어 있을 경우 Consumer 에서 처리
//              ifPresent(DoubleConsumer)
//              ifPresent(IntConsumer)
//              ifPResent(LongConsumer)
// -------------------------------------------------------------------------------

public class OptionalEx10 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // NoSuchElementException
//        double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        if (average.isPresent()) {
            System.out.println("방법1 평균: " + average.getAsDouble());
        } else {
            System.out.println("방법1 평균: 0.0");
        }

        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("방법2 평균: " + avg);

        list.stream().mapToInt(Integer::intValue).average().ifPresent(a -> System.out.println("방법3 평균: " + a));
    }
}
