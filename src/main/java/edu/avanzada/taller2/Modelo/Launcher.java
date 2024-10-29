package edu.avanzada.taller2.Modelo;

import edu.avanzada.taller2.control.ControladorCarrera;
import edu.avanzada.taller2.vista.VistaCarrera;
import javax.swing.SwingUtilities;

public class Launcher {
    public static void main(String[] args) {
        
        // Inicialización de la vista
        VistaCarrera vista = new VistaCarrera();
        
        // Inicialización del controlador con el modelo y la vista
        ControladorCarrera controlador = new ControladorCarrera(vista);

        // Inicialización del modelo: la carrera
        Carrera carrera = new Carrera(5000,vista);
        
        // Añadir caballos a la carrera
        carrera.agregarCaballo(new Caballo("Caballo 1", carrera));
        carrera.agregarCaballo(new Caballo("Caballo 2", carrera));
        // Puedes agregar más caballos si lo deseas
        
               
        // Ejecutar la vista en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            vista.setVisible(true);  // Mostrar la ventana principal de la interfaz
        });
    }
}

