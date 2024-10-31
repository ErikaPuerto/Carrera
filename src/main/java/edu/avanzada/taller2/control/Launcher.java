package edu.avanzada.taller2.control;

import edu.avanzada.taller2.control.ControladorPrincipal;
import javax.swing.SwingUtilities;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Inicializamos el controlador principal para iniciar la aplicación
            ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
            controladorPrincipal.iniciarAplicacion();
        });
    }
}