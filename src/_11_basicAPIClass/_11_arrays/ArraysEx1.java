package _11_basicAPIClass._11_arrays;

import java.util.Arrays;

// Arrays 클래스: 배열 조작 기능이 있다. 배열 조작이란 배열 복사, 항목 정렬, 항목 검색 기능을 말한다. 추가적으로 항목 정렬, 항목 검색, 항목 비교와 같은
//              기능을 제공해준다.(단순 배열 복사: System.arraycopy())
// Arrays 클래스 메소드들 (모두 static)
// -------------------------------------------------------------------------------
// 리턴 타입    메소드 이름                              설명
// -------------------------------------------------------------------------------
// int      binarySearch(배열, 찾는값)               전체 배열 항목에서 찾는 값이 있는 인덱스 리턴
// 타겟 배열  copyOf(원본배열, 복사할길이)                원본 배열의 0번 인덱스에서 복사할 길이만큼 복사한 배열 리턴, 복사할 길이는 원본 배열
//                                                길이보다 커도 되며, 타겟 배열의 길이가 된다.
// 타겟 배열  copyOfRange(원본배열, 시작인덱스, 끝인덱스)   원본 배열의 시작 인덱스에서 끝 인덱스까지 복사한 배열 리턴
// boolean  deepEquals(배열, 배열)                  두 배열의 깊은 비교(중첩 배열의 항목까지 비교)
// boolean  equals(배열, 배열)                      두 배열의 얕은 비교(중첩 배열의 항목은 비교하지 않음)
// void     fill(배열, 값)                          전체 배열 항목에 동일한 값을 저장
// void     fill(배열, 시작인덱스, 끝인덱스, 값)         시작 인덱스부터 끝 인덱스까지의 항목에만 동일한 값을 저장
// void     sort(배열)                             배열의 전체 항목을 오름차순으로 정렬
// String   toString(배열)                         "[값1, 값2, ...]"와 같은 문자열 리턴
// -------------------------------------------------------------------------------

// 1. 배열 복사: copyOf, copyOfRange. System.arraycopy()도 있다.
// 2. 배열 항목 비교: equals, deepEquals. equals()는 1차 항목의 값만 비교, deepEquals()는 1차 항목이 서로 다른 배열을 참조할 경우 중첩된
//                 배열의 항목까지 비교한다.
// 3. 배열 항목 정렬: 기본 타입 또는 String 배열은 Arrays.sort()의 매개값으로 지정해주면 자동으로 오름차순 정렬이 된다. 사용자 정의 클래스일 경우
//                 클래스가 Comparable 인터페이스를 구현하고 있어야 정렬된다. compareTo()는 오름차순일 때 자신이 매개값보다 낮을 경우 음수, 같을
//                 경우 0, 높을 경우 음수를 리턴하면 된다.
// 4. 배열 항목 검색: 특정 값이 위치한 인덱스를 얻는 것을 배열 검색이라 한다. 배열 항목을 검색하려면 먼저 Arrays.sort()로 항목을 오름차순 정렬 후
//                 Arrays.binarySearch()로 항목을 찾아야 한다.
public class ArraysEx1 {
    public static void main(String[] args) {
        // 1
        char[] arr1 = {'J', 'A', 'V', 'A'};
        // 방법1
        char[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr2));
        // 방법2
        char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);
        System.out.println(Arrays.toString(arr3));
        // 방법3
        char[] arr4 = new char[arr1.length];
        System.arraycopy(arr1, 0, arr4, 0, arr1.length);
        for (int i = 0; i < arr4.length; i++) {
            System.out.println("arr4[" + i + "] = " + arr4[i]);
        }

        // 2
        int[][] original = {{1, 2}, {3, 4}};
        System.out.println("[얕은 복제후 비교]");
        int[][] cloned1 = Arrays.copyOf(original, original.length);
        System.out.println("배열 번지 비교: " + original.equals(cloned1));
        System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original, cloned1));
        System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original, cloned1));

        System.out.println("[깊은 복제후 비교]");
        int[][] cloned2 = Arrays.copyOf(original, original.length);
        cloned2[0] = Arrays.copyOf(original[0], original[0].length);
        cloned2[1] = Arrays.copyOf(original[1], original[1].length);
        System.out.println("배열 번지 비교: " + original.equals(cloned2));
        System.out.println("1차 배열 항목값 비교: " + Arrays.equals(original, cloned2));
        System.out.println("중첩 배열 항목값 비교: " + Arrays.deepEquals(original, cloned2));

        // 3
        int[] scores = {99, 97, 98};
        Arrays.sort(scores);
        Arrays.stream(scores).forEach(System.out::println);
        Member m1 = new Member("제니");
        Member m2 = new Member("딴사람");
        Member[] m = {m1, m2};
        Arrays.sort(m);
        Arrays.stream(m).forEach(System.out::println);

        // 4
        int idx = Arrays.binarySearch(scores, 99);
        System.out.println("찾은 인덱스: " + idx);
        idx = Arrays.binarySearch(m, new Member("제니"));
        System.out.println("찾은 인덱스: " + idx);
    }
}
