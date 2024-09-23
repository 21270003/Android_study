package com.example.android08;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox cbIsStart;
    TextView tvQuestion;
    RadioGroup rgPet;
    Button btnComplete;
    ImageView ivPat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvQuestion =(TextView) findViewById(R.id.tvQuestion);
        rgPet =(RadioGroup) findViewById(R.id.rgPet);
        btnComplete =(Button) findViewById(R.id.btnComplete);
        ivPat =(ImageView) findViewById(R.id.ivPat);


        cbIsStart = (CheckBox) findViewById(R.id.cbIsStart);
        cbIsStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    tvQuestion.setVisibility(View.VISIBLE);
                    rgPet.setVisibility(View.VISIBLE);
                    btnComplete.setVisibility(View.VISIBLE);
                    ivPat.setVisibility(View.VISIBLE);
                }else{
                    tvQuestion.setVisibility(View.INVISIBLE);
                    rgPet.setVisibility(View.INVISIBLE);
                    btnComplete.setVisibility(View.INVISIBLE);
                    ivPat.setVisibility(View.INVISIBLE);

                }

            }
        });
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButton = rgPet.getCheckedRadioButtonId();
                if(selectedRadioButton == R.id.rbCat){
                    ivPat.setImageResource(R.drawable.cat);
                }else if (selectedRadioButton == R.id.rbDog){
                    ivPat.setImageResource(R.drawable.dog);
                }else if (selectedRadioButton == R.id.rbRabbit){
                    ivPat.setImageResource(R.drawable.rabbit);
                }
            }

        });
    }
}