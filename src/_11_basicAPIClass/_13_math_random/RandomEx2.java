package _11_basicAPIClass._13_math_random;

import java.util.Arrays;
import java.util.Random;

// java.util.Random 클래스: 난수를 얻어내기 위함. boolean, int, long, float, double 난수를 얻을 수 있다.
//                        종자값(seed)을 설정할 수 있다. 난수를 만드는 알고리즘에 사용되는 값으로 종자값이 같으면 같은 난수를 얻는다.
// Random 객체를 생성하는 방법
// -------------------------------------------------------------------------------
// 생성자                  설명
// -------------------------------------------------------------------------------
// Random()             호출 시마다 다른 종자값(현재시간 이용)이 자동 설정된다. 종자값 같으면 동일 난수 생성.
// Random(long seed)    매개값으로 주어진 종자값이 설정된다.
// -------------------------------------------------------------------------------

// Random 클래스가 제공하는 메소드
// -------------------------------------------------------------------------------
// 리턴값      메소드(매개 변수)  설명
// -------------------------------------------------------------------------------
// boolean  nextBoolean()   boolean 타입의 난수를 리턴
// double   nextDouble()    double 타입의 난수를 리턴(0.0 <= ~ < 1.0)
// int      nextInt()       int 타입의 난수를 리턴(-2^31 <= ~ <= 2^31-1)
// int      nextInt(int n)  int 타입의 난수를 리턴(0 <= ~ < n)
// -------------------------------------------------------------------------------

public class RandomEx2 {
    public static void main(String[] args) {
        // 선택번호
        int[] select = new int[6];
        Random r = new Random(3);
        System.out.println("선택 번호: ");
        for (int i = 0; i < 6; i++) {
            select[i] = r.nextInt(45) + 1;
            System.out.print(select[i] + " ");
        }
        System.out.println();

        int[] win = new int[6];
        Random winR = new Random(5);
        System.out.println("우승 번호: ");
        for (int i = 0; i < 6; i++) {
            win[i] = winR.nextInt(45) + 1;
            System.out.print(win[i] + " ");
        }
        System.out.println();

        // 당첨여부
        Arrays.sort(select);
        Arrays.sort(win);
        if (Arrays.equals(select, win)) {
            System.out.println("1등 당첨!!");
        } else {
            System.out.println("꽝");
        }
    }
}
