/**
 * La clase Carrera representa una carrera de caballos, gestionando los caballos
 * que participan, la longitud de la pista y el estado de la carrera.
 */
package edu.avanzada.taller2.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    /**
     * Lista de caballos participantes en la carrera.
     */
    private List<Caballo> caballos;

    /**
     * Longitud de la pista de la carrera en unidades (ej. metros).
     */
    private int longitudPista;

    /**
     * Indica si la carrera está en curso.
     */
    private boolean carreraEnCurso;

    /**
     * Constructor de la clase Carrera.
     * Inicializa la lista de caballos, la longitud de la pista, y establece
     * el estado de la carrera como no iniciada.
     *
     * @param longitudPista Longitud de la pista en unidades.
     */
    public Carrera(int longitudPista) {
        this.caballos = new ArrayList<>();
        this.longitudPista = longitudPista;
        this.carreraEnCurso = false;
    }

    /**
     * Verifica si la carrera está en curso.
     *
     * @return true si la carrera está en curso, false en caso contrario.
     */
    public boolean isCarreraEnCurso() {
        return carreraEnCurso;
    }

    /**
     * Establece el estado de la carrera.
     *
     * @param carreraEnCurso true si la carrera está en curso, false si no.
     */
    public void setCarreraEnCurso(boolean carreraEnCurso) {
        this.carreraEnCurso = carreraEnCurso;
    }

    /**
     * Obtiene la longitud de la pista de la carrera.
     *
     * @return La longitud de la pista.
     */
    public int getLongitudPista() {
        return longitudPista;
    }

    /**
     * Obtiene la lista de caballos en la carrera.
     *
     * @return Lista de caballos participantes.
     */
    public List<Caballo> getCaballos() {
        return caballos;
    }

    /**
     * Obtiene el número de caballos en la carrera.
     *
     * @return Número de caballos en la carrera.
     */
    public int numCaballos() {
        return caballos.size();
    }

    /**
     * Agrega un caballo a la carrera.
     *
     * @param caballo El caballo a agregar.
     */
    public void agregarCaballo(Caballo caballo) {
        caballos.add(caballo);
    }

    /**
     * Comprueba si ya existe un caballo en la carrera con el nombre proporcionado.
     *
     * @param nombre Nombre del caballo a verificar.
     * @return true si no existe un caballo con ese nombre, false en caso contrario.
     */
    public boolean comprobarNombre(String nombre) {
        for (Caballo caballo : getCaballos()) {
            if (caballo.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }
}