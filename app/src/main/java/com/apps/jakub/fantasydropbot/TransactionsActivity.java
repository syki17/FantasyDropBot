package com.apps.jakub.fantasydropbot;

import android.util.Log;
import com.apps.jakub.fantasydropbot.Models.FantasyContent;
import com.apps.jakub.fantasydropbot.Retrofit.RetrofitXML;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class TransactionsActivity {
    public TransactionsActivity(String token) {

        RetrofitXML retrofit = new RetrofitXML();
        Adapter serviceTransaction = retrofit.Retrofit("https://fantasysports.yahooapis.com").create(Adapter.class);
        token = "Bearer " + token.trim();
        Log.d("TAG Token", token);

        Call<FantasyContent> getTransactions = serviceTransaction.getTransactions(token);
        getTransactions.enqueue(new Callback<FantasyContent>() {
            @Override
            public void onResponse(Call<FantasyContent> call, Response<FantasyContent> response) {
                Log.d("TAG response", response.body().getLeague().getTransactions().getTransactionList().get(0).getTimestamp());
                Log.d("TAG response", response.body().getLeague().toString());
            //    Log.d("TAG response", response.errorBody().toString());


            }

            @Override
            public void onFailure(Call<FantasyContent> call, Throwable t) {
                Log.d("TAG response on fail", call.request().header("Authorization"));
                Log.d("TAG ail", t.toString());

            }
        });
        Log.d("Tag request after",getTransactions.request().toString());


    }
}
