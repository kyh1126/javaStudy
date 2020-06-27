package _11_basicAPIClass._16_java_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

// 날짜와 시간 객체 생성: java.time 패키지에는 다음과 같이 날짜와 시간을 표현하는 5개의 클래스가 있다.
// -------------------------------------------------------------------------------
// 클래스명             설명
// -------------------------------------------------------------------------------
// LocalDate        로컬 날짜 클래스
// LocalTime        로컬 시간 클래스
// LocalDateTime    로컬 날짜 및 시간 클래스(LocalDate + LocalTime)
// ZonedDateTime    특정 타임존(TimeZone)의 날짜와 시간 클래스
// Instant          특정 시점의 Time-Stamp 클래스
// -------------------------------------------------------------------------------

// 1. LocalDate: 로컬 날짜 클래스로 날짜 정보만을 저장할 수 있다. now()는 컴퓨터의 현재 날짜 정보를 저장한 객체를 리턴, of()는 매개값으로 주어진
//               날짜 정보를 저장한 LocalDate 객체를 리턴한다.
// 2. LocalTime: 로컬 시간 클래스로 시간 정보만을 저장할 수 있다. now()는 컴퓨터의 현재 시간 정보를 저장한 객체를 리턴, of()는 매개값으로 주어진
//               시간 정보를 저장한 LocalTime 객체를 리턴한다.
// 3. LocalDateTime: LocalDate + LocalTime 클래스. now()는 컴퓨터의 현재 날짜와 시간 정보를 저장한 객체를 리턴, of()는 매개값으로 주어진
//                   날짜와 시간 정보를 저장한 LocalDateTime 객체를 리턴한다.
// 4. ZonedDateTime: ISO-8601 달력 시스템에서 정의하고 있는 타임존 날짜와 시간을 저장하는 클래스. 2014-04-21T07:50:24.017+09:00[Asia/Seoul]
//                   같이 맨 뒤에 타임존에 대한 정보(+-존오프셋[존아이디])가 추가적으로 붙는다. 존오프셋(ZoneOffset)은 협정세계시(UTC)와 차이
//                   나는 시간(시차)을 말한다. now()에 ZoneId를 매개값으로 주고 얻을 수 있다. ZoneId는 of()로 얻을 수 있는데, of()의 매개값은
//                   java.util.TimeZone 의 getAvailableIDs()가 리턴하는 유효한 값 중 하나이다.
// 5. Instant: 날짜와 시간의 정보를 얻거나 조작하는데 사용되지 않고, 특정 시점의 타임스탬프로 사용된다. 주로 특정한 두 시점 간의 시간적 우선순위를 따질 때
//             사용한다. java.util.Date 와 가장 유사한 클래스이지만, 차이점은 Date 는 로컬 컴퓨터의 현재 날짜와 시간 정보를 기준으로 하지만
//             Instant 는 협정세계시(UTC)를 기준으로 한다. isBefore(), isAfter()는 시간의 앞뒤 여부를 확인, until()은 두 시점 간 차이를 리턴.

public class JavaTimeEx2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(1990, 11, 26));

        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(6, 30, 0, 0));

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(1990, 11, 26, 6, 30, 0, 0));

        System.out.println(ZonedDateTime.now(ZoneId.of("UTC")));
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));

        Instant now = Instant.now();
        Thread.sleep(10);
        Instant now1 = Instant.now();
        if (now.isBefore(now1)) {
            System.out.println("now 가 빠릅니다.");
        } else if (now.isAfter(now1)) {
            System.out.println("now 가 늦습니다.");
        } else {
            System.out.println("동일한 시간입니다.");
        }
        System.out.println("차이(nanos): " + now.until(now1, ChronoUnit.NANOS));
    }
}
