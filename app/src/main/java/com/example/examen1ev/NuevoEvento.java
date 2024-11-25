package com.example.examen1ev;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NuevoEvento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_evento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtEvento =findViewById(R.id.txtEvento);
        EditText txtDeporte = findViewById(R.id.txtDeporte);
        EditText txtEquipos = findViewById(R.id.txtEquipo);
        EditText txtResultado = findViewById(R.id.txtResultado);
        EditText txtValoracion = findViewById(R.id.txtValoracion);

        Button butAnadirEvento = findViewById(R.id.btnAnadirEvento);
        Button butCancelar = findViewById(R.id.btnCancelar);

        butAnadirEvento.setOnClickListener(view -> {
            if (txtEvento.getText().toString().isEmpty()
                    ||txtDeporte.getText().toString().isEmpty()
                    || txtEquipos.getText().toString().isEmpty()
                    || txtResultado.getText().toString().isEmpty()
                    || txtValoracion.getText().toString().isEmpty()){
                //Toast
            }else{
                Evento nuevoEvento = new Evento(txtDeporte.getText().toString(),
                        txtEvento.getText().toString(),
                        txtEquipos.getText().toString(),
                        txtResultado.getText().toString(),
                        txtValoracion.getText().toString());

                String stringVuelta = nuevoEvento.toString();

                Intent intentVuelta = new Intent();
                intentVuelta.putExtra("nuevoEvento", stringVuelta);
                setResult(RESULT_OK, intentVuelta);
                finish();
            }
        });

        butCancelar.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });





    }
}