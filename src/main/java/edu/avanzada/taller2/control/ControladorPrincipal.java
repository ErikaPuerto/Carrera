package edu.avanzada.taller2.control;

import edu.avanzada.taller2.vista.VistaCarre;

public class ControladorPrincipal {
    protected VistaCarre vista;
    private ControladorCarrera carrera;
    private ControladorCaballo controladorCaballo;

    public ControladorPrincipal() {
        // Inicializamos la vista
        vista = new VistaCarre();
        
        // Configuramos el modelo con la pista de carrera
        carrera = new ControladorCarrera(370, vista);
        
        // Inicializamos el controlador de la carrera con el modelo y la vista
        controladorCaballo = new ControladorCaballo(this,carrera, vista);
        iniciarAplicacion();
    }

    public void iniciarAplicacion() {
        vista.setVisible(true);  // Mostramos la ventana principal de la interfaz
    }
}