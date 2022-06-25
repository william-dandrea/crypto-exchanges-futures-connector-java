package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Model class that represent the error response generated when Binance encounter a problem
 */
public class BinanceApiError {

    /** Code generated from the error response*/
    private int code;
    /** Message generated from the error response*/
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("code", this.code)
                .append("message", this.message)
                .build();
    }
}
