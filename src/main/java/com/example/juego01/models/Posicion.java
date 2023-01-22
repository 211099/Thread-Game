package com.example.juego01.models;

public class Posicion {
    private int x;

    private  int id;



    public  Posicion(){

    }

    public Posicion(int x, int id) {
        this.x = x;
        this.id = id;
    }






    public int getX() {
        return x;
    }

    public int getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setId(int id) {
        this.id = id;
    }

}
