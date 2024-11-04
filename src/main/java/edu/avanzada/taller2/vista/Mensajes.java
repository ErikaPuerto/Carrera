package edu.avanzada.taller2.vista;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * La clase Mensajes se encarga de manejar la presentación de diferentes tipos de mensajes
 * al usuario a través de diálogos de la biblioteca Swing (JOptionPane).
 * Ofrece métodos para mostrar mensajes informativos, de error, advertencias, 
 * entradas de usuario y confirmaciones.
 *
 * @version 1.0
 */
public class Mensajes {

    /**
     * Muestra un cuadro de diálogo con un mensaje de información.
     *
     * @param mensaje El mensaje a mostrar al usuario.
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje en la consola (no implementado completamente, ya que solo imprime una línea vacía).
     *
     * @param mensaje El mensaje que debería mostrarse en la consola.
     */
    public void mostrarMensajeSystem(String mensaje) {
        System.out.println("");
    }

    /**
     * Muestra un cuadro de diálogo para que el usuario ingrese un texto.
     *
     * @param parent El componente padre para el diálogo (puede ser null).
     * @param mensaje El mensaje a mostrar en el cuadro de entrada.
     * @return El texto ingresado por el usuario, o null si el usuario cancela.
     */
    public String mostrarInput(Component parent, String mensaje) {
        return JOptionPane.showInputDialog(parent, mensaje, "Entrada requerida", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje de información en un componente específico.
     *
     * @param parent El componente padre para el cuadro de diálogo.
     * @param mensaje El mensaje a mostrar al usuario.
     */
    public void mostrarMensaje2(Component parent, String mensaje) {
        JOptionPane.showMessageDialog(parent, mensaje, "Entrada requerida", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje de error.
     *
     * @param mensaje El mensaje de error a mostrar al usuario.
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje de advertencia.
     *
     * @param mensaje El mensaje de advertencia a mostrar al usuario.
     */
    public void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo de confirmación para que el usuario elija entre "Sí" o "No".
     *
     * @param mensaje El mensaje de confirmación a mostrar al usuario.
     * @return true si el usuario selecciona "Sí", false si selecciona "No".
     */
    public boolean mostrarConfirmacion(String mensaje) {
        int resultado = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION);
        return resultado == JOptionPane.YES_OPTION;
    }
}