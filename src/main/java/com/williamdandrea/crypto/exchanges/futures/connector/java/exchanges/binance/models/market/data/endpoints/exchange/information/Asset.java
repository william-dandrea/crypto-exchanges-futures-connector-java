package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author D'Andréa William
 */
public class Asset {


    private final String asset;
    private final Boolean marginAvailable;
    private final Float autoAssetExchange;

    public Asset(
            @JsonProperty("asset") String asset,
            @JsonProperty("marginAvailable") Boolean marginAvailable,
            @JsonProperty("autoAssetExchange") String autoAssetExchange) {
        this.asset = asset;
        this.marginAvailable = marginAvailable;
        this.autoAssetExchange = Float.valueOf(autoAssetExchange);
    }

    public String getAsset() {
        return asset;
    }

    public Boolean getMarginAvailable() {
        return marginAvailable;
    }

    public Float getAutoAssetExchange() {
        return autoAssetExchange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("asset", asset)
                .append("marginAvailable", marginAvailable)
                .append("autoAssetExchange", autoAssetExchange)
                .build();

    }
}
