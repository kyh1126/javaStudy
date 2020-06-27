package _11_basicAPIClass._15_format;

import java.text.MessageFormat;

// 문자열 형식 클래스(MessageFormat): 데이터를 파일에 저장하거나, 네트워크로 전송할 때, DB SQL 문을 작성할 때 등 많은 부분에서 일정한 형식의 문자열을
//                               사용한다. MessageFormat 클래스를 사용하면 문자열에 데이터가 들어갈 자리를 표시해두고, 프로그램이 실행하면서
//                               동적으로 데이터를 삽입해 문자열을 완성시킬 수 있다.

public class MessageFormatEx3 {
    public static void main(String[] args) {
        String id = "java";
        String name = "jenny";
        String tel = "010-1234-1234";

        String text = "회원 ID: {0}, \n회원 이름: {1}, \n회원 전화: {2}";
        System.out.println(MessageFormat.format(text, id, name, tel));

        String sql = "insert into Member values( {0}, {1}, {2} )";
        Object[] arguments = {id, name, tel};
        System.out.println(MessageFormat.format(sql, arguments));
    }
}
