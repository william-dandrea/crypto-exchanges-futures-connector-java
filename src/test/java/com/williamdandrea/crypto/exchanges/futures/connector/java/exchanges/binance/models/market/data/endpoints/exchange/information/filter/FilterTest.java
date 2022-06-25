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
    void deserializationPriceFilterTest() throws JsonProcessingException {
        Filter filter = new ObjectMapper().readValue(
                "{\n" +
                "  \"minPrice\": \"556.80\",\n" +
                "  \"maxPrice\": \"4529764\",\n" +
                "  \"filterType\": \"PRICE_FILTER\",\n" +
                "  \"tickSize\": \"0.10\"\n" +
                "}"
                , Filter.class);

        PriceFilter priceFilter = (PriceFilter) filter;

        assertEquals(556.80, priceFilter.getMinPrice());
        assertEquals(4529764, priceFilter.getMaxPrice());
        assertEquals("PRICE_FILTER", priceFilter.getFilterType());
        assertEquals(0.10, priceFilter.getTickSize());

        assertThrows(ClassCastException.class, () -> {
            LotSizeFilter testFilter = (LotSizeFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MarketLotSizeFilter testFilter = (MarketLotSizeFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MaxNumOrdersFilter testFilter = (MaxNumOrdersFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MaxNumAlgoOrdersFilter testFilter = (MaxNumAlgoOrdersFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MinNotionalFilter testFilter = (MinNotionalFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            PercentPriceFilter testFilter = (PercentPriceFilter) filter;
        });
    }


    @Test
    void deserializationLotSizeFilterTest() throws JsonProcessingException {
        Filter filter = new ObjectMapper().readValue(
                " {" +
                        " \"stepSize\": \"0.001\",\n" +
                        " \"filterType\": \"LOT_SIZE\",\n" +
                        " \"maxQty\": \"1000\",\n" +
                        " \"minQty\": \"0.001\"\n" +
                        "}"
                , Filter.class);

        LotSizeFilter lotSizeFilter = (LotSizeFilter) filter;

        assertEquals(0.001, lotSizeFilter.getStepSize());
        assertEquals(1000, lotSizeFilter.getMaxQty());
        assertEquals("LOT_SIZE", lotSizeFilter.getFilterType());
        assertEquals(0.001, lotSizeFilter.getMinQty());

        assertThrows(ClassCastException.class, () -> {
            PriceFilter testFilter = (PriceFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MarketLotSizeFilter testFilter = (MarketLotSizeFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MaxNumOrdersFilter testFilter = (MaxNumOrdersFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MaxNumAlgoOrdersFilter testFilter = (MaxNumAlgoOrdersFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            MinNotionalFilter testFilter = (MinNotionalFilter) filter;
        });

        assertThrows(ClassCastException.class, () -> {
            PercentPriceFilter testFilter = (PercentPriceFilter) filter;
        });
    }
}
