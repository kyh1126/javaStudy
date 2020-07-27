package _16_streamAndParallel._3_parallel;

import _16_streamAndParallel._1_stream.Student;
import _16_streamAndParallel._2_streamCollect.MathStudent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 병렬 스트림 생성: 병렬 처리를 위해 코드에서 포크조인 프레임워크를 직접 사용할 수는 있지만, 병렬 스트림을 이용할 경우에는 백그라운드에서 포크조인 프레임워크가
//               사용되기 때문에 개발자는 매우 쉽게 병렬 처리를 할 수 있다.
// -------------------------------------------------------------------------------
// 인터페이스                        리턴 타입       메소드(매개 변수)
// -------------------------------------------------------------------------------
// java.util.Collection             Stream      parallelStream()
// -------------------------------------------------------------------------------
// java.util.Stream.Stream          Stream      parallel()
// java.util.Stream.IntStream       IntStream
// java.util.Stream.LongStream      LongStream
// java.util.Stream.DoubleStream    DoubleStream
// -------------------------------------------------------------------------------

// parallelStream(): 컬렉션으로부터 병렬 스트림을 바로 리턴한다.
// parallel(): 순차 처리 스트림을 병렬 처리 스트림으로 변환해서 리턴한다.

// 병렬 처리 성능: 스트림 병렬처리가 스트림 순차 처리보다 항상 실행 성능이 좋다고 판단해서는 안 된다. 병렬 처리에 영향을 미치는 3가지 요인.
// 1. 요소의 수와 요소당 처리 시간: 컬렉션 요소 수가 적고 요소당 처리 시간이 짧으면 순차 처리가 오히려 병렬 처리보다 빠를 수 있다. 병렬 처리는 스레드풀 생성,
//                           스레드 생성이라는 추가적인 비용이 발생하기 때문이다.
// 2. 스트림 소스의 종류: ArrayList, 배열은 인덱스로 요소를 관리하기 때문에 포크 단계에서 요소를 쉽게 분리할 수 있어 병렬 처리 시간이 절약된다. 반면에
//                   HashSet, TreeSet 은 요소 분리가 쉽지 않고, LinkedList 역시 링크를 따라가야 하므로 요소 분리가 쉽지 않다.(상대적으로 늦다)
// 3. 코어(Core)의 수: 싱글 코어 CPU 경우 순차 처리가 빠르다. 병렬 스트림을 사용할 경우 스레드 수만 증가하고 동시성 작업으로 처리되기 때문에 좋지 못한
//                   결과를 준다. 코어 수가 많을수록 병렬 작업 처리 속도는 빨라진다.

public class ParallelStreamEx3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍", 92, Student.Course.KOREAN),
                new Student("길", 96, Student.Course.MATH),
                new Student("길2", 96, Student.Course.KOREAN),
                new Student("동", 88, Student.Course.MATH)
        );

        MathStudent mathStudent = students.parallelStream()
                .filter(s -> s.getCourse() == Student.Course.MATH)
                .collect(MathStudent::new, MathStudent::accumulate, MathStudent::combine);


        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 순차 스트림 처리 시간 구하기
        long timeSequencial = testSequencial(list);
        long timeParallel = testParallel(list);

        if (timeSequencial < timeParallel) {
            System.out.println("순차 처리가 더 빠름");
        } else {
            System.out.println("병렬 처리가 더 빠름");
        }

        List<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        long arrayListParallel = testParallel(arrayList);
        long linkedListParallel = testParallel(linkedList);

        if (arrayListParallel < linkedListParallel) {
            System.out.println("arrayList 처리가 더 빠름");
        } else {
            System.out.println("linkedList 처리가 더 빠름");
        }
    }

    private static long testParallel(List<Integer> list) {
        long start = System.nanoTime();
        list.stream().parallel().forEach(ParallelStreamEx3::work);
        return System.nanoTime() - start;
    }

    private static long testSequencial(List<Integer> list) {
        long start = System.nanoTime();
        list.stream().forEach(ParallelStreamEx3::work);
        return System.nanoTime() - start;
    }

    private static void work(int value) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
