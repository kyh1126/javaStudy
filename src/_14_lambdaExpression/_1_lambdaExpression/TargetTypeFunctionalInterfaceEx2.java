package _14_lambdaExpression._1_lambdaExpression;

// 타겟 타입과 함수적 인터페이스
// 자바는 메소드를 단독 선언할 수 없고 클래스의 구성 멤버로 선언하기 때문에 람다식은 단순히 메소드를 선언하는 것이 아니라 이 메소드를 가지고 있는 객체를 생성해낸다.
// 인터페이스 변수 = 람다식;
// 람다식은 인터페이스의 익명 구현 객체를 생성한다. 인터페이스는 직접 객체화할 수 없기 때문에 구현 클래스가 필요한데, 람다식은 익명 구현 클래스를 생성하고 객체화한다.
// 람다식이 대입될 인터페이스를 람다식의 타겟 타입(target type)이라고 한다.

// 함수적 인터페이스(@FunctionalInterface): 하나의 추상 메소드가 선언된 인터페이스.
// 람다식이 하나의 메소드를 정의하기 때문에 2개 이상의 추상 메소드가 선언된 인터페이스는 람다식을 이용해 구현 객체를 생성할 수 없다.
// @FunctionalInterface 어노테이션은 함수적 인터페이스를 작성할 때 2개 이상의 추상 메소드가 선언되지 않도록 컴파일러가 체킹해준다.
public class TargetTypeFunctionalInterfaceEx2 {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        // 1. 매개변수와 리턴값이 없는 람다식
        fi = () -> {
            System.out.println("method called!");
        };
        fi.method();
        fi.method();

        fi = () -> System.out.println("remove {}");
        fi.method();

        // 2. 매개변수가 있는 람다식
        MyFunctionalInterface2 fi2;
        fi2 = (x) -> {
            System.out.println(x + 5);
        };
        fi2.method(3);

        fi2 = x -> System.out.println(x - 2);
        fi2.method(4);

        // 3. 리턴값이 있는 람다식
        MyFunctionalInterface3 fi3;
        fi3 = (x, y) -> {
            return x + y;
        };
        fi3.method(3, 4);

        fi3 = (x, y) -> x + y;
        fi3.method(3, 4);
    }
}
