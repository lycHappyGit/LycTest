//
//  Created by  fred on 2016/10/26.
//  Copyright Â© 2016å¹´ Alibaba. All rights reserved.
//

package sdk4;

import com.mlamp.api.gateway.sdk.constant.SdkConstant;
import com.mlamp.api.gateway.sdk.enums.HttpMethod;
import com.mlamp.api.gateway.sdk.model.ApiCallback;
import com.mlamp.api.gateway.sdk.model.ApiRequest;
import com.mlamp.api.gateway.sdk.model.ApiResponse;
import com.mlamp.api.gateway.sdk.model.HttpClientBuilderParams;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


public class Demo_wuweining {


    static {
        //HTTP Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        // appKey set
        httpParam.setAppKey("");
        // appSercret set
        httpParam.setAppSecret("");
        httpParam.setRegistry(getNoVerifyRegistry());
        HttpApiClient_wuweining.getInstance().init(httpParam);

        //HTTPS Client init
        HttpClientBuilderParams httpsParam = new HttpClientBuilderParams();
        // appKeyï¼è¯·æ ¹æ®å®éæåµæ¥å¡«å
        httpsParam.setAppKey("");
        // appSercretï¼è¯·æ ¹æ®å®éæåµæ¥å¡«å
        httpsParam.setAppSecret("");
        /**
         * HTTPS request use DO_NOT_VERIFY mode only for demo
         * Suggest verify for security
         */
        httpsParam.setRegistry(getNoVerifyRegistry());
        HttpsApiClient_wuweining.getInstance().init(httpsParam);
    }


    public static void SURF_CHN_MUL_HOR_1624518872420HttpTest() {
        HttpApiClient_wuweining.getInstance().SURF_CHN_MUL_HOR_1624518872420( new byte[0], new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public static void SURF_CHN_MUL_HOR_1624518872420HttpSyncTest() throws IOException {
        ApiResponse response = HttpApiClient_wuweining.getInstance().SURF_CHN_MUL_HOR_1624518872420_syncMode("{\"filter\":{},\"pageSize\":10,\"pageNum\":1}".getBytes("utf-8"));
        System.out.println(getResultString(response));
    }





    private static String getResultString(ApiResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("Response from backend server").append(SdkConstant.API_LF).append(SdkConstant.API_LF);
        result.append("ResultCode:").append(SdkConstant.API_LF).append(response.getCode()).append(SdkConstant.API_LF).append(SdkConstant.API_LF);
        if (response.getCode() != 200) {
            result.append("Error description:").append(response.getHeaders().get("X-Ca-Error-Message")).append(SdkConstant.API_LF).append(SdkConstant.API_LF);
        }
        result.append("ResultBody:").append(SdkConstant.API_LF).append(new String(response.getBody(), SdkConstant.API_ENCODING));
        return result.toString();
    }

    private static Registry<ConnectionSocketFactory> getNoVerifyRegistry() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
        try {
            registryBuilder.register("http", PlainConnectionSocketFactory.INSTANCE).build();
            registryBuilder.register(
                    "https",
                    new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(
                            KeyStore.getInstance(KeyStore.getDefaultType()), new TrustStrategy() {
                                @Override
                                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                                    return true;
                                }
                            }).build(),
                            new HostnameVerifier() {
                                @Override
                                public boolean verify(String paramString, SSLSession paramSSLSession) {
                                    return true;
                                }
                            }));

        } catch (Exception e) {
            throw new RuntimeException("HttpClientUtil init failure !", e);
        }
        return registryBuilder.build();
    }


    private static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements TrustManager,
            X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }

        public void checkClientTrusted(
                X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }
    }
    public static void main(String[] args) throws IOException {
        // http test
        Demo_wuweining.SURF_CHN_MUL_HOR_1624518872420HttpSyncTest();
        // https test
//        Demo_wuweining.${api.base.asName}HttpsSyncTest();
    }
}