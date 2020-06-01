package httpTest;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http请求工具类
 */
@Slf4j
public class HttpClientUtil {

    /**
     * get 方式请求
     * @param url
     * @return
     */
    public static String get(String url){

        String result = null;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            //发送get请求
            HttpGet httpGet = new HttpGet(url);
            log.info("get方式http请求, url : {}", url);
            HttpResponse response = client.execute(httpGet);
            /**请求发送成功，并得到响应**/
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.info("get方式http请求, 返回结果：{}", result);
            }else{
                log.error("get方式http请求失败, 状态码：{}", statusCode);
            }
        } catch (Exception e) {
            log.error("get方式http请求异常: ", e);
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    /**
     * post请求  contentType=x-www-form-urlencoded
     * @param url
     * @param bodyParam
     * @return
     */
    public static String post(String url, Map<String, String> bodyParam, Map<String, String> headerParam){

        String result = null;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            //body参数
            List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>();
            if(bodyParam != null && bodyParam.size() > 0){
                bodyParam.keySet().forEach(key ->{
                    param.add(new BasicNameValuePair(key, bodyParam.get(key)));
                });
            }
            //header参数
            Header[] headers = null;
            if(headerParam != null && headerParam.size() > 0){
                headers = new Header[headerParam.size()];
                int i = 0;
                for(String key : headerParam.keySet()){
                    BasicHeader basicHeader = new BasicHeader(key, headerParam.get(key));
                    headers[i] = basicHeader;
                    i++;
                }
            }
            HttpEntity entity = new UrlEncodedFormEntity(param, "utf-8");
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setHeaders(headers);
            log.info("post方式http请求, url : {}, bodyParam: {}, headerParam: {}", url, JSON.toJSONString(bodyParam), JSON.toJSONString(headerParam));
            HttpResponse response = client.execute(httpPost);
            /**请求发送成功，并得到响应**/
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.info("post方式http请求, 返回结果：{}", result);
            } else {
                log.error("post方式http请求失败, 状态码：{}", statusCode);
            }
        } catch (Exception e) {
            log.error("post方式http请求异常: ", e);
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    /**
     * postJson请求  contentType=application/json
     * @param url
     * @param jsonBodyParam
     * @param headerParam
     * @return
     */
    public static String postJson(String url, String jsonBodyParam, Map<String, String> headerParam){

        String result = null;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            //header参数
            Header[] headers = null;
            if(headerParam != null && headerParam.size() > 0){
                headers = new Header[headerParam.size()];
                int i = 0;
                for(String key : headerParam.keySet()){
                    BasicHeader basicHeader = new BasicHeader(key, headerParam.get(key));
                    headers[i] = basicHeader;
                    i++;
                }
            }
            StringEntity entity = new StringEntity(jsonBodyParam, ContentType.APPLICATION_JSON);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setHeaders(headers);
            log.info("postJson方式http请求, url : {}, jsonBodyParam: {}, headerParam: {}", url, jsonBodyParam, JSON.toJSONString(headerParam));
            HttpResponse response = client.execute(httpPost);
            /**请求发送成功，并得到响应**/
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.info("postJson方式http请求, 返回结果：{}", result);
            } else {
                log.error("postJson方式http请求失败, 状态码：{}", statusCode);
            }
        } catch (Exception e) {
            log.error("postJson方式http请求异常: ", e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
