package com.alexbm.calcula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author ALEX BONET
 * APP DE CALCULAR
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //DECLARACION DE LAS VARIABLES
    TextView textView;
    EditText num1, num2;
    Button button,restart;
    RadioButton suma, resta, pow, andy;
    float v1, v2, total;

    @Override //LO QUE PASA CUANDO SE INICICIA LA APP
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.resultt);
        num1 = findViewById(R.id.v1);
        num2 = findViewById(R.id.v2);
        button = findViewById(R.id.btn);
        suma= findViewById(R.id.rdsum);
        resta= findViewById(R.id.rdres);
        pow = findViewById(R.id.pow);
        andy = findViewById(R.id.andy);
        restart = findViewById(R.id.restart);

    }

    @Override //LO QUE PASA CUANDO HACES CLICK EN EL BOTÓN
    public void onClick(View view) {
        if (view instanceof Button){
            Button btn = (Button) view;
            if (btn==button){
                if (num1.getText().length()!=0 && num1.getText().length()!=0){
                    v1 = Float.parseFloat(num1.getText().toString());
                    v2 = Float.parseFloat(num2.getText().toString());
                    if (suma.isChecked()){
                        total = v1 + v2;
                        textView.setText("Resultado = " +  total);
                    }else if (resta.isChecked()) {
                        total = v1 - v2;
                        textView.setText("Resultado = " +  total);
                    }else if (pow.isChecked()) {
                        total = (float) Math.pow(v1,v2);
                        textView.setText("Resultado = " +  total);
                    }else if (andy.isChecked()) {
                        total = Integer.parseInt(num1.getText().toString()) & Integer.parseInt(num2.getText().toString());
                        textView.setText("Resultado = " +  total);
                    }else{
                        textView.setText("Selecciones una operación");
                    }
                }else{
                    textView.setText("Uno de los valores está vacio");
                }
                Toast.makeText(this, "GO", Toast.LENGTH_SHORT).show();
            }else if (btn == restart){
                restartValue();
                Toast.makeText(this, "REINICAR", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void restartValue(){
        v1 = 0;
        v2 = 0;
        num1.setText("");
        num2.setText("");
    }
}