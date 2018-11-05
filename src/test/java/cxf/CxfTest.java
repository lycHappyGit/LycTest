package cxf;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class CxfTest {

    @Test
    public void test(){

        String[] param = {"{id:\"3\",name:\"粮食\"}"};
        Object[] resp = CxfUtil.invokeRemoteMethod("http://localhost:8080/Service/UserServer?wsdl", "getUser", param);
        System.out.println(JSON.toJSONString(resp));
    }
}
