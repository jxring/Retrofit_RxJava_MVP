package com.example.y.mvp.network;


import com.socks.library.KLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * by y on 2016/4/28.
 */
class Network {


    private static TngouApi tngouApi;
    private static BaiDuApi baiDuApi;

    private static final Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static final CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static TngouApi getTngouApi() {
        if (tngouApi == null) {
            tngouApi = getRetrofit(Api.BASE_API_TNGOU).create(TngouApi.class);
        }
        return tngouApi;
    }

    public static BaiDuApi getBaiDuApi() {
        if (baiDuApi == null) {
            baiDuApi = getRetrofit(Api.BASE_API_BAIDU).create(BaiDuApi.class);
        }
        return baiDuApi;
    }

    private static OkHttpClient getOkHttp() {
        return new OkHttpClient
                .Builder()
                .addInterceptor(new BaseInterceptor())
                .build();
    }


    private static Retrofit getRetrofit(String baseUrl) {

        return new Retrofit.Builder()
                .client(getOkHttp())
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }


    private static class BaseInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            okhttp3.Response response = chain.proceed(chain.request());
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
//          KLog.i(chain.request().toString());
//          KLog.i(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s", response.request().url(), (System.nanoTime() - System.nanoTime()) / 1e6d, response.headers()));
            KLog.json(content);
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }
}
