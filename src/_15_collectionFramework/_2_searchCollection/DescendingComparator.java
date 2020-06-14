package _15_collectionFramework._2_searchCollection;

import _15_collectionFramework._1_collectionFramework.Student;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.sno < o2.sno) return 1;
        else if (o1.sno > o2.sno) return -1;
        return 0;
    }
}
