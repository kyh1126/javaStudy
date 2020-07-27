package _16_streamAndParallel._2_streamCollect;

import _16_streamAndParallel._1_stream.Student;

import java.util.ArrayList;
import java.util.List;

public class MathStudent {
    private List<Student> list;

    public MathStudent() {
        list = new ArrayList<Student>();
        System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
    }

    public void accumulate(Student student) {
        list.add(student);
        System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
    }

    public void combine(MathStudent other) {
        list.addAll(other.getList());
        System.out.println("[" + Thread.currentThread().getName() + "] combine()");
    }

    public List<Student> getList() {
        return list;
    }
}
