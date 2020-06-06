package _6_class._3_static;

// 싱글톤(Singleton): 전체 프로그램에서 단 하나의 객체만 만들도록 보장해야 하는 경우의 객체.
//                  클래스 외부에서 new 연산자로 생성자를 호출할 수 없도록 생성자 앞에 private 로 막아야 한다.
//                  그 후 정적 메소드 getInstance()로 정적 필드에서 참조하고 있는 자신의 객체를 리턴해준다.
public class SingletonEx2 {
    private static SingletonEx2 singleton = new SingletonEx2();

    private SingletonEx2() {
    }

    static SingletonEx2 getInstance() {
        return singleton;
    }

}

class main {
    public static void main(String[] args) {
        SingletonEx2 s1 = SingletonEx2.getInstance();
        SingletonEx2 s2 = SingletonEx2.getInstance();
//        SingletonEx2 s = new SingletonEx2();  // error

        System.out.println(s1 == s2);
    }
}