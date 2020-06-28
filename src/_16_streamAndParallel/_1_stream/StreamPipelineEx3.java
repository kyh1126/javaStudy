package _16_streamAndParallel._1_stream;

// Reduction: 대량의 데이터를 가공해서 축소하는 것. 데이터의 합계, 평균, 카운팅, 최대 최소값 등이 대표적인 리덕션 결과물. 리덕션의 결과물로 바로 집계할 수
//            없을 경우에는 집계하기 좋도록 필터링, 매핑, 정렬, 그룹핑 등 중간 처리가 필요하다.

// 중간 처리: 중간 스트림이 생성될 때 요소들이 바로 중간 처리(필터링, 매핑, 정렬)되는 것이 아니라 최종 처리가 시작되기 전까지 지연(lazy)된다. 최종 처리가
//          시작되면 비로소 컬렉션의 요소가 하나씩 중간 스트림에서 처리되고 최종 처리까지 오게 된다. 중간 처리된 스트림 리턴 후 다시 중간 처리 메소드를
//          호출해서 파이프라인을 형성한다.

// 스트림이 제공하는 중간 처리와 최종 처리를 하는 메소드들
// -------------------------------------------------------------------------------
// 종류      리턴타입                 메소드(매개 변수)
// -------------------------------------------------------------------------------
// 중간 처리  Stream        필터링    distinct(), filter()
//          IntStream     매핑     flatMap(), flatMapToDouble(), flatMapToInt(), flatMapToLong(),
//          LongStream            map(), mapToDouble(), mapToInt(), mapToLong(), mapToObj(),
//          DoubleStream          asDoubleStream(), asLongStream(), boxed()
//                        정렬     sorted()
//                        루핑     peek()
// -------------------------------------------------------------------------------
// 최종 처리  boolean       매칭     allMatch(), anyMatch(), noneMatch()
//          long          집계     count(), findFirst(), max(), min(), average(), reduce(), sum()
//          OptionalXXX
//          void          루핑     forEach()
//          R             수집     collect()
// -------------------------------------------------------------------------------

public class StreamPipelineEx3 {
}
