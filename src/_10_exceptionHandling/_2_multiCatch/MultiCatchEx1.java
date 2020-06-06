package _10_exceptionHandling._2_multiCatch;

// catch 순서: 상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치해야 한다.
// 멀티 catch: 자바 7부터 하나의 catch 블록에서 여러 예외를 처리할 수 있다.
public class MultiCatchEx1 {
    public static void main(String[] args) {
        // 1
        try {
            String s1 = args[0];
            System.out.println(Integer.parseInt(s1));
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("매개값 수 부족");
        } catch (Exception e2) {
            System.out.println("문제가 있다.");
        }

        // 2
        try {
            String s1 = "a1";
            System.out.println(Integer.parseInt(s1));
        }catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("매개값 수가 부족하거나 숫자변환 불가");
        }catch (Exception e2){
            System.out.println("예외 발생");
        }
    }
}
