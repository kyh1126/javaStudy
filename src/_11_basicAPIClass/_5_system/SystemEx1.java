package _11_basicAPIClass._5_system;

// System 클래스: 자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니라 JVM 위에서 실행된다. 따라서 운영체제의 모든 기능을 자바 코드로 직접 접근하기란
//              어렵다. 하지만 java.lang 패키지에 속한 System 클래스를 이용하면 OS 일부 기능을 이용할 수 있다. 프로그램 종료, 키보드로부터 입력,
//              모니터로 출력, 메모리 정리, 현재 시간 읽기, 시스템 프로퍼티 읽기, 환경변수 읽기 등이 가능하다. System 클래스의 모든 필드와 메소드는
//              정적 필드, 정적 메소드로 구성되어 있다.

// 1. 프로그램 종료(exit()): 강제적으로 JVM 종료. 현재 실행하고 있는 프로세스를 강제 종료시키는 역할을 한다. exit() 메소드는 init 매개값을 지정하도록
//                       되어있는데, 이 값을 종료 상태값이라고 한다. 일반적으로 정상 종료일 경우 0, 비정상 종료일 경우 그 외의 값을 준다. 어떤 값을
//                       주더라도 종료가 되는데, 만약 특정 값이 입력된 경우만 종료하고 싶다면 자바의 보안 관리자를 직접 설정해서 종료 상태값을 확인하면
//                       된다. System.exit()이 실행되면 보안 관리자의 checkExit()메소드가 자동 호출되는데, 이 메소드에서 종료 상태값을 조사해서
//                       특정 값이 입력되지 않으면 SecurityException 을 발생시켜 System.exit()을 호출한 곳에서 예외 처리 하게 해준다.

// 2. 쓰레기 수집기 실행(gc()): JVM 은 메모리가 부족할 때와 CPU 가 한가할 때에 쓰레기 수집기를 실행시켜 사용하지 않는 객체를 자동 제거한다. 참조를 잃은
//                         힙 영역 객체는 쓰레기 객체가 된다. System.gc()가 호출되면 쓰레기 수집기가 바로 실행되지는 않지만, JVM 은 빠른 시간 내에
//                         실행시키기 위해 노력한다.

// 3. 현재 시각 읽기(currentTimeMillis(), nanoTime()):
//    컴퓨터의 시계로부터 현재 시간을 읽어 밀리세컨드(1/1000초) 단위와 나노세컨드(1/10^9초) 단위의 long 값을 리턴.

// 4. 시스템 프로퍼티 읽기(getProperty()):
//    시스템 프로퍼티는 JVM 이 시작할 때 자동 설정되는 시스템의 속성값을 말한다. OS 종류 및 자바 프로그램 실행시킨 사용자 아이디, JVM 버전, OS 에서
//    사용되는 파일 경로 구분자 등.
// -------------------------------------------------------------------------------
// 키(key)           설명                          값(value)
// -------------------------------------------------------------------------------
// java.version     자바의 버전                      1.8.0_20
// java.home        사용하는 JRE 의 파일 경로          <jdk 설치 경로>\jre
// os.name          OS 이름                        Windows 7
// file.separator   File separator("/" on UNIX)   \
// user.name        사용자의 이름                    사용자계정
// user.home        사용자의 홈 디렉토리               C:\Users\사용자계졍
// user.dir         사용자가 현재 작업 중인 디렉토리 경로  다양
// -------------------------------------------------------------------------------

// 5. 환경 변수 읽기(getenv()):
//    환경 변수는 실행되는 프로그램들에게 유용한 정보를 제공할 목적이다. 프로그램상 변수가 아니라 OS 에서 이름과 값으로 관리되는 문자열 정보다.
//    OS 가 설치될 때 기본적인 내용이 설정되고, 사용자가 직접 설정하거나 응용 프로그램이 설치될 때 자동적으로 추가 설정 되기도 한다.
public class SystemEx1 {
    public static void main(String[] args) {
        // 1
        // 종료 상태값 5 입력되면 JVM 종료하도록 보안 관리자 설정.
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkExit(int status) {
                if (status != 5) {
                    throw new SecurityException();
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
//                System.exit(i);
            } catch (SecurityException e) {
            }
        }

        // 2
        Employee emp;
        emp = new Employee(1);
        emp = null;
        emp = new Employee(2);
        System.gc();

        // 3
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.print("");
        }
        long time2 = System.nanoTime();
        System.out.println(time2 - time1);

        // 4
        System.out.println("OS 이름: " + System.getProperty("os.name"));
//        System.getProperties().keySet().forEach(System.out::println);

        // 5
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
    }
}

class Employee {
    public int eno;

    public Employee(int eno) {
        this.eno = eno;
        System.out.println("Employee(" + eno + ") 가 메모리에 생성됨");
    }

    public void finalize() {
        System.out.println("Employee(" + eno + ") 가 메모리에서 제거됨");
    }
}
