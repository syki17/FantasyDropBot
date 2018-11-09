package com.apps.jakub.fantasydropbot;

import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button buttonAuthLogin;
Spinner selectSportType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectSportType = findViewById(R.id.dropdownGameSelector);

        buttonAuthLogin = findViewById(R.id.buttonAuthLogin);
        buttonAuthLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //open broswer with the post string
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9N29lRDhFbFFwVFVsJnM" +
                        "9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTI5&redirect_uri=oob&response_type=code"));
                startActivity(browserIntent);
            }
        });
    }
}
