package sg.edu.rp.c346.id21016412.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        btnReset = findViewById(R.id.buttonReset);
        tvDisplay = findViewById(R.id.textViewDisplay);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int timeHour = tp.getCurrentHour();
                int timeMinute = tp.getCurrentMinute();
                String time = "Time is " + timeHour + ":" + timeMinute;
                tvDisplay.setText(time);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dateDay = dp.getDayOfMonth();
                int dateMonth = dp.getMonth() + 1;
                int dateYear = dp.getYear();
                String date = "Date is " + dateDay + "/" + dateMonth + "/" + dateYear;
                tvDisplay.setText(date);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020, 0, 1);
                tvDisplay.setText("");
            }
        });
    }
}