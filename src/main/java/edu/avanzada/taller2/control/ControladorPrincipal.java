package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.VistaCarre;

public class ControladorPrincipal {
    protected VistaCarre vista;
    private Carrera carrera;
    private ControladorCarrera controladorCarrera;

    public ControladorPrincipal() {
        // Inicializamos la vista
        vista = new VistaCarre();
        
        // Configuramos el modelo con la pista de carrera
        carrera = new Carrera(370, vista);
        
        // Inicializamos el controlador de la carrera con el modelo y la vista
        controladorCarrera = new ControladorCarrera(this,carrera, vista);
    }

    public void iniciarAplicacion() {
        vista.setVisible(true);  // Mostramos la ventana principal de la interfaz
    }
}