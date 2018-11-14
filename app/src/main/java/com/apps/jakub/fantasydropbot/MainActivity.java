package com.apps.jakub.fantasydropbot;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.apps.jakub.fantasydropbot.Calls.TokenCallBody;
import com.apps.jakub.fantasydropbot.Models.Token;
import com.apps.jakub.fantasydropbot.Retrofit.Retrofit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button buttonAuthLogin;
    Spinner selectSportType;
    Button startRequest;
    EditText pasteCode;
    String authCode;
    TextView testText;
    String result;
    String tokenBody;
    String encode;
    Map<String,String> bodyValues;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testText = findViewById(R.id.testText);
        startRequest = findViewById(R.id.startRequests);
        startRequest.setEnabled(false);
        buttonAuthLogin = findViewById(R.id.buttonAuthLogin);
        pasteCode = findViewById(R.id.yahooCode);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();


        //encode
        //  byte[] encoded = Base64.getEncoder().encode("dj0yJmk9TkRVdHZxNnpabXpRJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTE3:d311b4b7da9400de442b41831d36353d8257197f".getBytes());
        encode ="Basic "+ Base64.encodeToString("dj0yJmk9N29lRDhFbFFwVFVsJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTI5:abb9b9a58172ed44992a8c6312993517620ecaf9".getBytes(), Base64.NO_WRAP);

        buttonAuthLogin.setOnClickListener(v -> {
            //open broswer with the post string
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9N29lRDhFbFFwVFVs" +
                    "JnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTI5&redirect_uri=oob&response_type=code"));
            startActivity(browserIntent);
        });


    }

    public void onResume() {
        super.onResume();
        Log.d("TAG", encode);

        //works for now but I have to paste code, make app pause, and then go back to app for start to be enabled.
        if (!pasteCode.getText().toString().equals("Paste Code Here")) {
            startRequest.setEnabled(true);
        } else {
            startRequest.setEnabled(false);
        }
        startRequest.setOnClickListener(v -> {
            testText = findViewById(R.id.testText);
            authCode = pasteCode.getText().toString();
           // testText.setText(authCode + "body here: "+tokenBody);
            /*
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.login.yahoo.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Adapter service = retrofit.create(Adapter.class);
       */

            bodyValues = new HashMap<>();
            bodyValues.put("redirect_uri","oob");
            bodyValues.put("code",authCode);
            bodyValues.put("grant_type","authorization_code");
            Retrofit retrofit = new Retrofit();
            tokenBody = "redirect_uri=oob&code="+authCode+"&grant_type=authorization_code";
            Adapter service = retrofit.Retrofit("https://api.login.yahoo.com").create(Adapter.class);
            testText.setText(authCode + "body here: "+tokenBody);
            TokenCallBody body = new TokenCallBody("oob",authCode,"authorization_code");
            Call<Token> call = service.loadToken(encode,bodyValues);
            try {
                Log.d("TAG", service.loadToken(encode, bodyValues).request().body().toString());
            }catch(NullPointerException e){
                Log.d("TAG", "RIP NO BODY");

            }
        //    Log.d("TAG", service.loadToken("application/x-www-form-urlencoded",encode,body).request().toString());
        //    Log.d("TAG", service.loadToken("application/x-www-form-urlencoded",encode,body).request().header("Authorization"));

            //Log.d("TAG", service.("application/x-www-form-urlencoded",encode,tokenBody).request().body().contentType().toString());


            // ADD FORM HEADED ENCODED!!!!!!!

            call.enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    try {
                    //    Log.d("TAG response", response.errorBody().string());
                        Log.d("TAG response", response.body().getAccessToken());

                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                    Log.d("TAG code", String.valueOf(response.code()));
                    Log.d("TAG raw", response.raw().toString());


                    result = response.message();
                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    result = "failed";
                    Log.d("TAG code", "failed");

                }
            });

        });
        testText = findViewById(R.id.testText);
        testText.setText(result);


    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}
