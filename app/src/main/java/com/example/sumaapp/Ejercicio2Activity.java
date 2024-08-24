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
    private double valorActual = 0;
    private String operadorActual = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio2);

        // Ajuste de padding para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ej2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización de variables
        initVars();
        initListeners();

        // Configuración inicial del TextView de la calculadora
        txtCalculadora = findViewById(R.id.txtCalculadora2);

        // Configuración de los listeners para los botones de la calculadora
        findViewById(R.id.btn_siete).setOnClickListener(view -> actualizarCalculadora("7"));
        findViewById(R.id.btn_ocho).setOnClickListener(view -> actualizarCalculadora("8"));
        findViewById(R.id.btn_nueve).setOnClickListener(view -> actualizarCalculadora("9"));
        findViewById(R.id.btn_cuatro).setOnClickListener(view -> actualizarCalculadora("4"));
        findViewById(R.id.btn_cinco).setOnClickListener(view -> actualizarCalculadora("5"));
        findViewById(R.id.btn_seis).setOnClickListener(view -> actualizarCalculadora("6"));
        findViewById(R.id.btn_uno).setOnClickListener(view -> actualizarCalculadora("1"));
        findViewById(R.id.btn_dos).setOnClickListener(view -> actualizarCalculadora("2"));
        findViewById(R.id.btn_tres).setOnClickListener(view -> actualizarCalculadora("3"));
        findViewById(R.id.btn_cero).setOnClickListener(view -> actualizarCalculadora("0"));

        findViewById(R.id.btn_mas).setOnClickListener(view -> {
            operadorActual = "+";
            valorActual = Double.parseDouble(txtCalculadora.getText().toString());
            txtCalculadora.setText("0");
        });
        findViewById(R.id.btn_multiclicado).setOnClickListener(view->{
            operadorActual="*";
            valorActual=Double.parseDouble(txtCalculadora.getText().toString());
            txtCalculadora.setText("0");
        });

        findViewById(R.id.btn_dividido).setOnClickListener(view -> {
            operadorActual = "/";
            valorActual = Double.parseDouble(txtCalculadora.getText().toString());
            txtCalculadora.setText("0");
        });

        findViewById(R.id.btn_igual).setOnClickListener(view -> calcularResultado());
    }

    // Método para inicializar la asignación de variables
    private void initVars() {
        btnAtras2 = findViewById(R.id.btnAtras2);
        txtCalculadora = findViewById(R.id.txtCalculadora2);
    }

    // Método para inicializar los listeners
    private void initListeners() {
        // Listener para el botón de volver
        btnAtras2.setOnClickListener(view -> {
            Intent intent = new Intent(Ejercicio2Activity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Cierra la actividad actual
        });
    }

    // Método para actualizar el TextView de la calculadora
    private void actualizarCalculadora(String numero) {
        String textoActual = txtCalculadora.getText().toString();
        if (textoActual.equals("0")) {
            txtCalculadora.setText(numero);
        } else {
            txtCalculadora.append(numero);
        }
    }

    // Método para calcular el resultado de la operación
    private void calcularResultado() {
        try {
            double valorNuevo = Double.parseDouble(txtCalculadora.getText().toString());
            double resultado = 0;

            switch (operadorActual) {
                case "+":
                    resultado = valorActual + valorNuevo;
                    break;
                case "*":
                    resultado = valorActual * valorNuevo;
                    break;
                case "/":
                    if (valorNuevo != 0) {
                        resultado = valorActual / valorNuevo;
                    } else {
                        txtCalculadora.setText("Error: Div/0");
                        operadorActual = "";
                        valorActual = 0;
                        return;
                    }
                    break;
                default:
                    txtCalculadora.setText("Operación no válida");
                    return;
            }

            txtCalculadora.setText(String.valueOf(resultado));
            operadorActual = "";
            valorActual = 0;
        } catch (NumberFormatException e) {
            // Manejar el caso en que el valor del TextView no sea un número válido
            txtCalculadora.setText("Error: Formato");
            operadorActual = "";
            valorActual = 0;
        }
    }

    // Método para borrar el contenido del TextView de la calculadora
    public void borrar(View view) {
        txtCalculadora.setText("0");
        valorActual = 0;
        operadorActual = "";
    }
}
