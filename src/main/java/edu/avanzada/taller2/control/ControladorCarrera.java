package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.VistaCarre;
import javax.swing.JOptionPane;

public class ControladorCarrera {

    private Carrera carrera;
    private ControladorPrincipal cp;
    private ControladorInterrupcion controladorInterrupcion;

    public ControladorCarrera(ControladorPrincipal cp, Carrera carrera, VistaCarre vista) {
        this.carrera = carrera;
        this.cp = cp;
        this.controladorInterrupcion = new ControladorInterrupcion(carrera, cp);
        configurarEventosVista();
    }

    private void configurarEventosVista() {
        cp.vista.agregarBotonAgregarCaballoListener(e -> agregarCaballo());
        cp.vista.agregarBotonIniciarListener(e -> carrera.iniciarCarrera());
        cp.vista.agregarBotonInterrumpirListener(e -> controladorInterrupcion.interrumpirCaballoAleatorio());
        cp.vista.agregarBotonSalirListener(e -> salirAplicacion());
    }

    private void agregarCaballo() {
        if (carrera.NumCaballos() < 4) {

            String nombre = JOptionPane.showInputDialog(cp.vista, "Ingrese el nombre del caballo:");
            if (carrera.ComprobarNombre(nombre)) {

                if (nombre != null && !nombre.trim().isEmpty()) {
                    Caballo nuevoCaballo = new Caballo(nombre.trim(), carrera);

                    cp.vista.info.setText(cp.vista.info.getText() + "\n Se ha agregado el caballo  " + nombre + ".\n");
                    carrera.agregarCaballo(nuevoCaballo);
                } else {
                    JOptionPane.showMessageDialog(cp.vista, "Nombre no válido. Inténtelo de nuevo.");
                }
            }else{cp.vista.info.setText(cp.vista.info.getText() + "\n No se puede ingresar un nombre repetido\n");}
        } else {
            cp.vista.info.setText(cp.vista.info.getText() + "\n No se pueden ingresar mas caballos\n");
        }

    }

    private void salirAplicacion() {
        carrera.finalizarCarrera(); // Finaliza la carrera antes de salir
        cp.vista.dispose();
        System.exit(0);
    }
}
