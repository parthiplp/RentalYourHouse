package house.rental.com.rentalyourhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import models.Globals;

public class SigninActivity extends AppCompatActivity {
Button btnSubmit;
    private RadioGroup radioUserGroup;
    private RadioButton selectedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.delete);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        radioUserGroup=(RadioGroup)findViewById(R.id.radio_user_group);
        btnSubmit=(Button)findViewById(R.id.btn_signin_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioUserGroup.getCheckedRadioButtonId();
                selectedUser = (RadioButton) findViewById(selectedId);

                if(selectedUser.getText().equals("Signin as Customer"))
                {
                    Globals.isUserLoggedIn=true;
                   moveToMainActivity();
                }else  if(selectedUser.getText().equals("Signin as Merchant"))
                {
                    Globals.isUserLoggedIn=false;
                    moveToMainActivity();
                }else
                {
                    Toast.makeText(SigninActivity.this, "Select user", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void moveToMainActivity() {

        Intent intent=new Intent(SigninActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(SigninActivity.this,SplashScreen.class);
        startActivity(intent);
        finish();
    }
}
