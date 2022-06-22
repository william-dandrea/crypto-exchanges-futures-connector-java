package com.williamdandrea.crypto.exchanges.futures.connector.java.utils;

import com.alibaba.fastjson.JSON;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exception.BinanceApiException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.utils.enumerations.HttpMethod;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class that add the URL and POST parameters to the Http Request
 * @author D'Andréa William
 */
public class UrlParams {

    private static final MediaType JSON_TYPE = MediaType.parse("application/json");
    private final ParamsMap paramsMap = new ParamsMap();
    private final ParamsMap postBodyMap = new ParamsMap();
    private HttpMethod method = HttpMethod.GET;

    private UrlParams(){}

    public static UrlParams build() {
        return new UrlParams();
    }

    public UrlParams setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public <T extends Enum> UrlParams putToUrl(String name, T value) throws BinanceApiException {
        if (value != null) {
            paramsMap.put(name, value.toString());
        }
        return this;
    }

    public UrlParams putToUrl(String name, String value) throws BinanceApiException {
        paramsMap.put(name, value);
        return this;
    }

    public UrlParams putToUrl(String name, Date value, String format) throws BinanceApiException {
        paramsMap.put(name, value, format);
        return this;
    }

    public UrlParams putToUrl(String name, Integer value) throws BinanceApiException {
        paramsMap.put(name, value);
        return this;
    }

    public UrlParams putToUrl(String name, Long value) throws BinanceApiException {
        paramsMap.put(name, value);
        return this;
    }

    public UrlParams putToUrl(String name, BigDecimal value) throws BinanceApiException {
        paramsMap.put(name, value);
        return this;
    }

    public UrlParams putToPost(String name, String value) throws BinanceApiException {
        postBodyMap.put(name, value);
        return this;
    }

    public <T extends Enum> UrlParams putToPost(String name, T value) throws BinanceApiException {
        if (value != null) {
            postBodyMap.put(name, value.toString());
        }
        return this;
    }

    public UrlParams putToPost(String name, Date value, String format) throws BinanceApiException {
        postBodyMap.put(name, value, format);
        return this;
    }

    public UrlParams putToPost(String name, Integer value) throws BinanceApiException {
        postBodyMap.put(name, value);
        return this;
    }

    public <T> UrlParams putToPost(String name, List<String> list) {
        postBodyMap.stringListMap.put(name, list);
        return this;
    }

    public UrlParams putToPost(String name, Long value) throws BinanceApiException {
        postBodyMap.put(name, value);
        return this;
    }

    public UrlParams putToPost(String name, BigDecimal value) throws BinanceApiException {
        postBodyMap.put(name, value);
        return this;
    }





    public String buildUrl() {
        Map<String, String> map = new LinkedHashMap<>(paramsMap.map);
        StringBuilder head = new StringBuilder("");
        return "?" + AppendUrl(map, head);
    }

    public String buildSignature() {
        Map<String, String> map = new LinkedHashMap<>(paramsMap.map);
        StringBuilder head = new StringBuilder();
        return AppendUrl(map, head);
    }

    public RequestBody buildPostBody() {
        if (postBodyMap.stringListMap.isEmpty()) {
            if (postBodyMap.map.isEmpty()) {
                return RequestBody.create("", JSON_TYPE);
            }
            return RequestBody.create(JSON.toJSONString(postBodyMap.map), JSON_TYPE);
        }

        return RequestBody.create(JSON.toJSONString(postBodyMap.stringListMap), JSON_TYPE);
    }

    private String AppendUrl(Map<String, String> map, StringBuilder stringBuilder) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!("").equals(stringBuilder.toString())) {
                stringBuilder.append("&");
            }
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(urlEncodeToUTF8(entry.getValue()));
        }
        return stringBuilder.toString();
    }

    private static String urlEncodeToUTF8(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
    }



    public boolean hasPostParam() {
        return !postBodyMap.map.isEmpty() || method.equals(HttpMethod.POST);
    }

    public String buildUrlToJsonString() {
        return JSON.toJSONString(paramsMap.map);
    }






    private class ParamsMap {

        final Map<String, String> map = new LinkedHashMap<>();
        final Map<String, List> stringListMap = new HashMap<>();

        void put(String name, String value) throws BinanceApiException {
            if (name == null || "".equals(name)) {
                throw new BinanceApiException(BinanceApiException.RUNTIME_ERROR, "[URL] Key can not be null");
            }
            if (value == null || "".equals(value)) {
                return;
            }

            map.put(name, value);
        }


        void put(String name, Integer value) throws BinanceApiException {
            put(name, value != null ? Integer.toString(value) : null);
        }

        void put(String name, Date value, String format) throws BinanceApiException {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
            put(name, value != null ? dateFormatter.format(value) : null);
        }

        void put(String name, Long value) throws BinanceApiException {
            put(name, value != null ? Long.toString(value) : null);
        }

        void put(String name, BigDecimal value) throws BinanceApiException {
            put(name, value != null ? value.toPlainString() : null);
        }
    }
}



