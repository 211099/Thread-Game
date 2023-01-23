package com.example.juego01.models;

import java.util.Observable;

public class Perro extends Observable implements Runnable {
    private Posicion pos;
    private int id;
    private boolean status = true;

    private boolean arriba = false;


    public void setArriba() {
       pos.setX(pos.getX() - 1) ;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public Perro() {
    }

    public Perro(int id) {
        this.id = id;
        pos = new Posicion();
    }
    public void setPosicion(int y,int id){
        pos.setId(id);
        pos.setX(y);
    }

    @Override
    public void run() {
        while (status) {
            this.setChanged();
            this.notifyObservers(this.pos);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
            if (arriba  == true){
                pos.setX(pos.getX() - 9);
                System.out.println("entre");
                arriba = false;
            }
        }
    }

    public void setStatus (boolean status){
        this.status = status;
    }

}
