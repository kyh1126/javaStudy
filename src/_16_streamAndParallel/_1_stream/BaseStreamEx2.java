package _16_streamAndParallel._1_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// BaseStream: 이 인터페이스를 부모로 해서 자식 인터페이스들이 다음과 같은 상속 관계를 이루고 있다. 공통 메소드들이 정의되어 있다.
// - Stream: 객체 요소를 처리하는 스트림.
// - IntStream: int 요소를 처리하는 스트림
// - LongStream: long "
// - DoubleStream: double "
// -------------------------------------------------------------------------------
// 리턴 타입            메소드(매개 변수)                                      소스
// -------------------------------------------------------------------------------
// Stream<T>        java.util.Collection.stream()                       컬렉션
//                  java.util.Collection.parallelStream()
// -------------------------------------------------------------------------------
// Stream<T>        Arrays.stream(T[]),      Stream.of(T[])             배열
// IntStream        Arrays.stream(int[]),    IntStream.of(int[])
// LongStream       Arrays.stream(long[]),   LongStream.of(long[])
// DoubleStream     Arrays.stream(double[]), DoubleStream.of(double[])
// -------------------------------------------------------------------------------
// IntStream        IntStream.range(int, int): 마지막 수 미포함             int 범위
//                  IntStream.rangeClosed(int, int): 마지막 수 포함
// -------------------------------------------------------------------------------
// LongStream       LongStream.range(long, long)                        long 범위
//                  LongStream.rangeClosed(long, long)
// -------------------------------------------------------------------------------
// Stream<Path>     Files.find(Path, int, BiPredicate, FileVisitOption) 디렉토리
//                  Files.list(Path)
// -------------------------------------------------------------------------------
// Stream<String>   Files.lines(Path, Charset)                          파일
//                  BufferedReader.lines()
// -------------------------------------------------------------------------------
// DoubleStream     Random.doubles(...)                                 랜덤 수
// IntStream        Random.ints()
// LongStream       Random.longs()
// -------------------------------------------------------------------------------

public class BaseStreamEx2 {
    public static void main(String[] args) throws IOException {
        // 컬렉션으로부터 스트림 얻기
        List<String> names = Arrays.asList("a", "b", "c");
        Stream<String> stream = names.stream();

        // 배열로부터 스트림 얻기
        String[] str = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(str);

        // 숫자 범위로부터 스트림 얻기
        IntStream intStream = IntStream.range(1, 10);
        intStream.forEach(System.out::print);

        // 파일로부터 스트림 얻기
        Path path = Paths.get("/Users/kakao/javaStudy/IdeaProjects/javaProject/src/_16_streamAndParallel/_1_stream/a.txt");
        // 1. Files.lines() 이용
        Stream<String> stream2 = Files.lines(path, Charset.defaultCharset());
        stream2.forEach(System.out::println);
        // 2. BufferedReader 의 lines() 이용
        File file = path.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        Stream<String> stream3 = br.lines();
        stream3.forEach(System.out::println);

        // 디렉토리로부터 스트림 얻기
        Path path1 = Paths.get("/Users/kakao/javaStudy/IdeaProjects");
        Stream<Path> stream4 = Files.list(path1);
        stream4.forEach(p -> System.out.println(p.getFileName()));
    }
}
