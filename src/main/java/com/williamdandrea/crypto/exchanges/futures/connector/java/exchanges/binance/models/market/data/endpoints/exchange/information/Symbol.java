package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.OrderType;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums.TimeInForce;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information.filter.Filter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * @author D'Andréa William
 */
public class Symbol {


    @JsonProperty private String symbol;
    @JsonProperty private String pair;
    @JsonProperty private String contractType;
    @JsonProperty private Long deliveryDate;
    @JsonProperty private Long onboardDate;
    @JsonProperty private String status;
    @JsonProperty private String maintMarginPercent;
    @JsonProperty private String requiredMarginPercent;
    @JsonProperty private String baseAsset;
    @JsonProperty private String quoteAsset;
    @JsonProperty private String marginAsset;
    @JsonProperty private Long pricePrecision;
    @JsonProperty private Long quantityPrecision;
    @JsonProperty private Long baseAssetPrecision;
    @JsonProperty private Long quotePrecision;
    @JsonProperty private String underlyingType;
    @JsonProperty private List<String> underlyingSubType;
    @JsonProperty private Long settlePlan;
    @JsonProperty private String triggerProtect;
    @JsonProperty private String liquidationFee;
    @JsonProperty private String marketTakeBound;


    @JsonProperty List<Filter> filters;

    @JsonProperty List<OrderType> orderTypes;
    @JsonProperty List<TimeInForce> timeInForce;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("symbol", this.symbol)
                .append("pair", this.pair)
                .append("contractType", this.contractType)
                .append("deliveryDate", this.deliveryDate)
                .append("onboardDate", this.onboardDate)
                .append("status", this.status)
                .append("maintMarginPercent", this.maintMarginPercent)
                .append("requiredMarginPercent", this.requiredMarginPercent)
                .append("baseAsset", this.baseAsset)
                .append("quoteAsset", this.quoteAsset)
                .append("marginAsset", this.marginAsset)
                .append("pricePrecision", this.pricePrecision)
                .append("quantityPrecision", this.quantityPrecision)
                .append("baseAssetPrecision", this.baseAssetPrecision)
                .append("quotePrecision", this.quotePrecision)
                .append("underlyingType", this.underlyingType)
                .append("underlyingSubType", this.underlyingSubType)
                .append("settlePlan", this.settlePlan)
                .append("triggerProtect", this.triggerProtect)
                .append("liquidationFee", this.liquidationFee)
                .append("marketTakeBound", this.marketTakeBound)
                .append("filters", this.filters)
                .append("orderTypes", this.orderTypes)
                .append("timeInForce", this.timeInForce)
                .build();

    }
}
