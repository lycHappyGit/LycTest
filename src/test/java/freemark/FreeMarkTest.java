package freemark;

import mail.MailTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkTest {

    @Test
    public void test1(){

        //设置发送内容
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("updateTime", "2018-11-20 22:22:22");
        dataModel.put("invoiceNumber", "300");
        dataModel.put("warningNum", "400");
        dataModel.put("taxpayerCode", "123456789");

        Map<String, Object> dataModel2 = new HashMap<>();
        dataModel2.put("updateTime", "2018-11-22 22:22:22");
        dataModel2.put("invoiceNumber", "301");
        dataModel2.put("warningNum", "401");
        dataModel2.put("taxpayerCode", "0123456789");

        ArrayList<Map<String, Object>> listData = new ArrayList<>();
        listData.add(dataModel);
        listData.add(dataModel2);

        HashMap<String, Object> map = new HashMap<>();
        map.put("listData", listData);

        String mailcontent = FreeMarkerUtil.generateString(map,"mailcontent2.ftl");
        System.out.println(mailcontent);
        MailTest.send(mailcontent);
    }

    @Test
    public void test2(){

        //设置发送内容
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("updateTime", "2018-11-20 22:22:22");
        dataModel.put("invoiceNumber", "300");
        dataModel.put("warningNum", "400");
        dataModel.put("taxpayerCode", "123456789");

        String mailcontent = FreeMarkerUtil.generateString(dataModel,"mailcontent.ftl");
        System.out.println(mailcontent);
//        MailTest.send(mailcontent);
    }

}
