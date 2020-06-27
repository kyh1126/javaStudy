package _11_basicAPIClass._15_format;

import java.text.SimpleDateFormat;
import java.util.Date;

// 날짜 형식 클래스(SimpleDateFormat): Date 클래스의 toString()은 영문 날짜를 리턴하는데 만약 특정 문자열 포맷으로 얻고 싶다면 SimpleDateFormat
//                                 클래스를 이용하면 된다. 날짜를 원하는 형식으로 표현하기 위해서 패턴을 사용한다.
// -------------------------------------------------------------------------------
// 패턴 문자    의미                  패턴 문자    의미
// -------------------------------------------------------------------------------
// y        년                       H       시(0 ~ 23)
// M        월                       h       시(1 ~ 12)
// d        일                       K       시(0 ~ 11)
// D        월 구분이 없는 일(1 ~ 365)  k       시(1 ~ 24)
// E        요일                     m       분
// a        오전/오후                 s       초
// w        년의 몇 번째 주            S       밀리세컨드(1/1000초)
// W        월의 몇 번째 주
// -------------------------------------------------------------------------------

public class SimpleDateFormatEx2 {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("오늘은 E요일");
        System.out.println(sdf.format(now));

        sdf = new SimpleDateFormat("올해의 D번째 날");
        System.out.println(sdf.format(now));

        sdf = new SimpleDateFormat("이달의 d번째 날");
        System.out.println(sdf.format(now));
    }
}
