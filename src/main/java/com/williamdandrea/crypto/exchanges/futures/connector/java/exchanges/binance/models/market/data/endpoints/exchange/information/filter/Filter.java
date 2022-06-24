package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author D'Andréa William
 */



@JsonDeserialize(using = FilterDeserializer.class)
public abstract class Filter {

    @JsonProperty protected String filterType;

    @JsonCreator
    public Filter(String filterType) {
        this.filterType = filterType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("filterType", filterType)
                .build();
    }
}


/*
@JsonSubTypes({
        @JsonSubTypes.Type(value = PriceFilter.class, name = "PRICE_FILTER"),
        @JsonSubTypes.Type(value = LotSizeFilter.class, name = "LOT_SIZE"),
        @JsonSubTypes.Type(value = MarketLotSizeFilter.class, name = "MARKET_LOT_SIZE"),
        @JsonSubTypes.Type(value = MaxNumAlgoOrdersFilter.class, name = "MAX_NUM_ALGO_ORDERS"),
        @JsonSubTypes.Type(value = MaxNumOrdersFilter.class, name = "MAX_NUM_ORDERS"),
        @JsonSubTypes.Type(value = MinNotionalFilter.class, name = "MIN_NOTIONAL"),
        @JsonSubTypes.Type(value = PercentPriceFilter.class, name = "PERCENT_PRICE"),
}) */


