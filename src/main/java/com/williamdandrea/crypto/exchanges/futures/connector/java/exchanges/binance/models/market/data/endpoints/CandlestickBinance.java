package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;

/**
 * @author D'Andréa William
 */
@JsonDeserialize(using=CandlestickBinanceDeserializer.class)
public class CandlestickBinance {

    private final Long openTime;
    private final Double openPrice;
    private final Double highPrice;
    private final Double lowPrice;
    private final Double closePrice;
    private final Double volume;
    private final Long closeTime;
    private final Double quoteAssetVolume;
    private final Long numberOfTrades;
    private final Double takerBuyBaseVolume;
    private final Double takerBuyQuoteVolume;

    public CandlestickBinance(Long openTime, Double openPrice, Double highPrice, Double lowPrice, Double closePrice, Double volume, Long closeTime, Double quoteAssetVolume, Long numberOfTrades, Double takerBuyBaseVolume, Double takerBuyQuoteVolume) {
        this.openTime = openTime;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseVolume = takerBuyBaseVolume;
        this.takerBuyQuoteVolume = takerBuyQuoteVolume;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public Double getVolume() {
        return volume;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public Double getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public Long getNumberOfTrades() {
        return numberOfTrades;
    }

    public Double getTakerBuyBaseVolume() {
        return takerBuyBaseVolume;
    }

    public Double getTakerBuyQuoteVolume() {
        return takerBuyQuoteVolume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("openTime", this.openTime )
                .append("openPrice", this.openPrice )
                .append("highPrice", this.highPrice )
                .append("lowPrice", this.lowPrice )
                .append("closePrice", this.closePrice )
                .append("volume", this.volume )
                .append("closeTime", this.closeTime )
                .append("quoteAssetVolume", this.quoteAssetVolume )
                .append("numberOfTrades", this.numberOfTrades )
                .append("takerBuyBaseVolume", this.takerBuyBaseVolume )
                .append("takerBuyQuoteVolume", this.takerBuyQuoteVolume )
                .build();
    }
}


class CandlestickBinanceDeserializer extends StdDeserializer<CandlestickBinance> {

    public CandlestickBinanceDeserializer(Class<?> vc) {
        super(vc);
    }

    public CandlestickBinanceDeserializer() {
        this(null);
    }


    @Override
    public CandlestickBinance deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Long openTime = node.get(0).asLong();
        Double openPrice = Double.valueOf(node.get(1).textValue());
        Double highPrice = Double.valueOf(node.get(2).textValue());
        Double lowPrice = Double.valueOf(node.get(3).textValue());
        Double closePrice = Double.valueOf(node.get(4).textValue());
        Double volume = Double.valueOf(node.get(5).textValue());
        Long closeTime = node.get(6).asLong();
        Double quoteAssetVolume = Double.valueOf(node.get(7).textValue());
        Long numberOfTrades = node.get(8).asLong();
        Double takerBuyBaseVolume = Double.valueOf(node.get(9).textValue());
        Double takerBuyQuoteVolume = Double.valueOf(node.get(10).textValue());


        return new CandlestickBinance(openTime, openPrice, highPrice, lowPrice, closePrice, volume, closeTime, quoteAssetVolume, numberOfTrades, takerBuyBaseVolume, takerBuyQuoteVolume);
    }
}
