package com.app.smartpos.customers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.smartpos.R;

public class CustomerDetailsActivity extends AppCompatActivity {
    TextView name,mobile,email,adress,outstanding;
    Button editbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        getSupportActionBar().setTitle(R.string.customers);

        name =findViewById(R.id.customername);
        mobile =findViewById(R.id.customernumber);
        email=findViewById(R.id.customeremail);
        adress=findViewById(R.id.customerAddress);
        outstanding=findViewById(R.id.outstandingbalance);
        editbtn =findViewById(R.id.editbtn);



        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerDetailsActivity.this,EditCustomersActivity.class);
                startActivity(intent);
            }
        });
    }
}