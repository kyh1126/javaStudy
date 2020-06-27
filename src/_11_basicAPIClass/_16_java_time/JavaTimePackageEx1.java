package _11_basicAPIClass._16_java_time;

// java.time 패키지: 자바 7 이전까지는 Date, Calendar 클래스로 날짜와 시간 정보를 얻을 수 있었다. Date 클래스 대부분 메소드는 Deprecated 되었고,
//                 Date 의 용도는 단순히 특정 시점의 날짜 정보를 저장하는 역할만 한다. Calendar 클래스는 날짜와 시간 정보를 얻기에는 충분하지만,
//                 날짜와 시간을 조작하거나 비교하는 기능이 불충분하다. 그래서 자바 8부터 날짜와 시간을 나타내는 여러 API 를 추가했다. 이 API 는
//                 java.util 패키지에 없고 별도로 java.time 패키지와 하위 패키지로 제공된다.
// -------------------------------------------------------------------------------
// 패키지                  설명
// -------------------------------------------------------------------------------
// java.time            날짜와 시간을 나타내는 핵심 API 인 LocalDate, LocalDateTime, ZonedDateTime 을 포함하고 있다. 이 클래스들은
//                      ISO-8601에 정의된 달력 시스템에 기초한다.
// java.time.chrono     ISO-8601에 정의된 달력 시스템 이외에 다른 달력 시스템이 필요할 때 사용할 수 있는 API 들이 포함되어 있다.
// java.time.format     날짜와 시간을 파싱하고 포맷팅하는 API 들이 포함되어 있다.
// java.time.temporal   날짜와 시간을 연산하기 위한 보조 API 들이 포함되어 있다.
// java.time.zone       타임존을 지원하는 API 들이 포함되어 있다.
// -------------------------------------------------------------------------------

public class JavaTimePackageEx1 {
}
