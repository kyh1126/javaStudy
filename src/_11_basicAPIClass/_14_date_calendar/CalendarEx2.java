package _11_basicAPIClass._14_date_calendar;

import com.sun.deploy.util.StringUtils;

import java.util.*;

// Calendar 클래스: 달력을 표현한 클래스. 추상 클래스이므로 new 연산자로 인스턴스 생성할 수 없다. 날짜와 시간을 계산하는 방법이 지역과 문화, 나라마다
//                다르기 때문이다.(우리나라는 음력, 양력 사용) 그래서 날짜와 시간을 계산하는데 꼭 필요한 메소드들만 선언되어 있고 특정한 역법 계산은
//                하위 클래스에서 구현하도록 되어 있다. 특별한 역법을 사용하는 경우가 아니라면 하위 클래스를 만들필요는 없고 Calendar.getInstance()
//                로 현재 운영체제에 설정된 시간대(TimeZone) 기준으로 Calendar 하위 객체를 얻을 수 있다.

public class CalendarEx2 {
    public static void main(String[] args) {
        Calendar now = java.util.Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        int week = now.get(Calendar.DAY_OF_WEEK);
        String s = null;
        switch (week) {
            case Calendar.MONDAY:
                s = "월";
                break;
            case Calendar.TUESDAY:
                s = "화";
                break;
            case Calendar.WEDNESDAY:
                s = "수";
                break;
            case Calendar.THURSDAY:
                s = "목";
                break;
            default:
                s = "신나는 주말!";
        }
        System.out.println(s);

        int amPm = now.get(Calendar.AM_PM);
        if (amPm == Calendar.AM) {
            System.out.println("오전");
        } else {
            System.out.println("오후");
        }

        List<String> time = new ArrayList<>();
        Collections.addAll(time, String.valueOf(now.get(Calendar.HOUR)), String.valueOf(now.get(Calendar.MINUTE)), String.valueOf(now.get(Calendar.SECOND)));
        System.out.println(StringUtils.join(time, ":"));

        Arrays.stream(TimeZone.getAvailableIDs()).forEach(System.out::println);

        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar laCalendar = Calendar.getInstance(timeZone);
        time = new ArrayList<>();
        Collections.addAll(time, String.valueOf(laCalendar.get(Calendar.HOUR)), String.valueOf(laCalendar.get(Calendar.MINUTE)), String.valueOf(laCalendar.get(Calendar.SECOND)));
        System.out.println(StringUtils.join(time, ":"));
    }
}
