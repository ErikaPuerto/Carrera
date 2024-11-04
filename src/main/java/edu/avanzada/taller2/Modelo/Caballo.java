package edu.avanzada.taller2.Modelo;

import edu.avanzada.taller2.control.ControladorCarrera;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.Mensajes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Caballo implements Runnable {
    private Mensajes mensaje;
    private String nombre;
    private int posicion;
    private boolean enCarrera;
    private ControladorCarrera controlCarrera;
    private Carrera carrera;
    private int carrerasGanadas;
    private boolean enPausa;
    private List<Caballo> rivales;

    public Caballo(String nombre, Carrera carrera,ControladorCarrera controlCarrera) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.controlCarrera = controlCarrera;
        this.posicion = 0;
        this.enCarrera = true;
        this.carrerasGanadas = 0;
        this.enPausa = false;
        this.rivales = new ArrayList<>();
    }

    @Override
    public void run() {
        Random random = new Random();
        int longitudPista = carrera.getLongitudPista();
        
        while (enCarrera && posicion < carrera.getLongitudPista()) {
            try {
                while (enPausa) {
                    Thread.sleep(100); // Espera activa
                }
                
                Thread.sleep(random.nextInt(500) + 100);  // Pausa aleatoria para simular el movimiento
                posicion += random.nextInt(10) + 1;       // Avanza una distancia aleatoria
                controlCarrera.actualizarVista(this);            // Notifica a carrera para actualizar la vista

                if (posicion >= carrera.getLongitudPista()) {
                    controlCarrera.verificarGanador(this);       // Verificar si el caballo ha ganado
                    break;
                }
            } catch (InterruptedException e) {
                mensaje.mostrarMensajeSystem(nombre + " ha sido interrumpido.");
                break;
            }
        }
        if (enCarrera) {
            controlCarrera.verificarGanador(this);
        }
    }

    public void avanzar() {
        posicion++;
    }

    public void detener() {
        enCarrera = false;
        Thread.currentThread().interrupt();
    }
    
    public void detenerRivales(){
        for(Caballo rival : rivales){
            rival.detener();
        }
    }

    public void pausar() {
        enPausa = true; // Cambia el estado a pausa
    }

    public void reanudar() {
        enPausa = false; // Cambia el estado a no pausa
        enCarrera = true; // Cambia el estado a en carrera
    new Thread(this).start(); // Inicia un nuevo hilo para el caballo
    }
    
    public void reiniciar() {
    this.posicion = 0; // Regresa la posición a 0
    this.enCarrera = true; // Asegúrate de que el caballo esté en carrera
    this.enPausa = false; // Asegúrate de que no esté en pausa
}

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getCarrerasGanadas() {
        return carrerasGanadas;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public void setRivales(List<Caballo> rivales) {
        this.rivales = rivales;
    }

public void setEnCarrera(boolean enCarrera) {
    this.enCarrera = enCarrera;
}


    public void incrementarCarrerasGanadas() {
        carrerasGanadas++;
    }
    public boolean isEnCarrera() {
    return enCarrera; // Retorna el estado del caballo
}
}
