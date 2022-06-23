package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.middleware;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class that generate the message signature using HMAC-SHA256
 * @author D'Andréa William
 */
public class HmacSHA256SignatureManager {

    public static String sign(String message, String secretKey) {
        try {
            Mac sha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256.init(secretKeySpec);
            return Hex.encodeHexString(sha256.doFinal(message.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign message.", e);
        }
    }


}
