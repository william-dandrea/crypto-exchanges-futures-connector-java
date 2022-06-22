package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance;

import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.RestApiPrefixUrl;

/**
 * @author D'Andréa William
 */
public class RestApiEndpoints {

    private final String apiKey;
    private final String secretKey;
    private final String url;


    public RestApiEndpoints(String apiKey, String secretKey, RestApiPrefixUrl url) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.url = url.getUrl();
    }





}
