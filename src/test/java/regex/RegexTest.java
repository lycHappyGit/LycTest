package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void test(){
        String s1 = "/test/test1/adf.abc";
        String s2 = "/swagger-resources";
        String s3 = "123";
        String regex = "/swagger-resources[\\w\\W]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(s1);
        Matcher matcher2 = pattern.matcher(s2);
        Matcher matcher3 = pattern.matcher(s3);
        boolean matches1 = matcher1.matches();
        boolean matches2 = matcher2.matches();
        boolean matches3 = matcher3.matches();
        System.out.println("------------" + matches1);
        System.out.println("------------" + matches2);
        System.out.println("------------" + matches3);
    }

}
