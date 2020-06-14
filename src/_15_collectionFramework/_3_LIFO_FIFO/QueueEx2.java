package _15_collectionFramework._3_LIFO_FIFO;

import java.util.LinkedList;
import java.util.Queue;

// FIFO(First In First Out): 먼저 넣은 객체가 먼저 빠져나가는 자료구조.
// 큐(Queue): 대표적인 예가 스레드풀(ExecutorService)의 작업 큐이다. 작업 큐는 먼저 들어온 작업부터 처리한다.
//            Queue 인터페이스를 구현한 대표적인 클래스는 LinkedList 다. List 인터페이스를 구현했기 때문에 List 컬렉션이기도 하다.
// Queue 인터페이스의 주요 메소드들.
// -------------------------------------------------------------------------------
// 리턴 타입    메소드      설명
// -------------------------------------------------------------------------------
// boolean  offer(E e)  주어진 객체를 넣는다.
// E        peek()      객체 하나를 가져온다. 객체를 큐에서 제거하지 않는다.
// E        poll()      객체 하나를 가져온다. 객체를 큐에서 제거한다.
// -------------------------------------------------------------------------------
public class QueueEx2 {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();
        messageQueue.offer(new Message("sendSms", "saram4"));
        messageQueue.offer(new Message("sendMail", "saram1"));
        messageQueue.offer(new Message("sendSms", "saram2"));
        messageQueue.offer(new Message("sendKakaotalk", "saram3"));

        while (!messageQueue.isEmpty()) {
            Message m = messageQueue.poll();
            switch (m.command) {
                case "sendSms":
                    System.out.println(m.to + "님께 문자를 보냅니다.");
                    break;
                case "sendMail":
                    System.out.println(m.to + "님께 메일을 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(m.to + "님께 카톡을 보냅니다.");
                    break;
            }
        }
    }
}
