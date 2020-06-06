package _8_interface._2_typeConversionAndPolymorphism;

public class Bus implements Vehicle {
    @Override
    public void run() {
        System.out.println("버스가 달린다.");
    }

    void checkFare() {
        System.out.println("요금을 체크!");
    }
}
