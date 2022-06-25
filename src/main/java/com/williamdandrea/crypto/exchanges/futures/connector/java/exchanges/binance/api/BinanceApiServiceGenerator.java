package com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.api;

import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.exceptions.BinanceApiException;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.middleware.BinanceInterceptor;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.models.BinanceApiError;
import com.williamdandrea.crypto.exchanges.futures.connector.java.exchanges.binance.utils.BinanceConstants;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * @author D'Andréa William
 */
public class BinanceApiServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BinanceConstants.BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret) {
        if (!StringUtils.isEmpty(apiKey) && !StringUtils.isEmpty(secret)) {
            BinanceInterceptor interceptor = new BinanceInterceptor(apiKey, secret);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);
                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                BinanceApiError apiError = getBinanceApiError(response);
                throw new BinanceApiException(apiError.toString());
            }
        } catch (IOException e) {
            throw new BinanceApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static BinanceApiError getBinanceApiError(Response<?> response) throws IOException, BinanceApiException {
        return (BinanceApiError) retrofit.responseBodyConverter(BinanceApiError.class, new Annotation[0]).convert(response.errorBody());
    }


}
