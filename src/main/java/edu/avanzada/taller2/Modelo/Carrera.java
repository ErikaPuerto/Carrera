
package edu.avanzada.taller2.Modelo;

import edu.avanzada.taller2.vista.VistaCarrera;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carrera {
    private VistaCarrera vista;
    private List<Caballo> caballos;
    private int longitudPista;
    private Semaforo semaforo;
    private boolean carreraEnCurso;

    public Carrera(int longitudPista, VistaCarrera vista) {
        this.caballos = new ArrayList<>();
        this.longitudPista = longitudPista;
        this.carreraEnCurso = false;
        this.semaforo = new Semaforo(this);
        this.vista = vista;
    }

    public void agregarCaballo(Caballo caballo) {
        caballos.add(caballo);
    }

    public void iniciarCarrera() {
        if (!carreraEnCurso) {
        carreraEnCurso = true;
        Thread semaforoThread = new Thread(new Semaforo(this));
        semaforoThread.start();
        System.out.println("Iniciando carrera..."); }
    }

    public void iniciarCaballos() {
        for (Caballo caballo : caballos) {
            new Thread(caballo).start();
        }
    }

    public void finalizarCarrera() {
        carreraEnCurso = false;
    }
    
    public void interrumpirCaballoAleatorio() {
        if (!carreraEnCurso || caballos.isEmpty()) {
            System.out.println("La carrera no está en progreso o no hay caballos.");
            return;
        }

        Random random = new Random();
        Caballo caballoAleatorio = caballos.get(random.nextInt(caballos.size()));

    // Verifica si el caballo aleatorio está en carrera antes de detenerlo
    if (caballoAleatorio.isEnCarrera()) {
        caballoAleatorio.detener(); // Detenemos el caballo
        System.out.println("El caballo " + caballoAleatorio.getNombre() + " ha sido interrumpido.");
    } else {
        System.out.println("El caballo " + caballoAleatorio.getNombre() + " ya no está en carrera.");
    }
    }
    
    public synchronized void verificarGanador(Caballo caballo) {
        if (!carreraEnCurso) return;
        
        carreraEnCurso = false;
        caballo.incrementarCarrerasGanadas();
        mostrarGanador(caballo);
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
        if (vista != null) {vista.actualizarVistaSemaforo(color);}
    }

    public void mostrarGanador(Caballo ganador) {
        if (ganador != null) {
        // Llama al método de VistaCarrera para mostrar el nombre del ganador
        vista.mostrarGanador("Ganador: " + ganador.getNombre());        
        } else {
            vista.mostrarGanador("Empate entre caballos.");
        }vista.actualizarVistaSemaforo("ROJO");
    }
}

