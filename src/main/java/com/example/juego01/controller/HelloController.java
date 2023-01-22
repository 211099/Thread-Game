package com.example.juego01.controller;

import com.example.juego01.models.Carro;
import com.example.juego01.models.Posicion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {


    private Carro C1;
    private Carro C2;


    @FXML
    private Button idAbajo;

    @FXML
    private Button idArriba;

    @FXML
    private Button idIniciar;

    @FXML
    private Circle idPerro;

    @FXML
    private Button idReiniciar;

    @FXML
    private AnchorPane rootScene;

    @FXML
    private Rectangle idRectangule1;

    @FXML
    private Rectangle idRectangule2;

    @FXML
    void AbajoOnMouse(MouseEvent event) {

    }

    @FXML
    void ArribaOnMouse(MouseEvent event) {

    }

    @FXML
    void IniciarOnMouse(MouseEvent event) {
        C1 = new Carro(1);
        C1.addObserver(this);
        Thread hilo1 = new Thread(C1);
        hilo1.setDaemon(true);
        hilo1.start();
        C1.setPosicion(2,1);

        C2 = new Carro(2);
        C2.addObserver(this);
        Thread hilo2 = new Thread(C2);
        hilo2.setDaemon(true);
        hilo2.start();
        C2.setPosicion(559,2);





    }

    @FXML
    void ReiniciarOnMouse(MouseEvent event) {

    }

    @FXML
    void SaliOnMouse(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(Thread.currentThread().getName());
        Posicion pos1 = (Posicion)arg;

        switch (pos1.getId()){
            case 1:
                Platform.runLater(() ->  idRectangule1.setLayoutX(pos1.getX()));
                break;
            case 2:
                Platform.runLater(() ->  idRectangule2.setLayoutX(pos1.getX()));
                break;
        }




    }
}
