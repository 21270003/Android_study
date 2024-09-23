package com.example.android10;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int selectYear, selectMonth, selectDay, selectHours, selectMinite ;
    Chronometer chronometer;
    Button btnStart, btnEnd ;
    TextView tvFinalDate ;
    TimePicker tpTime ;
    CalendarView dpDate ;
    RadioGroup rgSelectCase;
    RadioButton rbDate, rbTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer)  findViewById( R.id.chronometer ) ;
        rbDate = (RadioButton) findViewById( R.id.rbDate ) ;
        rbDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "날짜선택...", Toast.LENGTH_SHORT).show();
                tpTime.setVisibility( View.GONE );
                dpDate.setVisibility( View.VISIBLE  );
            }
        });
        rbTime = (RadioButton) findViewById( R.id.rbTime ) ;
        rbTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tpTime.setVisibility( View.VISIBLE );
                dpDate.setVisibility( View.GONE);
            }
        });
        btnStart = (Button)  findViewById( R.id.btnStart ) ;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rgSelectCase.setVisibility( View.VISIBLE );
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.setTextColor( Color.RED );
                chronometer.start() ;
            }
        });
        btnEnd = (Button)  findViewById( R.id.btnEnd ) ;
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalResult =  selectYear+" 년"+ selectMonth+ " 월" + selectDay +" 일" +selectHours +" 시"+ selectMinite+" 분 예약완료";
                tvFinalDate.setText( finalResult );
                chronometer.stop();;
                chronometer.setTextColor( Color.BLACK );
            }
        });

        tvFinalDate=(TextView)  findViewById( R.id.tvFinalDate ) ;
        tpTime=(TimePicker)  findViewById( R.id.tpTime ) ;
        tpTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                selectHours=hourOfDay;
                selectMinite=minute;
            }
        });
        dpDate = (CalendarView)  findViewById( R.id.dpDate ) ;
        dpDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month;
                selectDay = dayOfMonth;
            }
        });
        rgSelectCase=(RadioGroup)  findViewById( R.id.rgSelectCase ) ;

    }
}