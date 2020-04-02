package httpTest;

import bean.User;
import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpTest {

    @Test
    public void get(){

        String url = "http://download-oss-qa2.weizhipin.com/oss/accessResourceByUrl?t=1541389241357&token=b5e168ac74d2d7af387b04759d9d3295&businessId=3&type=5&url=%2Finvoice%2F2018110100000000000000000000000000022608001";

        //get请求返回结果
        String str = "";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            //发送get请求
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = client.execute(httpGet);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
//                str = EntityUtils.toString(response.getEntity());
                byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                FileOutputStream fos = new FileOutputStream("D:/getFileabcd.pdf");
                fos.write(bytes);
                fos.flush();
                fos.close();
                System.out.println("请求成功");
            }else{
                System.out.println("get请求提交失败:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getAndCookie(){

        String url = "http://127.0.0.1:8083/dssp/getLoginUserInfo";
        //get请求返回结果
        String str = "";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            //发送get请求
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Cookie", "SESSION=356fb6b1-5887-41e3-8bbf-42f1ca36b0ef");
            HttpResponse response = client.execute(httpGet);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String result = EntityUtils.toString(response.getEntity());
                System.out.println("请求成功 result + " + result);
            }else{
                System.out.println("get请求提交失败:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws UnsupportedEncodingException {

        System.out.println("011001700112".substring(10, 12));
    }

    @Test
    public void post(){

        String url = "http://localhost:8080/bb";
        CloseableHttpClient client = HttpClientBuilder.create().build();

        String str = "";
        try {
            List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>();
            param.add(new BasicNameValuePair("name", "urlEncodedFormEntity lisi"));
            param.add(new BasicNameValuePair("like", "玩游戏!"));

            HttpEntity entity = new UrlEncodedFormEntity(param, "utf-8");
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            HttpResponse response = client.execute(httpPost);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(response.getEntity());
            } else {
                System.out.println("get请求提交失败:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void post2(){

        String url = "http://localhost:8080/bb";
        CloseableHttpClient client = HttpClientBuilder.create().build();

        String str = "";
        try {
            List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>();
            param.add(new BasicNameValuePair("name", "urlEncodedFormEntity lisi"));
            param.add(new BasicNameValuePair("like", "玩游戏!"));

            HttpEntity entity = new UrlEncodedFormEntity(param, "utf-8");
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            HttpResponse response = client.execute(httpPost);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(response.getEntity());
            } else {
                System.out.println("get请求提交失败:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void postJson(){

        String url = "http://localhost:8080/cc";
        CloseableHttpClient client = HttpClientBuilder.create().build();

        String str = "";
        try {
            User user = new User("StringEntity json wangwu", "看电影");
            String param = JSON.toJSONString(user);
            StringEntity entity = new StringEntity(param, ContentType.APPLICATION_JSON);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            HttpResponse response = client.execute(httpPost);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(response.getEntity());
            } else {
                System.out.println("请求失败:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void postUploadFile(){

        String url = "http://localhost:8080/fileUpload";
        CloseableHttpClient client = HttpClientBuilder.create().build();

        String str = "";
        try {

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addBinaryBody("fileName", new File("d:/abc.pdf"));
            multipartEntityBuilder.addTextBody("talk", "this is multipart upload test");

            HttpEntity entity = multipartEntityBuilder.build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            HttpResponse response = client.execute(httpPost);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(response.getEntity());
            } else {
                System.out.println("请求失败:" + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
