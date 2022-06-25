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

    private final String symbol;
    private final String pair;
    private final String contractType;
    private final Long deliveryDate;
    private final Long onboardDate;
    private final String status;
    private final Float maintMarginPercent;
    private final Float requiredMarginPercent;
    private final String baseAsset;
    private final String quoteAsset;
    private final String marginAsset;
    private final Long pricePrecision;
    private final Long quantityPrecision;
    private final Long baseAssetPrecision;
    private final Long quotePrecision;
    private final String underlyingType;
    private final List<String> underlyingSubType;
    private final Long settlePlan;
    private final Float triggerProtect;
    private final Float liquidationFee;
    private final Float marketTakeBound;
    private final List<Filter> filters;
    private final List<OrderType> orderTypes;
    private final List<TimeInForce> timeInForce;

    public Symbol(
            @JsonProperty("symbol") String symbol,
            @JsonProperty("pair") String pair,
            @JsonProperty("contractType") String contractType,
            @JsonProperty("deliveryDate") Long deliveryDate,
            @JsonProperty("onboardDate") Long onboardDate,
            @JsonProperty("status") String status,
            @JsonProperty("maintMarginPercent") String maintMarginPercent,
            @JsonProperty("requiredMarginPercent") String requiredMarginPercent,
            @JsonProperty("baseAsset") String baseAsset,
            @JsonProperty("quoteAsset") String quoteAsset,
            @JsonProperty("marginAsset") String marginAsset,
            @JsonProperty("pricePrecision") Long pricePrecision,
            @JsonProperty("quantityPrecision") Long quantityPrecision,
            @JsonProperty("baseAssetPrecision") Long baseAssetPrecision,
            @JsonProperty("quotePrecision") Long quotePrecision,
            @JsonProperty("underlyingType") String underlyingType,
            @JsonProperty("underlyingSubType") List<String> underlyingSubType,
            @JsonProperty("settlePlan") Long settlePlan,
            @JsonProperty("triggerProtect") String triggerProtect,
            @JsonProperty("liquidationFee") String liquidationFee,
            @JsonProperty("marketTakeBound") String marketTakeBound,
            @JsonProperty("filters") List<Filter> filters,
            @JsonProperty("orderTypes") List<OrderType> orderTypes,
            @JsonProperty("timeInForce") List<TimeInForce> timeInForce
    ) {
        this.symbol = symbol;
        this.pair = pair;
        this.contractType = contractType;
        this.deliveryDate = deliveryDate;
        this.onboardDate = onboardDate;
        this.status = status;
        this.maintMarginPercent = Float.valueOf(maintMarginPercent);
        this.requiredMarginPercent = Float.valueOf(requiredMarginPercent);
        this.baseAsset = baseAsset;
        this.quoteAsset = quoteAsset;
        this.marginAsset = marginAsset;
        this.pricePrecision = pricePrecision;
        this.quantityPrecision = quantityPrecision;
        this.baseAssetPrecision = baseAssetPrecision;
        this.quotePrecision = quotePrecision;
        this.underlyingType = underlyingType;
        this.underlyingSubType = underlyingSubType;
        this.settlePlan = settlePlan;
        this.triggerProtect = Float.valueOf(triggerProtect);
        this.liquidationFee = Float.valueOf(liquidationFee);
        this.marketTakeBound = Float.valueOf(marketTakeBound);
        this.filters = filters;
        this.orderTypes = orderTypes;
        this.timeInForce = timeInForce;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPair() {
        return pair;
    }

    public String getContractType() {
        return contractType;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public Long getOnboardDate() {
        return onboardDate;
    }

    public String getStatus() {
        return status;
    }

    public Float getMaintMarginPercent() {
        return maintMarginPercent;
    }

    public Float getRequiredMarginPercent() {
        return requiredMarginPercent;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public String getMarginAsset() {
        return marginAsset;
    }

    public Long getPricePrecision() {
        return pricePrecision;
    }

    public Long getQuantityPrecision() {
        return quantityPrecision;
    }

    public Long getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public Long getQuotePrecision() {
        return quotePrecision;
    }

    public String getUnderlyingType() {
        return underlyingType;
    }

    public List<String> getUnderlyingSubType() {
        return underlyingSubType;
    }

    public Long getSettlePlan() {
        return settlePlan;
    }

    public Float getTriggerProtect() {
        return triggerProtect;
    }

    public Float getLiquidationFee() {
        return liquidationFee;
    }

    public Float getMarketTakeBound() {
        return marketTakeBound;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public List<OrderType> getOrderTypes() {
        return orderTypes;
    }

    public List<TimeInForce> getTimeInForce() {
        return timeInForce;
    }

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
