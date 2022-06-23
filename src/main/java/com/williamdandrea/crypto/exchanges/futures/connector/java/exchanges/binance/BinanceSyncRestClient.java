package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance;

/**
 * @author D'Andréa William
 */
public interface BinanceSyncRestClient {


    /*
     * GENERAL ENDPOINTS
     */

    /**
     * Test connectivity to the Rest API.
     */
    void ping();

    /**
     * Check server time.
     */
    Long getServerTime();
}
