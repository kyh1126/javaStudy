package _11_basicAPIClass._9_stringBuffer_stringBuilder;

// 문자열을 결합하는 + 연산자를 많이 사용할수록 그만큼 String 객체 수가 늘어나기 때문에, 프로그램 성능을 느리게 하는 요인이 된다. 문자열 변경 작업이 많을
// 경우 String 클래스보단 StringBuffer, StringBuilder 클래스를 사용하는 것이 좋다. 이 두 클래스는 내부 버퍼(buffer: 데이터를 임시로 저장하는
// 메모리)에 문자열을 저장해두고, 그 안에서 추가, 수정, 삭제 작업을 할 수 있도록 설계되어 있다. 새로운 객체를 만들지 않고도 문자열 조작할 수 있는 것이다.

// StringBuilder 클래스: 단일 스레드 환경에서만 사용하도록 설계되어 있다.
// StringBuffer 클래스: 멀티 스레드 환경에서 사용할 수 있도록 동기화가 적용되어 있어 스레드 안전하다.
// -------------------------------------------------------------------------------
// 메소드                                      설명
// -------------------------------------------------------------------------------
// append(...)                              문자열 끝에 주어진 매개값을 추가
// insert(int offset, ...)                  문자열 중간에 주어진 매개값을 추가
// delete(int start, int end)               문자열의 일부분을 삭제
// deleteCharAt(int index)                  문자열에서 주어진 index 의 문자를 삭제
// replace(int start, int end, String s)    문자열의 일부분을 다른 문자열로 대치
// reverse()                                문자열의 순서를 뒤바꿈
// setCharAt(int index, char c)             문자열에서 주어진 index 의 문자를 다른 문자로 대치
// -------------------------------------------------------------------------------

public class StringBufferEx1 {
    public static void main(String[] args) {
        // data: 메모리 스택 영역
        // "ABC", "ABCDEF": 메모리 힙 영역
        String data = "ABC";
        // -> data 변수가 참조하는 힙 객체가 "ABCDEF"로 변경된다.
        data += "DEF";

        StringBuilder sb = new StringBuilder();
        sb.append("Java ");
        System.out.println(sb.toString());

        sb.insert(4, "2");
        System.out.println(sb.toString());

        sb.setCharAt(4, '6');
        System.out.println(sb.toString());

        sb.replace(6, 13, "Book");
        System.out.println(sb.toString());

        sb.delete(4, 5);
        System.out.println(sb.toString());

        int length = sb.length();
        System.out.println(length);

        // 버퍼에 있는것을 String 타입으로 리턴
        String res = sb.toString();
        System.out.println(res);
        System.out.println(sb);
        System.out.println(sb.reverse());

        // 기본 생성자는 16개의 문자들을 저장할 수 있는 초기 버퍼를 만들고, 매개변수 생성자는 해당 개수만큼 문자들 저장할 수 있는 초기 버퍼를 만든다.
        // 버퍼가 부족할 경우 자동으로 버퍼 크기를 늘리기 때문에 초기 버퍼 크기는 중요하지 않다.
        StringBuilder str = new StringBuilder();
        str.append("Java 10");
        System.out.println(str.reverse());
    }
}
