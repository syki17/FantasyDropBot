package com.apps.jakub.fantasydropbot;

import com.apps.jakub.fantasydropbot.Calls.TokenCallBody;
import com.apps.jakub.fantasydropbot.Models.FantasyContent;

import com.apps.jakub.fantasydropbot.Models.Token;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface Adapter {

    // We are calling this site https://fantasysports.yahooapis.com
    //after testing we replace the keys with @Path so it can load for different leagues
    @GET("/fantasy/v2/league/386.l.7366/transactions;type=drop;count=5")
    Call<FantasyContent> loadRSSFeed();

    //get our Token
    @POST("/oauth2/get_token")
    @FormUrlEncoded
    Call<Token> loadToken(
            //@Header("Content-Type") String applicationHeader,
            @Header("Authorization") String base64Auth,
            //  @Body TokenCallBody token);
            @FieldMap Map<String,String> bodyValues);

}