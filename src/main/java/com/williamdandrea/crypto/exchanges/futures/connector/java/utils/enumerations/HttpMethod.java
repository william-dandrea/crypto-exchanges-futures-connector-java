package com.williamdandrea.crypto.exchanges.futures.connector.java.utils.enumerations;

/**
 * @author D'Andréa William
 */
public enum HttpMethod {

    GET("GET"), PUT("PUT"), DELETE("DELETE"), POST("POST");

    private final String value;

    HttpMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
