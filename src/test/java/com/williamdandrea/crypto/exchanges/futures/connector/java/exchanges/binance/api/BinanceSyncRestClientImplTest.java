package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceClientFactory;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceSyncRestClient;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class BinanceSyncRestClientImplTest {

    private BinanceSyncRestClient binanceSyncRestClient;

    @BeforeEach
    void setUp() {
        BinanceClientFactory binanceClientFactory = new BinanceClientFactory(Constants.BINANCE_API_KEY, Constants.BINANCE_SECRET_KEY);
        this.binanceSyncRestClient = binanceClientFactory.newSyncRestClient();
    }

    @Test
    void pingTest() {
        this.binanceSyncRestClient.ping();
    }

    @Test
    void serverTimeTest() {
        System.out.println(this.binanceSyncRestClient.getServerTime());
    }

    @Test
    void exchangeInfoTest() {
        System.out.println(this.binanceSyncRestClient.getExchangeInformation());
    }

    @Test
    void orderBookTest() {
        System.out.println(this.binanceSyncRestClient.getOrderBook("BTCUSDT", 5));

        assertThrows(BinanceApiException.class, () -> {
            this.binanceSyncRestClient.getOrderBook("BTCUSDT", 7);
        });
    }




    @AfterEach
    void tearDown() {
    }
}
