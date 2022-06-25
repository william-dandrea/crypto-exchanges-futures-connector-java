package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.RateLimitInterval;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.RateLimitType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class RateLimitTest {

    private static final String RATE_LIMIT_1 = "{\n" +
            "            \"rateLimitType\": \"REQUEST_WEIGHT\",\n" +
            "            \"interval\": \"MINUTE\",\n" +
            "            \"intervalNum\": 1,\n" +
            "            \"limit\": 2400\n" +
            "        }";

    private static final String RATE_LIMIT_2 = "{ \"rateLimitType\": \"ORDERS\", \"interval\": \"SECOND\",\"intervalNum\": 10,\"limit\": 300}";


    @Test
    public void rateLimitMinuteTest() {

        RateLimit rateLimit = null;

        try {
            rateLimit = new ObjectMapper().readValue(RATE_LIMIT_1, RateLimit.class);
        } catch (JsonProcessingException e) {
            fail(e);
        }

        if (rateLimit != null) {

            assertEquals(RateLimitType.REQUEST_WEIGHT, rateLimit.getRateLimitType());
            assertEquals(RateLimitInterval.MINUTE, rateLimit.getInterval());
            assertEquals(1, rateLimit.getIntervalNum());
            assertEquals(2400, rateLimit.getLimit());

        } else {
            fail("RateLimit not instanciate");
        }
    }


    @Test
    public void rateLimitSecondsOrderTest() {

        RateLimit rateLimit = null;

        try {
            rateLimit = new ObjectMapper().readValue(RATE_LIMIT_2, RateLimit.class);
        } catch (JsonProcessingException e) {
            fail(e);
        }

        if (rateLimit != null) {

            assertEquals(RateLimitType.ORDERS, rateLimit.getRateLimitType());
            assertEquals(RateLimitInterval.SECOND, rateLimit.getInterval());
            assertEquals(10, rateLimit.getIntervalNum());
            assertEquals(300, rateLimit.getLimit());

        } else {
            fail("RateLimit not instanciate");
        }
    }

}
