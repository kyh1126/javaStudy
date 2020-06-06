package _8_interface._3_interfaceInheritance;

// 인터페이스 상속: 인터페이스는 클래스와 달리 다중 상속을 허용한다.
public class InterfaceInheritanceEx1 {
    public static void main(String[] args) {
        ImplementationC impl = new ImplementationC();

        InterfaceA ia = impl;
        ia.methodA();
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();

        InterfaceB b = new ImplementationB();
        b.methodB();
    }
}
