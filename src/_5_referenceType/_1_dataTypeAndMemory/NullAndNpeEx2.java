package _5_referenceType._1_dataTypeAndMemory;

// 참조 타입 변수는 힙 영역의 객체를 참조하지 않는다는 뜻으로 null 값을 가질 수 있다. null 로 초기화 된 참조 변수는 스택 영역에 생성된다.
// 참조 타입 변수가 null 을 가지고 있을 경우, 참조 타입 변수는 사용할 수 없다. 사용하면 NPE 발생.
public class NullAndNpeEx2 {
    public static void main(String[] args) {
        int[] refArr = null;
        System.out.println(refArr == null);
//        refArr[0] = 10; // 이 변수가 참조하는 배열 객체가 없음

        String refStr = null;
//        System.out.println(refStr.length());  // NPE

        // 자바는 문자열 리터럴이 동일하면 String 객체를 공유하도록 되어 있다.
        String name1 = "jenny";
        String name2 = "jenny";
        // new 연산자로 String 객체 생성시킬 수도 있다. 힙 영역에 새로운 객체를 만들 때 사용하는 연산자로 객체 생성 연산자라고 한다.
        String name3 = new String("jenny");
        System.out.println("name1 == name2: " + (name1 == name2));
        System.out.println("name1 == name3: " + (name1 == name3));
    }
}
