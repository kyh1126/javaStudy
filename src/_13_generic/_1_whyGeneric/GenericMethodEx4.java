package _13_generic._1_whyGeneric;

// 제네릭 메소드: 매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메소드. 리턴 타입 앞에 <> 추가하고 타입 파라미터 기술 후, 리턴 타입과 매개 타입으로 타입 파라미터 사용.
// 제네릭 메소드 호출
// 1. 코드에서 타입 파라미터의 구체적인 타입 명시적으로 지정
// 2. 컴파일러가 매개값의 타입을 보고 구체적인 타입 추정하도록 함
public class GenericMethodEx4 {
    public static void main(String[] args) {
        // 1
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int val = box1.getT();

        // 2
        Box<String> box2 = Util.boxing("이름");
        String str = box2.getT();

        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(1, "orange");
        // 1
        boolean result = Util.<Integer, String>compare(p1, p2);
        if (result) {
            System.out.println("논리적으로 동등한 객체입니다.");
        } else {
            System.out.println("논리적으로 동등하지 않은 객체입니다.");
        }
        // 2
        boolean res2 = Util.compare(p1, p2);
    }
}
