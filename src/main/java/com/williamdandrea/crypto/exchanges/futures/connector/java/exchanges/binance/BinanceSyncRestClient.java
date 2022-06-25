package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.TradeList;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook.OrderBook;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;

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
     *
     * @param symbol the ticker symbol (eg. BNBUSDT)
     * @param limit - optional (-> replace by null) - depth of the orderbook ( Default 500; Valid limits:[5, 10, 20, 50, 100, 500, 1000] )
     */
    OrderBook getOrderBook(String symbol, Integer limit);


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
    List<TradeList> getRecentTradeList(String symbol, Integer limit);


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
    List<TradeList> getOldTradeLookup(String symbol, Integer limit, Long fromId);

}
