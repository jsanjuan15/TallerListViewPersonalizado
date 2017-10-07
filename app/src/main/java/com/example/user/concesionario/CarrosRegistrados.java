package com.example.user.concesionario;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CarrosRegistrados extends AppCompatActivity {


    private TextView t;
    private ArrayList<Carro>carros;
    private int aux;
    private Resources r;
    private String respuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_registrados);
            t = (TextView) findViewById(R.id.txtCarRegistrados);
            r = this.getResources();
            carros = Datos.getCarros();
            aux = carros.size();


        if (validar()) {
            respuesta = r.getString(R.string.RepTotalRegistrados) + String.valueOf(aux);
            t.setText(respuesta);
        }
    }
    public void atrasTotalR(View v){
        this.onBackPressed();
    }
    public boolean validar(){
        if (aux<=0){
            new AlertDialog.Builder(this).setTitle("Ok").setMessage(this.getResources().getString(R.string.error3)).show();

        }
        return true;
    }
}
