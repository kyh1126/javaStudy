package _13_generic._1_whyGeneric;

import _8_interface._1_interface.Tv;

// 제네릭 타입의 상속과 구현: 제네릭 타입도 부모 클래스가 될 수 있다. 자식 제네릭 타입은 추가적으로 타입 파라미터를 가질 수 있다.
public class GenericInheritanceEx7 {
    public static void main(String[] args) {
        ChildProduct<Tv, String, String> product = new ChildProduct<>();
        product.setKind(new Tv());
        product.setModel("Smart TV");
        product.setCompany("Samsung");

        Storage<Tv> storage = new StorageImpl<>(100);
        storage.add(new Tv(), 0);
        Tv tv = storage.get(0);
    }
}
