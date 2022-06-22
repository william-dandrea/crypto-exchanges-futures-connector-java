package com.williamdandrea.crypto.exchanges.futures.connector.java.interfaces;

/**
 * Interface that contain all the operations available for each exchanges (eg - Place limit order, get all positions ...)
 * @author D'Andréa William
 */
public interface RestApiRequest {

    // static RestApiRequest createSynchronousClient(String apiKey, String secretKey);



    /**
     * Endpoints
     */

    String testConnectivity();


}
