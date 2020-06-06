package _4_conditionAndLoop._1_conditionalStatements;

// switch: if문 처럼 조건식이 true 일 경우가 아니라 어떤 값을 갖느냐에 따라 선택된다.
//         break 는 다음 case 실행하지 말고 빠져나가기 위해. 없으면 밑에 case 값 상관없이 다 실행된다.
public class IfAndSwitchEx1 {
    public static void main(String[] args) {
        char grade = 'B';

        switch (grade) {
            case 'B':
            case 'b':
                System.out.println("but practice more!");
            case 'A':
                System.out.println("excellent!");
                if (grade != 'A') {
                    System.out.println("grade: " + grade);
                }
            default:
                System.out.println("do hard!");
                break;
        }
    }
}
