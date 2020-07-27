package _16_streamAndParallel._1_stream;

import java.util.Arrays;
import java.util.List;

// 커스텀 집계(reduce): sum, average, count, max, min 은 기본 집계 메소드, reduce 는 커스텀 집계 메소드.
// -------------------------------------------------------------------------------
// 인터페이스        리턴 타입       메소드(매개 변수)
// -------------------------------------------------------------------------------
// Stream       Optional        reduce(BinaryOperator<T> accumulator)
//              T               reduce(T identity, BinaryOperator<T> accumulator)
// -------------------------------------------------------------------------------
// IntStream    OptionalInt     reduce(IntBinaryOperator op)
//              int             reduce(int identity, IntBinaryOperator op)
// -------------------------------------------------------------------------------
// LongStream   OptionalLong    reduce(LongBinaryOperator op)
//              long            reduce(long identity, LongBinaryOperator op)
// -------------------------------------------------------------------------------
// DoubleStream OptionalDouble  reduce(DoubleBinaryOperator op)
//              double          reduce(double identity, DoubleBinaryOperator op)
// -------------------------------------------------------------------------------

public class ReduceEx11 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍", 92), new Student("길", 96), new Student("동", 88)
        );

        int sum1 = students.stream().mapToInt(Student::getScore).sum();

        int sum2 = students.stream().map(Student::getScore).reduce((a, b) -> a + b).get();

        int sum3 = students.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);

        int sum4 = students.stream().map(Student::getScore).reduce(0, Integer::sum);

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum4);
    }
}
