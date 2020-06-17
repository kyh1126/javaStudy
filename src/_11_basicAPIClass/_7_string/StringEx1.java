package _11_basicAPIClass._7_string;

// String 메소드
// -------------------------------------------------------------------------------
// 리턴 타입    메소드명(매개 변수)                 설명
// -------------------------------------------------------------------------------
// char     charAt(int index)               특정 위치의 문자 리턴
// boolean  equals(Object anObject)         두 문자열을 비교
// byte[]   getBytes()                      byte[]로 리턴
// byte[]   getBytes(Charset charset)       주어진 문자셋으로 인코딩한 byte[]로 리턴
// int      indexOf(String str)             문자열 내에서 주어진 문자열의 위치를 리턴
// int      length()                        총 문자의 수를 리턴
// String   replace(CharSequence target,    target 부분을 replacement 로 대치한 새 문자열 리턴
//          CharSequence replacement)
// String   substring(int beginIndex)       beginIndex 위치에서 끝까지 잘라낸 새 문자열 리턴
// String   substring(int beginIndex,       beginIndex 위치에서 endIndex 전까지 잘라낸 새 문자열 리턴
//          int endIndex)
// String   toLowerCase()                   알파벳 소문자로 변환한 새 문자열 리턴
// String   toUpperCase()                   알파벳 대문자로 변환한 새 문자열 리턴
// String   trim()                          앞뒤 공백을 제거한 새 문자열 리턴
// String   valueOf(int i)                  기본 타입값을 문자열로 리턴
//          valueOf(double d)
// -------------------------------------------------------------------------------

// 1. 문자 추출(charAt): 매개값으로 주어진 인덱스의 문자 리턴.
// 2. 문자열 비교(equals): 기본 타입 변수값을 비교할 때에는 == 연산자를 사용한다. 자바는 문자열 리터럴이 동일하다면 동일한 String 객체를 참조하도록
//                      되어 있다. 그러나 new 연산자로 만든 String 은 다른 String 객체를 참조한다.
// 3. 바이트 배열로 변환(getBytes()): 네트워크로 문자열을 전송하거나, 문자열을 암호화할 때 문자열을 바이트 배열로 변환한다. 시스템의 기본 문자셋으로
//                               인코딩된 바이트 배열을 리턴한다. EUC-KR 은 알파벳 1byte, 한글 2byte 로 변환, UTF-8 은 앒파벳 1byte,
//                               한글 3byte 로 변환. 잘못된 문자셋을 매개값으로 주면 UnsupportedEncodingException 예외 발생.
//                               인코딩된 바이트 배열을 단순 String 생성자로 디코딩하면 시스템의 기본 문자셋을 이용한다.
// 4. 문자열 찾기(indexOf()): 매개값으로 주어진 문자열이 시작되는 인덱스 리턴. 포함되어 있지 않으면 -1 리턴.
// 5. 문자열 길이(length()): 문자열의 길이(문자의 수) 리턴.
// 6. 문자열 대치(replace()): 첫 번째 매개값인 문자열을 찾아 두 번째 매개값인 문자열로 대치한 새로운 문자열을 생성하고 리턴. String 객체의 문자열은
//                         변경이 불가한 특성을 갖기 때문에 replace() 메소드가 리턴하는 문자열은 원래 문자열의 수정본이 아니라 완전 새 문자열이다.
// 7. 문자열 잘라내기(substring()): 주어진 인덱스에서 문자열을 추출한다.
// 8. 알파벳 대소문자 변경(toLowerCase(), toUpperCase()): 변경된 새 문자열 생성 후 리턴. 비교할 땐 equalsIgnoreCase() 메소드를 사용하면 된다.
// 9. 문자열 앞뒤 공백 잘라내기(trim()): 변경된 새 문자열 생성 후 리턴.
// 10. 문자열 변환(valueOf()): 기본 타입의 값을 문자열로 변환하는 기능을 가지고 있다.(boolean, char, int, long, double, float)

import java.io.UnsupportedEncodingException;

public class StringEx1 {
    public static void main(String[] args) {
        byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};

        // 배열 전체를 String 객체로 생성, 영어는 한 글자가 1바이트, 한글은 2바이트.
        String s1 = new String(bytes);
        System.out.println(s1);

        // 배열의 offset 인덱스 위치부터 length 만큼 String 객체로 생성
        String s2 = new String(bytes, 6, 4);
        System.out.println(s2);

        // 1
        String ssn = "010624-1230123";
        char c = ssn.charAt(7);
        switch (c) {
            case '1':
            case '3':
                System.out.println("남자입니다.");
                break;
            case '2':
            case '4':
                System.out.println("여자입니다.");
                break;
        }

        // 2
        String strVar1 = new String("신민철");
        String strVar2 = "신민철";
        String strVar3 = "신민철";

        if (strVar1 == strVar2) {
            System.out.println("strVar1 == strVar2 ? 같은 String 객체 참조중~~");
        } else {
            System.out.println("strVar1 == strVar2 ? 다른 String 객체 참조중~~");
        }

        if (strVar2 == strVar3) {
            System.out.println("strVar2 == strVar3 ? 같은 String 객체 참조중~~");
        } else {
            System.out.println("strVar2 == strVar3 ? 다른 String 객체 참조중~~");
        }

        // 3
        // 기본 문자셋으로 인코딩과 디코딩
        byte[] bytes1 = "안녕".getBytes();
        System.out.println("bytes1 length: " + bytes1.length);
        String str = new String(bytes1);
        System.out.println("bytes1 -> String: " + str);

        try {
            byte[] bytes2 = "안녕".getBytes("EUC-KR");
            System.out.println("bytes2 length: " + bytes2.length);
            String str2 = new String(bytes2, "EUC-KR");
            System.out.println("bytes2 -> String: " + str2);
            System.out.println("bytes2 -> UTF-8: " + new String(bytes2, "UTF-8"));

            byte[] bytes3 = "안녕".getBytes("UTF-8");
            System.out.println("bytes3 length: " + bytes3.length);
            String str3 = new String(bytes3, "UTF-8");
            System.out.println("bytes3 -> String: " + str3);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 4
        String obj = "자바 프로그래밍";
        System.out.println(obj.indexOf("프로그래밍"));
        if (obj.indexOf("자바") != -1) {
            System.out.println("자바 관련!");
        } else {
            System.out.println("no 관련");
        }

        // 10
        System.out.println(String.valueOf(10).equals("10"));
    }
}
