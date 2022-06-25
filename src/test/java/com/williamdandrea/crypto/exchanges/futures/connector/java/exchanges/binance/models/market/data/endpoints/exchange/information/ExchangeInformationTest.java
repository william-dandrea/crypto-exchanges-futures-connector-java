package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class ExchangeInformationTest {

    private static final String EXCHANGE_JSON = "{\"timezone\":\"UTC\",\"serverTime\":1656136823468,\"futuresType\":\"U_MARGINED\",\"rateLimits\":[],\"exchangeFilters\":[],\"assets\":[],\"symbols\":[]}";

    @Test
    public void exchangeInformationTest() {

         ExchangeInformation exchangeInformation = null;

        try {
            exchangeInformation = new ObjectMapper().readValue(EXCHANGE_JSON, ExchangeInformation.class);
        } catch (JsonProcessingException e) {
            fail(e);
        }

        if (exchangeInformation != null) {

            assertEquals("UTC", exchangeInformation.getTimezone());
            assertEquals(Long.valueOf("1656136823468"), exchangeInformation.getServerTime());
            assertEquals("U_MARGINED", exchangeInformation.getFuturesType());
            assertTrue(exchangeInformation.getRateLimits().isEmpty());
            assertTrue(exchangeInformation.getAssets().isEmpty());
            assertTrue(exchangeInformation.getExchangeFilters().isEmpty());
            assertTrue(exchangeInformation.getSymbols().isEmpty());

        } else {
            fail("exchangeInformation is not instantiate");
        }
    }

}
