package _11_basicAPIClass._16_java_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// 날짜와 시간에 대한 정보 얻기
// LocalDate, LocalTime 은 프로그램에서 날짜와 시간 정보를 이용할 수 있도록 다음 메소드를 제공한다.
// -------------------------------------------------------------------------------
// 클래스      리턴 타입       메소드(매개 변수)      설명
// -------------------------------------------------------------------------------
// LocalDate    int         getYear()       년
//              Month       getMonth()      Month 열거값
//              int         getMonthValue() 월
//              int         getDayOfYear()  일년의 몇 번째 일
//              int         getDayOfMonth() 월의 몇 번째 일
//              DayOfWeek   getDayOfWeek()  요일
//              boolean     isLeapYear()    윤년 여부
// -------------------------------------------------------------------------------
// LocalTime    int         getHour()       시간
//              int         getMinute()     분
//              int         getSecond()     초
//              int         getNano()       나노초 리턴
// -------------------------------------------------------------------------------

// LocalDateTime, ZonedDateTime 은 날짜와 시간 정보를 모두 갖고 있기 때문에 위 표에 나와 있는 대부분의 메소드를 가지고 있다. 단, isLeapYear()는
// LocalDate 에만 있기 때문에 toLocalDate()로 변환한 후 사용할 수 잇다. ZonedDateTime 은 시간존에 정보를 제공하는 다음 메소드를 갖고 있다.
// -------------------------------------------------------------------------------
// 클래스              리턴 타입   메소드(매개 변수)      설명
// -------------------------------------------------------------------------------
// ZonedDateTime    ZoneID      getZone()       존아이디를 리턴(ex> Asia/Seoul)
//                  ZoneOffset  getOffset()     존오프셋(시차)을 리턴
// -------------------------------------------------------------------------------

public class GetDateTimeInfoEx3 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate nowDate = now.toLocalDate();
        if (nowDate.isLeapYear()) {
            System.out.println("올해는 윤년! 2/29까지 있슴");
        } else {
            System.out.println("윤년아님! 2월은 28일까지 있슴");
        }

        ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("협정 세계 시: " + utc);

        ZonedDateTime seoul = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("서울 타임존: " + seoul);

        System.out.println("서울 존아이디: " + seoul.getZone());
        System.out.println("서울 존오프셋: " + seoul.getOffset());
    }
}
