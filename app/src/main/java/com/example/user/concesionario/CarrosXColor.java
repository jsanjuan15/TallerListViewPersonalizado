package com.example.user.concesionario;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CarrosXColor extends AppCompatActivity {

    private TextView t;
    private ArrayList<Carro> carros;
    private Resources r;
    private String respuesta;
    private int azul = 0, rojo = 0, blanco = 0, negro = 0,aux;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_xcolor);

            t = (TextView) findViewById(R.id.txtXColor);
            r = this.getResources();
            carros = Datos.getCarros();
            aux=carros.size();
            if (validar()) {
            for (int i = 0; i < carros.size(); i++) {
                if (carros.get(i).getColor().equalsIgnoreCase(r.getString(R.string.azul))) {
                    azul = azul + 1;
                }
                if (carros.get(i).getColor().equalsIgnoreCase(r.getString(R.string.rojo))) {
                    rojo = rojo + 1;
                }
                if (carros.get(i).getColor().equalsIgnoreCase(r.getString(R.string.blanco))) {
                    blanco = blanco + 1;
                }
                if (carros.get(i).getColor().equalsIgnoreCase(r.getString(R.string.negro))) {
                    negro = negro + 1;
                }
            }

            respuesta = r.getString(R.string.NoDeCarrosPorColor) + " "
                    + r.getString(R.string.azul) + " " + r.getString(R.string.Es) + " " + String.valueOf(azul) + "\n" + "\n"
                    + r.getString(R.string.NoDeCarrosPorColor) + " "
                    + r.getString(R.string.rojo) + " " + r.getString(R.string.Es) + " " + String.valueOf(rojo) + "\n" + "\n"
                    + r.getString(R.string.NoDeCarrosPorColor) + " "
                    + r.getString(R.string.blanco) + " " + r.getString(R.string.Es) + " " + String.valueOf(blanco) + "\n" + "\n"
                    + r.getString(R.string.NoDeCarrosPorColor) + " "
                    + r.getString(R.string.negro) + " " + r.getString(R.string.Es) + " " + String.valueOf(negro);
            t.setText(respuesta);
        }
    }

    public void atrasxColor(View v) {
        this.onBackPressed();
    }

    public boolean validar(){
        if (aux<=0){
            new AlertDialog.Builder(this).setTitle("Ok").setMessage(this.getResources().getString(R.string.error3)).show();

        }

        return true;
    }
}
