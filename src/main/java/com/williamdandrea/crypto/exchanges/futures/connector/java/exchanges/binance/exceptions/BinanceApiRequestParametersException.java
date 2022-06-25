package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions;

/**
 * @author D'Andréa William
 */
public class BinanceApiRequestParametersException extends IllegalArgumentException {

    public BinanceApiRequestParametersException() {
    }

    public BinanceApiRequestParametersException(String s) {
        super(s);
    }

    public BinanceApiRequestParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinanceApiRequestParametersException(Throwable cause) {
        super(cause);
    }
}
