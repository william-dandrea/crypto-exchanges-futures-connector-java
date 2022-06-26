package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.enums;

/**
 * m -> minutes; h -> hours; d -> days; w -> weeks; M -> months
 *
 * @author D'Andréa William
 */
public enum CandlestickChartInterval {

    ONE_MINUTES("1m"),
    THREE_MINUTES("3m"),
    FIVE_MINUTES("5m"),
    FIFTEEN_MINUTES("15m"),
    THIRTY_MINUTES("30m"),
    ONE_HOUR("1h"),
    TWO_HOURS("2h"),
    FOUR_HOURS("4h"),
    SIX_HOURS("6h"),
    HEIGHT_HOURS("8h"),
    TWELVE_HOURS("12h"),
    ONE_DAY("1d"),
    THREE_DAYS("3d"),
    ONE_WEEK("1w"),
    ONE_MONTH("1M");

    private final String value;

    CandlestickChartInterval(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
