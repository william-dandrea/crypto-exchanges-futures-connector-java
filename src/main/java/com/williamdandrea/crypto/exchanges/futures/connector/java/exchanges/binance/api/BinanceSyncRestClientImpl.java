package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceSyncRestClient;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;

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
    public ServerTime getServerTime() {
        return executeSync(binanceApiService.getServerTime());
    }

    @Override
    public ExchangeInformation getExchangeInformation() {
        return executeSync(binanceApiService.getExchangeInformation());
    }
}
