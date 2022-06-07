package com.harsha.bmi_calculator;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RadioButton button_male;
    private EditText age;
    private EditText weight;
    private EditText height;
    private Button calculate;
    private TextView answer;

    private boolean isMale = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.prog);
        button_male = findViewById(R.id.male_radio);
        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        calculate = findViewById(R.id.bmicalci);
        answer = findViewById(R.id.ans);

        if(button_male.isChecked()){
            isMale = true;
        }


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int int_age = Integer.parseInt(age.getText().toString()+"");
                int int_weight = Integer.parseInt(weight.getText().toString());
                int int_height = Integer.parseInt(height.getText().toString());

                progressBar.setVisibility(View.VISIBLE);

                Log.d("debug",int_weight+"");
                Log.d("debug",int_height+"");

                double BMI = int_weight/(Math.pow(int_height,2))*10000;

                Toast.makeText(MainActivity.this, BMI+"", Toast.LENGTH_SHORT).show();
                if(BMI<18.5){
                    progressBar.setProgress(25);
                    answer.setText("You are Underweight");
                }else if(BMI>=18.5 && BMI<=24){
                    progressBar.setProgress(50);
                    answer.setText("You are Normal Weight");
                }else if(BMI>=25 && BMI<=29.9){
                    progressBar.setProgress(75);
                    answer.setText("You are Overweight");
                }else if(BMI>=30){
                    progressBar.setProgress(100);
                    answer.setText("You are Obese");
                }
            }
        });

    }
}