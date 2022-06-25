package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class BinanceApiErrorTest {

    private BinanceApiError binanceApiError;

    @BeforeEach
    void setUp() {
        this.binanceApiError = new BinanceApiError();
    }

    @Test
    void testToString() {
        this.binanceApiError.setCode(202);
        this.binanceApiError.setMessage("Request Error");
        assertEquals("{\"code\":202,\"message\":\"Request Error\"}", this.binanceApiError.toString());
    }
}
