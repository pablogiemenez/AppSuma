package com.example.sumaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ejercicio2Activity extends AppCompatActivity {
    private ImageView btnAtras2;
    private TextView txtCalculadora;
    protected void onCreate (Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ej2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initVars();
        initListeners();

        txtCalculadora= (TextView) findViewById(R.id.txt_calculadora);
    }
    public void borrar(View view){
        txtCalculadora.setText("0");
    }

    //metodo para inicializar la asignacion
    private void initVars() {
        btnAtras2 = findViewById(R.id.btnAtras2);
    }

    //metodo de los listeners
    private void initListeners () {
        btnAtras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ejercicio2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
