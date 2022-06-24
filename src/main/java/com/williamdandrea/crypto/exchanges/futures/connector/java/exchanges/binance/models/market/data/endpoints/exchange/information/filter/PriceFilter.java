package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class PriceFilter extends Filter {

    @JsonProperty
    private Double minPrice;
    @JsonProperty
    private Double maxPrice;
    @JsonProperty
    private Double tickSize;

    @JsonCreator
    public PriceFilter(String filterType, Double minPrice, Double maxPrice, Double tickSize) {
        super(filterType);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.tickSize = tickSize;

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("filterType", this.filterType)
                .append("minPrice", this.minPrice)
                .append("maxPrice", this.maxPrice)
                .append("tickSize", this.tickSize)
                .build();
    }
}
