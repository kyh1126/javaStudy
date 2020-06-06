package _9_nestedClassAndInterface._4_anonymousObject;

public class Anonymous {
    Person field = new Person() {
        void work() {
            System.out.println("일하러가지롱~");
        }

        @Override
        void wake() {
            System.out.println("6시에 일어납니다.");
        }
    };

    void method1() {
        Person localVar = new Person() {
            void walk() {
                System.out.println("걷지롱~");
            }

            @Override
            void wake() {
                System.out.println("로컬은 일찍일어나나?");
                walk();
            }
        };
        localVar.wake();
    }

    void method2(Person person) {
        person.wake();
    }
}
