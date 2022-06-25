package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.OrderType;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.TimeInForce;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class SymbolTest {

    private final static String SYMBOL_BTC = "{\"symbol\":\"BTCUSDT\",\"pair\":\"BTCUSDT\",\"contractType\":\"PERPETUAL\",\"deliveryDate\":4133404800000,\"onboardDate\":1569398400000,\"status\":\"TRADING\",\"maintMarginPercent\":\"2.5000\",\"requiredMarginPercent\":\"5.0000\",\"baseAsset\":\"BTC\",\"quoteAsset\":\"USDT\",\"marginAsset\":\"USDT\",\"pricePrecision\":2,\"quantityPrecision\":3,\"baseAssetPrecision\":8,\"quotePrecision\":8,\"underlyingType\":\"COIN\",\"underlyingSubType\":[\"PoW\"],\"settlePlan\":0,\"triggerProtect\":\"0.0500\",\"liquidationFee\":\"0.015000\",\"marketTakeBound\":\"0.05\",\"filters\":[{\"minPrice\":\"556.80\",\"maxPrice\":\"4529764\",\"filterType\":\"PRICE_FILTER\",\"tickSize\":\"0.10\"},{\"stepSize\":\"0.001\",\"filterType\":\"LOT_SIZE\",\"maxQty\":\"1000\",\"minQty\":\"0.001\"},{\"stepSize\":\"0.001\",\"filterType\":\"MARKET_LOT_SIZE\",\"maxQty\":\"120\",\"minQty\":\"0.001\"},{\"limit\":200,\"filterType\":\"MAX_NUM_ORDERS\"},{\"limit\":10,\"filterType\":\"MAX_NUM_ALGO_ORDERS\"},{\"notional\":\"5\",\"filterType\":\"MIN_NOTIONAL\"},{\"multiplierDown\":\"0.9500\",\"multiplierUp\":\"1.0500\",\"multiplierDecimal\":\"4\",\"filterType\":\"PERCENT_PRICE\"}],\"orderTypes\":[\"LIMIT\",\"MARKET\",\"STOP\",\"STOP_MARKET\",\"TAKE_PROFIT\",\"TAKE_PROFIT_MARKET\",\"TRAILING_STOP_MARKET\"],\"timeInForce\":[\"GTC\",\"IOC\",\"FOK\",\"GTX\"]}";

    @Test
    public void symbolTest() {
        Symbol symbol = null;

        try {
            symbol = new ObjectMapper().readValue(SYMBOL_BTC, Symbol.class);
        } catch (JsonProcessingException e) {
            fail(e);
        }

        if (symbol != null) {

            assertEquals("BTCUSDT", symbol.getSymbol());
            assertEquals("BTCUSDT", symbol.getPair());
            assertEquals("PERPETUAL", symbol.getContractType());
            assertEquals(Long.valueOf("4133404800000"), symbol.getDeliveryDate());
            assertEquals(Long.valueOf("1569398400000"), symbol.getOnboardDate());
            assertEquals("TRADING", symbol.getStatus());
            assertEquals(Float.valueOf((float) 2.5), symbol.getMaintMarginPercent());
            assertEquals(Float.valueOf((float) 5.0), symbol.getRequiredMarginPercent());
            assertEquals("BTC", symbol.getBaseAsset());
            assertEquals("USDT", symbol.getQuoteAsset());
            assertEquals("USDT", symbol.getMarginAsset());
            assertEquals(2, symbol.getPricePrecision());
            assertEquals(3, symbol.getQuantityPrecision());
            assertEquals(8, symbol.getBaseAssetPrecision());
            assertEquals(8, symbol.getQuotePrecision());
            assertEquals("COIN", symbol.getUnderlyingType());
            assertEquals(new ArrayList<>(){{add("PoW");}}, symbol.getUnderlyingSubType());
            assertEquals(0, symbol.getSettlePlan());
            assertEquals((float) 0.05, symbol.getTriggerProtect());
            assertEquals((float) 0.015, symbol.getLiquidationFee());
            assertEquals((float) 0.05, symbol.getMarketTakeBound());
            assertEquals(7, symbol.getFilters().size());
            assertEquals(new ArrayList<>(){{
                        add(OrderType.LIMIT);
                        add(OrderType.MARKET);
                        add(OrderType.STOP);
                        add(OrderType.STOP_MARKET);
                        add(OrderType.TAKE_PROFIT);
                        add(OrderType.TAKE_PROFIT_MARKET);
                        add(OrderType.TRAILING_STOP_MARKET);
            }}, symbol.getOrderTypes());

            assertEquals(new ArrayList<>(){{
                add(TimeInForce.GTC);
                add(TimeInForce.IOC);
                add(TimeInForce.FOK);
                add(TimeInForce.GTX);
            }}, symbol.getTimeInForce());

        } else {
            fail("Symbol is not instantiate");
        }
    }

}
