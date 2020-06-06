package _14_lambdaExpression._2_useInLambdaExpression;

import _14_lambdaExpression._1_lambdaExpression.MyFunctionalInterface;

public class UsingLocalVariable {
    // 아래에서 사용되게 되면.. arg 는 final 특성을 가짐
    void method(int arg) {
        // localVar 는 final 특성을 가짐
        int localVar = 40;

        // final 특성 때문에 수정 불가
//        arg = 30;

        MyFunctionalInterface fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar: " + localVar);
        };
        fi.method();
    }
}
