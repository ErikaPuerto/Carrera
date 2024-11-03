package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.Mensajes;
import edu.avanzada.taller2.vista.VistaCarre;

public class ControladorCaballo {

    private ControladorCarrera controlCarrera;
    private Carrera carrera;
    private ControladorPrincipal cp;
    private ControladorInterrupcion controladorInterrupcion;
    private Mensajes mensaje;

    public ControladorCaballo(ControladorPrincipal cp, ControladorCarrera controlCarrera, VistaCarre vista) {
        mensaje = new Mensajes();
        this.controlCarrera = controlCarrera;
        this.carrera = controlCarrera.getCarrera();
        this.cp = cp;
        this.controladorInterrupcion = new ControladorInterrupcion(carrera, cp);
        configurarEventosVista();
    }

    private void configurarEventosVista() {
        cp.vista.agregarBotonAgregarCaballoListener(e -> agregarCaballo());
        cp.vista.agregarBotonIniciarListener(e -> controlCarrera.iniciarCarrera());
        cp.vista.agregarBotonInterrumpirListener(e -> controladorInterrupcion.interrumpirCaballoAleatorio());
        cp.vista.agregarBotonSalirListener(e -> salirAplicacion());
    }

    private void agregarCaballo() {
        if (carrera.numCaballos() < 4) {
if (mensaje == null) {
    System.err.println("La instancia de Mensajes no ha sido inicializada.");
} else if (cp.vista == null) {
    System.err.println("La vista de cp no ha sido inicializada.");
}
            String nombre = mensaje.mostrarInput(cp.vista, "Ingrese el nombre del caballo:");

            if (carrera.comprobarNombre(nombre)) {

                if (nombre != null && !nombre.trim().isEmpty()) {
                    Caballo nuevoCaballo = new Caballo(nombre.trim(), carrera,controlCarrera);

                    cp.vista.info.setText(cp.vista.info.getText() + "\n Se ha agregado el caballo  " + nombre + ".\n");
                    controlCarrera.agregarCaballo(nuevoCaballo);
                } else {
                    mensaje.mostrarMensaje2(cp.vista, "Nombre no válido. Inténtelo de nuevo.");
                }
            }else{cp.vista.info.setText(cp.vista.info.getText() + "\n No se puede ingresar un nombre repetido\n");}
        } else {
            cp.vista.info.setText(cp.vista.info.getText() + "\n No se pueden ingresar mas caballos\n");
        }

    }

    private void salirAplicacion() {
        controlCarrera.finalizarCarrera(); // Finaliza la carrera antes de salir
        cp.vista.dispose();
        System.exit(0);
    }
}
