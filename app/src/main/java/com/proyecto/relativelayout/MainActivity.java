package com.proyecto.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerDate, spinnerTime;
    String[] fecha, hora;

    List<String> lista, listahora;
    ArrayAdapter<String> Adapter, adapterhora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerDate = findViewById(R.id.dates);
        spinnerTime = findViewById(R.id.times);

        spinnerDate.setOnItemSelectedListener(this);
        spinnerTime.setOnItemSelectedListener(this);

        SimpleDateFormat f = new SimpleDateFormat("E, dd/MM/yyyy");
        SimpleDateFormat fa = new SimpleDateFormat("HH:mm");
        Calendar c = Calendar.getInstance();
        fecha = new String[1];
        hora = new String[1];
        fecha[0] = f.format(c.getTime());
        hora[0] = fa.format(c.getTime());
        //   Toast.makeText(this, fecha, Toast.LENGTH_SHORT).show();


        lista = new ArrayList<>();
        listahora = new ArrayList<>();
        Collections.addAll(lista, fecha);
        Collections.addAll(listahora, hora);
        Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapterhora = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listahora);
        //Cargo el spinner con los datos
        spinnerDate.setAdapter(Adapter);
        spinnerTime.setAdapter(adapterhora);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}