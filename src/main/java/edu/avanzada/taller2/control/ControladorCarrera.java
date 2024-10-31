package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.VistaCarrera;
import javax.swing.JOptionPane;

public class ControladorCarrera {
    private Carrera carrera;
    private VistaCarrera vista;
    private ControladorInterrupcion controladorInterrupcion;

    public ControladorCarrera(Carrera carrera, VistaCarrera vista) {
        this.carrera = carrera;
        this.vista = vista;
        this.controladorInterrupcion = new ControladorInterrupcion(carrera);
        configurarEventosVista();
    }

    private void configurarEventosVista() {
        vista.agregarBotonAgregarCaballoListener(e -> agregarCaballo());
        vista.agregarBotonIniciarListener(e -> carrera.iniciarCarrera());
        vista.agregarBotonInterrumpirListener(e -> controladorInterrupcion.interrumpirCaballoAleatorio());
        vista.agregarBotonSalirListener(e -> salirAplicacion());
    }

    private void agregarCaballo() {
        String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del caballo:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            Caballo nuevoCaballo = new Caballo(nombre.trim(), carrera);
            carrera.agregarCaballo(nuevoCaballo);
        } else {
            JOptionPane.showMessageDialog(vista, "Nombre no válido. Inténtelo de nuevo.");
        }
    }

    private void salirAplicacion() {
        carrera.finalizarCarrera(); // Finaliza la carrera antes de salir
        vista.dispose();
        System.exit(0);
    }
}