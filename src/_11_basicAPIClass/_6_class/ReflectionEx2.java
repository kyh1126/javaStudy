package _11_basicAPIClass._6_class;

// 리플렉션(Reflection): Class 객체를 이용하면 클래스의 생성자, 필드, 메소드 정보를 알아낼 수 있다. Class 객체는 getDeclaredConstructor(),
//                    getDeclaredFields(), getDeclaredMethods()를 리플렉션 용으로 제공한다.(각 생성자, 필드, 메소드 배열을 리턴한다)
//                    이는 클래스에 선언된 멤버만 가져오고 상속된 public 멤버도 얻고 싶다면 getFields(), getMethods()를 이용해야 한다.

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx2 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("_6_class._2_objectAndClass.Car");
            System.out.println("클래스 이름: " + clazz.getName());
            System.out.println();

            System.out.println("[생성자 정보]");
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor c : constructors) {
                System.out.print(c.getName() + "(");
                Class[] parameterTypes = c.getParameterTypes();
                printParameters(parameterTypes);
                System.out.print(")");
            }
            System.out.println();

            System.out.println("[필드 정보]");
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f.getType().getSimpleName() + " " + f.getName());
            }
            System.out.println();

            System.out.println("[메소드 정보]");
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for(Method m: declaredMethods){
                System.out.print(m.getName()+"(");
                Class<?>[] parameterTypes = m.getParameterTypes();
                printParameters(parameterTypes);
                System.out.print(")");
            }
            System.out.println();

        } catch (ClassNotFoundException e) {
        }

    }

    private static void printParameters(Class[] parameterTypes) {
        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.print(parameterTypes[i].getName());
            if (i < parameterTypes.length - 1) {
                System.out.print(", ");
            }
        }
    }

}
