package com.example.android06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnButton, btnNextNext, btnBottom;
    TextView tvDisplay;
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnButton = (Button) findViewById(R.id.btnButton);
        btnNextNext = (Button) findViewById(R.id.btnNextNext);
        btnBottom = (Button) findViewById(R.id.btnBottom);

        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        etNumber = (EditText) findViewById(R.id.etNumber);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String inString = etNumber.getText().toString();
                tvDisplay.setText(etNumber.getText().toString());
            }
        });
    }
}