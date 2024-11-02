package edu.avanzada.taller2.Modelo;

import edu.avanzada.taller2.vista.VistaCarre;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private VistaCarre vista;
    private List<Caballo> caballos;
    private int longitudPista;
    private Semaforo semaforo;
    private boolean carreraEnCurso;
    private List<Caballo> caballosGanadores = new ArrayList<>();
    private boolean hayGanador = false; // Variable para controlar si ya hay un ganador

    public Carrera(int longitudPista, VistaCarre vista) {
        this.caballos = new ArrayList<>();
        this.longitudPista = longitudPista;
        this.carreraEnCurso = false;
        this.semaforo = new Semaforo(this);
        this.vista = vista;
    }

    public void agregarCaballo(Caballo caballo) {
        caballos.add(caballo);
        vista.agregarCaballo(caballo);
    }

    public void iniciarCarrera() {
        if (caballos.size() < 2) {
            vista.mostrarMensaje("Se requieren al menos 2 caballos para iniciar la carrera.");
            return;
        }
        if (!carreraEnCurso) {  // Si la carrera no está en curso, entonces reiniciar y comenzar
            reiniciarCaballos();
            carreraEnCurso = true;
            new Thread(semaforo).start();
            vista.info.setText( vista.info.getText()+"\n Iniciando carrera...\n");
        }
    }

    public void iniciarCaballos() {
        for (Caballo caballo : caballos) {
            new Thread(caballo).start();
        }
    }

     public void finalizarCarrera() {
        carreraEnCurso = false;
        detenerTodosLosCaballos();
        vista.mostrarResultadosFinales(this); // Muestra los resultados finales
    }

    public synchronized void verificarGanador(Caballo caballo) {
    if (!carreraEnCurso) return;
    if (!hayGanador && caballo.getPosicion() >= longitudPista) {
        caballosGanadores.add(caballo);
        hayGanador = true; // Establece que ya hay un ganador
        detenerTodosLosCaballos(); // Detiene a todos los caballos
        if (caballosGanadores.size() == 1) {
            mostrarGanador(caballosGanadores.get(0));
        } else {
            mostrarEmpate(caballosGanadores);
        }
        carreraEnCurso = false;
    } else if (caballos.stream().allMatch(c -> c.getPosicion() >= longitudPista)) {
        carreraEnCurso = false;
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
        ganador.incrementarCarrerasGanadas(); // Incrementa las carreras ganadas del caballo ganador
        vista.actualizarVistaSemaforo("ROJO");
    }

    public void detenerTodosLosCaballos() {
        for (Caballo caballo : caballos) {
            caballo.detener();
        }
    }

    public boolean isCarreraEnCurso() {
        return carreraEnCurso;
    }

    public int getLongitudPista() {
        return longitudPista;
    }

    public List<Caballo> getCaballos() {
        return caballos;
    }

    // Métodos para actualizar la vista y mostrar el ganador
    public void actualizarVista(Caballo caballo) {
        vista.actualizarPosicionCaballo(caballo, caballo.getPosicion());
    }

    public void actualizarVistaSemaforo(String color) {
        vista.actualizarVistaSemaforo(color);
    }

    public void reiniciarCaballos() {
        for (Caballo caballo : caballos) {
            caballo.setPosicion(0);
            caballo.setEnCarrera(true);
        }
        carreraEnCurso = false;
        hayGanador = false; // Reinicia el indicador de ganador
        caballosGanadores.clear(); // Limpia la lista de ganadores
        vista.actualizarVistaSemaforo("ROJO");
    }
}
