package edu.avanzada.taller2.control;

import edu.avanzada.taller2.vista.VistaCarre;

/**
 * La clase ControladorPrincipal actúa como el controlador principal de la aplicación, 
 * inicializando la vista y coordinando los controladores secundarios, como el de la carrera y los caballos.
 * Su responsabilidad principal es arrancar la interfaz gráfica y enlazar los distintos controladores necesarios.
 */
public class ControladorPrincipal {

    /** La vista principal de la aplicación */
    protected VistaCarre vista;
    
    /** Controlador para gestionar la lógica de la carrera */
    private ControladorCarrera carrera;
    
    /** Controlador para gestionar la lógica de los caballos */
    private ControladorCaballo controladorCaballo;

    /**
     * Constructor de la clase ControladorPrincipal.
     * Se encarga de inicializar la vista, configurar los controladores de carrera y caballos,
     * y de arrancar la aplicación.
     */
    public ControladorPrincipal() {
        // Inicializamos la vista
        vista = new VistaCarre();
        
        // Configuramos el modelo con la pista de carrera
        carrera = new ControladorCarrera(370, vista);
        
        // Inicializamos el controlador de la carrera con el modelo y la vista
        controladorCaballo = new ControladorCaballo(this, carrera, vista);
        
        // Iniciamos la aplicación
        iniciarAplicacion();
    }

    /**
     * Método para iniciar la aplicación mostrando la interfaz gráfica al usuario.
     * Hace visible la ventana principal que contiene la interfaz de usuario.
     */
    public void iniciarAplicacion() {
        vista.setVisible(true);  // Mostramos la ventana principal de la interfaz
    }
}
