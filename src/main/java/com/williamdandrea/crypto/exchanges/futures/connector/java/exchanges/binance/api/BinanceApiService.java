package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author D'Andréa William
 */
public interface BinanceApiService {

    @GET("/api/v1/ping")
    Call<Void> ping();

}
