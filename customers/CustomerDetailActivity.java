package com.app.smartpos.customers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.smartpos.R;

import java.util.Set;

public class CustomerDetailActivity extends AppCompatActivity {
    TextView name,number,mail,address,balance;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

        name =findViewById(R.id.customername);
        number =findViewById(R.id.customernumber);
        mail=findViewById(R.id.customeremail);
        address=findViewById(R.id.customeradress);
        balance=findViewById(R.id.balanceamnt);
        Log.i("extras",getIntent().getExtras()+"mmmm");


        Bundle dataList=getIntent().getExtras();
       Set<String> keys= dataList.keySet();

      Log.i("datachecking","gaf"+dataList.get("customer_name"));

        name.setText(getIntent().getExtras().getString("customer_name"));
        number.setText(getIntent().getExtras().getString("customer_cell"));
        mail.setText(getIntent().getExtras().getString("customer_email"));
        address.setText(getIntent().getExtras().getString("customer_address"));
        //balance.setText(getIntent().getExtras().getString("customer_name"));

      String        get_customer_id = getIntent().getExtras().getString("customer_id");
//        get_customer_name = getIntent().getExtras().getString("customer_name");
//        get_customer_cell = getIntent().getExtras().getString("customer_cell");
//        get_customer_email = getIntent().getExtras().getString("customer_email");
//        get_customer_address = getIntent().getExtras().getString("customer_address");
        edit=findViewById(R.id.editbtnn);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomerDetailActivity.this,EditCustomersActivity.class);
                intent.putExtra("customer_id", getIntent().getExtras().getString("customer_id"));
                intent.putExtra("customer_name", getIntent().getExtras().getString("customer_name"));
                intent.putExtra("customer_cell", getIntent().getExtras().getString("customer_cell"));
                intent.putExtra("customer_email", getIntent().getExtras().getString("customer_email"));
                intent.putExtra("customer_address", getIntent().getExtras().getString("customer_address"));


                startActivity(intent);
            }
        });
    }
}