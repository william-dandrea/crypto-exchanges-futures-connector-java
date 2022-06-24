package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class MinNotionalFilter extends Filter {

    @JsonProperty
    private Double notional;

    @JsonCreator
    public MinNotionalFilter(String filterType, Double notional) {
        super(filterType);
        this.notional = notional;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("filterType", this.filterType)
                .append("notional", this.notional)
                .build();
    }
}
