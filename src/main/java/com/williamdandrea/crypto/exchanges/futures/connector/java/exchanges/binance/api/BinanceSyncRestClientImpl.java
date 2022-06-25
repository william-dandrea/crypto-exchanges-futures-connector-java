package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceSyncRestClient;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook.OrderBook;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;

import java.util.Arrays;

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

    @Override
    public OrderBook getOrderBook(String symbol) {
        return executeSync(binanceApiService.getOrderBook(symbol, null));
    }

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {

        if (!Arrays.asList(new Integer[] {5, 10, 20, 50, 100, 500, 1000}).contains(limit)) {
            throw new BinanceApiException("Limit must be one of this value : [5, 10, 20, 50, 100, 500, 1000]");
        }

        return executeSync(binanceApiService.getOrderBook(symbol, limit));
    }
}
