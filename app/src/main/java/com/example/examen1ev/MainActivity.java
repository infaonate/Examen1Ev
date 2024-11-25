package com.example.examen1ev;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Evento> listaEventos= new ArrayList<Evento>();

    final private static int REQ_EVENTO = 23;
    final private static String CLAVE_SHARED= "clvShared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listaEventos = findViewById(R.id.listViewEventos);

        Button butAnadir = findViewById(R.id.butActivityAnadir);
        butAnadir.setOnClickListener(view -> {
            //pasamos al activity añadir evento
            Intent intent = new Intent(MainActivity.this, NuevoEvento.class);
            startActivityForResult(intent, REQ_EVENTO);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_EVENTO && resultCode==RESULT_OK) {
            Evento eventoAnadido = new Evento(data.getStringExtra("nuevoEvento"));
            listaEventos.add(eventoAnadido);
            //TOast
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        String stringGuardar="";
        for (Evento evento: listaEventos) {
            stringGuardar += evento.toString() + ";";
        }
        stringGuardar = stringGuardar.substring(0, stringGuardar.length()-1);
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CLAVE_SHARED, stringGuardar);
        editor.apply();

    }

}