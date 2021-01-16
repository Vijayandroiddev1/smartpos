package com.app.smartpos.customers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.app.smartpos.R;
import com.app.smartpos.database.DatabaseAccess;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ApointmentActivity extends AppCompatActivity implements View.OnClickListener {
    TextView date, time;
    EditText custId;
    AutoCompleteTextView custName;
    Button submit;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apointment);
        init();
    }

    private void init() {
        date = findViewById(R.id.etxt_apointment_date);
        time = findViewById(R.id.etxt_apointment_time);

        date.setOnClickListener(this);
        time.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etxt_apointment_date:
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                int mYear, mMonth, mDay;
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog mDatePicker = new DatePickerDialog(ApointmentActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                                date.setText(selectedday + "/" + selectedmonth + "/" + selectedyear);
                            }
                        }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
                break;

            case R.id.etxt_apointment_time:
                //Get Current Time
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker = new TimePickerDialog(ApointmentActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                time.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, false);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
                break;
        }
    }
}