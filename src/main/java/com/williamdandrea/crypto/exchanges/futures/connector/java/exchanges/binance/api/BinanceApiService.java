package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook.OrderBook;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.ExchangeInformation;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.ServerTime;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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

}
