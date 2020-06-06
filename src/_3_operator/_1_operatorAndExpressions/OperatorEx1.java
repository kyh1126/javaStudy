package _3_operator._1_operatorAndExpressions;

// -------------------------------------------------------------------------------
// 연산자종류    연산자                     기능 설명
// -------------------------------------------------------------------------------
// 산술       + - * / %               사칙연산 및 나머지 계산
// 부호       + -                     음수 양수의 부호
// 문자열      +                       두 문자열을 연결
// 대입       = += -= *= /= %= &=     우변의 값을 좌변의 변수에 대입
//          ^= |= <<= >>= >>>=
// 증감       ++ --                   1 만큼 증가/감소
// 비교       == != > < >= <=         값의 비교
//          instanceof
// 논리       ! & | && ||             논리적 NOT, AND, OR 연산
// 조건       (조건식) ? A : B          조건식에 따라 A 또는 B 중 하나를 선택
// 비트       ~ & | ^                 비트 NOT, AND, OR, XOR 연산
// 쉬프트      >> << >>>               비트를 좌측/우측으로 밀어서 이동

// 연산자 우선순위 표
// -------------------------------------------------------------------------------
// 연산자                                      연산 방향    우선순위
// -------------------------------------------------------------------------------
// 증감(++ --), 부호(+ -), 논리(!)                  <         1
// 산술(* / %)                                    >         2
// 산술(+ -)                                      >         3
// 쉬프트(<< >> >>>)                               >         4
// 비교(< > <= >= instanceof)                     >         5
// 비교(== !=)                                    >         6
// 논리(&)                                        >         7
// 논리(^)                                        >         8
// 논리(|)                                        >         9
// 논리(&&)                                       >         10
// 논리(||)                                       >         11
// 조건(?:)                                       >         12
// 대입(= += -= *= /= %= &= ^= |= <<= >>= >>>=)   <         13
public class OperatorEx1 {
    public static void main(String[] args) {
        byte b = 1;
        System.out.println("b: " + Integer.toBinaryString(b));
        // 비트 반전 연산자: 정수 타입의 피연산자에만 사용되며 최상위 비트 포함 모든 비트가 반전된다.
        //               연산을 수행하기 전에 int 보다 작은 타입은 int 타입으로 변환되고 반전이 일어나서 결과는 int 타입이다.
        System.out.println("b: " + Integer.toBinaryString(~b));
        System.out.println("b: " + ~b);

        // % 연산자: 나머지 리턴
        int res = 10 % 3;
        System.out.println("res: " + res);

        // 리터럴 간의 연산은 타입 변환 없이 해당 타입으로 계산.
        char c1 = 'A' + 1;
        char c2 = 'A';
        // c2는 int 타입으로 변환되고 1과 연산이 되어 int 타입이 된다. 강제 타입 변환을 해서 char 로 얻을 수 있다.
//        char c3 = c2 + 1;
    }
}
