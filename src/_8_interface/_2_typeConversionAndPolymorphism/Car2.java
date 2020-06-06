package _8_interface._2_typeConversionAndPolymorphism;

public class Car2 {
    Tire[] tires = {new HankookTire(), new HankookTire(), new HankookTire(), new HankookTire()};

    void run() {
        for (Tire tire : tires) {
            tire.roll();
        }
    }
}
