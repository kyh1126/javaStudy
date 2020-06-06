package _13_generic._1_whyGeneric;

import _8_interface._1_interface.Tv;
import _8_interface._2_typeConversionAndPolymorphism.Car;

// 제네릭 타입은 2개 이상의 멀티 타입 파라미터를 사용할 수 있는데, 각 타입 파라미터를 콤마로 구분한다.
public class MultiTypeParameterEx3 {
    public static void main(String[] args) {
        Product<Tv, String> p1 = new Product<Tv, String>();
        p1.setKind(new Tv());
        p1.setModel("스마트 TV");

        // 자바 7부터는 다이아몬드 연산자를 사용해서 간단하게 작성할 수 있다.
        Product<Car, String> p2 = new Product<>();
        p2.setKind(new Car());
        p2.setModel("스마트 카");

    }
}
