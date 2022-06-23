package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * https://binance-docs.github.io/apidocs/futures/en/#exchange-information
 * @author D'Andréa William
 */
public class ExchangeInformation {

    @JsonProperty
    private List<String> exchangeFilters;

    @JsonProperty
    private List<RateLimit> rateLimits;

    @JsonProperty
    private String futuresType;

    @JsonProperty
    private Long serverTime;

    @JsonProperty
    private List<Asset> assets;

    @JsonProperty @JsonIgnore
    private List<Symbol> symbols;

    @JsonProperty
    private String timezone;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("exchangeFilters", exchangeFilters)
                .append("rateLimits", rateLimits)
                .append("futuresType", futuresType)
                .append("serverTime", serverTime)
                .append("assets", assets)
                .append("symbols", symbols)
                .append("timezone", timezone)
                .build();

    }
}
