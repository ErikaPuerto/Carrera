package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.VistaCarrera;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

public class ControladorCarrera {
    private Carrera carrera;
    private VistaCarrera vista;
    private Caballo caballoDetenido;
    private boolean carreraEnCurso;

    public ControladorCarrera(VistaCarrera vista) {
        this.vista = vista;
        this.carrera = new Carrera(100,this.vista); 
        

        // Agregar listeners a los botones en la vista
        vista.agregarBotonAgregarCaballoListener(e -> agregarCaballo());
        vista.agregarBotonIniciarListener((ActionEvent e) -> {
            iniciarCarrera();
        });

        vista.agregarBotonInterrumpirListener((ActionEvent e) -> {
            interrumpirCaballo();
        });

        vista.agregarBotonSalirListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirPrograma();
            }
        });
    }

    // Métodos para manejar los eventos de los botones
    private void agregarCaballo() {
        String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del caballo:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            Caballo nuevoCaballo = new Caballo(nombre, carrera); 
            carrera.agregarCaballo(nuevoCaballo); 
            vista.agregarCaballo(nuevoCaballo); 
        } else {
            JOptionPane.showMessageDialog(vista, "El nombre del caballo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void iniciarCarrera() {
    if (!carreraEnCurso) {
        if (carrera.getCaballos().isEmpty()) {
            vista.mostrarMensaje("No hay caballos en la carrera.");
            return;
        }
        carrera.iniciarCarrera(); // Inicia la carrera
        carreraEnCurso = true; // Establece que la carrera está en curso
    } else {
        // Si la carrera ya está en curso, reiniciamos los caballos
        carrera.reiniciarCaballos(); // Reinicia los caballos
        vista.mostrarMensaje("La carrera ha sido reiniciada.");
        carrera.iniciarCarrera(); // Iniciar la carrera de nuevo
    }
}



    private void interrumpirCaballo() {
        if (caballoDetenido == null) {
            // Elegir un caballo aleatorio para interrumpir
            Random random = new Random();
            caballoDetenido = carrera.getCaballos().get(random.nextInt(carrera.getCaballos().size()));
            carrera.interrumpirCaballo(caballoDetenido);
            vista.mostrarMensaje("El caballo " + caballoDetenido.getNombre() + " ha sido interrumpido.");
        } else {
            // Reanudar el caballo previamente interrumpido
            caballoDetenido.reanudar();
            vista.mostrarMensaje("El caballo " + caballoDetenido.getNombre() + " ha reanudado la carrera.");
            caballoDetenido = null; // Restablecer la variable
        }
    }

    private void salirPrograma() {
        vista.mostrarResultadosFinales(carrera);
        System.exit(0);
    }
}

