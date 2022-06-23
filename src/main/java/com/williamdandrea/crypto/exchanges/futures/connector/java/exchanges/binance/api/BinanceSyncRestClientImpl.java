package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceSyncRestClient;

import static com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api.BinanceApiServiceGenerator.createService;
import static com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api.BinanceApiServiceGenerator.executeSync;

/**
 * @author D'Andréa William
 */
public class BinanceSyncRestClientImpl implements BinanceSyncRestClient {

    private final BinanceApiService binanceApiService;

    public BinanceSyncRestClientImpl(String apiKey, String secret) {
        this.binanceApiService = createService(BinanceApiService.class, apiKey, secret);
    }


    @Override
    public void ping() {
        executeSync(binanceApiService.ping());
    }

    @Override
    public Long getServerTime() {
        return executeSync(binanceApiService.getServerTime()).getServerTime();
    }
}
