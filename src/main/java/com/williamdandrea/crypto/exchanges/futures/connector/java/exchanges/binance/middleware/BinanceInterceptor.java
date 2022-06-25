package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.middleware;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.utils.BinanceConstants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author D'Andréa William
 */
public class BinanceInterceptor implements Interceptor {

    private final String apiKey;
    private final String secretKey;

    public BinanceInterceptor(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request initialRequest = chain.request();
        Request.Builder responseRequestBuilder = initialRequest.newBuilder();

        // Watch if the apiKey or signature is required
        boolean isApiKeyRequired = initialRequest.header(BinanceConstants.ENDPOINT_SECURITY_TYPE_APIKEY) != null;
        boolean isSignatureRequired = initialRequest.header(BinanceConstants.ENDPOINT_SECURITY_TYPE_SIGNED) != null;

        // Reset the headers associated to the apiKey or signature
        responseRequestBuilder.removeHeader(BinanceConstants.ENDPOINT_SECURITY_TYPE_APIKEY);
        responseRequestBuilder.removeHeader(BinanceConstants.ENDPOINT_SECURITY_TYPE_SIGNED);

        // If the request need the apiKey (or the signature - if its require the signature, it's require automatically the apiKey)
        if (isApiKeyRequired || isSignatureRequired) {
            responseRequestBuilder.addHeader(BinanceConstants.API_KEY_HEADER, apiKey);
        }

        // Add the signature if required
        if (isSignatureRequired) {
            String payload = initialRequest.url().query();
            if (!StringUtils.isEmpty(payload)) {
                String signature = HmacSHA256SignatureManager.sign(payload, secretKey);
                HttpUrl signedUrl = initialRequest.url().newBuilder().addQueryParameter("signature", signature).build();
                responseRequestBuilder.url(signedUrl);
            }
        }


        return chain.proceed(responseRequestBuilder.build());
    }
}
