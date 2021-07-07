//
//  Created by  fred on 2017/1/12.
//  Copyright Â© 2016å¹´ Alibaba. All rights reserved.
//

package sdk4;

import com.mlamp.api.gateway.sdk.client.ApacheHttpClient;
import com.mlamp.api.gateway.sdk.enums.HttpMethod;
import com.mlamp.api.gateway.sdk.enums.ParamPosition;
import com.mlamp.api.gateway.sdk.enums.Scheme;
import com.mlamp.api.gateway.sdk.model.ApiCallback;
import com.mlamp.api.gateway.sdk.model.ApiRequest;
import com.mlamp.api.gateway.sdk.model.ApiResponse;
import com.mlamp.api.gateway.sdk.model.HttpClientBuilderParams;

public class HttpsApiClient_wuweining extends ApacheHttpClient {
    public final static String HOST = "172.16.35.68:28443" ;
    static HttpsApiClient_wuweining instance = new HttpsApiClient_wuweining();

    public static HttpsApiClient_wuweining getInstance() {
        return instance;
    }

    public void init(HttpClientBuilderParams httpClientBuilderParams) {
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }


}