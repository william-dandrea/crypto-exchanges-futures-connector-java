package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api.BinanceSyncRestClientImpl;

/**
 * @author D'Andréa William
 */
public class BinanceClientFactory {

    /** Binance API key*/
    private final String apiKey;
    /** Binance API secret key */
    private final String secretKey;


    /**
     * Instantiate a new Binance Client Factory
     *
     * @param apiKey the Binance API key
     * @param secretKey the Binance API secret key
     */
    public BinanceClientFactory(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }


    /**
     * Create a new synchronous Binance Rest Client
     * @return the BinanceSyncRestClient
     */
    public BinanceSyncRestClient newSyncRestClient() {
        return new BinanceSyncRestClientImpl(this.apiKey, this.secretKey);
    }

    /**
     * Create a new asynchronous Binance Rest Client
     * @return the BinanceAsyncRestClient
     */
    public BinanceAsyncRestClient newAsyncRestClient() {
        return null;
    }

    /**
     * Create a new Binance Websocket Client
     * @return the BinanceWebsocketClient
     */
    public BinanceWebsocketClient newWebsocketClient() {
        return null;
    }
}
