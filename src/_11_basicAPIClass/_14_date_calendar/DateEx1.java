package _11_basicAPIClass._14_date_calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

// Date 클래스: 날짜를 표현하는 클래스. 객체 간에 날짜 정보를 주고 받을 때 주로 사용. 여러 생성자 중 Date() 외엔 deprecated. Date()는 컴퓨터 현재
//            날짜를 읽어 Date 객체로 만든다. 현재 날짜를 문자열로 얻고 싶다면 toString() 사용. 영문 날짜 리턴하는데, 만약 특정 문자열 포맷으로 얻고
//            싶다면 java.text.SimpleDateFormat 클래스를 이용하면 된다.
public class DateEx1 {
    public static void main(String[] args) {
        Date now = new Date();
        String s = now.toString();
        System.out.println(s);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        System.out.println(sdf.format(now));
    }
}
