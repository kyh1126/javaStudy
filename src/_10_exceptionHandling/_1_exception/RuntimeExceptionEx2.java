package _10_exceptionHandling._1_exception;

import _8_interface._1_interface.Audio;
import _8_interface._1_interface.RemoteControl;
import _8_interface._1_interface.Tv;

// 1. NullPointerException: 객체 참조가 없는 상태. null 값을 갖는 참조 변수로 객체 접근 연산자인 도트(.)를 사용했을 떄 발생한다.
// 2. ArrayIndexOutOfBoundsException: 배열에서 인덱스 범위를 초과하여 사용할 경우.
// 3. NumberFormatException: 문자열 데이터를 숫자로 변경하는데 이상한 문자열일 경우.
// 4. ClassCastException: 타입 변환(Casting)은 상위/하위 클래스 간, 구현 클래스 인터페이스 간에 발생한다.
//                        instanceof 연산 결과가 true 이면 좌항 객체를 우항 타입으로 변환이 가능하다는 뜻이다.
public class RuntimeExceptionEx2 {
    public static void main(String[] args) {
        // 1
        try {
            String data = null;
            System.out.println(data.toString());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!");
        }

        //2
        try {
            int[] arr = new int[3];
            System.out.println("arr[2]: " + arr[2]);
            System.out.println("arr[3]: " + arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException!");
        }

        //3
        try {
            String s1 = "100";
            String s2 = "a100";

            System.out.println("s1: " + Integer.parseInt(s1));
            System.out.println("s2: " + Integer.parseInt(s2));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException!");
        }

        //4
        try {
            RemoteControl rc = new Audio();
            System.out.println("audio?: " + (Audio) rc);
            System.out.println("Tv?: " + (Tv) rc);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException!");
        }
    }
}
