package _16_streamAndParallel._1_stream;

import java.util.Arrays;

// 루핑: 요소 전체를 반복하는 것.

// peek: 중간 처리 메소드. 중간 처리 단계에서 전체 요소를 루핑하면서 추가적인 작업을 하기 위해 사용. 최종 처리 메소드가 실행되지 않으면 지연되기 때문에
//       반드시 최종 처리 메소드가 호출되어야 동작.
// forEach: 최종 처리 메소드. 파이프라인 마지막에 루핑하면서 요소를 하나씩 처리. 요소를 소비하는 최종 메소드이므로 이후에 다른 최종 메소드를 호출하면 안된다.

public class LoopingEx7 {
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5};

        int sum = Arrays.stream(intArr).peek(System.out::println).sum();
        System.out.println(sum);
    }
}
