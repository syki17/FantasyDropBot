package com.apps.jakub.fantasydropbot.Retrofit;

import com.apps.jakub.fantasydropbot.Adapter;
import okhttp3.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import java.io.IOException;

public class RetrofitXML {
    /**
     * Intercept request to add a auth header
     *;
     * @param baseUrl   base url of yahoo
     * @return
     */
    public retrofit2.Retrofit Retrofit(String baseUrl){

       // OkHttpClient client = new OkHttpClient();

       // MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
       // RequestBody body = RequestBody.create(mediaType, "redirect_uri=oob&code=rpkbpqt&grant_type=authorization_code");



        return new retrofit2.Retrofit.Builder()
                .baseUrl(baseUrl)
                //.client(client)
            //    .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }
    // Adapter adapter = rBuilder.create(Adapter.class);
}