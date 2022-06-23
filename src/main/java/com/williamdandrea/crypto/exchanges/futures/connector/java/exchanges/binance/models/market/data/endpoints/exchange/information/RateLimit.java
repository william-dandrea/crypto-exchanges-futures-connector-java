package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.RateLimitInterval;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.RateLimitType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *              "interval": "MINUTE",
 *              "intervalNum": 1,
 *              "limit": 2400,
 *              "rateLimitType": "REQUEST_WEIGHT"
 * @author D'Andréa William
 */
public class RateLimit {


    @JsonProperty
    private RateLimitInterval interval;

    @JsonProperty
    private Integer intervalNum;

    @JsonProperty
    private Integer limit;

    @JsonProperty
    private RateLimitType rateLimitType;



    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("interval", interval)
                .append("intervalNum", intervalNum)
                .append("limit", limit)
                .append("rateLimitType", rateLimitType)
                .build();

    }
}
