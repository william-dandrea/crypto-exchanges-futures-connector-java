package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Model class that represent the error response generated when Binance encounter a problem
 */
public class BinanceApiError {

    /** Code generated from the error response*/
    @JsonProperty(value = "code", required = false)
    private int code;

    /** Message generated from the error response*/
    @JsonProperty("msg")
    private String message;

    @JsonProperty("error")
    private String error;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("code", this.code)
                .append("message", this.message)
                .build();
    }
}
