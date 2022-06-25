package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook.OrderBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author D'Andréa William
 */
class OrderBookTest {

    @BeforeEach
    void setUp() {}

    @Test
    void orderBookTest() throws JsonProcessingException {
        OrderBook orderBook = new ObjectMapper().readValue("{\n" +
                "    \"lastUpdateId\": 1652034365302,\n" +
                "    \"E\": 1656142477560,\n" +
                "    \"T\": 1656142477547,\n" +
                "    \"bids\": [\n" +
                "        [\n" +
                "            \"21502.50\",\n" +
                "            \"0.691\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21502.40\",\n" +
                "            \"0.279\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21502.30\",\n" +
                "            \"0.001\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21502.10\",\n" +
                "            \"0.002\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21501.70\",\n" +
                "            \"1.985\"\n" +
                "        ]\n" +
                "    ],\n" +
                "    \"asks\": [\n" +
                "        [\n" +
                "            \"21502.60\",\n" +
                "            \"0.130\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21503.00\",\n" +
                "            \"0.006\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21503.10\",\n" +
                "            \"0.143\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21504.00\",\n" +
                "            \"0.002\"\n" +
                "        ],\n" +
                "        [\n" +
                "            \"21504.20\",\n" +
                "            \"1.247\"\n" +
                "        ]\n" +
                "    ]\n" +
                "}", OrderBook.class);


        assertEquals(Long.valueOf("1652034365302"), orderBook.getLastUpdateId());
        assertEquals(Long.valueOf("1656142477560"), orderBook.getMessageOutputTime());
        assertEquals(Long.valueOf("1656142477547"), orderBook.getTransactionTime());

        List<Bids> bids = orderBook.getBids();
        List<Asks> asks = orderBook.getAsks();

        assertEquals(5, bids.size());
        assertEquals("21502.5", String.valueOf(bids.get(0).getPrice()));
        assertEquals("0.691", String.valueOf(bids.get(0).getQuantity()));

        assertEquals(5, asks.size());
        assertEquals("21502.6", String.valueOf(asks.get(0).getPrice()));
        assertEquals("0.13", String.valueOf(asks.get(0).getQuantity()));
    }
}
