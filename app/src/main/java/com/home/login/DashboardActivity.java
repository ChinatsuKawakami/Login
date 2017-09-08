package com.home.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {

    private TextView greeting;
    public static String USER = "user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        greeting = (TextView)findViewById(R.id.greeting);

        String greet = getIntent().getExtras().getString(USER);
        greeting.setText(String.format(Locale.getDefault(),getString(R.string.greeting),greet));
    }
}
