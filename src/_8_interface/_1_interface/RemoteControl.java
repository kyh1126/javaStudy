package _8_interface._1_interface;

// 1. 상수 필드(Constant Field): 인터페이스는 객체 사용 설명서이므로 런타임 시 데이터를 저장할 수 있는 필드를 선언할 수 없다.
//                             그러나 상수 필드는 선언이 가능하다. 상수는 인터페이스에 고정된 값으로 런타임 시에 데이터를 바꿀 수 없다.
//                             상수를 선언할 때에는 반드시 초기값을 대입해야 한다.
// 2. 추상 메소드(Abstract Method): 추상 메소드는 객체가 가지고 있는 메소드를 설명한 것으로 호출할 때 어떤 매개값, 리턴 타입인지만 알려준다.
//                               실제 실행부는 (구현)객체가 가지고 있다.
// 3. 디폴트 메소드(Default Method): 인터페이스에 선언되지만 사실은 (구현)객체가 가지고 있는 인스턴스 메소드라고 생각해야 한다.
//                                자바 8에서 디폴트 메소드를 허용한 이유는 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서다.
// 4. 정적 메소드(Static Method): 이 역시 자바 8부터 작성 가능한데, 디폴트 메소드와는 달리 객체가 없어도 인터페이스만으로 호출이 가능하다.
public interface RemoteControl {
    // 상수 필드 선언: 인터페이스는 데이터를 저장할 수 없기 때문에 데이터를 저장할 인스턴스 또는 정적 필드를 선언할 수 없다.
    //              인터페이스에 선언된 필드는 모두 public static final 의 특성을 갖는다. 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.
    int MAX_VOLUME = 10;

    // 추상 메소드 선언: 인터페이스에 선언된 추상 메소드는 모두 public abstract 특성을 갖기 때문에 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.
    //               인터페이스의 모든 메소드는 기본적으로 public 접근 제한을 갖기 때문에 public 보다 더 낮은 접근 제한으로 작성할 수 없다.
    void turnOn();

    void setVolume(int volume);

    // 디폴트 메소드 선언: 자바 8에서 추가된 세로운 멤버. 형태는 클래스의 인스턴스 메소드와 동일한데, default 키워드가 리턴 타입 앞에 붙는다.
    //                 public 특성을 갖기 때문에 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.
    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리!");   // 실행 내용까지 작성.
        } else {
            System.out.println("무음 해제!");
        }
    }

    // 정적 메소드 선언: 자바 8에서 추가된 새로운 멤버. 형태는 클래스의 정적 메소드와 완전 동일.
    //               public 특성을 갖기 때문에 생략하더라도 자동적으로 컴파일 과정에서 붙게 된다.
    static void changeBattery() {
        System.out.println("건전지 교환!");
    }
}