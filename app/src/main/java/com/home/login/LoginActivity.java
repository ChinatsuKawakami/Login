package com.home.login;
//date : 31st August
//Chinatsu Kawakami
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
private EditText username;
    private EditText password;
    private TextView getHelp;
    private CheckBox rememberMe;
    private Button login;
private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        password= (EditText)findViewById(R.id.password);
        getHelp = (TextView)findViewById(R.id.gethelp);
        rememberMe = (CheckBox)findViewById(R.id.checkbox);
        login = (Button)findViewById(R.id.login);

        prefs = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);

        if(prefs.contains("user") && prefs.contains("pass"))
        {
            username.setText(prefs.getString("user",""));
            password.setText(prefs.getString("pass",""));
            rememberMe.setChecked(true);
        }
        getHelp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText())) {
                    //Log.d(LoginActivity.class.getName(),"Fields are empty")
                    Toast.makeText(LoginActivity.this, "Please fill in mandatory files", Toast.LENGTH_SHORT).show();
                } else {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    SharedPreferences.Editor editor = prefs.edit();
                    if(rememberMe.isChecked())
                    {
                        editor.putString("user",user);
                        editor.putString("password",pass);
                    }//else{editor.clear()}
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
            }
        });

    }
}
