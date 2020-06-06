package _6_class._2_objectAndClass;

public class Car {
    int doorCnt = 4;
    int speed = 10;

    public Car() {
    }

    public Car(int doorCnt) {
        this.doorCnt = doorCnt;
    }

    public Car(int doorCnt, int speed) {
        this(doorCnt);
        this.speed = speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }
}

//public class Tire {
//}

class Tire {
}