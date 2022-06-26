package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance;

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

import java.util.List;

/**
 * @author D'Andréa William
 */
public interface BinanceSyncRestClient {


    /**
     * Test Connectivity
     * Test connectivity to the Rest API.
     *
     * GET /fapi/v1/ping
     * Weight: 1
     *
     * https://binance-docs.github.io/apidocs/futures/en/#test-connectivity
     */
    void ping();

    /**
     * Check Server Time
     * Test connectivity to the Rest API and get the current server time.
     *
     * GET /fapi/v1/time
     * Weight: 1
     *
     * https://binance-docs.github.io/apidocs/futures/en/#check-server-time
     */
    ServerTime getServerTime();

    /**
     * Exchange Information
     * Current exchange trading rules and symbol information
     *
     * GET /fapi/v1/exchangeInfo
     * Weight: 1
     *
     * https://binance-docs.github.io/apidocs/futures/en/#exchange-information
     */
    ExchangeInformation getExchangeInformation();


    /**
     *  Get Order Book of a symbol
     *
     *  GET /fapi/v1/depth
     *  Weight: Adjusted based on the limit
     *      | --------------------------|
     *      |    Limit	    |   Weight  |
     *      | 5, 10, 20, 50	|    2      |
     *      | 100	        |    5      |
     *      | 500	        |   10      |
     *      | 1000	        |   20      |
     *      | --------------------------|
     *
     *  https://binance-docs.github.io/apidocs/futures/en/#order-book
     *  @param symbol the ticker symbol (eg. BNBUSDT)
     * @param limit - optional (-> replace by null) - depth of the orderbook ( Default 500; Valid limits:[5, 10, 20, 50, 100, 500, 1000] )
     */
    OrderBook getOrderBook(@NotNull String symbol, @Nullable Integer limit);


    /**
     * Recent Trades List
     * Get recent market trades.
     *
     * Market trades means trades filled in the order book. Only market trades will be
     * returned, which means the insurance fund trades and ADL trades won't be returned.
     *
     * GET /fapi/v1/trades
     * Weight: 1
     *
     * https://binance-docs.github.io/apidocs/futures/en/#recent-trades-list
     *
     * @param symbol the ticker symbol (eg. BNBUSDT)
     * @param limit - optional (-> replace by null) - Default 500; max 1000. number of trades
     */
    List<TradeList> getRecentTradeList(@NotNull String symbol, @Nullable Integer limit);


    /**
     * Old Trades Lookup (MARKET_DATA)
     * Get older market historical trades.
     *
     * Market trades means trades filled in the order book. Only market trades will be returned, which means the
     * insurance fund trades and ADL trades won't be returned.
     *
     * GET /fapi/v1/historicalTrades
     * Weight: 20
     *
     * https://binance-docs.github.io/apidocs/futures/en/#old-trades-lookup-market_data
     *
     * @param symbol the ticker symbol (eg. BNBUSDT)
     * @param limit  - optional (-> replace by null) - Default 500; max 1000. number of trades
     * @param fromId - optional (-> replace by null) - TradeId to fetch from. Default gets most recent trades.
     */
    List<TradeList> getOldTradeLookup(@NotNull String symbol, @Nullable Integer limit, @Nullable Long fromId);


    /**
     * Compressed/Aggregate Trades List
     *
     * Get compressed, aggregate market trades. Market trades that fill in 100ms with the same price and the same taking
     * side will have the quantity aggregated.
     *
     *   -  If both startTime and endTime are sent, time between startTime and endTime must be less than 1 hour.
     *   -  If fromId, startTime, and endTime are not sent, the most recent aggregate trades will be returned.
     *   -  Only market trades will be aggregated and returned, which means the insurance fund trades and ADL
     *      trades won't be aggregated.
     *
     * GET /fapi/v1/aggTrades
     * Weight: 20
     *
     * https://binance-docs.github.io/apidocs/futures/en/#compressed-aggregate-trades-list
     *
     * @param symbol the ticker symbol (eg. BNBUSDT)
     * @param fromId - optional (-> replace by null) - ID to get aggregate trades from INCLUSIVE.
     * @param startTime - optional (-> replace by null) - Timestamp in ms to get aggregate trades from INCLUSIVE.
     * @param endTime - optional (-> replace by null) - Timestamp in ms to get aggregate trades until INCLUSIVE.
     * @param limit - optional (-> replace by null) - Default 500; max 1000.
     */
    List<AggregateTradeList> getCompressedAggregateTradesList(@NotNull String symbol, @Nullable Long fromId, @Nullable Long startTime, @Nullable Long endTime, @Nullable Integer limit);


    /**
     * Kline/Candlestick Data
     *
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *  - If startTime and endTime are not sent, the most recent klines are returned.
     *
     * GET /fapi/v1/klines
     * Limit [1;100[        -> Weight = 1
     * Limit [100;500[      -> Weight = 2
     * Limit [500;1000[     -> Weight = 5
     * Limit [1000;1500]    -> Weight = 10
     *
     *
     * https://binance-docs.github.io/apidocs/futures/en/#kline-candlestick-data
     *
     * @param symbol the ticker symbol (eg. BNBUSDT)
     * @param interval of the candlestick
     * @param startTime - optional (-> replace by null) - Timestamp in ms for the first candle
     * @param endTime - optional (-> replace by null) - Timestamp in ms for the last candle
     * @param limit - optional (-> replace by null) - Default 500; max 1500.
     */
    List<CandlestickBinance> getCandlestickData(@NotNull String symbol, @NotNull CandlestickChartInterval interval, @Nullable Long startTime, @Nullable Long endTime, @Nullable Integer limit);


    /** Continuous Contract Kline/Candlestick Data
     *
     * Kline/candlestick bars for a specific contract type.
     * Klines are uniquely identified by their open time.
     *
     *  -  If startTime and endTime are not sent, the most recent klines are returned.
     *  -  Contract type: PERPETUAL / CURRENT_QUARTER / NEXT_QUARTER
     *
     *
     * GET /fapi/v1/continuousKlines
     * Limit [1;100[        -> Weight = 1
     *      * Limit [100;500[      -> Weight = 2
     *      * Limit [500;1000[     -> Weight = 5
     *      * Limit [1000;1500]    -> Weight = 10
     *
     * https://binance-docs.github.io/apidocs/futures/en/#continuous-contract-kline-candlestick-data
     *
     * @param symbol the ticker symbol (eg. BNBUSDT)
     * @param contractType PERPETUAL / CURRENT_QUARTER / NEXT_QUARTER
     * @param interval of the candlestick
     * @param startTime - optional (-> replace by null) - Timestamp in ms for the first candle
     * @param endTime - optional (-> replace by null) - Timestamp in ms for the last candle
     * @param limit - optional (-> replace by null) - Default 500; max 1500.
     */
    List<CandlestickBinance> getContinuousContractCandlestickData(@NotNull String symbol, @NotNull ContractType contractType,@NotNull CandlestickChartInterval interval, @Nullable Long startTime, @Nullable Long endTime, @Nullable Integer limit);

}
