package _6_class._2_objectAndClass;

// 인스턴스(instance) 멤버: 객체(인스턴스)를 생성한 후 사용할 수 있는 필드와 메소드를 말한다.
// 아래 코드 실행된 후 메모리 상태는
// myCar(스택 영역), myCar 객체, doorCnt(힙 영역), void setSpeed(메소드 영역)

// 인스턴스 필드는 객체마다 따로 존재하고, 인스턴스 메소드 setSpeed()는 객체마다 존재하지 않고 메소드 영역에 저장되고 공유된다.
// 객체 외부에서 인스턴스 멤버에 접근하기 위해 참조 변수를 사용하는 것과 마찬가지로
// 객체 내부에서도 인스턴스 멤버에 접근하기 위해 this 를 사용한다.
public class InstanceAndThisEx5 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.doorCnt = 2;
        myCar.setSpeed(20);
    }
}
