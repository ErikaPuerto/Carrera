
package edu.avanzada.taller2.vista;


import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class VistaCarrera extends JFrame {
    private JLabel semaforoLabel;
    private JButton btnAgregarCaballo, btnIniciarCarrera, btnInterrumpir, btnSalir;
    private JPanel pistaPanel;
    private Map<Caballo, JLabel> caballosLabels;
    private JLabel ganadorLabel;  // Label para mostrar el ganador

    public VistaCarrera() {
        setTitle("Carrera de Caballos");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Botón de agregar caballo
        btnAgregarCaballo = new JButton("Agregar Caballo");
        btnAgregarCaballo.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Inicialización del botón de inicio
        btnIniciarCarrera = new JButton("Iniciar Carrera");
        btnIniciarCarrera.setFont(new Font("Arial", Font.BOLD, 14));

        // Inicialización del botón de interrupción
        btnInterrumpir = new JButton("Interrumpir Carrera");
        btnInterrumpir.setFont(new Font("Arial", Font.BOLD, 14));

        // Inicialización del botón de salida
        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 14));

        // Panel para botones
        JPanel botonesPanel = new JPanel();
        botonesPanel.add(btnAgregarCaballo);
        botonesPanel.add(btnIniciarCarrera);
        botonesPanel.add(btnInterrumpir);
        botonesPanel.add(btnSalir);
        add(botonesPanel, BorderLayout.NORTH);

        // Inicialización del semáforo
        semaforoLabel = new JLabel("ROJO");
        semaforoLabel.setForeground(Color.RED);
        semaforoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        semaforoLabel.setBounds(10, 50, 100, 50);
        
        // Inicialización del label de ganador
        ganadorLabel = new JLabel("Ganador: ");
        ganadorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(ganadorLabel, BorderLayout.SOUTH);

        // Panel para la pista y los caballos
        pistaPanel = new JPanel();
        pistaPanel.setLayout(null);
        pistaPanel.add(semaforoLabel);
        add(pistaPanel, BorderLayout.CENTER);

        // Inicialización del mapa de JLabels de caballos
        caballosLabels = new HashMap<>();
    }

    public void agregarCaballo(Caballo caballo) {
        JLabel caballoLabel = new JLabel(caballo.getNombre());
        caballoLabel.setBounds(0, caballosLabels.size() * 30, 100, 20);
        pistaPanel.add(caballoLabel);
        caballosLabels.put(caballo, caballoLabel);
    }

    public void actualizarVistaSemaforo(String color) {
    // Cambiar el texto del JLabel del semáforo según el color recibido
    switch (color) {
        case "ROJO" -> {
            semaforoLabel.setText("ROJO");
            semaforoLabel.setForeground(Color.RED);
            }
        case "AMARILLO" -> {
            semaforoLabel.setText("AMARILLO");
            semaforoLabel.setForeground(Color.YELLOW);
            }
        case "VERDE" -> {
            semaforoLabel.setText("VERDE");
            semaforoLabel.setForeground(Color.GREEN);
            }
    }
    semaforoLabel.repaint(); // Re-pinta la vista para aplicar los cambios
}


    public void actualizarPosicionCaballo(Caballo caballo, int posicion) {
        JLabel caballoLabel = caballosLabels.get(caballo);  // caballosLabels es un Map de JLabels por nombre de caballo
    if (caballoLabel != null) {
        caballoLabel.setLocation(posicion, caballoLabel.getY()); // Actualiza la posición horizontal
        caballoLabel.repaint();
        }
    }

    public void mostrarGanador(String mensaje) {
        ganadorLabel.setText(mensaje);
        ganadorLabel.repaint();
    }

    public void mostrarResultadosFinales(Carrera carrera) {
        StringBuilder resultados = new StringBuilder("Resultados finales:\n");
        for (Caballo caballo : carrera.getCaballos()) {
            resultados.append(caballo.getNombre())
                    .append(" - Carreras ganadas: ")
                    .append(caballo.getCarrerasGanadas())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(this, resultados.toString());
    }
    public void mostrarMensaje(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje);
}


    // Métodos para añadir los listeners a los botones
    public void agregarBotonAgregarCaballoListener(ActionListener listener) {
        btnAgregarCaballo.addActionListener(listener);
    }
    public void agregarBotonIniciarListener(ActionListener listener) {
        btnIniciarCarrera.addActionListener(listener);
    }

    public void agregarBotonInterrumpirListener(ActionListener listener) {
        btnInterrumpir.addActionListener(listener);
    }

    public void agregarBotonSalirListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }
}

