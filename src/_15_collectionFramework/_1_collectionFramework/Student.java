package _15_collectionFramework._1_collectionFramework;

import java.util.Objects;

public class Student {
    public int sno;
    public String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student student = (Student) o;
            return sno == student.sno && Objects.equals(name, student.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return sno + name.hashCode();
    }
}
