package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MarketLotSizeFilter extends Filter {

    @JsonProperty
    private Double stepSize;
    @JsonProperty
    private Double maxQty;
    @JsonProperty
    private Double minQty;


    @JsonCreator
    public MarketLotSizeFilter(String filterType, Double stepSize, Double maxQty, Double minQty) {
        super(filterType);
        this.stepSize = stepSize;
        this.maxQty = maxQty;
        this.minQty = minQty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("filterType", this.filterType)
                .append("stepSize", this.stepSize)
                .append("maxQty", this.maxQty)
                .append("minQty", this.minQty)
                .build();
    }
}
