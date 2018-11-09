package com.apps.jakub.fantasydropbot;

import com.apps.jakub.fantasydropbot.Models.FantasyContent;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Adapter {
    // We are calling this site https://fantasysports.yahooapis.com
    @GET("/fantasy/v2/league/386.l.7366/transactions;type=drop;count=5")
    Call<FantasyContent> loadRSSFeed();
}