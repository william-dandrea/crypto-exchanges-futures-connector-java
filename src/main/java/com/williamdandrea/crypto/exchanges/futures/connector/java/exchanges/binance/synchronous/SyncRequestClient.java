package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.synchronous;

/**
 * Synchronous request interface, invoking Binance RestAPI via synchronous
 * method.
 * All methods in this interface will be blocked until the RestAPI response.
 * If the invoking failed or timeout, the BinanceApiException will be thrown.
 */
public interface SyncRequestClient {

}
