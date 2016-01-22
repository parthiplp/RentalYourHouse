package house.rental.com.rentalyourhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import models.Globals;

public class SplashScreen extends AppCompatActivity {
    Button login, signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
     /*   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        login = (Button) findViewById(R.id.btn_login);
        signin = (Button) findViewById(R.id.btn_signin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.isUserLoggedIn=false;
                Intent intent=new Intent(SplashScreen.this,SigninActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.isUserLoggedIn=true;
                Intent intent=new Intent(SplashScreen.this,SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
