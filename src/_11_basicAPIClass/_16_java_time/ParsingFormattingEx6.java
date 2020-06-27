package _11_basicAPIClass._16_java_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 파싱과 포맷팅: 날짜와 시간 클래스는 문자열을 파싱해서 날짜와 시간을 생성하는 메소드, 포맷팅된 문자열로 변환하는 메소드를 제공한다.

// 1. 파싱 메소드
// -------------------------------------------------------------------------------
// 클래스          리턴 타입         메소드(매개 변수)
// -------------------------------------------------------------------------------
// LocalDate      LocalDate      parse(CharSequence)
// LocalTime      LocalTime
// LocalDateTime  LocalDateTime  parse(CharSequence, DateTimeFormatter)
// ZonedDateTime  ZonedDateTime
// -------------------------------------------------------------------------------
// LocalDate 의 parse(CharSequence)는 기본적으로 ISO_LOCAL_DATE 포맷터를 사용해 문자열 파싱.

// ISO_LOCAL_DATE: DateTimeFormatter 의 상수로 정의되어 있는데, "2024-05-03" 형식의 포맷터이다.

// DateTimeFormatter: 표준화된 포맷터들이 상수로 미리 정의되어 있고, ofPattern()로 정의할 수도 있다.

// 2. 포맷팅 메소드: 날짜와 시간을 포맷팅된 문자열로 변환시키는 format()
// -------------------------------------------------------------------------------
// 클래스          리턴 타입   메소드(매개 변수)
// -------------------------------------------------------------------------------
// LocalDate      String    format(DateTimeFormatter)
// LocalTime
// LocalDateTime
// ZonedDateTime
// -------------------------------------------------------------------------------

public class ParsingFormattingEx6 {
    public static void main(String[] args) {
        // 1
        System.out.println(LocalDate.parse("2024-05-21"));
        System.out.println(LocalDate.parse("2024-05-21", DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(LocalDate.parse("2024/05/21", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        System.out.println(LocalDate.parse("2024.05.21", DateTimeFormatter.ofPattern("yyyy.MM.dd")));

        // 2
        String result = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a h시 m분 이당~~"));
        System.out.println(result);
    }
}
