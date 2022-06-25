package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceSyncRestClient;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiRequestParametersException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.TradeList;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook.OrderBook;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;

import java.util.Arrays;
import java.util.List;

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
            throw new BinanceApiRequestParametersException("Limit must be one of this value : [5, 10, 20, 50, 100, 500, 1000]");
        }

        return executeSync(binanceApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeList> getRecentTradeList(String symbol, Integer limit) {

        if (limit <= 0 || limit > 1000) {
            throw new BinanceApiRequestParametersException("Parameter 'limit' must be between [1;1000]");
        }

        return executeSync(binanceApiService.getRecentTradeList(symbol, limit));
    }

    @Override
    public List<TradeList> getRecentTradeList(String symbol) {
        return executeSync(binanceApiService.getRecentTradeList(symbol, null));
    }
}
