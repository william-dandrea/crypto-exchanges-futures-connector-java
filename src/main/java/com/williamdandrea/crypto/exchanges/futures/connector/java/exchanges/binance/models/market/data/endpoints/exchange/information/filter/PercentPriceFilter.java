package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PercentPriceFilter extends Filter {

    @JsonProperty
    private Double multiplierDown;
    @JsonProperty
    private Double multiplierUp;
    @JsonProperty
    private Double multiplierDecimal;

    @JsonCreator
    public PercentPriceFilter(String filterType, Double multiplierDown, Double multiplierUp, Double multiplierDecimal) {
        super(filterType);
        this.multiplierDown = multiplierDown;
        this.multiplierUp = multiplierUp;
        this.multiplierDecimal = multiplierDecimal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("filterType", this.filterType)
                .append("multiplierDown", this.multiplierDown)
                .append("multiplierUp", this.multiplierUp)
                .append("multiplierDecimal", this.multiplierDecimal)
                .build();
    }
}
