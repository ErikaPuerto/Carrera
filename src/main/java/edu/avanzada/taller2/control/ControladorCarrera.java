package edu.avanzada.taller2.control;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.vista.VistaCarrera;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorCarrera {
    private Carrera carrera;
    private VistaCarrera vista;

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
        carrera.iniciarCarrera();
    }

    private void interrumpirCaballo() {
        carrera.interrumpirCaballoAleatorio();
    }

    private void salirPrograma() {
        vista.mostrarResultadosFinales(carrera);
        System.exit(0);
    }
}

