/**
 * Clase que representa un caballo en una carrera. Implementa la interfaz Runnable
 * para que cada caballo pueda correr en un hilo separado, simulando su avance
 * de forma concurrente.
 */
package edu.avanzada.taller2.Modelo;

import edu.avanzada.taller2.control.ControladorCarrera;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.Mensajes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Caballo implements Runnable {
    private Mensajes mensaje; // Clase que maneja mensajes de información y errores.
    private String nombre; // Nombre del caballo.
    private int posicion; // Posición actual del caballo en la carrera.
    private boolean enCarrera; // Indica si el caballo está en carrera.
    private ControladorCarrera controlCarrera; // Controlador que gestiona la carrera.
    private Carrera carrera; // Carrera en la que participa el caballo.
    private int carrerasGanadas; // Contador de carreras ganadas por el caballo.
    private boolean enPausa; // Indica si el caballo está en pausa.
    private List<Caballo> rivales; // Lista de rivales del caballo.

    /**
     * Constructor que inicializa los atributos principales del caballo.
     *
     * @param nombre         Nombre del caballo.
     * @param carrera        Carrera en la que participa.
     * @param controlCarrera Controlador que gestiona la carrera.
     */
    public Caballo(String nombre, Carrera carrera, ControladorCarrera controlCarrera) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.controlCarrera = controlCarrera;
        this.posicion = 0;
        this.enCarrera = true;
        this.carrerasGanadas = 0;
        this.enPausa = false;
        this.rivales = new ArrayList<>();
    }

    /**
     * Método ejecutado al iniciar el hilo del caballo. Simula su avance en la carrera
     * y verifica si ha ganado al llegar a la meta.
     */
    @Override
    public void run() {
        Random random = new Random();
        int longitudPista = carrera.getLongitudPista();

        while (enCarrera && posicion < longitudPista) {
            try {
                // Pausa el avance si el caballo está en pausa.
                while (enPausa) {
                    Thread.sleep(100); // Espera activa.
                }

                // Simula el avance del caballo en una distancia aleatoria.
                Thread.sleep(random.nextInt(500) + 100); 
                posicion += random.nextInt(10) + 1;

                // Actualiza la vista para reflejar la posición actual del caballo.
                controlCarrera.actualizarVista(this);

                // Verifica si el caballo ha alcanzado o superado la longitud de la pista.
                if (posicion >= longitudPista) {
                    controlCarrera.verificarGanador(this); 
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

    /**
     * Avanza la posición del caballo en una unidad.
     */
    public void avanzar() {
        posicion++;
    }

    /**
     * Detiene al caballo y lo saca de la carrera.
     */
    public void detener() {
        enCarrera = false;
        Thread.currentThread().interrupt();
    }

    /**
     * Detiene a todos los rivales del caballo.
     */
    public void detenerRivales() {
        for (Caballo rival : rivales) {
            rival.detener();
        }
    }

    /**
     * Pausa el avance del caballo.
     */
    public void pausar() {
        enPausa = true;
    }

    /**
     * Reanuda el avance del caballo iniciando un nuevo hilo.
     */
    public void reanudar() {
        enPausa = false;
        enCarrera = true;
        new Thread(this).start();
    }

    /**
     * Reinicia el estado del caballo para una nueva carrera.
     */
    public void reiniciar() {
        this.posicion = 0;
        this.enCarrera = true;
        this.enPausa = false;
    }

    /**
     * Retorna el nombre del caballo.
     *
     * @return nombre del caballo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la posición actual del caballo.
     *
     * @return posición actual.
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Retorna la cantidad de carreras ganadas por el caballo.
     *
     * @return número de carreras ganadas.
     */
    public int getCarrerasGanadas() {
        return carrerasGanadas;
    }

    /**
     * Establece la posición del caballo.
     *
     * @param posicion nueva posición del caballo.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * Establece la lista de rivales del caballo.
     *
     * @param rivales lista de rivales del caballo.
     */
    public void setRivales(List<Caballo> rivales) {
        this.rivales = rivales;
    }

    /**
     * Cambia el estado del caballo en carrera.
     *
     * @param enCarrera estado del caballo en carrera.
     */
    public void setEnCarrera(boolean enCarrera) {
        this.enCarrera = enCarrera;
    }

    /**
     * Incrementa el contador de carreras ganadas.
     */
    public void incrementarCarrerasGanadas() {
        carrerasGanadas++;
    }

    /**
     * Retorna el estado del caballo en carrera.
     *
     * @return verdadero si el caballo está en carrera, falso en caso contrario.
     */
    public boolean isEnCarrera() {
        return enCarrera;
    }
}