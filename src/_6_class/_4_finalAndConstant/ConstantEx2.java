package _6_class._4_finalAndConstant;

// 상수(constant): 불변의 값. 불변의 값은 객체마다 저장할 필요가 없는 공용성을 띠고 있다. static final 이어야 한다.
//                객체마다 저장되지 않고, 클래스에만 포함된다. 한 번 초기값이 저장되면 변경할 수 없다.
//                상수 이름은 모두 대문자로 작성하는 것이 관례이다. 정적 블록에서 값 초기화 가능.
public class ConstantEx2 {
    static final int CONSTANT;

    static {
        CONSTANT = 1;
    }
}
