package _11_basicAPIClass._3_object;

import java.util.Objects;

public class Key {
    public int number;

    public Key(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Key) {
            Key compareKey = (Key) o;
            if (this.number == compareKey.number) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Key{" +
                "number=" + number +
                '}';
    }
}
