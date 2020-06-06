package _9_nestedClassAndInterface._4_anonymousObject;

public class Anonymous3 {
    private int field;

    public void method(final int arg1, int arg2) {
        final int var1 = 0;
        int var2 = 0;

        field = 10;

        // final 키워드로 인해 바로 할당 금지 표시가 뜬다.
//        arg1 = 20;
        // 익명 클래스 내부에서 쓰게되면 final 로 암묵적으로 되기 때문에 안된다.
//        arg2 = 20;

//        var1 = 30;
//        var2 = 30;

        Calculatable c = new Calculatable() {
            @Override
            public int sum() {
                int result = field + arg1 + arg2 + var1 + var2;
                return result;
            }
        };

        System.out.println(c.sum());
    }
}
