package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author D'Andréa William
 */
public class AggregateTradeList {

    private final Long aggregateTradeId;
    private final Double price;
    private final Double quantity;
    private final Long firstTradeId;
    private final Long lastTradeId;
    private final Long timestamp;
    private final Boolean wasTheBuyerTheMaker;

    public AggregateTradeList(
            @JsonProperty("a") Long aggregateTradeId,
            @JsonProperty("p") String price,
            @JsonProperty("q") String quantity,
            @JsonProperty("f") Long firstTradeId,
            @JsonProperty("l") Long lastTradeId,
            @JsonProperty("T") Long timestamp,
            @JsonProperty("m") Boolean wasTheBuyerTheMaker
    ) {
        this.aggregateTradeId = aggregateTradeId;
        this.price = Double.valueOf(price);
        this.quantity = Double.valueOf(quantity);
        this.firstTradeId = firstTradeId;
        this.lastTradeId = lastTradeId;
        this.timestamp = timestamp;
        this.wasTheBuyerTheMaker = wasTheBuyerTheMaker;
    }

    public Long getAggregateTradeId() {
        return aggregateTradeId;
    }

    public Double getPrice() {
        return price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Long getFirstTradeId() {
        return firstTradeId;
    }

    public Long getLastTradeId() {
        return lastTradeId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Boolean getWasTheBuyerTheMaker() {
        return wasTheBuyerTheMaker;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("aggregateTradeId", this.aggregateTradeId )
                .append("price", this.price )
                .append("quantity", this.quantity )
                .append("firstTradeId", this.firstTradeId )
                .append("lastTradeId", this.lastTradeId )
                .append("timestamp", this.timestamp )
                .append("wasTheBuyerTheMaker", this.wasTheBuyerTheMaker )
                .build();
    }
}
