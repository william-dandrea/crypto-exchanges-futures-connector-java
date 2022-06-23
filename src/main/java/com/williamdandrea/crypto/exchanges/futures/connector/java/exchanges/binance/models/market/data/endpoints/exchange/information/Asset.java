package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author D'Andréa William
 */
public class Asset {

    @JsonProperty
    private String asset;

    @JsonProperty
    private Boolean marginAvailable;

    @JsonProperty
    private String autoAssetExchange;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("asset", asset)
                .append("marginAvailable", marginAvailable)
                .append("autoAssetExchange", autoAssetExchange)
                .build();

    }
}
