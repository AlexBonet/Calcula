package com.alexbm.calcula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText num1, num2;
    Button button;
    RadioButton suma, resta;
    int v1, v2, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.resultt);
        num1 = findViewById(R.id.v1);
        num2 = findViewById(R.id.v2);
        button = findViewById(R.id.btn);
        suma= findViewById(R.id.rdsum);
        resta= findViewById(R.id.rdres);
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button){
            if (num1.getText().length()!=0 && num1.getText().length()!=0){
                v1 = Integer.parseInt(num1.getText().toString());
                v2 = Integer.parseInt(num2.getText().toString());
                if (suma.isChecked()){
                    total = v1 + v2;
                    textView.setText("Resultado = " +  total);
                }else if (resta.isChecked()) {
                    total = v1 - v2;
                    textView.setText("Resultado = " +  total);
                }
            }
        }
    }
}