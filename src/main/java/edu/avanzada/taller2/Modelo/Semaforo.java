package edu.avanzada.taller2.Modelo;

import java.util.Random;


public class Semaforo implements Runnable {
    private String estado;
    private Carrera carrera;

    public Semaforo(Carrera carrera) {
        this.carrera = carrera;
        this.estado = "ROJO";
    }

    @Override
    public void run() {
        try {
            carrera.actualizarVistaSemaforo("ROJO");
            Thread.sleep(new Random().nextInt(2000) + 1000);  // Espera aleatoria en ROJO

            carrera.actualizarVistaSemaforo("AMARILLO");
            Thread.sleep(new Random().nextInt(2000) + 1000);  // Espera aleatoria en AMARILLO

            carrera.actualizarVistaSemaforo("VERDE");
            carrera.iniciarCaballos();  // Iniciar caballos cuando el semáforo esté en verde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getEstado() {
        return estado;
    }
}

