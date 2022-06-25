package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.utils;

/**
 * @author D'Andréa William
 */
public class BinanceConstants {

    public static final String BASE_URL = "https://fapi.binance.com";

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "X-MBX-APIKEY";

    /**
     * Decorator to indicate that an endpoint requires an API key.
     */
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY";
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";

    /**
     * Decorator to indicate that an endpoint requires a signature.
     */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";



}
