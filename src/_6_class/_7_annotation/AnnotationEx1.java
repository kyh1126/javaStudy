package _6_class._7_annotation;

// 어노테이션(Annotation): 메타데이터(metadata)라고 볼 수 있다.
//                      메타데이터란 애플리케이션이 처리해야 할 데이터가 아니라, 컴파일 과정과 실행 과정에서 코드를 어떻게 컴파일하고 처리할 것인지 알려주는 정보.
// 1. 컴파일러에게 코드 문법 에러를 체크하도록 정보를 제공
// 2. 소프트웨어 개발 툴이 빌드나 배치 시 코드를 자동으로 생성할 수 있도록 정보를 제공
// 3. 실행 시(런타임 시) 특정 기능을 실행하도록 정보를 제공
// 빌드 시 자동으로 XML 설정 파일을 생성하거나, 배포를 위해 JAR 압축 파일을 생성하는데에도 사용된다. 실행 시 클래스의 역할을 정의하기도 한다.

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.IntStream;

// 예시 >
// 1. @Override: 컴파일러에게 코드 문법 에러를 체크하도록 정보를 제공하는 어노테이션. 메소드 선언 시 사용. 메소드가 오버라이드(재정의)된 것임을 컴파일러에게
//               알려주어 컴파일러가 오버라이드 검사를 하도록 해준다. 정확히 오버라이드 되지 않았다면 컴파일러는 에러를 발생시킨다.
public class AnnotationEx1 {
    @PrintAnnotation
    public void method1() {
        System.out.println("실행 내용1");
    }

    @PrintAnnotation("*")
    public void method2() {
        System.out.println("실행 내용2");
    }

    @PrintAnnotation(value = "#", number = 20)
    public void method3() {
        System.out.println("실행 내용3");
    }

    public static void main(String[] args) {
        // AnnotationEx1 클래스에 선언된 메소드 얻기(리플렉션)
        Method[] declaredMethods = AnnotationEx1.class.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);

        Arrays.stream(declaredMethods).forEach(m -> {
            if (m.isAnnotationPresent(PrintAnnotation.class)) {
                // PrintAnnotation 객체 얻기
                PrintAnnotation annotation = m.getAnnotation(PrintAnnotation.class);

                // 메소드 이름 출력
                System.out.println(String.format("[%s]", m.getName()));

                // 구분선 출력
                IntStream.range(0, annotation.number()).forEach(i -> {
                    System.out.print(annotation.value());
                });
                System.out.println();

                try {
                    // 메소드 호출
                    m.invoke(new AnnotationEx1());
                } catch (Exception e) {
                    System.out.println();
                }
            }

        });
    }
}
