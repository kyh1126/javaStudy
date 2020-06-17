package _11_basicAPIClass._8_stringTokenizer;

// 1. split(): 파이프 기호로 연결한 기호들을 구분자로 해서 부분 문자열을 추출한다.
// 2. StringTokenizer 클래스: 문자열이 한 종류 구분자로 연결되어 있을 경우 첫 번째 매개값으로 전체 문자열, 두 번째 매개값으로 구분자.
// StringTokenizer 메소드들
// -------------------------------------------------------------------------------
// 메소드                          설명
// -------------------------------------------------------------------------------
// int     | countToken()       꺼내지 않고 남아 있는 토큰 수
// boolean | hasMoreTokens()    남아 있는 토큰이 있는지 여부
// String  | nextToken()        토큰을 하나씩 꺼내옴
// -------------------------------------------------------------------------------

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerEx1 {
    public static void main(String[] args) {
        // 1
        Arrays.stream("홍길동&이연수,김자바-최명".split("&|,|-")).forEach(System.out::println);
        System.out.println();

        //2
        StringTokenizer st = new StringTokenizer("김윤희/제니/제니크크", "/");
        for (int i = 0; i < st.countTokens(); i++) {
            // nextToken() 메소드는 NoSuchElementException 예외를 발생시킨다. 그래서 hasMoreTokens 체크를 쓰는게 좋다.
            System.out.println(st.nextToken());
        }
    }
}
