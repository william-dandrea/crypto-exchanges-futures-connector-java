package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.exchange.information;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty private Integer pricePrecision;
    @JsonProperty private Integer quantityPrecision;
    @JsonProperty private Integer baseAssetPrecision;
    @JsonProperty private Integer quotePrecision;
    @JsonProperty private String underlyingType;
    @JsonProperty private List<String> underlyingSubType;
    @JsonProperty private Integer settlePlan;
    @JsonProperty private String triggerProtect;
    @JsonProperty private String liquidationFee;
    @JsonProperty private String marketTakeBound;
    @JsonProperty private List<Filter> filters;






}
