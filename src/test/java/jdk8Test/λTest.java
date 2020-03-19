package jdk8Test;

import org.junit.Test;

public class λTest {

    @Test
    public void test(){
        MathOperation addition = (int a, int b) -> a + b;
        int operate = operate(5, 10, addition);
        System.out.println(operate);
    }

    @Test
    public void test2(){
        MathOperation subtraction = (int a, int b) -> a - b;
        int operate = operate(5, 10, subtraction);
        System.out.println(operate);
    }

    @Test
    public void test3(){
        MathOperation multiplication = (int a, int b) -> a * b;
        int operate = operate(5, 10, multiplication);
        System.out.println(operate);
    }


    interface MathOperation{
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}