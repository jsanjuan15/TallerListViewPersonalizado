package com.example.user.concesionario;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CarrosXMarca extends AppCompatActivity {


    private TextView t;
    private ArrayList<Carro> carros;
    private Resources r;
    private String respuesta;
    private int toyota=0,chevro=0,kia=0,mazda=0,aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_xmarca);
            t = (TextView) findViewById(R.id.txtXMarca);
            r = this.getResources();
            carros = Datos.getCarros();
            aux=carros.size();


            if (validar()) {
            for (int i = 0; i < carros.size(); i++) {
                if (carros.get(i).getMarca().equalsIgnoreCase(r.getString(R.string.toyota))) {
                    toyota = toyota + 1;
                }
                if (carros.get(i).getMarca().equalsIgnoreCase(r.getString(R.string.chevrolet))) {
                    chevro = chevro + 1;
                }
                if (carros.get(i).getMarca().equalsIgnoreCase(r.getString(R.string.kia))) {
                    kia = kia + 1;
                }
                if (carros.get(i).getMarca().equalsIgnoreCase(r.getString(R.string.mazda))) {
                    mazda = mazda + 1;
                }
            }


            respuesta = r.getString(R.string.NoDeCarrosPorMarcas) + " "
                    + r.getString(R.string.toyota) + " " + r.getString(R.string.Es) + " " + String.valueOf(toyota) + "\n" + "\n"
                    + r.getString(R.string.NoDeCarrosPorMarcas) + " "
                    + r.getString(R.string.chevrolet) + " " + r.getString(R.string.Es) + " " + String.valueOf(chevro) + "\n" + "\n"
                    + r.getString(R.string.NoDeCarrosPorMarcas) + " "
                    + r.getString(R.string.kia) + " " + r.getString(R.string.Es) + " " + String.valueOf(kia) + "\n" + "\n"
                    + r.getString(R.string.NoDeCarrosPorMarcas) + " "
                    + r.getString(R.string.mazda) + " " + r.getString(R.string.Es) + " " + String.valueOf(mazda);

            t.setText(respuesta);
        }
    }

    public void atrasxmarca(View v) {
        this.onBackPressed();
    }
    public boolean validar(){
        if (aux<=0){
            new AlertDialog.Builder(this).setTitle("Ok").setMessage(this.getResources().getString(R.string.error3)).show();

        }
        return true;
    }
}


