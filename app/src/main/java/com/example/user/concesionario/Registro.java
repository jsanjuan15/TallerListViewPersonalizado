package com.example.user.concesionario;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Registro extends AppCompatActivity {



    private EditText cajaplaca,cajaprecio;
    private Spinner spmarca,spmodelo,spcolor;
    private ArrayAdapter<String>adtMarca;
    private ArrayAdapter<String>adtModelo;
    private ArrayAdapter<String>adtcolor;
    private String []Vmarca;
    private String []Vmodelo;
    private String []Vcolor;
    private Intent i;
    private Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        String placa,comboMarca,comboModelo,comboColor;
        int precio;

        cajaplaca=(EditText)findViewById(R.id.cajaPlaca);
        cajaprecio=(EditText)findViewById(R.id.cajaPrecio);
        spmarca=(Spinner)findViewById(R.id.cmbMarca);
        spmodelo=(Spinner)findViewById(R.id.cmbModelo);
        spcolor=(Spinner)findViewById(R.id.cmbColor);

        Vmarca=this.getResources().getStringArray(R.array.marcas);
        adtMarca= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Vmarca);
        spmarca.setAdapter(adtMarca);

        Vmodelo=this.getResources().getStringArray(R.array.modelos);
        adtModelo= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Vmodelo);
        spmodelo.setAdapter(adtModelo);

        Vcolor=this.getResources().getStringArray(R.array.colores);
        adtcolor= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Vcolor);
        spcolor.setAdapter(adtcolor);
    }


    public void registrar(View v){
        String placa,marca,modelo,color,foto;
        if (validar()) {
            int precio, aux;
            placa = cajaplaca.getText().toString().trim();
            precio = Integer.parseInt(cajaprecio.getText().toString().trim());
            marca = spmarca.getSelectedItem().toString();
            modelo = spmodelo.getSelectedItem().toString();
            color = spcolor.getSelectedItem().toString();
            foto = String.valueOf(fotoAletoria());
            Carro c = new Carro(placa, marca, modelo, color, foto, precio);
            c.guardar();
            new AlertDialog.Builder(this).setTitle("Ok").setMessage(this.getResources().getString(R.string.mensajeRegistro)).show();
        }
    }


    public int fotoAletoria(){
        int  fotos[]={R.drawable.carro1,R.drawable.carro2,R.drawable.carro3,R.drawable.carro4};
        int numero = (int) (Math.random()*4);
        return fotos [numero];
    }


    public void borrar(View v){
        cajaplaca.setText("");
        cajaprecio.setText("");
        spmarca.setSelection(0);
        spmodelo.setSelection(0);
        spcolor.setSelection(0);
    }


    public boolean validar(){
        if (cajaplaca.getText().toString().isEmpty()){

            cajaplaca.setError(getResources().getString(R.string.error1));

            return false;
        }
        if (cajaprecio.getText().toString().isEmpty()){
            cajaprecio.setError(getResources().getString(R.string.error2));
            //Toast.makeText(getApplicationContext(),"Digite el apellido por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
