package com.apps.jakub.fantasydropbot.Controller;

import com.apps.jakub.fantasydropbot.Adapter;
import com.apps.jakub.fantasydropbot.Models.FantasyContent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class Controller implements Callback<FantasyContent> {

    static final String BASE_URL = "https://fantasysports.yahooapis.com";

    public void start() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        Adapter adapter = retrofit.create(Adapter.class);

        Call<FantasyContent> call = adapter.loadRSSFeed();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<FantasyContent> call, Response<FantasyContent> response) {
        if (response.isSuccessful()) {
            FantasyContent rss = response.body();
            System.out.println("Channel title: " + rss.getLeague().getTransactions().getTransactionList());
            rss.getLeague().getTransactions().getTransactionList().forEach(
                    article -> System.out.println("Type: " + article.getType() + " Link: "));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<FantasyContent> call, Throwable t) {
        t.printStackTrace();
    }
}