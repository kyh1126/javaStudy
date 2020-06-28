package _16_streamAndParallel._1_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 매핑: 중간 처리 기능으로 스트림의 요소를 다른 요소로 대체하는 작업.

// 1. flatMapXXX 메소드: 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림을 리턴한다.
// -------------------------------------------------------------------------------
// 리턴 타입        메소드(매개 변수)                              요소 -> 대체 요소
// -------------------------------------------------------------------------------
// Stream<R>     flatMap(Function<T, Stream<R>>)             T -> Stream<R>
// DoubleStream  flatMap(DoubleFunction<DoubleStream>)       double -> DoubleStream
// IntStream     flatMap(IntFunction<IntStream>)             int -> IntStream
// LongStream    flatMap(LongFunction<LongStream>)           long -> LongStream
// DoubleStream  flatMapToDouble(Function<T, DoubleStream>)  T -> DoubleStream
// IntStream     flatMapToInt(Function<T, IntStream>)        T -> IntStream
// LongStream    flatMapToLong(Function<T, LongStream>)      T -> LongStream
// -------------------------------------------------------------------------------

// 2. mapXXX 메소드: 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴한다.
// -------------------------------------------------------------------------------
// 리턴 타입        메소드(매개 변수)                          요소 -> 대체요소
// -------------------------------------------------------------------------------
// Stream<R>      map(Function<T, R>)                   T -> R
// DoubleStream   mapToDouble(ToDoubleFunction<T>)      T -> double
// IntStream      mapToInt(ToIntFunction<T>)            T -> int
// LongStream     mapToLong(ToLongFunction<T>)          T -> long
// DoubleStream   map(DoubleUnaryOperator)              double -> double
// IntStream      mapToInt(DoubleToIntFunction)         double -> int
// LongStream     mapToLong(DoubleToLongFunction)       double -> long
// Stream<U>      mapToObj(DoubleFunction<U>)           double -> U
// IntStream      map(IntUnaryOperator)                 int -> int
// DoubleStream   mapToDouble(IntToDoubleFunction)      int -> double
// LongStream     mapToLong(IntToLongFunction)          int -> long
// Stream<U>      mapToObj(IntFunction<U>)              int -> U
// LongStream     map(LongUnaryOperator)                long -> long
// DoubleStream   mapToDouble(LongToDoubleFunction)     long -> double
// IntStream      mapToInt(LngToIntFunction)            long -> int
// Stream<U>      mapToObj(LongFunction<U>)             long -> U
// -------------------------------------------------------------------------------

// 3. asDoubleStream, asLongStream, boxed 메소드
// -------------------------------------------------------------------------------
// 리턴 타입          메소드(매개 변수)        설명
// -------------------------------------------------------------------------------
// DoubleStream     asDoubleStream()    int -> double
//                                      long -> double
// -------------------------------------------------------------------------------
// LongStream       asLongStream()      int -> long
// -------------------------------------------------------------------------------
// Stream<Integer>  boxed()             int -> Integer
// Stream<Long>                         long -> Long
// Stream<Double>                       double -> Double
// -------------------------------------------------------------------------------

public class MappingEx5 {
    public static void main(String[] args) {
        // 1
        List<String> inputList1 = Arrays.asList("a is apple", "b is banana", "c is chocolate", "d is diamond");
        inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(System.out::println);

        List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        inputList2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                }).forEach(System.out::print);
        System.out.println();

        // 2
        List<Student> students = Arrays.asList(
                new Student("a", 10),
                new Student("b", 20),
                new Student("c", 30));
        students.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);
        System.out.println();

        // 3
        int[] ints = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(ints);
        intStream.asDoubleStream().forEach(System.out::println);

        intStream = Arrays.stream(ints);
        intStream.boxed()                       // Stream<Integer> 생성
                .forEach(System.out::println);
    }
}
