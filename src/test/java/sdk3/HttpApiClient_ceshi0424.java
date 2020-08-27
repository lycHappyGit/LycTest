//
//  Created by  fred on 2017/1/12.
//  Copyright Â© 2016å¹´ Alibaba. All rights reserved.
//

package sdk3;

import com.mlamp.api.gateway.sdk.client.ApacheHttpClient;
import com.mlamp.api.gateway.sdk.enums.HttpConnectionModel;
import com.mlamp.api.gateway.sdk.enums.HttpMethod;
import com.mlamp.api.gateway.sdk.enums.ParamPosition;
import com.mlamp.api.gateway.sdk.enums.Scheme;
import com.mlamp.api.gateway.sdk.model.ApiCallback;
import com.mlamp.api.gateway.sdk.model.ApiRequest;
import com.mlamp.api.gateway.sdk.model.ApiResponse;
import com.mlamp.api.gateway.sdk.model.HttpClientBuilderParams;
import org.apache.commons.httpclient.HttpStatus;
import java.net.URI;
import java.net.URISyntaxException;


public class HttpApiClient_ceshi0424 extends ApacheHttpClient {
    public final static String HOST = "localhost:28080" ;
    static HttpApiClient_ceshi0424 instance = new HttpApiClient_ceshi0424();

    public static HttpApiClient_ceshi0424 getInstance() {
        return instance;
    }

    public void init(HttpClientBuilderParams httpClientBuilderParams) {
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }

    public void ceshissss(String fyl, ApiCallback callback) {
            //String path = "http://172.21.1.152:28080/frontapi/cgqnt/f/y/l/{fyl}" ;
            String path="/frontapi/cgqnt/f/y/l/{fyl}";
            ApiRequest request = new ApiRequest(HttpMethod.GET, path);
            request.addParam("fyl",String.valueOf(fyl), ParamPosition.PATH, true);
            sendAsyncRequest(request, callback);
        }

    public ApiResponse ceshissss_syncMode(String fyl) {
              //String path = "http://172.21.1.152:28080/frontapi/cgqnt/f/y/l/{fyl}" ;
              String path="/frontapi/cgqnt/f/y/l/{fyl}";
            ApiRequest request = new ApiRequest(HttpMethod.GET, path);
            request.addParam("fyl", String.valueOf(fyl), ParamPosition.PATH, true);
    ApiResponse apiResponse = sendSyncRequest(request);
    if(HttpStatus.SC_TEMPORARY_REDIRECT == apiResponse.getCode()){
        String location = apiResponse.getFirstHeaderValue("location");
        try {
            URI uri = new URI(location);
            String host = uri.getHost() + ":" + uri.getPort();
            request.setHttpConnectionMode(HttpConnectionModel.MULTIPLE_CONNECTION);
            request.setHost(host);
            request.setScheme(Scheme.HTTPS);
            apiResponse = sendSyncRequest(request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    return apiResponse;
    }
}