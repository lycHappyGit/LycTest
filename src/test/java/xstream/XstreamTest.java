package xstream;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xstream.bean.Customer;
import xstream.bean.User;

import java.util.ArrayList;
import java.util.List;

public class XstreamTest {
    
    //创建xStream对象
    private XStream xStream;

    @Before
    public void begin(){

        System.out.println("测试开始...");
        xStream = new XStream();
    }



    @Test
    public void Java2Xml(){

        //创建user对象与customer对象并赋值
        User user = new User();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setCommodity("商品1");
        customer2.setCommodity("商品2");
        List<Customer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer2);
        user.setName("beyondLi");
        user.setAge(23);
        user.setCustomer(list);

        //给外层对象设置别名, 没有别名的话会默认使用全路径
//        xStream.alias("User", User.class);
//        xStream.alias("Customer", Customer.class);
        //调用toXML 将对象转成字符串

        //启用注解
        xStream.processAnnotations(User.class);
        String s = xStream.toXML(user);
        System.out.println(JSON.toJSONString(user));
        System.out.println(s);
    }

    @Test
    public void Xml2Java(){

        String xml = "<User>\n" +
                "  <name>beyondLi</name>\n" +
                "  <age>23</age>\n" +
                "  <customer>\n" +
                "    <Customer>\n" +
                "      <commodity>商品1</commodity>\n" +
                "    </Customer>\n" +
                "    <Customer>\n" +
                "      <commodity>商品2</commodity>\n" +
                "    </Customer>\n" +
                "  </customer>\n" +
                "</User>";

        //给外层对象设置别名, 没有别名的话会默认使用全路径
//        xStream.alias("User", User.class);
//        xStream.alias("Customer", Customer.class);

        //启用注解
        xStream.processAnnotations(User.class);
        User user = (User) xStream.fromXML(xml);

        System.out.println(JSON.toJSON(user));
    }


    @After
    public void end(){

        System.out.println("测试结束...");
    }

}
