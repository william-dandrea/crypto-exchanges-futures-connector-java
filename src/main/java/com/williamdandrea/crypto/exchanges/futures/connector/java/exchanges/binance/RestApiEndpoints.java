package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance;

import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.RestApiInitialUrl;

/**
 * @author D'Andréa William
 */
public class RestApiEndpoints {

    private final String apiKey;
    private final String secretKey;
    private final String url;


    public RestApiEndpoints(String apiKey, String secretKey, RestApiInitialUrl url) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.url = url.getUrl();
    }





}
