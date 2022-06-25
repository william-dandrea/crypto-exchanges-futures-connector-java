package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author D'Andréa William
 */
public class ServerTime {

    @JsonProperty
    private Long serverTime;

    @Override
    public String toString() {
        return String.valueOf(serverTime);
    }
}
