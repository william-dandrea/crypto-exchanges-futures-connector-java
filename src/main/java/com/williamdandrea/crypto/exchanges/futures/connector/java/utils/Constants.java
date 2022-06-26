package com.williamdandrea.crypto.exchanges.futures.connector.java.utils;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * @author D'Andréa William
 */
public class Constants {

    private static Dotenv dotenv = Dotenv.configure().load();


    public static String BINANCE_API_KEY = dotenv.get("BINANCE_API_KEY");
    public static String BINANCE_SECRET_KEY = dotenv.get("BINANCE_SECRET_KEY");


    /**
     * Utils
     */

    public static final Long MS_IN_ONE_DAY = Long.valueOf(24 * 60 * 60 * 1000);


}
