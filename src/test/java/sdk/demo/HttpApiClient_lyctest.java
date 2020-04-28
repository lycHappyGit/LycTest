////
////  Created by  fred on 2017/1/12.
////  Copyright Â© 2016å¹´ Alibaba. All rights reserved.
////
//
//package sdk.demo;
//
//import com.mlamp.api.gateway.sdk.client.ApacheHttpClient;
//import com.mlamp.api.gateway.sdk.enums.HttpConnectionModel;
//import com.mlamp.api.gateway.sdk.enums.HttpMethod;
//import com.mlamp.api.gateway.sdk.enums.Scheme;
//import com.mlamp.api.gateway.sdk.model.ApiCallback;
//import com.mlamp.api.gateway.sdk.model.ApiRequest;
//import com.mlamp.api.gateway.sdk.model.ApiResponse;
//import com.mlamp.api.gateway.sdk.model.HttpClientBuilderParams;
//import org.apache.commons.httpclient.HttpStatus;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//
//public class HttpApiClient_lyctest extends ApacheHttpClient {
//    public final static String HOST = "172.21.1.152:28080" ;
//    static HttpApiClient_lyctest instance = new HttpApiClient_lyctest();
//
//    public static HttpApiClient_lyctest getInstance() {
//        return instance;
//    }
//
//    public void init(HttpClientBuilderParams httpClientBuilderParams) {
//        httpClientBuilderParams.setScheme(Scheme.HTTP);
//        httpClientBuilderParams.setHost(HOST);
//        super.init(httpClientBuilderParams);
//    }
//
//    public void pg_type_1583830351893(byte[] body, ApiCallback callback) {
//            //String path = "http://172.21.1.152:28080/dgs/api_686979482438860800124104" ;
//            String path="/dgs/api_686979482438860800124104";
//            ApiRequest request = new ApiRequest(HttpMethod.POST_BODY, path, body);
//            sendAsyncRequest(request, callback);
//        }
//
//    public ApiResponse pg_type_1583830351893_syncMode(byte[] body) {
//              //String path = "http://172.21.1.152:28080/dgs/api_686979482438860800124104" ;
//              String path="/dgs/api_686979482438860800124104";
//            ApiRequest request = new ApiRequest(HttpMethod.POST_BODY, path, body);
//    ApiResponse apiResponse = sendSyncRequest(request);
//    if(HttpStatus.SC_TEMPORARY_REDIRECT == apiResponse.getCode()){
//        String location = apiResponse.getFirstHeaderValue("location");
//        try {
//            URI uri = new URI(location);
//            String host = uri.getHost() + ":" + uri.getPort();
//            request.setHttpConnectionMode(HttpConnectionModel.MULTIPLE_CONNECTION);
//            request.setHost(host);
//            request.setScheme(Scheme.HTTPS);
//            apiResponse = sendSyncRequest(request);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }
//    return apiResponse;
//    }
//}