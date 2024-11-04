/**
 * La clase ControladorCaballo gestiona las interacciones relacionadas con los caballos en una carrera.
 * Permite agregar caballos, iniciar y detener la carrera, y manejar eventos de la vista.
 */
package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.Mensajes;
import edu.avanzada.taller2.vista.VistaCarre;

public class ControladorCaballo {

    /**
     * Controlador de la carrera para gestionar el estado de la carrera.
     */
    private ControladorCarrera controlCarrera;

    /**
     * Carrera actual en la que participan los caballos.
     */
    private Carrera carrera;

    /**
     * Controlador principal de la aplicación.
     */
    private ControladorPrincipal cp;

    /**
     * Controlador de interrupciones para detener un caballo aleatorio.
     */
    private ControladorInterrupcion controladorInterrupcion;

    /**
     * Objeto para mostrar mensajes en la interfaz gráfica.
     */
    private Mensajes mensaje;

    /**
     * Constructor de la clase ControladorCaballo.
     * Inicializa los controladores y configura los eventos de la vista.
     *
     * @param cp            Controlador principal de la aplicación.
     * @param controlCarrera Controlador de la carrera.
     * @param vista         Vista de la carrera para mostrar los elementos gráficos.
     */
    public ControladorCaballo(ControladorPrincipal cp, ControladorCarrera controlCarrera, VistaCarre vista) {
        mensaje = new Mensajes();
        this.controlCarrera = controlCarrera;
        this.carrera = controlCarrera.getCarrera();
        this.cp = cp;
        this.controladorInterrupcion = new ControladorInterrupcion(carrera, cp);
        configurarEventosVista();
    }

    /**
     * Configura los eventos de la vista para responder a las acciones del usuario,
     * como agregar un caballo, iniciar la carrera, interrumpir un caballo, y salir de la aplicación.
     */
    private void configurarEventosVista() {
        cp.vista.agregarBotonAgregarCaballoListener(e -> agregarCaballo());
        cp.vista.agregarBotonIniciarListener(e -> controlCarrera.iniciarCarrera());
        cp.vista.agregarBotonInterrumpirListener(e -> controladorInterrupcion.interrumpirCaballoAleatorio());
        cp.vista.agregarBotonSalirListener(e -> salirAplicacion());
    }

    /**
     * Agrega un caballo a la carrera si el límite de caballos no se ha alcanzado
     * y si el nombre ingresado no está repetido. Actualiza la interfaz con el estado de la operación.
     */
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
                    Caballo nuevoCaballo = new Caballo(nombre.trim(), carrera, controlCarrera);
                    cp.vista.info.setText(cp.vista.info.getText() + "\n Se ha agregado el caballo  " + nombre + ".\n");
                    controlCarrera.agregarCaballo(nuevoCaballo);
                } else {
                    mensaje.mostrarMensaje2(cp.vista, "Nombre no válido. Inténtelo de nuevo.");
                }
            } else {
                cp.vista.info.setText(cp.vista.info.getText() + "\n No se puede ingresar un nombre repetido\n");
            }
        } else {
            cp.vista.info.setText(cp.vista.info.getText() + "\n No se pueden ingresar más caballos\n");
        }
    }

    /**
     * Cierra la aplicación, finalizando la carrera y liberando los recursos de la interfaz gráfica.
     */
    private void salirAplicacion() {
        controlCarrera.finalizarCarrera(); // Finaliza la carrera antes de salir
        cp.vista.dispose();
        System.exit(0);
    }
}