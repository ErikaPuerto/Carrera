/**
 * La clase Semaforo simula un semáforo en una carrera, controlando el cambio de estados
 * (ROJO, AMARILLO, VERDE) para indicar el inicio de la carrera.
 * Implementa la interfaz Runnable para ejecutar en un hilo independiente.
 */
package edu.avanzada.taller2.Modelo;

import edu.avanzada.taller2.control.ControladorCarrera;
import java.util.Random;

public class Semaforo implements Runnable {

    /**
     * Estado actual del semáforo (ROJO, AMARILLO, VERDE).
     */
    private String estado;

    /**
     * Controlador de la carrera, utilizado para actualizar la vista y coordinar el inicio de la carrera.
     */
    private ControladorCarrera carrera;

    /**
     * Constructor de la clase Semaforo.
     * Inicializa el semáforo en estado "ROJO" y guarda el controlador de la carrera.
     *
     * @param carrera Controlador de la carrera que maneja el semáforo.
     */
    public Semaforo(ControladorCarrera carrera) {
        this.carrera = carrera;
        this.estado = "ROJO";
    }

    /**
     * Método que ejecuta la secuencia del semáforo en un hilo.
     * Cambia de ROJO a AMARILLO y luego a VERDE, actualizando la vista
     * y, en estado VERDE, inicia la carrera.
     */
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

    /**
     * Obtiene el estado actual del semáforo.
     *
     * @return Estado actual del semáforo.
     */
    public String getEstado() {
        return estado;
    }
}

