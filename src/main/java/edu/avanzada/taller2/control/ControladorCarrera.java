package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Semaforo;
import edu.avanzada.taller2.vista.VistaCarre;
import java.util.ArrayList;
import java.util.List;

public class ControladorCarrera {

    private VistaCarre vista;
    private Carrera carrera;
    private Semaforo semaforo;
    private List<Caballo> caballosGanadores;
    private boolean hayGanador = false;
    private ControladorCaballo controlCaballo;

    public ControladorCarrera(int longitudPista, VistaCarre vista) {
        this.carrera = new Carrera(longitudPista);
        this.semaforo = new Semaforo(this);
        this.vista = vista;
        this.caballosGanadores = new ArrayList<>();
    }

    public void agregarCaballo(Caballo caballo) {
        carrera.agregarCaballo(caballo);
        vista.agregarCaballo(caballo);
    }

    public void iniciarCarrera() {
        if (carrera.numCaballos() < 2) {
            vista.mostrarMensaje("Se requieren al menos 2 caballos para iniciar la carrera.");
            return;
        }
        if (!carrera.isCarreraEnCurso()) {
            reiniciarCaballos();
            carrera.setCarreraEnCurso(true);
            new Thread(semaforo).start();
            vista.info.setText(vista.info.getText() + "\n Iniciando carrera...\n");
        }
    }

    public void iniciarCaballos() {
        for (Caballo caballo : carrera.getCaballos()) {
            new Thread(caballo).start();
        }
    }

    public void finalizarCarrera() {
        carrera.setCarreraEnCurso(false);
        detenerTodosLosCaballos();
        vista.mostrarResultadosFinales(carrera);
    }

    public synchronized void verificarGanador(Caballo caballo) {
        if (!carrera.isCarreraEnCurso()) return;

        if (!hayGanador && caballo.getPosicion() >= carrera.getLongitudPista()) {
            caballosGanadores.add(caballo);
            hayGanador = true;
            detenerTodosLosCaballos();
            if (caballosGanadores.size() == 1) {
                mostrarGanador(caballosGanadores.get(0));
            } else {
                mostrarEmpate(caballosGanadores);
            }
            carrera.setCarreraEnCurso(false);
        } else if (carrera.getCaballos().stream().allMatch(c -> c.getPosicion() >= carrera.getLongitudPista())) {
            carrera.setCarreraEnCurso(false);
            detenerTodosLosCaballos();
            if (caballosGanadores.size() > 1) {
                mostrarEmpate(caballosGanadores);
            } else {
                mostrarGanador(caballosGanadores.get(0));
            }
        }
    }

    private void mostrarEmpate(List<Caballo> caballosEmpatados) {
        StringBuilder mensaje = new StringBuilder("Empate entre los caballos: ");
        for (Caballo caballo : caballosEmpatados) {
            mensaje.append(caballo.getNombre()).append(" ");
        }
        vista.mostrarGanador(mensaje.toString());
        vista.actualizarVistaSemaforo("ROJO");
    }

    private void mostrarGanador(Caballo ganador) {
        vista.mostrarGanador("Ganador: " + ganador.getNombre());
        ganador.incrementarCarrerasGanadas();
        vista.actualizarVistaSemaforo("ROJO");
    }

    public void detenerTodosLosCaballos() {
        for (Caballo caballo : carrera.getCaballos()) {
            caballo.detener();
        }
    }

    public void actualizarVista(Caballo caballo) {
        vista.actualizarPosicionCaballo(caballo, caballo.getPosicion());
    }

    public void actualizarVistaSemaforo(String color) {
        vista.actualizarVistaSemaforo(color);
    }

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
    
    public Carrera getCarrera() {
        return carrera;
    }
}
