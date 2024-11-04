package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Semaforo;
import edu.avanzada.taller2.vista.VistaCarre;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador principal para la gestión de una carrera de caballos.
 * Esta clase maneja la lógica de control entre el modelo de carrera y su vista,
 * gestionando el inicio, desarrollo y finalización de la carrera.
 */
public class ControladorCarrera {

    /** Vista asociada a la carrera */
    private VistaCarre vista;
    /** Modelo de la carrera */
    private Carrera carrera;
    /** Semáforo para controlar el inicio de la carrera */
    private Semaforo semaforo;
    /** Lista que almacena los caballos que han ganado la carrera */
    private List<Caballo> caballosGanadores;
    /** Indica si ya hay un ganador en la carrera actual */
    private boolean hayGanador = false;

    /**
     * Constructor del controlador de carrera.
     * @param longitudPista Longitud de la pista de carrera
     * @param vista Vista asociada a la carrera
     */
    public ControladorCarrera(int longitudPista, VistaCarre vista) {
        this.carrera = new Carrera(longitudPista);
        this.semaforo = new Semaforo(this);
        this.vista = vista;
        this.caballosGanadores = new ArrayList<>();
    }

    /**
     * Agrega un nuevo caballo a la carrera y actualiza la vista.
     * @param caballo Caballo a agregar a la carrera
     */
    public void agregarCaballo(Caballo caballo) {
        carrera.agregarCaballo(caballo);
        vista.agregarCaballo(caballo);
    }

    /**
     * Inicia la carrera si hay al menos dos caballos participantes.
     * Reinicia las posiciones de los caballos y asigna los rivales antes de comenzar.
     */
    public void iniciarCarrera() {
        if (carrera.numCaballos() < 2) {
            vista.mostrarMensaje("Se requieren al menos 2 caballos para iniciar la carrera.");
            return;
        }
        reiniciarCaballos();
        asignarRivales();
        if (!carrera.isCarreraEnCurso()) {
            carrera.setCarreraEnCurso(true);
            new Thread(semaforo).start();
            vista.info.setText(vista.info.getText() + "\n Iniciando carrera...\n");
        }
    }

    /**
     * Inicia los hilos de todos los caballos participantes.
     */
    public void iniciarCaballos() {
        for (Caballo caballo : carrera.getCaballos()) {
            new Thread(caballo).start();
        }
    }

    /**
     * Finaliza la carrera, detiene todos los caballos y muestra los resultados.
     */
    public void finalizarCarrera() {
        carrera.setCarreraEnCurso(false);
        detenerTodosLosCaballos();
        vista.mostrarResultadosFinales(carrera);
    }

    /**
     * Verifica si un caballo ha ganado la carrera.
     * Este método es sincronizado para evitar condiciones de carrera.
     * @param caballo Caballo a verificar
     */
    public synchronized void verificarGanador(Caballo caballo) {
        if (!carrera.isCarreraEnCurso()) return;

        if (!hayGanador && caballo.getPosicion() >= carrera.getLongitudPista()) {
            caballosGanadores.add(caballo);
            hayGanador = true;
            caballo.detenerRivales();
            detenerTodosLosCaballos();
            if (caballosGanadores.size() == 1) {
                mostrarGanador(caballosGanadores.get(0));
            } else {
                mostrarEmpate(caballosGanadores);
            }
            carrera.setCarreraEnCurso(false);
        }
    }

    /**
     * Muestra el mensaje de empate cuando múltiples caballos llegan a la meta simultáneamente.
     * @param caballosEmpatados Lista de caballos que empataron
     */
    private void mostrarEmpate(List<Caballo> caballosEmpatados) {
        StringBuilder mensaje = new StringBuilder("Empate entre los caballos: ");
        for (Caballo caballo : caballosEmpatados) {
            mensaje.append(caballo.getNombre()).append(" ");
        }
        vista.mostrarGanador(mensaje.toString());
        vista.actualizarVistaSemaforo("ROJO");
    }

    /**
     * Muestra el mensaje del caballo ganador y actualiza sus estadísticas.
     * @param ganador Caballo ganador de la carrera
     */
    private void mostrarGanador(Caballo ganador) {
        vista.mostrarGanador("Ganador: " + ganador.getNombre());
        ganador.incrementarCarrerasGanadas();
        vista.actualizarVistaSemaforo("ROJO");
    }

    /**
     * Detiene todos los caballos participantes en la carrera.
     */
    public void detenerTodosLosCaballos() {
        for (Caballo caballo : carrera.getCaballos()) {
            caballo.detener();
        }
    }

    /**
     * Actualiza la posición de un caballo en la vista.
     * @param caballo Caballo cuya posición se actualizará
     */
    public void actualizarVista(Caballo caballo) {
        vista.actualizarPosicionCaballo(caballo, caballo.getPosicion());
    }

    /**
     * Actualiza el color del semáforo en la vista.
     * @param color Nuevo color del semáforo
     */
    public void actualizarVistaSemaforo(String color) {
        vista.actualizarVistaSemaforo(color);
    }

    /**
     * Reinicia el estado de todos los caballos y la carrera.
     * Coloca todos los caballos en la posición inicial y limpia la lista de ganadores.
     */
    public void reiniciarCaballos() {
        for (Caballo caballo : carrera.getCaballos()) {
            caballo.setPosicion(0);
            caballo.setEnCarrera(true);
        }
        carrera.setCarreraEnCurso(false);
        hayGanador = false;
        caballosGanadores.clear();
        vista.actualizarVistaSemaforo("ROJO");
    }
    
    /**
     * Obtiene el objeto Carrera asociado al controlador.
     * @return Objeto Carrera actual
     */
    public Carrera getCarrera() {
        return carrera;
    }
    
    /**
     * Asigna los rivales a cada caballo participante.
     * Cada caballo recibe una lista de todos los demás caballos como rivales.
     */
    public void asignarRivales() {
        List<Caballo> caballos = carrera.getCaballos();
        for (Caballo caballoActual : caballos) {
            List<Caballo> rivales = new ArrayList<>(caballos);
            rivales.remove(caballoActual);
            caballoActual.setRivales(rivales);
        }
    }
}