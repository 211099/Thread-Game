package com.example.juego01.models;

import java.util.Observable;

public class Carro extends Observable implements Runnable {

    private int id ;
    private Posicion pos;

    private boolean status = true;
    private int distanciax = 10;

    public Carro(int id) {
       this.id = id;
       pos = new Posicion();
    }
    public void setPosicion(int x, int id){
        pos.setX(x);
        pos.setId(id);
    }
    @Override
    public void run() {
        while (status) {
            this.setChanged();
            this.notifyObservers(this.pos);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            pos.setX(pos.getX() + distanciax);
            if (pos.getX() >= 570)
                distanciax *= -1;
            if (pos.getX() <= 0)
                distanciax *= -1;
        }
    }
    public void setStatus (boolean status){
        this.status = status;
    }
}
