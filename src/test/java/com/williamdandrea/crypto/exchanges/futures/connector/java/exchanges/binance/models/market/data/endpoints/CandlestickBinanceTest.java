package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class CandlestickBinanceTest {

    private final String CANDLESTICK_JSON = "[\n" +
            "    1607444700000," +
            "    \"18879.99\",      " +
            "    \"18900.00\",        " +
            "    \"18878.98\",            " +
            "    \"18896.13\",         " +
            "    \"492.363\",   " +
            "    1607444759999,      " +
            "    \"9302145.66080\",      " +
            "    1874,               " +
            "    \"385.983\",         " +
            "    \"7292402.33267\",   " +
            "    \"0\"               " +
            "  ]";


    @Test
    void candlestickBinanceTest() {

        CandlestickBinance candlestickBinance = null;

        try {
            candlestickBinance = new ObjectMapper().readValue(CANDLESTICK_JSON, CandlestickBinance.class);
        } catch (JsonProcessingException e) {
            fail(e);
        }


        if (candlestickBinance != null) {
            assertEquals(Long.valueOf("1607444700000"), candlestickBinance.getOpenTime());
            assertEquals(Long.valueOf("1607444759999"), candlestickBinance.getCloseTime());
            assertEquals(Long.valueOf("1874"), candlestickBinance.getNumberOfTrades());

            assertEquals(Double.valueOf("18879.99"), candlestickBinance.getOpenPrice());
            assertEquals(Double.valueOf("18900.00"), candlestickBinance.getHighPrice());
            assertEquals(Double.valueOf("18878.98"), candlestickBinance.getLowPrice());
            assertEquals(Double.valueOf("18896.13"), candlestickBinance.getClosePrice());
            assertEquals(Double.valueOf("492.363"), candlestickBinance.getVolume());
            assertEquals(Double.valueOf("9302145.66080"), candlestickBinance.getQuoteAssetVolume());
            assertEquals(Double.valueOf("385.983"), candlestickBinance.getTakerBuyBaseVolume());
            assertEquals(Double.valueOf("7292402.33267"), candlestickBinance.getTakerBuyQuoteVolume());
        } else {
            fail();
        }

    }


}
