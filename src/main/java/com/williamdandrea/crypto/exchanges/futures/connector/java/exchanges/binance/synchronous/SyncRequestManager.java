package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.synchronous;



import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.RestApiPrefixUrl;
import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.UrlParams;
import okhttp3.Request;


/**
 * @author D'Andréa William
 */
public class SyncRequestManager {

    private final String apiKey;
    private final String secretKey;
    private final String prefixUrl;


    public SyncRequestManager(String apiKey, String secretKey, RestApiPrefixUrl url) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.prefixUrl = url.getUrl();
    }



    private Request createRequest(String postfixUrl, UrlParams urlParams) {
        String concatUrl = this.prefixUrl + postfixUrl;
        return null;
    }


}
