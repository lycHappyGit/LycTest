package genType;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 泛型擦除测试
 */
public class GenTypeTest {

    private GenTypeTest genTypeTest;

    @Before
    public void begin(){
        if(genTypeTest == null){
            genTypeTest = new GenTypeTest();
        }
    }


    public void say(Object obj){
        System.out.println("it is Object !");
    }

    public void say(String str){
        System.out.println("it is String !");
    }

    @Test
    public void test(){
        genTypeTest.say(null);
    }
}
