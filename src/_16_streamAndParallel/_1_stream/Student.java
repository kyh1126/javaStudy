package _16_streamAndParallel._1_stream;

public class Student {
    private Course course;
    private String name;
    private int score;
    private City city;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, Course course) {
        this.name = name;
        this.score = score;
        this.course = course;
    }

    public Student(String name, int score, Course course, City city) {
        this.name = name;
        this.score = score;
        this.course = course;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Course getCourse() {
        return course;
    }

    public enum Course {
        KOREAN, MATH, ENGLISH
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public enum City {
        SEOUL, PUSAN;
    }

    public City getCity() {
        return city;
    }
}
