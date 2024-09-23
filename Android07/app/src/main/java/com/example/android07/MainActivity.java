package com.example.android07;

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

    Button  btnPlus, btnSubtract,  btnMultiply, btnDivide;
    EditText  etFirstNumber, etSecondNumber;
    TextView tvDisplayResult;

    private  String  getResult( EditText  etFirstNumber, EditText etSecondNumber , int operator ){

        int        iFirstNumber = Integer.parseInt(  etFirstNumber.getText().toString()  );
        int        iSecondNumber = Integer.parseInt(  etSecondNumber.getText().toString()  );

        int        iResult=0;
        switch(operator ){
            case 1:  iResult = iFirstNumber + iSecondNumber; break;
            case 2:  iResult = iFirstNumber - iSecondNumber; break;
            case 3:  iResult = iFirstNumber * iSecondNumber; break;
            case 4:  iResult = iFirstNumber / iSecondNumber; break;
        }

        return   "RESULT:"+ iResult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etFirstNumber=(EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber=(EditText) findViewById(R.id.etSecondNumber);
        tvDisplayResult=(TextView) findViewById(R.id.tvDisplayResult);

        btnPlus=(Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplayResult.setText(  getResult(etFirstNumber, etSecondNumber, 1)  );
            }
        });
        btnSubtract=(Button) findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplayResult.setText(  getResult(etFirstNumber, etSecondNumber, 2)  );
            }
        });
        btnMultiply=(Button) findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplayResult.setText(  getResult(etFirstNumber, etSecondNumber, 3) );
            }
        });
        btnDivide=(Button) findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplayResult.setText(   getResult(etFirstNumber, etSecondNumber, 4)  );

            }
        });


    }
}