package _2_variableAndType._2_dataType;

// 타입 변환: 데이터 타입을 다른 데이터 타입으로 변환하는 것. 자동(묵시적) 타입 변환, 강제(명시적) 타입 변환.
// 자동 타입 변환(Promotion): 작은 크기를 가지는 타입이 큰 크기를 가지는 타입에 저장될 때 발생.
// 강제 타입 변환(Casting): 큰 크기를 작은 크기 타입으로 저장하는 것. 메모리 상 맨뒤 바이트부터 저장되므로 원래 값이 보존되지 않는다.
// 두 피연산자 중 큰 타입으로 자동 변환된 후 연산한다. 작은 타입 연산을 해야한다면 큰 타입을 강제 변환 후 연산을 수행하면 된다.
public class TypeConversionEx2 {
    public static void main(String[] args) {
        // 데이터 손실 방지
//        int i = 128;
        int i = 127;

        if (i < Byte.MIN_VALUE || (i > Byte.MAX_VALUE)) {
            System.out.println("값이 날아갈 수 있어 실패");
        } else {
            byte b = (byte) i;
            System.out.println("b: " + b);
        }

        char ai = 'A';
        // 자바는 정수 연산일 경우 int 타입을 기본으로 한다.
        System.out.println("unicode: " + ai + 1);
        System.out.println("char: " + (char) (ai + 1));
    }
}
