package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class FilterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void deserializationEasyTest() throws JsonProcessingException {
        Filter filter = new ObjectMapper().readValue("{\n" +
                "  \"minPrice\": \"556.80\",\n" +
                "  \"maxPrice\": \"4529764\",\n" +
                "  \"filterType\": \"PRICE_FILTER\",\n" +
                "  \"tickSize\": \"0.10\"\n" +
                "}", Filter.class);


        System.out.println(filter);
    }



}
