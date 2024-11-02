package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import java.util.Random;

public class ControladorInterrupcion {
    private Carrera carrera;
    private ControladorPrincipal cp;
    private Caballo ultimoCaballoInterrumpido;

    public ControladorInterrupcion(Carrera carrera,ControladorPrincipal cp) {
        this.cp=cp;
        this.carrera = carrera;
        this.ultimoCaballoInterrumpido = null; // Inicialmente no hay caballo interrumpido
    }

    public synchronized void interrumpirCaballoAleatorio() {
        // Si la carrera no está en curso o no hay caballos, no hacer nada
        if (!carrera.isCarreraEnCurso() || carrera.getCaballos().isEmpty()) {
           cp.vista.info.setText( cp.vista.info.getText()+"\n La carrera no está en progreso o no hay caballos.\n");
            return;
        }

        // Si ya hay un caballo interrumpido, intenta reanudarlo
        if (ultimoCaballoInterrumpido != null && !ultimoCaballoInterrumpido.isEnCarrera()) {
            if (carrera.isCarreraEnCurso()) {
                ultimoCaballoInterrumpido.reanudar();  // Reanuda el último caballo interrumpido
                cp.vista.info.setText( cp.vista.info.getText()+"\n El caballo " + ultimoCaballoInterrumpido.getNombre() + " ha reanudado la carrera.\n");
                ultimoCaballoInterrumpido = null;  // Reinicia el último caballo interrumpido
            } else {
                cp.vista.info.setText( cp.vista.info.getText()+"\n La carrera ya ha terminado.\n");
            }
            return;
        }

        // Si no hay caballo interrumpido o el último caballo ya fue reanudado, interrumpe uno nuevo
        Random random = new Random();
        Caballo caballoAleatorio = carrera.getCaballos().get(random.nextInt(carrera.getCaballos().size()));

        if (caballoAleatorio.isEnCarrera()) {
            caballoAleatorio.detener();  // Detiene el nuevo caballo aleatorio
            cp.vista.info.setText( cp.vista.info.getText()+"\n El caballo " + caballoAleatorio.getNombre() + " ha sido interrumpido.\n");
            ultimoCaballoInterrumpido = caballoAleatorio;  // Actualiza el último caballo interrumpido
        } else {
            cp.vista.info.setText( cp.vista.info.getText()+"\n El caballo " + caballoAleatorio.getNombre() + " ya no está en carrera.\n");
        }
    }
}
