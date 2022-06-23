package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models;

/**
 * @author D'Andréa William
 */
public class ServerTime {

    private Long serverTime;

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    @Override
    public String toString() {
        return String.valueOf(serverTime);
    }
}
