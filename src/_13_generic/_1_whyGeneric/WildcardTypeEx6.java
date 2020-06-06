package _13_generic._1_whyGeneric;

import java.util.Arrays;

// 와일드카드 타입: 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 구체적인 타입 대신에 와일드카드 사용.
// 1. 제네릭타입<?>: Unbounded Wildcards(제한 없음). 타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있다.
// 2. 제네릭타입<? extends 상위타입>: Upper Bounded Wildcards(상위 클래스 제한). 타입 파라미터를 대치하는 구체적인 타입으로 상위 타입이나 하위 타입만 올 수 있다.
// 3. 제네릭타입<? super 하위타입>: Lower Bounded Wildcards(하위 클래스 제한). 타입 파라미터를 대치하는 구체적인 타입으로 하위 타입이나 상위 타입만 올 수 있다.

// Bounded type parameter VS Bounded wildcard
// : https://stackoverflow.com/questions/3486689/java-bounded-wildcards-or-bounded-type-parameter

// 예시 >
// Person
// Worker   Student
//          HighStudent
public class WildcardTypeEx6 {
    // 모든 과정
    public static void registerCourse(Course<?> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }

    // 학생 과정
    public static void registerCourseStudent(Course<? extends Student> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }

    // 직장인과 일반인 과정
    public static void registerCourseWorker(Course<? super Worker> course) {
        System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
    }


    public static void main(String[] args) {
        // Course<?>: 수강생은 모든 타입이 될 수 있다.
        // Course<? extends Student>: 수강생은 Student, HighStudent 만 될 수 있다.
        // Course<? super Worker>: 수강생은 Worker, Person 만 될 수 있다.
        Course<Person> personCourse = new Course<>("일반인과정", 5);
        personCourse.add(new Person("일반인"), new Worker("직장인"), new Student("학생"), new HighStudent("고등학생"));

        Course<Worker> workerCourse = new Course<>("직장인과정", 5);
        workerCourse.add(new Worker("직장인"));

        Course<Student> studentCourse = new Course<>("학생과정", 5);
        studentCourse.add(new Student("학생"), new HighStudent("고등학생"));

        Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
        highStudentCourse.add(new HighStudent("고등학생"));

        // 모든 과정 등록 가능
        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);
        System.out.println();

        // 학생 과정만 등록 가능
//        registerCourseStudent(personCourse);
//        registerCourseStudent(workerCourse);
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        // 직장인과 일반인 과정만 등록 가능
        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
//        registerCourseWorker(studentCourse);
//        registerCourseWorker(highStudentCourse);

    }
}
