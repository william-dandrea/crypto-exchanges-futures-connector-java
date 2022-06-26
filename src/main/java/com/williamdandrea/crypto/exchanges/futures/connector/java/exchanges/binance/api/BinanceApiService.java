package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.AggregateTradeList;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.TradeList;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook.OrderBook;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.utils.BinanceConstants;
import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

/**
 * @author D'Andréa William
 */
public interface BinanceApiService {

    @GET("/fapi/v1/ping")
    Call<Void> ping();

    @GET("/fapi/v1/time")
    Call<ServerTime> getServerTime();

    @GET("/fapi/v1/exchangeInfo")
    Call<ExchangeInformation> getExchangeInformation();

    @GET("/fapi/v1/depth")
    Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @GET("/fapi/v1/trades")
    Call<List<TradeList>> getRecentTradeList(@Query("symbol")String symbol, @Query("limit")Integer limit);

    @Headers(BinanceConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/fapi/v1/historicalTrades")
    Call<List<TradeList>> getOldTradeLookup(@Query("symbol")String symbol, @Query("limit")Integer limit, @Query("fromId")Long fromId);

    @GET("/fapi/v1/aggTrades")
    Call<List<AggregateTradeList>> getCompressedAggregateTradesList(@Query("symbol")String symbol, @Query("fromId") Long fromId, @Query("startTime") Long startTime, @Query("endTime") Long endTime, @Query("limit") Integer limit);
}
