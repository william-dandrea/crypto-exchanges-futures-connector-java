package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * @author D'Andréa William
 */
public class FilterDeserializer extends StdDeserializer<Filter> {


    public FilterDeserializer(Class<?> vc) {
        super(vc);
    }

    public FilterDeserializer() {
        this(null);
    }


    @Override
    public Filter deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String filterType = node.get("filterType").asText();


        if (filterType.equals("PRICE_FILTER")) {
            Double minPrice = node.get("minPrice").asDouble();
            Double maxPrice = node.get("maxPrice").asDouble();
            Double tickSize = node.get("tickSize").asDouble();
            PriceFilter result = new PriceFilter(filterType, minPrice, maxPrice, tickSize);
            return result;
        }

        if (filterType.equals("LOT_SIZE")) {
            Double stepSize = node.get("stepSize").asDouble();
            Double maxQty = node.get("maxQty").asDouble();
            Double minQty = node.get("minQty").asDouble();
            return new LotSizeFilter(filterType, stepSize, maxQty, minQty);
        }

        if (filterType.equals("MARKET_LOT_SIZE")) {
            Double stepSize = node.get("stepSize").asDouble();
            Double maxQty = node.get("maxQty").asDouble();
            Double minQty = node.get("minQty").asDouble();
            return new MarketLotSizeFilter(filterType, stepSize, maxQty, minQty);
        }

        if (filterType.equals("MAX_NUM_ALGO_ORDERS")) {
            Double limit = node.get("limit").asDouble();
            return new MaxNumAlgoOrdersFilter(filterType, limit);
        }
        if (filterType.equals("MAX_NUM_ORDERS")) {
            Double limit = node.get("limit").asDouble();
            return new MaxNumOrdersFilter(filterType, limit);
        }
        if (filterType.equals("MIN_NOTIONAL")) {
            Double notional = node.get("notional").asDouble();
            return new MinNotionalFilter(filterType, notional);
        }

        if (filterType.equals("PERCENT_PRICE")) {
            Double multiplierDown = node.get("multiplierDown").asDouble();
            Double multiplierUp = node.get("multiplierUp").asDouble();
            Double multiplierDecimal = node.get("multiplierDecimal").asDouble();

            return new PercentPriceFilter(filterType, multiplierDown, multiplierUp, multiplierDecimal);
        }

        System.out.println("ICI");
        return null;
    }
}
