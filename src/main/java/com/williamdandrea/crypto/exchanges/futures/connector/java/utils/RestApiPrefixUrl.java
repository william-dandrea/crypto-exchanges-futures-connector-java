package com.williamdandrea.crypto.exchanges.futures.connector.java.utils;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.constants.BinanceConstants;
import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.enumerations.Exchange;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Factory class that manage the base url of each exchanges and verify that the transformation String -> URL is valid
 * @author D'Andréa William
 */
public class RestApiPrefixUrl {

    /** Prefix URL of the Exchange */
    private String url;
    /** Exchange we work for (Binance / KuCoin / ByBit ...) */
    private final Exchange exchange;

    /**
     * Initialize the class attribute url
     * @param exchange we work for (Binance / KuCoin / ByBit ...)
     */
    public RestApiPrefixUrl(Exchange exchange) {
        this.exchange = exchange;
        this.setUrl();
    }

    /**
     * Get the String url from the exchange
     * @return the prefix url from the exchange
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Method that set the class attribute url and watch if the url is valid or not.
     */
    private void setUrl() {
        try {
            URL url = new URL(this.getGoodUrlFromExchange());
            this.url = url.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Factory method that generate the good prefix URL from each types of exchanges.
     * @return the String prefix URL of each exchanges.
     */
    private String getGoodUrlFromExchange() {
        if (exchange.equals(Exchange.BINANCE))
            this.url = BinanceConstants.API_BASE_URL;

        return "";
    }


}
