package _11_basicAPIClass._10_regex;

// Regex 기본 기호들
// -------------------------------------------------------------------------------
// 기호       설명
// -------------------------------------------------------------------------------
// []       한 개의 문자 | [abc]     a, b, c 중 하나의 문자
//                    | [^abc]    a, b, c 이외의 하나의 문자
//                    | [a-zA-Z]  a~z, A~Z 중 하나의 문자
// \d       한 개의 숫자, [0-9]와 동일.
// \s       공백
// \w       한 개의 알파벳 또는 한 개의 숫자, [a-zA-Z_0-9]와 동일
// ?        없음 또는 한 개
// *        없음 또는 한 개 이상
// +        한 개 이상
// {n}      정확히 n개
// {n,}     최소 n개
// {n, m}   n ~ m개
// ()       그룹핑
// -------------------------------------------------------------------------------

import java.util.regex.Pattern;

public class RegexEx1 {
    public static void main(String[] args) {
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        if (Pattern.matches(regExp, "010-123-1234")) {
            System.out.println("정규식 일치");
        } else {
            System.out.println("정규식 일치 x");
        }

        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        if (Pattern.matches(regExp, "abc@naver.com")) {
            System.out.println("정규식 일치");
        } else {
            System.out.println("정규식 일치 x");
        }
    }
}
