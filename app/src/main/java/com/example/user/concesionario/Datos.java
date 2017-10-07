package com.example.user.concesionario;

import java.util.ArrayList;



public class Datos {


    public static ArrayList<Carro> carros = new ArrayList<Carro>();
    public static void guardar(Carro c){carros.add(c); }
    public static ArrayList<Carro> getCarros() {
        return carros;
    }
}
