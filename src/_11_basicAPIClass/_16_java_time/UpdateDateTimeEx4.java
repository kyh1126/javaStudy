package _11_basicAPIClass._16_java_time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

// 날짜와 시간을 조작하기: 날짜와 시간 클래스들은 날짜와 시간을 조작하는 메소드와 상대 날짜를 리턴하는 메소드들을 가지고 있다.

// 1. 빼기와 더하기: 날짜와 시간을 빼거나 더하는 메소드들.
// -------------------------------------------------------------------------------
// 클래스           리턴 타입         메소드(매개 변수)          설명
// -------------------------------------------------------------------------------
// LocalDate      LocalDate       minusYears(long)    년 빼기
// LocalDateTime  LocalDateTime   minusMonths(long)   달 빼기
// ZonedDateTime  ZonedDateTime   minusDays(long)     일 빼기
//                                minusWeeks(long)    주 빼기
//                                plusYears(long)     년 더하기
//                                plusMonths(long)    달 더하기
//                                plusDays(long)      일 더하기
//                                plusWeeks(long)     주 더하기
// -------------------------------------------------------------------------------
// LocalTime      LocalTime       minusHours(long)    시간 빼기
// LocalDateTime  LocalDateTime   minusMinutes(long)  분 빼기
// ZonedDateTime  ZonedDateTime   minusSeconds(long)  초 빼기
//                                minusNanos(long)    나노초 빼기
//                                plusHours(long)     시간 더하기
//                                plusMinutes(long)   분 더하기
//                                plusSeconds(long)   초 더하기
//                                plusNanos(long)     나노초 더하기
// -------------------------------------------------------------------------------

// 2. 변경하기
// -------------------------------------------------------------------------------
// 클래스           리턴 타입         메소드(매개 변수)           설명
// -------------------------------------------------------------------------------
// LocalDate      LocalDate       withYear(int)           년 변경
// LocalDateTime  LocalDateTime   withMonth(int)          월 변경
// ZonedDateTime  ZonedDateTime   withDayOfMonth(int)     월의 일 변경
//                                withDayOfYear(int)      년의 일 변경
//                                with(TemporalAdjuster)  상대 변경
// -------------------------------------------------------------------------------
// LocalTime      LocalTime       withHour(int)           시간 변경
// LocalDateTime  LocalDateTime   withMinute(int)         분 변경
// ZonedDateTime  ZonedDateTime   withSecond(int)         초 변경
//                                withNano(int)           나노초 변경
// -------------------------------------------------------------------------------

// TemporalAdjuster 메소드들
// -------------------------------------------------------------------------------
// 리턴 타입            메소드(매개 변수)              설명
// -------------------------------------------------------------------------------
// TemporalAdjuster   firstDayOfYear()          이번 해의 첫 번째 일
//                    lastDayOfYear()           이번 해의 마지막 일
//                    firstDayOfNextYear()      다음 해의 첫 번째 일
//                    firstDayOfMonth()         이번 달의 첫 번째 일
//                    lastDayOfMonth()          이번 달의 마지막 일
//                    firstDayOfNextMonth()     다음 달의 첫 번째 일
//                    firstInMonth(DayOfWeek)   이번 달의 첫 번째 요일
//                    lastInMonth(DayOfWeek)    이번 달의 마지막 요일
//                    next(DayOfWeek)           돌아오는 요일
//                    nextOrSame(DayOfWeek)     돌아오는 요일(오늘 포함)
//                    previous(DayOfWeek)       지난 요일
//                    previousOrSame(DayOfWeek) 지난 요일(오늘 포함)
// -------------------------------------------------------------------------------

public class UpdateDateTimeEx4 {
    public static void main(String[] args) {
        // 1
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime targetDateTime = now.plusYears(1)
                .minusMonths(3)
                .plusDays(3)
                .plusHours(2)
                .minusMinutes(30)
                .plusSeconds(3);
        System.out.println(targetDateTime);

        // 2
        targetDateTime = null;
        targetDateTime = now.withYear(1990)
                .withMonth(11)
                .withDayOfMonth(26)
                .withHour(6)
                .withMinute(30);
        System.out.println(targetDateTime);

        targetDateTime = now.with(TemporalAdjusters.firstDayOfYear())   // 이번 해의 첫 일
                .with(TemporalAdjusters.lastDayOfYear())                // 이번 해의 마지막 일
                .with(TemporalAdjusters.firstDayOfNextYear());          // 다음 해의 첫 일
        System.out.println(targetDateTime);

        targetDateTime = now.with(TemporalAdjusters.firstDayOfMonth())  // 이번 달의 첫 일
                .with(TemporalAdjusters.lastDayOfMonth())               // 이번 달의 마지막 일
                .with(TemporalAdjusters.firstDayOfNextMonth());         // 다음 달의 첫 일
        System.out.println(targetDateTime);

        targetDateTime = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)) // 이번 달의 첫 월요일
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))                     // 돌아오는 월요일
                .with(TemporalAdjusters.previous(DayOfWeek.MONDAY));                // 지난 월요일
        System.out.println(targetDateTime);
    }
}
