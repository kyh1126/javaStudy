package _11_basicAPIClass._12_wrapper;

// Wrapper 클래스: 자바는 기본 타입의 값을 갖는 객체를 생성할 수 있다. 이런 객체를 Wrapper 객체라고 하는데, 그 이유는 기본 타입의 값을 내부에 두고
//               포장하기 때문이다. 포장하고 있는 기본 타입 값은 외부에서 변경할 수 없다. 만약 내부값을 변경하고 싶다면 새 포장 객체를 만들어야 한다.
// java.lang.WrapperClass
// -------------------------------------------------------------------------------
// 기본 타입    포장 클래스
// -------------------------------------------------------------------------------
// byte     Byte
// char     Character
// short    Short
// int      Integer
// long     Long
// float    Float
// double   Double
// boolean  Boolean
// -------------------------------------------------------------------------------

// 박싱: 기본 타입의 값을 포장 객체로 만드는 과정.
// -------------------------------------------------------------------------------
// 기본 타입의 값을 줄 경우               문자열을 줄 경우
// -------------------------------------------------------------------------------
// Byte b = new Byte(10);           Byte b = new Byte("10");
// Character c = new Character('가');    없음
// Short s = new Short(100);        Short s = new Short("100");
// Integer i = new Integer(1000);   Integer i = new Integer("1000");
// Long l = new Long(10000);        Long l = new Long("10000");
// Float f = new Float(2.5F);       Float f = new Float("2.5F");
// Double d = new Double(3.5);      Double d = new Double("3.5");
// Boolean b = new Boolean(true);   Boolean b = new Boolean("true");
// -------------------------------------------------------------------------------

// 언박싱: 포장 객체에서 기본 타입의 값을 얻어내는 과정.
// -------------------------------------------------------------------------------
// 기본 타입의 값을 이용
// -------------------------------------------------------------------------------
// byte     num = o.byteValue();
// char     ch = o.charValue();
// short    num = o.shortValue();
// int      num = o.intValue();
// long     num = o.longValue();
// float    num = o.floatValue();
// double   num = o.doubleValue();
// boolean  bool = o.booleanValue();
// -------------------------------------------------------------------------------

// 자동 박싱: 포장 클래스 타입에 기본값이 대입될 경우.
// 자동 언박싱: 기본 타입에 포장 객체가 대입될 경우. 자바 5부터 추가된 기능.

// 문자열을 기본 타입 값으로 변환: 포장 클래스 주 용도는 기본 타입의 값을 박싱해서 포장 객체로 만드는 것, 문자열을 기본 타입 값으로 변환시에도 많이 사용된다.
// -------------------------------------------------------------------------------
// 기본 타입의 값을 이용
// -------------------------------------------------------------------------------
// byte     num = Byte.parseByte("str");
// short    num = Short.parseShort("str");
// int      num = Integer.parseInt("str");
// long     num = Long.parseLong("str");
// float    num = Float.parseFloat("str");
// double   num = Double.parseDouble("str");
// boolean  bool = Boolean.parseBoolean("str");
// -------------------------------------------------------------------------------

// 포장 값 비교: 포장 객체는 내부의 값을 비교하기 위해 ==, != 연산자를 사용할 수 없다. 이 연산자는 내부 값을 비교하는게 아니라 포장 객체의 참조를 비교한다.
//            내부 값만 비교하려면 언박싱한 값을 얻어 비교해야 한다. 박싱된 값이 아래의 값일 때만 ==, != 로 바로 비교할 수 있다.
//            어떤 값이 저장될지 모르면 ==, != 연산자는 사용하지 않는 것이 좋다. 포장 클래스 equals()는 내부의 값을 비교하도록 오버라이딩되어 있다.
// -------------------------------------------------------------------------------
// 타입                   값의 범위
// -------------------------------------------------------------------------------
// boolean              true, false
// char                 \u0000 ~ \u007f
// byte, short, int     -128 ~ 127
// -------------------------------------------------------------------------------

public class WrapperEx1 {
    public static void main(String[] args) {
        // Boxing
        Integer o1 = new Integer(100);
        Integer o2 = new Integer("20");
        Integer o3 = Integer.valueOf("300");
        // Unboxing
        int v1 = o1.intValue();
        System.out.println(v1);
        System.out.println(o2);

        // 자동 박싱
        Integer o = 100;
        System.out.println(o.intValue());
        // 자동 언박싱
        int val = o;
        // 연산 시 자동 언박싱
        int res = o + 100;
        System.out.println(res);

        // 포장 값 비
        System.out.println("[-128 ~ 127 초과값일 경우]");
        Integer i1 = 300;
        Integer i2 = 300;
        System.out.println("== : " + (i1 == i2));
        System.out.println("언박싱 후 == : " + (i1.intValue() == i2.intValue()));
        System.out.println("equals() : " + i1.equals(i2));

        System.out.println("[-128 ~ 127 범위값일 경우]");
        i1 = 100;
        i2 = 100;
        System.out.println("== : " + (i1 == i2));
        System.out.println("언박싱 후 == : " + (i1.intValue() == i2.intValue()));
        System.out.println("equals() : " + i1.equals(i2));

        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println("== : " + (b1 == b2));
        System.out.println("언박싱 후 == : " + (b1.booleanValue() == b2.booleanValue()));
        System.out.println("equals() : " + b1.equals(b2));
    }
}
