package _15_collectionFramework._3_LIFO_FIFO;

import java.util.Stack;

// LIFO(Last In First Out): 나중에 넣은 객체가 먼저 빠져나가는 자료구조.
// 스택(Stack): 대표적인 예가 JVM 스택 메모리. 스택 메모리에 저장된 변수는 나중에 저장된 것부터 제거된다.
// Stack 클래스의 주요 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드             설명
// -------------------------------------------------------------------------------
// E        push(E item)    주어진 객체를 스택에 넣는다.
// E        peek()          스택의 맨 위 객체를 가져온다. 객체를 스택에서 제거하지 않는다.
// E        pop()           스택의 맨 위 객체를 가져온다. 객체를 스택에서 제거한다.
// -------------------------------------------------------------------------------
public class StackEx1 {
    public static void main(String[] args) {
        Stack<Coin> coinBox = new Stack<>();
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));

        while (!coinBox.empty()) {
            System.out.println(coinBox.pop().getValue());
        }
    }
}
