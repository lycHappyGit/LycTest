package PushIdKey;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Map;

public class PushIdKey {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test1() throws Exception {

        String path = "D:/PushIdKey.txt";
        FileInputStream fis = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuffer result = new StringBuffer("");
        String str = "";
        while((str = br.readLine()) != null){
            result.append(str);
        }
        br.close();
        fis.close();
        logger.info("获取结果为:" + result.toString());

        List<Map> list = JSON.parseArray(result.toString(), Map.class);
        int i = 0;
        for(Map map : list){
            i++;
            String secKey = (String) map.get("secKey");
            String qybs = (String) map.get("qybs");
            String secId = (String) map.get("secId");

            logger.info("{} id:{},key:{},qybs:{}",i,secId,secKey,qybs);
        }

    }
}
