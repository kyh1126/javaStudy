package _3_operator._1_operatorAndExpressions;

import java.time.LocalDateTime;

// 대입 연산자: 오른쪽 피연산자의 값을 좌측 피연산자인 변수에 저장한다.
//           피연산자는 리터럴 및 변수, 다른 연산식이 올 수 있다.
// -------------------------------------------------------------------------------
// 구분           연산식             설명
// -------------------------------------------------------------------------------
// 단순 대입 연산자  변수 = 피연산자     피연산자의 값을 변수에 저장
// -------------------------------------------------------------------------------
// 복합 대입 연산자  변수 += 피연산자    피연산자의 값을 변수의 값과 더한 후 다시 변수에 저장
//               변수 -= 피연산자     "                    뺀 후 "
//               변수 *= 피연산자     "                   곱한 후 "
//               변수 /= 피연산자     "                   나눈 후 "
//               변수 %= 피연산자     "                   나눈 후 나머지를 변수에 저장
//               변수 &= 피연산자     "                  & 연산 후 결과를 변수에 저장
//               변수 |= 피연산자     "                  | 연산 후 결과를 변수에 저장
//               변수 ^= 피연산자     "                  ^ 연산 후 결과를 변수에 저장
//               변수 <<= 피연산자    "                  << 연산 후 결과를 변수에 저장
//               변수 >>= 피연산자    "                  >> 연산 후 결과를 변수에 저장
//               변수 >>>= 피연산자   "                >>> 연산 후 결과를 변수에 저장
// -------------------------------------------------------------------------------
// 삼항 연산자: 조건식에 따라 앞,뒤의 피연산자가 선택된다. 조건 연산식이라고 부르기도 한다.
public class AssignmentAndTernaryOperatorEx4 {
    public static void main(String[] args) {
        int res = 2;
        res <<= 2;
        System.out.println(res);

        System.out.println("저녁밥? " + ((LocalDateTime.now().getHour() > 18) ? "먹어야지!" : "때가 아니다."));
    }
}
