package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author D'Andréa William
 */
public class TradeList {

    private final Long id;
    private final Float price;
    private final Float qty;
    private final Float quoteQty;
    private final Long time;
    private final Boolean isBuyerMaker;

    public TradeList(
            @JsonProperty("id") Long id,
            @JsonProperty("price") String price,
            @JsonProperty("qty") String qty,
            @JsonProperty("quoteQty") String quoteQty,
            @JsonProperty("time") String time,
            @JsonProperty("isBuyerMaker") Boolean isBuyerMaker
    ) {
        this.id = id;
        this.price = Float.valueOf(price);
        this.qty = Float.valueOf(qty);
        this.quoteQty = Float.valueOf(quoteQty);
        this.time = Long.valueOf(time);
        this.isBuyerMaker = isBuyerMaker;
    }

    public Float getQty() {
        return qty;
    }

    public Long getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    public Float getQuoteQty() {
        return quoteQty;
    }

    public Long getTime() {
        return time;
    }

    public Boolean getBuyerMaker() {
        return isBuyerMaker;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", this.id)
                .append("price", this.price)
                .append("quoteQty", this.quoteQty)
                .append("time", this.time)
                .append("isBuyerMaker", this.isBuyerMaker)
                .build();
    }


}
