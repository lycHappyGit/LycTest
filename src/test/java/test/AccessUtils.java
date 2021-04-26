package test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

/**
 * Created by yiwenwu on 2017/10/16.
 */
public class AccessUtils {

    public static String getAccessAuthHeader() {
//        String secureId = "pudJKC13xqt7ngYV0zqsF7e95QsXzp6q1lJG";
//        String secureKey = "llV4FNgoO5NN4yESiloMgKVJa17DNbFe";

        String secureId = "IlkyF8EUT7mAONrRmnIx1k9TwrM1sstWjexF";
        String secureKey = "GYmsd3ZMLBM1i9kmkMP8fo9NMVEEXpsn";



        Long timestamp = System.currentTimeMillis();
        Integer nonce = new Random().nextInt(10 * 8) + 1;
        String signature = AccessUtils.generateSignature(secureId, timestamp, nonce, secureKey);
        String accessHeader = "TBDS " + secureId + " " + timestamp + " " + nonce + " " + signature;
        return accessHeader;
    }

    private static String generateSignature(String secureId, long timestamp, int randomValue, String secureKey) {
        Base64 base64 = new Base64();
        byte[] baseStr = base64.encode(HmacUtils.hmacSha1(secureKey, secureId + timestamp + randomValue));
        String result = "";
        try {
            result = URLEncoder.encode(new String(baseStr), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Send tbds get.
     */
    public static String doGet(String url) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpGet get = new HttpGet(url);
        try {
            get.setHeader("Authorization", AccessUtils.getAccessAuthHeader());
            patchSetHeaders(get);

            System.out.println("doGet url:----------------" + url);
            System.out.println("doGet headers Authorization:" + AccessUtils.getAccessAuthHeader());
            response = client.execute(get);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("doGet result:" + result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Send get error." + e);
        } finally {
            get.releaseConnection();
        }
        return null;
    }

    /**
     * Send tbds ranger get.
     */
    public static String doGetRanger(String url) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpGet get = new HttpGet(url);
        try {
            //在请求头信息中携带Basic认证信息(这里才是实际Basic认证传递用户名密码的方式)
            patchSetHeaders(get);
            get.setHeader("Authorization", getRangerAuthheader());

            System.out.println("get ranger url:----------------" + url);
            response = client.execute(get);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("doGetRanger result:" + result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Send get error." + e);
        } finally {
            get.releaseConnection();
        }
        return null;
    }

    /**
     * Send tbds get.
     */
    public static String doPost(String url, String bodyJson) throws Exception {
        CloseableHttpResponse response;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpPost post = new HttpPost(url);
        try {
            patchSetHeaders(post);
            post.setHeader("Authorization", AccessUtils.getAccessAuthHeader());

            System.out.println("doPost url:----------------" + url);
            System.out.println("doPost headers Authorization:" + AccessUtils.getAccessAuthHeader());
            System.out.println("bodyJson:------------" + bodyJson);

            // 传入请求体
            StringEntity entity = new StringEntity(bodyJson);
            post.setEntity(entity);
            // 发送请求，得到响应体
            response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("doPost result:" + result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Send get error." + e);
        } finally {
            post.releaseConnection();
        }
        return null;
    }

    /**
     * ranger
     * Send post.
     */
    public static String doPostRanger(String url, String bodyJson) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpPost post = new HttpPost(url);
        try {
            post.setHeader("Authorization", getRangerAuthheader());
            patchSetHeaders(post);

            System.out.println("doPostRanger url:----------------" + url);
            System.out.println("request headers Authorization:" + "Basic " + getRangerAuthheader());
            System.out.println("bodyJson:------------" + bodyJson);
            // 传入请求体
            StringEntity entity = new StringEntity(bodyJson);
            post.setEntity(entity);
            // 发送请求，得到响应体
            response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("doPostRanger result:" + result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Send post error." + e);
        } finally {
            post.releaseConnection();
        }
        return null;
    }

    private static String getRangerAuthheader() {
        String authentication = "admin" + ":" + "admin";
        //在请求头信息中携带Basic认证信息(这里才是实际Basic认证传递用户名密码的方式)
        return "Basic " + java.util.Base64.getEncoder().encodeToString(authentication.getBytes());
    }

    /**
     * Send tbds get.
     */
    public static String doPut(String url, String bodyJson) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpPut put = new HttpPut(url);
        try {
            patchSetHeaders(put);
            put.setHeader("Authorization", AccessUtils.getAccessAuthHeader());
            System.out.println("url:----------------" + url);
            System.out.println("bodyJson:------------" + bodyJson);
            StringEntity entity = new StringEntity(bodyJson);
            put.setEntity(entity);
            // 发送请求，得到响应体
            response = client.execute(put);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Send put error." + e);
        } finally {
            put.releaseConnection();
        }
        return null;
    }

    /**
     * Send tbds ranger put.
     */
    public static String doPutRanger(String url, String bodyJson) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpPut put = new HttpPut(url);
        try {
            patchSetHeaders(put);
            put.setHeader("Authorization", getRangerAuthheader());

            System.out.println("doPutRanger url:----------------" + url);
            System.out.println("doPutRanger bodyJson:------------" + bodyJson);
            StringEntity entity = new StringEntity(bodyJson);
            put.setEntity(entity);
            // 发送请求，得到响应体
            response = client.execute(put);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("doPutRanger result" + result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Send put error." + e);
        } finally {
            put.releaseConnection();
        }
        return null;
    }

    /**
     * Send tbds get.
     */
    public static JSONObject doDelete(String url, String bodyJson) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpDelete delete = new HttpDelete(url);
        try {
            patchSetHeaders(delete);
            delete.setHeader("Authorization", AccessUtils.getAccessAuthHeader());
            System.out.println("delete url:----------------" + url);
            System.out.println("delete bodyJson:------------" + bodyJson);
            // 发送请求，得到响应体
            response = client.execute(delete);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            JSONObject js = JSONObject.parseObject(result);
            if (js.get("resultCode").equals("0")) {
                return js;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Send delete error." + e);
        } finally {
            delete.releaseConnection();
        }

        return null;
    }

    /**
     * Send tbds ranger Delete.
     */
    public static String doDeleteRanger(String url) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpDelete delete = new HttpDelete(url);
        try {
            patchSetHeaders(delete);
            delete.setHeader("Authorization", getRangerAuthheader());
            System.out.println("url:----------------" + url);

            // 发送请求，得到响应体
            response = client.execute(delete);
            response.getAllHeaders();
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("doDeleteRanger result" + result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("Send delete error." + e);
        } finally {
            delete.releaseConnection();
        }
        return null;
    }

    /**
     * 批量设置headers
     *
     * @param request
     */
    private static void patchSetHeaders(AbstractHttpMessage request) {
        request.setHeader("Content-Type", "application/json;charset=UTF-8");
        request.setHeader("User-Agent", "Mozilla/5.0");
        request.setHeader("Accept-Language", "en-US,en;q=0.5");
        request.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
    }
}
