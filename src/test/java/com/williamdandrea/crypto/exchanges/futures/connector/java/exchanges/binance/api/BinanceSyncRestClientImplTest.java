package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceClientFactory;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.BinanceSyncRestClient;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiRequestParametersException;
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
        System.out.println(this.binanceSyncRestClient.getOrderBook("BTCUSDT", null));

        assertThrows(BinanceApiRequestParametersException.class, () -> {
            this.binanceSyncRestClient.getOrderBook("BTCUSDT", 7);
        });
    }

    @Test
    void orderBookOneParameterTest() {
        System.out.println(this.binanceSyncRestClient.getOrderBook("BTCUSDT", null));
    }

    @Test
    void recentTradeListOneParameterTest() {
        System.out.println(this.binanceSyncRestClient.getRecentTradeList("BTCUSDT", null));
    }

    @Test
    void recentTradeListTest() {
        System.out.println(this.binanceSyncRestClient.getRecentTradeList("BTCUSDT", 5));

        assertThrows(BinanceApiRequestParametersException.class, () -> {
            this.binanceSyncRestClient.getRecentTradeList("BTCUSDT", 0);
        });

        assertThrows(BinanceApiRequestParametersException.class, () -> {
            this.binanceSyncRestClient.getRecentTradeList("BTCUSDT", 1001);
        });
    }

    @Test
    void oldTradeLookupTest() {

        System.out.println(this.binanceSyncRestClient.getOldTradeLookup("BTCUSDT", null, null));
        System.out.println(this.binanceSyncRestClient.getOldTradeLookup("BTCUSDT", 5, null));


        assertThrows(BinanceApiRequestParametersException.class, () -> {
            this.binanceSyncRestClient.getOldTradeLookup("BTCUSDT", 0, null);
        });

        assertThrows(BinanceApiRequestParametersException.class, () -> {
            this.binanceSyncRestClient.getOldTradeLookup("BTCUSDT", 1001, null);
        });
    }

    @Test
    void oldTradeLookupWithIdTest() {
        System.out.println(this.binanceSyncRestClient.getOldTradeLookup("BTCUSDT", null, 100000000000L));
    }


    @AfterEach
    void tearDown() {}
}
