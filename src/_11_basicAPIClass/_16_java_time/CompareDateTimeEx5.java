package _11_basicAPIClass._16_java_time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

// 날짜와 시간을 비교하기: 날짜와 시간 클래스들은 다음과 같이 비교하거나 차이를 구하는 메소드들을 가지고 있다.
// -------------------------------------------------------------------------------
// 클래스              리턴 타입       메소드(매개 변수)              설명
// -------------------------------------------------------------------------------
// LocalDate         boolean    isAfter(ChronoLocalDate)    이후 날짜인지 비교
// LocalDateTime                isBefore(ChronoLocalDate)   이전 날짜인지 비교
//                              isEqual(ChronoLocalDate)    동일 날짜인지 비교
// -------------------------------------------------------------------------------
// LocalTime         boolean    isAfter(LocalTime)          이후 시간인지 비교
// LocalDateTime                isBefore(LocalTime)         이전 시간인지 비교
// -------------------------------------------------------------------------------
// LocalDate         Period     until(ChronoLocalDate)      날짜 차이
// -------------------------------------------------------------------------------
// LocalDate         long       until(                      시간 차이
// LocalTime                    Temporal endExclusive,
// LocalDateTime                TemporalUnit unit )
// -------------------------------------------------------------------------------
// Period            Period     between(                    날짜 차이
//                              LocalDate startDateInclusive,
//                              LocalDate endDateExclusive )
// -------------------------------------------------------------------------------
// Duration          Duration   between(                    시간 차이
//                              Temporal startInclusive,
//                              Temporal endExclusive )
// -------------------------------------------------------------------------------
// ChronoUnit.YEARS  long       between(                    전체 년 차이
// ChronoUnit.MONTHS            Temporal temp1Inclusive,    전체 달 차이
// ChronoUnit.WEEKS             Temporal temp2Exclusive )   전체 주 차이
// ChronoUnit.DAYS                                          전체 일 차이
// ChronoUnit.HOURS                                         전체 시간 차이
// ChronoUnit.SECONDS                                       전체 초 차이
// ChronoUnit.MILLIS                                        전체 밀리초 차이
// ChronoUnit.NANOS                                         전체 나노초 차이
// -------------------------------------------------------------------------------

// Period, Duration 은 날짜와 시간의 양을 나타내는 클래스들이다. Period 는 년, 달, 일의 양을 나타내는 클래스들, Duration 은 시, 분, 초, 나노초
// 양을 나타내는 클래스들이다. 이 클래스들은 D-day 나 D-time 을 구할 때 사용될 수 있다. Period, Duration 에서 제공하는 메소드들
// -------------------------------------------------------------------------------
// 쿨래스      리턴 타입   메소드(매개 변수)      설명
// -------------------------------------------------------------------------------
// Period       int     getYears()      년의 차이
//                      getMonths()     달의 차이
//                      getDays()       일의 차이
// -------------------------------------------------------------------------------
// Duration     int     getSeconds()    초의 차이
//                      getNano()       나노초의 차이
// -------------------------------------------------------------------------------

public class CompareDateTimeEx5 {
    public static void main(String[] args) {
        LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 9, 0, 0);
        System.out.println("시작일: " + startDateTime);

        LocalDateTime endDateTime = LocalDateTime.of(2024, 3, 31, 18, 0, 0);
        System.out.println("종료일: " + endDateTime);

        if (startDateTime.isBefore(endDateTime)) {
            System.out.println("진행 중입니다.");
        } else if (startDateTime.isEqual(endDateTime)) {
            System.out.println("종료합니다.");
        } else if (startDateTime.isAfter(endDateTime)) {
            System.out.println("종료했습니다.");
        }

        System.out.println("[종료까지 남은 시간]");
        long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
        System.out.println("남은 해: " + remainYear);
        System.out.println(remainYear == ChronoUnit.YEARS.between(startDateTime, endDateTime));

        System.out.println("[종료까지 남은 기간]");
        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
        System.out.println("남은 기간: " + period.getYears() + "년 ");
        System.out.println(period.getMonths() + "월 ");
        System.out.println(period.getDays() + "일");

        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
        System.out.println("남은 초: " + duration.getSeconds());
    }
}
