package _4_conditionAndLoop._2_loopStatements;

import java.io.IOException;

//                              (증감 후 2로 간다)
//  for (1. 초기화식; 2. 조건식; 4. 증감식){
//      3. 실행문 (2 true 일 경우 실행)
//  }
public class ForAndWhileEx1 {
    public static void main(String[] args) throws IOException {
        for (int i = 1, j = 0; i < 50 && (i % 3 > 0); i += j, i++, j++) {
            System.out.println("i: " + i + ", j: " + j);
        }

        boolean run = true;
        int speed = 0;
        int keyCode = 0;

        while (run) {
            if (keyCode != 13 && keyCode != 10) {
                System.out.println("1.증속, 2.감속, 3.중지");
                System.out.println("선택: ");
            }
            keyCode = System.in.read();

            switch (keyCode) {
                case 49:
                    speed++;
                    System.out.println("현재 속도: " + speed);
                    break;
                case 50:
                    speed--;
                    System.out.println("현재 속도: " + speed);
                    break;
                case 51:
                    run = false;
                    System.out.println("종료");
                    break;
            }
        }

        Outter:
        for (char upper = 'A'; upper <= 'C'; upper++) {
            for (char lower = 'a'; lower <= 'h'; lower++) {
                if (lower > 'b' && lower < 'f') {
                    continue;
                }
                System.out.println(upper + "-" + lower);
                if (lower == 'g') {
                    break Outter;
                }
            }
        }
        System.out.println("라벨 종료");
    }
}
