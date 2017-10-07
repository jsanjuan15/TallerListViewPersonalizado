package com.example.user.concesionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {


    private ListView listado;
    private ArrayList<Carro>carros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado=(ListView)findViewById(R.id.lvListado);
        carros=Datos.getCarros();
        AdaptadorCarro adapter= new AdaptadorCarro(this,carros);
        listado.setAdapter(adapter);
    }
}
