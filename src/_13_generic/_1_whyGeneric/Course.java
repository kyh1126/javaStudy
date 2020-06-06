package _13_generic._1_whyGeneric;

public class Course<T> {
    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;
        // 타입 파라미터로 배열을 생성하려면 new T[] 형태로 배열을 생성할 수 없고 아래와 같이 해야한다.
        this.students = (T[]) (new Object[capacity]);
    }

    public String getName() {
        return name;
    }

    public T[] getStudents() {
        return students;
    }

    public void add(T... t) {
        int cnt = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = t[cnt];
                if (cnt == (t.length - 1)) {
                    break;
                }
                cnt++;
            }
        }
    }
}
