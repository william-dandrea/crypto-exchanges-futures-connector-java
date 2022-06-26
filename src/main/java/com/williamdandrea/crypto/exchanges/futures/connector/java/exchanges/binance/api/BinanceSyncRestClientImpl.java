package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceSyncRestClient;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiRequestParametersException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.CandlestickChartInterval;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.ContractType;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.AggregateTradeList;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.CandlestickBinance;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.TradeList;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook.OrderBook;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api.BinanceApiServiceGenerator.createService;
import static com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api.BinanceApiServiceGenerator.executeSync;
import static com.williamdandrea.crypto.exchanges.futures.connector.java.utils.Constants.MS_IN_ONE_DAY;

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
    public OrderBook getOrderBook(@NotNull String symbol, @Nullable Integer limit) {

        if (limit != null) {
            if (!Arrays.asList(new Integer[] {5, 10, 20, 50, 100, 500, 1000}).contains(limit)) {
                throw new BinanceApiRequestParametersException("Limit must be one of this value : [5, 10, 20, 50, 100, 500, 1000]");
            }
        }

        return executeSync(binanceApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeList> getRecentTradeList(@NotNull String symbol, @Nullable Integer limit) {

        if (limit != null) {
            if (limit <= 0 || limit > 1000) {
                throw new BinanceApiRequestParametersException("Parameter 'limit' must be between [1;1000]");
            }
        }

        return executeSync(binanceApiService.getRecentTradeList(symbol, limit));
    }


    @Override
    public List<TradeList> getOldTradeLookup(@NotNull String symbol, @Nullable Integer limit, @Nullable Long fromId) {

        if (limit != null) {
            if (limit <= 0 || limit > 1000) {
                throw new BinanceApiRequestParametersException("Parameter 'limit' must be between [1;1000]");
            }
        }

        return executeSync(binanceApiService.getOldTradeLookup(symbol, limit, fromId));
    }

    @Override
    public List<AggregateTradeList> getCompressedAggregateTradesList(@NotNull String symbol, @Nullable Long fromId, @Nullable Long startTime, @Nullable Long endTime, @Nullable Integer limit) {

        // Limit : Default 500; max 1000.
        if (limit != null) {
            if (limit <= 0 || limit > 1000) {
                throw new BinanceApiRequestParametersException("Parameter 'limit' must be between [1;1000]");
            }
        }

        // If both startTime and endTime are sent, time between startTime and endTime must be less than 1 hour.
        if (startTime != null && endTime != null) {
            if (startTime > endTime) {
                throw new BinanceApiRequestParametersException("startTime need to be greater than endTime");
            }

            if (endTime - startTime >= MS_IN_ONE_DAY) {
                throw new BinanceApiRequestParametersException("Time between startTime and endTime must be less than 1 hour");
            }
        }

        return executeSync(binanceApiService.getCompressedAggregateTradesList(symbol, fromId, startTime, endTime, limit));
    }

    @Override
    public List<CandlestickBinance> getCandlestickData(@NotNull String symbol, @NotNull CandlestickChartInterval interval, @Nullable Long startTime, @Nullable Long endTime, @Nullable Integer limit) {

        // Limit : Default 500; max 1500.
        if (limit != null) {
            if (limit <= 0 || limit > 1500) {
                throw new BinanceApiRequestParametersException("Parameter 'limit' must be between [1;1000]");
            }
        }

        if (startTime != null && endTime != null) {
            if (startTime > endTime) {
                throw new BinanceApiRequestParametersException("startTime need to be greater than endTime");
            }
        }

        return executeSync(binanceApiService.getCandlestickData(symbol, interval.getValue(), startTime, endTime, limit));
    }

    @Override
    public List<CandlestickBinance> getContinuousContractCandlestickData(@NotNull String symbol, @NotNull ContractType contractType, @NotNull CandlestickChartInterval interval, @Nullable Long startTime, @Nullable Long endTime, @Nullable Integer limit) {

        // Limit : Default 500; max 1500.
        if (limit != null) {
            if (limit <= 0 || limit > 1500) {
                throw new BinanceApiRequestParametersException("Parameter 'limit' must be between [1;1000]");
            }
        }

        if (startTime != null && endTime != null) {
            if (startTime > endTime) {
                throw new BinanceApiRequestParametersException("startTime need to be greater than endTime");
            }
        }

        if (contractType != ContractType.PERPETUAL && contractType != ContractType.CURRENT_QUARTER && contractType != ContractType.NEXT_QUARTER) {
            throw new BinanceApiRequestParametersException("contractType need to be PERPETUAL or CURRENT_QUARTER or NEXT_QUARTER");
        }


        return executeSync(binanceApiService.getContinuousContractCandlestickData(symbol, contractType, interval.getValue(), startTime, endTime, limit));
    }
}
