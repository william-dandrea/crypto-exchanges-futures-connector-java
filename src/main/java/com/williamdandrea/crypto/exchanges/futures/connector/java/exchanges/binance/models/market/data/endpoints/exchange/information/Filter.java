package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author D'Andréa William
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "filterType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PriceFilter.class),
        @JsonSubTypes.Type(value = LotSizeFilter.class),
        @JsonSubTypes.Type(value = MarketLotSizeFilter.class),
        @JsonSubTypes.Type(value = MaxNumOrdersFilter.class),
        @JsonSubTypes.Type(value = MaxNumAlgoOrdersFilter.class),
        @JsonSubTypes.Type(value = MinNationalFilter.class),
        @JsonSubTypes.Type(value = PercentPriceFilter.class),
})
public abstract class Filter {

    @JsonProperty private String filterType;
}


@JsonTypeName("PRICE_FILTER")
class PriceFilter extends Filter {

    @JsonProperty private String minPrice;
    @JsonProperty private String maxPrice;
    @JsonProperty private String tickSize;
}

@JsonTypeName("LOT_SIZE")
class LotSizeFilter extends Filter {

    @JsonProperty private String stepSize;
    @JsonProperty private String maxQty;
    @JsonProperty private String minQty;
}

@JsonTypeName("MARKET_LOT_SIZE")
class MarketLotSizeFilter extends Filter {

    @JsonProperty private String stepSize;
    @JsonProperty private String maxQty;
    @JsonProperty private String minQty;
}

@JsonTypeName("MAX_NUM_ORDERS")
class MaxNumOrdersFilter extends Filter {

    @JsonProperty private String limit;
}

@JsonTypeName("MAX_NUM_ALGO_ORDERS")
class MaxNumAlgoOrdersFilter extends Filter {

    @JsonProperty private String limit;
}

@JsonTypeName("MIN_NOTIONAL")
class MinNationalFilter extends Filter {

    @JsonProperty private String notional;
}


@JsonTypeName("PERCENT_PRICE")
class PercentPriceFilter extends Filter {

    @JsonProperty private String multiplierDown;
    @JsonProperty private String multiplierUp;
    @JsonProperty private String multiplierDecimal;
}
