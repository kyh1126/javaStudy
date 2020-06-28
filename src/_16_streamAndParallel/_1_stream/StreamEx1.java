package _16_streamAndParallel._1_stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

// 스트림(Stream): 자바 8부터 추가된 컬렉션(배열 포함)의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자. Iterator 와 비슷한 역할
//               을 하는 반복자이지만, 람다식으로 요소 처리 코드를 제공하는 점, 내부 반복자를 사용하므로 병렬 처리가 쉽다는 점, 중간 처리와 최종 처리 작
//               업을 수행하는 점 차이가 있다.

// 1. 람다식으로 요소 처리 코드를 제공한다.
// 2. 내부 반복자를 사용하므로 병렬 처리가 쉽다: 외부 반복자란 개발자가 코드로 직접 컬렉션의 요소를 반복해서 가져오는 코드 패턴을 말한다. index 를 이용하는
//    for 문, Iterator 를 이용하는 while 문은 모두 외부 반복자를 이용하는 것이다. 반면 내부 반복자는 컬렉션 내부에서 요소들을 반복시키고, 개발자는
//    요소당 처리해야 할 코드만 제공하는 코드 패턴을 말한다. 내부 반복자 이점은 컬렉션 내부에서 어떻게 요소를 반복시킬 것인가는 컬렉션에게 맡겨두고, 개발자는
//    요소 처리 코드에만 집중할 수 있다는 것이다. 내부 반복자는 요소들의 반복 순서를 변경하거나, 멀티 코어 CPU 를 최대한 활용하기 위해 요소들을 분해시켜
//    병렬 작업을 할 수 있게 도와주기 때문에 하나씩 처리하는 순차적 외부 반복자보다는 효율적으로 요소를 반복시킬 수 있다.
// 3. 스트림은 중간 처리와 최종 처리를 할 수 있다: 스트림은 컬렉션 요소에 대해 중간 처리와 최종 처리를 수행할 수 있는데, 중간 처리에서는 매핑, 필터링, 정렬
//    을 수행하고 최종 처리에서는 반복, 카운팅, 평균, 총합 등의 집계 처리를 수행한다.

// 병렬 처리: 한 가지 작업을 서브 작업으로 나누고, 서브 작업들을 분리된 스레드에서 병렬적으로 처리하는 것. 병렬 처리 스트림을 이용하면 런타임 시 하나의 작업을
//          서브 작업으로 자동으로 나누고, 서브 작업의 결과를 자동으로 결합해서 최종 결과물을 생성한다.
//          ex> 컬렉션의 요소 총합을 구할 때 순차 처리 스트림은 하나의 스레드가 요소들을 순차적으로 읽어 합. 병렬 처리 스트림은 여러 스레드가 요소들을
//              부분적으로 합하고 이 부분합을 최종 결합해서 전체 합을 생성.
public class StreamEx1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Stream<String> stream = list.stream();
        // 1. 컬렉션의 요소를 소비할 코드를 람다식으로(Consumer 함수적 인터페이스 타입) 가진다.
        stream.forEach(name -> System.out.println(name));

        long startTime = System.nanoTime();
        // 2
        // 순차 처리
        list.stream().forEach(StreamEx1::print);
        System.out.println(System.nanoTime() - startTime);
        System.out.println("----------");

        // main 스레드 포함 ForkJoinPool(스레드풀)의 작업 스레드들이 병렬적으로 요소를 처리한다.
        startTime = System.nanoTime();
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(StreamEx1::print);
        System.out.println(System.nanoTime() - startTime);
    }

    private static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}
