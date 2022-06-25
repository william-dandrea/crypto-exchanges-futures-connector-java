package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.market.data.endpoints.orderbook;

import com.fasterxml.jackson.annotation.JsonProperty;
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

@JsonDeserialize(using=AsksDeserializer.class)
public class Asks {

    @JsonProperty
    private Float price;

    @JsonProperty
    private Float quantity;

    public Asks(Float price, Float quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public Float getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("price", this.price)
                .append("quantity", this.quantity)
                .build();
    }
}


class AsksDeserializer extends StdDeserializer<Asks> {

    public AsksDeserializer(Class<?> vc) {
        super(vc);
    }

    public AsksDeserializer() {
        this(null);
    }


    @Override
    public Asks deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);


        Float price = Float.valueOf(node.get(0).textValue());
        Float quantity = Float.valueOf(node.get(1).textValue());

        return new Asks(price, quantity);
    }
}
