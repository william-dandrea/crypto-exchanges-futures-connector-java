package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * @author D'Andréa William
 */
public class OrderBook {

    @JsonProperty
    private Long lastUpdateId;

    @JsonProperty(value = "E")
    private Long messageOutputTime;

    @JsonProperty(value = "T")
    private Long transactionTime;

    @JsonProperty
    private List<Bids> bids;

    @JsonProperty
    private List<Asks> asks;

    public Long getLastUpdateId() {
        return lastUpdateId;
    }

    public Long getMessageOutputTime() {
        return messageOutputTime;
    }

    public Long getTransactionTime() {
        return transactionTime;
    }

    public List<Bids> getBids() {
        return bids;
    }

    public List<Asks> getAsks() {
        return asks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("lastUpdateId", this.lastUpdateId)
                .append("messageOutputTime", this.messageOutputTime)
                .append("transactionTime", this.transactionTime)
                .append("bids", this.bids)
                .append("asks", this.asks)
                .build();
    }


}
