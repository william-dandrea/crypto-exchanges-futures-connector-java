package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;

/**
 * @author D'Andréa William
 */
public interface BinanceSyncRestClient {


    /*
     * Market Data Endpoints
     */

    /**
     * Test Connectivity
     * GET /fapi/v1/ping
     * Test connectivity to the Rest API.
     *
     * https://binance-docs.github.io/apidocs/futures/en/#test-connectivity
     */
    void ping();

    /**
     * Check Server Time
     * GET /fapi/v1/time
     * Test connectivity to the Rest API and get the current server time.
     *
     * https://binance-docs.github.io/apidocs/futures/en/#check-server-time
     * @return
     */
    ServerTime getServerTime();

    /**
     * Exchange Information
     * GET /fapi/v1/exchangeInfo
     * Current exchange trading rules and symbol information
     *
     * https://binance-docs.github.io/apidocs/futures/en/#exchange-information
     */
    ExchangeInformation getExchangeInformation();
}
