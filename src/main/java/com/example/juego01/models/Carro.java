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

    public int getId() {
        return id;
    }

    public Posicion getPos() {
        return pos;
    }

    public void setPosicion(int x, int id){
        pos.setX(x);
        pos.setId(id);
    }







    @Override
    public void run() {
        while (status) {
            //notificar el cambio
            //notyfy avisa que algo cambio
            //setChanged y notifyObservers simpre van en pares
            this.setChanged();
            this.notifyObservers(this.pos);
            //Dormir el Hilo
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
            //Realizar calculos
            System.out.println(pos.getX());
            pos.setX(pos.getX() + distanciax);
            System.out.println(pos.getX());

            if (pos.getX() >= 570)
                distanciax *= -1;
            if (pos.getX() <= 0)
                distanciax *= -1;


        }
        System.out.println("se murio mi hilo");
    }

    public void setStatus (boolean status){
        this.status = status;
    }
}
