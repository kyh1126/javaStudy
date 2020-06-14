package _15_collectionFramework._4_synchronizedCollection;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

// Synchronized 컬렉션은 하나의 스레드가 요소를 처리할 때 전체 잠금이 발생하여 다른 스레드는 대기 상태가 된다. 그렇기 때문에 멀티 스레드가 병렬적으로
// 빠르게 컬렉션의 요소들을 처리할 수 없다. concurrent 패키지의 ConcurrentHashMap 과 ConcurrentLinkedQueue 제공한다.
// ConcurrentHashMap: 부분(segment) 잠금을 사용하여, 컬렉션 10개 요소가 저장되있을 경우, 1개를 처리할 동안 전체 10개의 요소를 다른 스레드가
//                    처리하지 못하게 하는 것이 전체 잠금이라면, 처리하는 요소가 포함된 부분만 잠금하고 나머지 부분은 다른 스레드가 변경할 수 있도록 하는
//                    것이 부분 잠금이다. 하지만 자바 1.8부터 Segment 클래스 대신 Node & TreeBin 콤비네이션으로 바뀌었다.
// https://kkewwei.github.io/elasticsearch_learning/2017/11/05/ConcurrentHashMap-put%E8%BF%87%E7%A8%8B%E4%BB%8B%E7%BB%8D/
// https://github.com/CL0610/Java-concurrency/blob/master/14.%E5%B9%B6%E5%8F%91%E5%AE%B9%E5%99%A8%E4%B9%8BConcurrentHashMap(JDK%201.8%E7%89%88%E6%9C%AC)/%E5%B9%B6%E5%8F%91%E5%AE%B9%E5%99%A8%E4%B9%8BConcurrentHashMap(JDK%201.8%E7%89%88%E6%9C%AC).md
// https://programmer.group/concurrent-hashmap-source-detailed-analysis-jdk-1.8.html
// ConcurrentLinkedQueue: 락-프리(lock-free) 알고리즘을 구현한 컬렉션. 여러 개의 스레드가 동시에 접근할 경우, 잠금을 사용하지 않고도 최소한 하나의
//                        스레드가 안전하게 요소를 저장하거나 얻도록 해준다.
public class ConcurrentCollectionEx2 {
    public static void main(String[] args) {
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        Queue<String> concurrentQueue = new ConcurrentLinkedDeque<>();
    }
}
