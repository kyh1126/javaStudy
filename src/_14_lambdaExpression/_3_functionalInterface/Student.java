package _14_lambdaExpression._3_functionalInterface;

public class Student {
    private String name;
    private Sex sex;
    private int englishScore;
    private int mathScore;

    public Student(String name, int englishScore, int mathScore) {
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public Student(String name, String sex, int mathScore) {
        this.name = name;
        this.sex = Sex.fromCode(sex);
        this.mathScore = mathScore;
    }

    public String getName() {
        return name;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public Sex getSex() {
        return sex;
    }
}
