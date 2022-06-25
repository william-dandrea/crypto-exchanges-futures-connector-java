package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class TradeListTest {

    private final static String TRADELIST_JSON = "{\"id\":2457767567,\"price\":\"21196.90\",\"qty\":\"0.001\",\"quoteQty\":\"21.19\",\"time\":1656165215009,\"isBuyerMaker\":true}";

    @BeforeEach
    void setUp() {
    }

    @Test
    void tradeListDeserializerTest() {

        TradeList tradeList = null;

        try {
            tradeList = new ObjectMapper().readValue(TRADELIST_JSON, TradeList.class);
        } catch (JsonProcessingException e) {
            fail(e);
        }

        if (tradeList != null) {
            assertEquals(Long.valueOf("2457767567"), tradeList.getId());
            assertEquals(Float.valueOf("21196.90"), tradeList.getPrice());
            assertEquals(Float.valueOf((float) 0.001), tradeList.getQty());
            assertEquals(Float.valueOf((float) 21.19), tradeList.getQuoteQty());
            assertEquals(Long.valueOf("1656165215009"), tradeList.getTime());
            assertEquals(true, tradeList.getBuyerMaker());
        } else {
            fail("tradeList == null");
        }

    }
}
