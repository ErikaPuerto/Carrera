package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.VistaCarrera;

public class ControladorPrincipal {
    private VistaCarrera vista;
    private Carrera carrera;
    private ControladorCarrera controladorCarrera;

    public ControladorPrincipal() {
        // Inicializamos la vista
        vista = new VistaCarrera();
        
        // Configuramos el modelo con la pista de carrera
        carrera = new Carrera(200, vista);
        
        // Inicializamos el controlador de la carrera con el modelo y la vista
        controladorCarrera = new ControladorCarrera(carrera, vista);
    }

    public void iniciarAplicacion() {
        vista.setVisible(true);  // Mostramos la ventana principal de la interfaz
    }
}