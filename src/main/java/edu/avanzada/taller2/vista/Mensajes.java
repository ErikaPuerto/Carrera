package edu.avanzada.taller2.vista;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensajes {
    // Método para mostrar un mensaje de información
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
public void mostrarMensajeSystem(String mensaje) {
        System.out.println("");
    }
public String mostrarInput(Component parent, String mensaje) {
        return JOptionPane.showInputDialog(parent, mensaje, "Entrada requerida", JOptionPane.QUESTION_MESSAGE);
    }

public void mostrarMensaje2(Component parent, String mensaje) {
    JOptionPane.showMessageDialog(parent, mensaje, "Entrada requerida", JOptionPane.INFORMATION_MESSAGE);
}
    // Método para mostrar un mensaje de error
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para mostrar un mensaje de advertencia
    public void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    // Método para mostrar opciones (Ej. Confirmar acción)
    public boolean mostrarConfirmacion(String mensaje) {
        int resultado = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION);
        return resultado == JOptionPane.YES_OPTION;
    }
}
