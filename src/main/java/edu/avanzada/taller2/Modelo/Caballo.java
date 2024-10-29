
package edu.avanzada.taller2.Modelo;

import java.util.Random;

public class Caballo implements Runnable {
    private String nombre;
    private int posicion;
    private boolean enCarrera;
    private Carrera carrera;
    private int carrerasGanadas;
    private boolean enPausa;

    public Caballo(String nombre, Carrera carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.posicion = 0;
        this.enCarrera = true;
        this.carrerasGanadas = 0;
        this.enPausa = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (enCarrera && posicion < carrera.getLongitudPista()) {
            try {
                while (enPausa) {
                    Thread.sleep(100); // Espera activa
                }
                
                Thread.sleep(random.nextInt(500) + 100);  // Pausa aleatoria para simular el movimiento
                posicion += random.nextInt(10) + 1;       // Avanza una distancia aleatoria
                carrera.actualizarVista(this);            // Notifica a carrera para actualizar la vista

                if (posicion >= carrera.getLongitudPista()) {
                    carrera.verificarGanador(this);       // Verificar si el caballo ha ganado
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println(nombre + " ha sido interrumpido.");
                break;
            }
        }
        if (enCarrera) {
            carrera.verificarGanador(this);
        }
    }

    public void avanzar() {
        posicion++;
    }

    public void detener() {
        enCarrera = false;
        Thread.currentThread().interrupt();
    }

    public void pausar() {
        enPausa = true; // Cambia el estado a pausa
    }

    public void reanudar() {
        enPausa = false; // Cambia el estado a no pausa
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

    public void incrementarCarrerasGanadas() {
        carrerasGanadas++;
    }
    public boolean isEnCarrera() {
    return enCarrera; // Retorna el estado del caballo
}

}
