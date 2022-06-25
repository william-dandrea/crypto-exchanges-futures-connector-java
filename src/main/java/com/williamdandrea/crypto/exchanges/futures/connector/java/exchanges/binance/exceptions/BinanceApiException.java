package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.BinanceApiError;

/**
 * Exception thrown when we have a problem with the binance exchange
 * @author D'Andréa William
 */
public class BinanceApiException extends RuntimeException {

    /** Error message from binance */
    private BinanceApiError error;

    public BinanceApiException(BinanceApiError error) {
        this.error = error;
    }

    public BinanceApiException() {
        super();
    }

    public BinanceApiException(String message) {
        super(message);
    }

    public BinanceApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinanceApiException(Throwable cause) {
        super(cause);
    }

    public BinanceApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BinanceApiError getError() {
        return error;
    }
}
