package _6_class._5_package;

// 패키지: 클래스의 일부분이다. 클래스를 유일하게 만들어주는 식별자 역할을 한다. 클래스의 전체 이름은 패키지명+클래스명.

// 패키지 이름
// 1. 숫자로 시작해서는 안 되고, _ $ 를 제외한 특수 문자를 사용해서는 안 된다.
// 2. java 로 시작하는 패키지는 자바 표준 API 에서만 사용하므로 사용해서는 안 된다.
// 3. 모두 소문자로 작성하는 것이 관례이다.
// 도메인 이름으로 패키지 이름을 만들 경우, 도메인 이름 역순으로 패키지 이름을 지어준다. ex> com.lg.projectname

// 패키지 폴더가 자동으로 생성되려면 javac 명령어 다음에 -d 옵션을 추가하고 패키지가 생성될 경로를 다음과 같이 지정해야 한다.
// javac -d . ClassName.java : 현재 폴더 내에 생성
// javac -d C:\Temp\bin ClassName.java : C:\Temp\bin 폴더에 생성
// 이렇게 생성된 패키지에 소속된 클래스를 명령 프롬프트에서 실행하려면 바이트 코드 파일이 있는 폴더에서 java 명령어를 사용하면 안된다.
// 패키지는 클래스의 일부분이므로 패키지가 시작하는 폴더에서 java 명령어를 사용해야 한다.
// /Users/kim-yoonhee/IdeaProjects/javaProject/out/production/javaProject> java _4_conditionAndLoop._2_loopStatements.ForAndWhileEx1

// 패키지 이름 전체를 기술하는게 필요한 경우는 서로 다른 패키지에 동일한 클래스 이름이 존재하고, 두 패키지가 모두 import 되어 있을 경우이다.
public class PackageEx1 {
}
