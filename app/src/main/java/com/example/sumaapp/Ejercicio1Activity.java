package com.example.sumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ejercicio1Activity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private ImageView btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ej1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initVars();
        initListeners();
    }

    //metodo para inicializar la asignacion
    private void initVars (){
        et1 = (EditText)findViewById(R.id.num1);
        et2 = (EditText)findViewById(R.id.num2);
        tv1 = (TextView)findViewById(R.id.result);
        btnAtras = findViewById(R.id.btnAtras2);
    }

    //metodo de listeners
    private void initListeners () {
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ejercicio1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
