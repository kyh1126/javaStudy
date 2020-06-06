package _9_nestedClassAndInterface._2_nestedClassAccessLimit;

// 클래스 내부 this: 객체 자신의 참조.
// 중첩 클래스에서 바깥 클래스 참조 얻기: 바깥 클래스의 이름을 this 앞에 붙여주면 된다.
public class OutterclassRefEx2 {
    public static void main(String[] args) {
        OutterClass outter = new OutterClass();
        OutterClass.Nested nested = outter.new Nested();
        nested.print();
    }
}
