package _16_streamAndParallel._2_streamCollect;

import _16_streamAndParallel._1_stream.Student;

import java.util.Arrays;
import java.util.List;

// 사용자 정의 컨테이너에 수집하기
// -------------------------------------------------------------------------------
// 인터페이스        리턴 타입   메소드(매개 변수)
// -------------------------------------------------------------------------------
// Stream           R       collect(Supplier<R>, BiConsumer<R,? super T>, BiConsumer<R,R>)
// IntStream        R       collect(Supplier<R>, ObjIntConsumer<R>, BiConsumer<R,R>)
// LongStream       R       collect(Supplier<R>, ObjLongConsumer<R>, BiConsumer<R,R>)
// DoubleStream     R       collect(Supplier<R>, ObjDoubleConsumer<R>, BiConsumer<R,R>)
// -------------------------------------------------------------------------------
// - 첫 번째 Supplier 는 요소들이 수집될 컨테이너 객체(R)를 생성하는 역할을 한다. 순차 처리(싱글 스레드) 스트림에서는 단 한번 Supplier 가 실행되고
//   하나의 컨테이너 객체를 생성한다. 병렬 처리(멀티 스레드) 스트림에서는 여러번 Supplier 가 실행되고 스레드별로 여러 컨테이너 객체를 생성한다. 하지만
//   최종적으로는 하나의 컨테이너 객체로 결합된다.
// - 두 번째 XXConsumer 는 컨테이너 객체(R)에 요소(T)를 수집하는 역할을 한다. 스트림에서 요소를 컨테이너에 수집할 때마다 XXConsumer 가 실행된다.
// - 세 번째 BiConsumer 는 컨테이너 객체(R)를 결합하는 역할을 한다. 순차 처리 스트림에서는 호출되지 않고, 병렬 처리 스트림에서만 호출되어 스레드별로
//   생성된 컨테이너 객체를 결합해서 최종 컨테이너 객체를 완성한다.

public class CustomCollectEx2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍", 92, Student.Course.KOREAN),
                new Student("길", 96, Student.Course.MATH),
                new Student("길2", 96, Student.Course.KOREAN),
                new Student("동", 88, Student.Course.MATH)
        );

        MathStudent mathStudent = students.stream()
                .filter(s -> s.getCourse() == Student.Course.MATH)
                .collect(MathStudent::new, MathStudent::accumulate, MathStudent::combine);

        mathStudent.getList().stream().forEach(s -> System.out.println(s));
    }
}
