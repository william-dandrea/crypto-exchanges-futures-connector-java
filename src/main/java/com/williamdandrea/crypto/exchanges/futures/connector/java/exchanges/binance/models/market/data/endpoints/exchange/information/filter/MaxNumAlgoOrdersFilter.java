package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MaxNumAlgoOrdersFilter extends Filter {

    @JsonProperty
    private Double limit;

    @JsonCreator
    public MaxNumAlgoOrdersFilter(String filterType, Double limit) {
        super(filterType);
        this.limit = limit;
    }

    public Double getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("filterType", this.filterType)
                .append("limit", this.limit)
                .build();
    }
}
