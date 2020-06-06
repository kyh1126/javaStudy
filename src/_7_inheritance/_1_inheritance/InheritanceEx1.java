package _7_inheritance._1_inheritance;

// 상속(Inheritance): OOP 에서 부모 클래스의 멤버를 자식 클래스에게 물려주는 것. OOP 의 특징 중 하나.(캡슐화, 상속, 다형성)
//                   부모 클래스에서 private 접근 제한을 갖는 필드와 메소드는 상속 제외된다.
//                   부모와 자식이 다른 패키지에 존재한다면 default 접근 제한을 갖는 필드와 메소드도 상속 대상에서 제외된다.
//                   다른 언어와는 달리 자바는 다중 상속을 허용하지 않는다.

// 부모 객체가 먼저 생성되고 자식 객체가 그 다음에 생성된다. 부모 생성자는 자식 생성자의 맨 첫줄에서 호출된다.
// super(매개값, ...)가 생략되면 컴파일러에 의해 super()가 자동적으로 추가되기 때문에 부모의 기본 생성자가 존재해야 한다.
// this()와 같이 super()도 반드시 생성자 첫 줄에 위치해야 한다.
public class InheritanceEx1 {
    public static void main(String[] args) {

        // 스택에 dmbPhone 생성  힙 영역의 DmbPhone 객체 가리킨다. 이 객체는 Phone 객체 상속받아 가리킨다.
        DmbPhone dmbPhone = new DmbPhone("자바폰", "검정", 10);
        System.out.println("모델: " + dmbPhone.model);
        System.out.println("색: " + dmbPhone.color);
        System.out.println("채널:" + dmbPhone.channel);

        dmbPhone.turnOnDmb();
        dmbPhone.turnOffDmb();
    }
}
