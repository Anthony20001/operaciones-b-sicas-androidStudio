package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BasicOperations basicOperations = new BasicOperations();

    private EditText number1, number2;
    private TextView result;
    private Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.editTextNum1);
        number2 = findViewById(R.id.editTextNum2);
        btnRun = findViewById(R.id.buttonRun);
        result = findViewById(R.id.textViewResult);

        btnRun.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                try{
                    if(number1.getText().toString().trim().equals("")){
                        number1.setError(getResources().getString(R.string.empty_input));
                    }else if(number2.getText().toString().trim().equals("")){
                        number2.setError(getResources().getString(R.string.empty_input));
                    }else {
                        Double num1 = Double.parseDouble(number1.getText().toString());
                        Double num2 = Double.parseDouble(number2.getText().toString());

                        result.setText(String.valueOf(basicOperations.sum(num1, num2)));
                        number1.setText("");
                        number2.setText("");
                    }
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.err_data), Toast.LENGTH_LONG);
                }
            }
        });

    }
}