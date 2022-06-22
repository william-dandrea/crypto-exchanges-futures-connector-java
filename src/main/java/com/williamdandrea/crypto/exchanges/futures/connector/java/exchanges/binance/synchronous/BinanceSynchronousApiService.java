package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.synchronous;

import retrofit2.Call;
import retrofit2.http.*;


/**
 * @author D'Andréa William
 */
public interface BinanceSynchronousApiService {

    @GET("/api/v1/ping")
    Call<Void> ping();

}
