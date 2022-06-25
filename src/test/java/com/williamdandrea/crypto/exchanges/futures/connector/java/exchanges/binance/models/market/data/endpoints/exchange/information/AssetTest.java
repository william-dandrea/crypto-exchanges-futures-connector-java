package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author D'Andréa William
 */
class AssetTest {


    @Test
    public void assetLongTest() {

        Asset asset = null;

        try {
            asset = new ObjectMapper().readValue(
                    "{\n" +
                    "            \"asset\": \"USDT\",\n" +
                    "            \"marginAvailable\": true,\n" +
                    "            \"autoAssetExchange\": \"-10000\"\n" +
                    "        },\n"
                    , Asset.class
            );
        } catch (JsonProcessingException e) {
            fail(e);
        }

        if (asset != null) {

            assertEquals("USDT", asset.getAsset());
            assertEquals(true, asset.getMarginAvailable());
            assertEquals(-10000, asset.getAutoAssetExchange());

        } else {
            fail();
        }
    }

    @Test
    public void assetFloatTest() {

        Asset asset = null;

        try {
            asset = new ObjectMapper().readValue(
                    "{\n" +
                            "            \"asset\": \"BTC\",\n" +
                            "            \"marginAvailable\": true,\n" +
                            "            \"autoAssetExchange\": \"-0.00100000\"\n" +
                            "        }"
                    , Asset.class
            );
        } catch (JsonProcessingException e) {
            fail(e);
        }

        if (asset != null) {

            assertEquals("BTC", asset.getAsset());
            assertEquals(true, asset.getMarginAvailable());
            assertEquals(Float.valueOf((float) -0.001) , asset.getAutoAssetExchange());
        } else {
            fail();
        }
    }

}
