//
//  Created by  fred on 2017/1/12.
//  Copyright Â© 2016å¹´ Alibaba. All rights reserved.
//

package sdk4;

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


public class HttpApiClient_wuweining extends ApacheHttpClient {
    public final static String HOST = "172.16.35.68:28080" ;
    static HttpApiClient_wuweining instance = new HttpApiClient_wuweining();

    public static HttpApiClient_wuweining getInstance() {
        return instance;
    }

    public void init(HttpClientBuilderParams httpClientBuilderParams) {
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }

    public void SURF_CHN_MUL_HOR_1624518872420(byte[] body, ApiCallback callback) {
            //String path = "http://172.16.35.68:28080/dgs/api_857639729913397248614" ;
            String path="/dgs/api_857639729913397248614";
            ApiRequest request = new ApiRequest(HttpMethod.POST_BODY, path, body);
            sendAsyncRequest(request, callback);
        }

    public ApiResponse SURF_CHN_MUL_HOR_1624518872420_syncMode(byte[] body) {
              //String path = "http://172.16.35.68:28080/dgs/api_857639729913397248614" ;
              String path="/dgs/api_857639729913397248614";
            ApiRequest request = new ApiRequest(HttpMethod.POST_BODY, path, body);
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