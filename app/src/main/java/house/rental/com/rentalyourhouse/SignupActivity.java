package house.rental.com.rentalyourhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {
    Button btnSubmit, btnCustomer, btnMerchant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_home);
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
        btnSubmit = (Button) findViewById(R.id.btn_signup_submit);
        btnCustomer = (Button) findViewById(R.id.btn_customer);
        btnMerchant = (Button) findViewById(R.id.btn_merchant);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, OTPActivation.class);
                startActivity(intent);
                finish();
            }
        });
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCustomer.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                btnMerchant.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.transparent));
            }
        });
        btnMerchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCustomer.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.transparent));
                btnMerchant.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SignupActivity.this, SplashScreen.class);
        startActivity(intent);
        finish();
    }
}
