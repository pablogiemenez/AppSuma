package com.example.sumaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio1Activity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        et1 = (EditText)findViewById(R.id.num1);
        et2 = (EditText)findViewById(R.id.num2);
        tv1 = (TextView)findViewById(R.id.result);
    }

    //metodo para calcular la suma
    public void Sumar(View view){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());

        int suma = num1 + num2;

        String result = String.valueOf(suma);
        tv1.setText(result);
    }
}
