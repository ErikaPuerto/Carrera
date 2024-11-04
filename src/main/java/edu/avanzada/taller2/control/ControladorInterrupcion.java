package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import java.util.Random;

/**
 * Controlador que maneja las interrupciones aleatorias de caballos durante una carrera.
 * Esta clase permite detener y reanudar caballos de forma aleatoria durante el transcurso
 * de una carrera, añadiendo un elemento de dinamismo a la competencia.
 */
public class ControladorInterrupcion {

    /** Modelo de la carrera que se está controlando */
    private Carrera carrera;
    
    /** Controlador principal de la aplicación */
    private ControladorPrincipal cp;
    
    /** Referencia al último caballo que fue interrumpido */
    private Caballo ultimoCaballoInterrumpido;

    /**
     * Constructor del controlador de interrupciones.
     * 
     * @param carrera La carrera que se va a controlar
     * @param cp El controlador principal que maneja la interfaz y la lógica general
     */
    public ControladorInterrupcion(Carrera carrera, ControladorPrincipal cp) {
        this.cp = cp;
        this.carrera = carrera;
        this.ultimoCaballoInterrumpido = null; // Inicialmente no hay caballo interrumpido
    }

    /**
     * Método sincronizado que gestiona la interrupción y reanudación aleatoria de caballos durante la carrera.
     * 
     * Este método funciona de la siguiente manera:
     * 1. Si hay un caballo interrumpido previamente, lo reanuda.
     * 2. Si no hay un caballo interrumpido, selecciona uno al azar y lo interrumpe.
     * 
     * Las acciones de este método solo se ejecutan si la carrera está en curso y si existen caballos
     * participando. La causa de la interrupción es seleccionada de forma aleatoria de entre
     * tres posibles: "distracción del caballo", "hueco en la pista" o "cansancio del caballo".
     * 
     * Las interrupciones y reanudaciones son registradas en la interfaz de usuario a través del controlador
     * principal, actualizando la información mostrada al usuario.
     */
    public synchronized void interrumpirCaballoAleatorio() {
        // Verifica si la carrera está en curso y hay caballos participando
        if (!carrera.isCarreraEnCurso() || carrera.getCaballos().isEmpty()) {
            cp.vista.info.setText(cp.vista.info.getText() + 
                "\n La carrera no está en progreso o no hay caballos.\n");
            return;
        }

        // Maneja la reanudación de un caballo previamente interrumpido
        if (ultimoCaballoInterrumpido != null && !ultimoCaballoInterrumpido.isEnCarrera()) {
            if (carrera.isCarreraEnCurso()) {
                // Reanuda el último caballo interrumpido
                ultimoCaballoInterrumpido.reanudar();
                cp.vista.info.setText(cp.vista.info.getText() + 
                    "\n El caballo " + ultimoCaballoInterrumpido.getNombre() + 
                    " ha reanudado la carrera.\n");
                // Resetea la referencia al último caballo interrumpido
                ultimoCaballoInterrumpido = null;
            } else {
                cp.vista.info.setText(cp.vista.info.getText() + 
                    "\n La carrera ya ha terminado.\n");
            }
            return;
        }

        // Selecciona y detiene un nuevo caballo aleatorio
        Random random = new Random();
        Caballo caballoAleatorio = carrera.getCaballos().get(
            random.nextInt(carrera.getCaballos().size()));
        
        if (caballoAleatorio.isEnCarrera()) {
            // Detiene el caballo seleccionado aleatoriamente
            caballoAleatorio.detener();

            // Array de causas posibles
            String[] causas = { "por distracción del caballo", "por un hueco en la pista", "por cansancio del caballo" };

            // Selecciona una causa aleatoria para la interrupción
            String causaInterrupcion = causas[random.nextInt(causas.length)];

            // Actualiza la información en la vista
            cp.vista.info.setText(cp.vista.info.getText() + 
                "\n El caballo " + caballoAleatorio.getNombre() + 
                " ha sido interrumpido " + causaInterrupcion + ".\n");

            // Guarda el caballo interrumpido como el último en ser detenido
            ultimoCaballoInterrumpido = caballoAleatorio;
        } else {
            cp.vista.info.setText(cp.vista.info.getText() + 
                "\n El caballo " + caballoAleatorio.getNombre() + 
                " ya no está en carrera.\n");
        }
    }
}