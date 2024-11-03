package edu.avanzada.taller2.vista;

import edu.avanzada.taller2.Modelo.Caballo;
import edu.avanzada.taller2.Modelo.Carrera;
import edu.avanzada.taller2.control.ControladorCarrera;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author anaro
 */
public class VistaCarre extends javax.swing.JFrame {

    /**
     * Creates new form VistaCarre
     */
    FondoPanel fondo = new FondoPanel();

    public VistaCarre() {
        this.setContentPane(fondo);   
        initComponents(); setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
         semaforoLabel = new JLabel("ROJO");
        semaforoLabel.setForeground(Color.RED);
        semaforoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        semaforoLabel.setBounds(10, 50, 100, 50);
        ganadorLabel = new JLabel("Ganador: ");
        ganadorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(ganadorLabel, BorderLayout.SOUTH);
        caballosLabels = new HashMap<>();
        //VistaCarrera();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel2();
        btnIniciarCarrera = new javax.swing.JButton();
        btnInterrumpir = new javax.swing.JButton();
        btnAgregarCaballo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnIniciarCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciar.png"))); // NOI18N
        btnIniciarCarrera.setBorderPainted(false);
        btnIniciarCarrera.setContentAreaFilled(false);
        btnIniciarCarrera.setFocusPainted(false);
        btnIniciarCarrera.setSelected(true);

        btnInterrumpir.setBackground(new java.awt.Color(113, 97, 65));
        btnInterrumpir.setForeground(new java.awt.Color(113, 97, 65));
        btnInterrumpir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/interrumpir.png"))); // NOI18N
        btnInterrumpir.setBorderPainted(false);
        btnInterrumpir.setContentAreaFilled(false);
        btnInterrumpir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterrumpirActionPerformed(evt);
            }
        });

        btnAgregarCaballo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregarCaballo.setAutoscrolls(true);
        btnAgregarCaballo.setBorderPainted(false);
        btnAgregarCaballo.setContentAreaFilled(false);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(info);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo4.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIniciarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInterrumpir, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnAgregarCaballo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnIniciarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAgregarCaballo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInterrumpir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInterrumpirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterrumpirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInterrumpirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaCarre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCarre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCarre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCarre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCarre().setVisible(true);
            }
        });
    }

     private JLabel semaforoLabel;
    //private JButton btnAgregarCaballo, btnIniciarCarrera, btnInterrumpir, btnSalir;
    private Map<Caballo, JLabel> caballosLabels;
    private JLabel ganadorLabel;  // Label para mostrar el ganador

    public void VistaCarrera() {
        setTitle("Carrera de Caballos");
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
        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.add(semaforoLabel);
        add(jPanel1, BorderLayout.CENTER);

        // Inicialización del mapa de JLabels de caballos
        caballosLabels = new HashMap<>();
    }

    public void agregarCaballo(Caballo caballo) {
    // Cargar la imagen usando una ruta relativa
    URL imageUrl = getClass().getClassLoader().getResource("caballo.png");

    // Verificar si la imagen se ha encontrado
    if (imageUrl != null) {
        ImageIcon iconoCaballo = new ImageIcon(imageUrl);
        JLabel caballoLabel = new JLabel(iconoCaballo);

        int posY = caballosLabels.size() * (iconoCaballo.getIconHeight() + 10); // Espacio entre caballos
        caballoLabel.setBounds(0, posY, iconoCaballo.getIconWidth(), iconoCaballo.getIconHeight());
        jPanel1.add(caballoLabel);
        caballosLabels.put(caballo, caballoLabel);
        
        // Actualiza la vista
        jPanel1.revalidate(); // Verifica el layout
        jPanel1.repaint(); // Redibuja el panel
    } else {
        System.out.println("La imagen no se encontró en la ruta especificada.");
    }
}



    public void actualizarVistaSemaforo(String color) {
    // Cambiar el texto del JLabel del semáforo según el color recibido
    switch (color) {
        case "ROJO" -> {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo3.png")));
            }
        case "AMARILLO" -> {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo2.png")));
            }
        case "VERDE" -> {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semaforo1.png")));
            }
    }
    semaforoLabel.repaint(); // Re-pinta la vista para aplicar los cambios
}


    public void actualizarPosicionCaballo(Caballo caballo, int posicion) {
    JLabel caballoLabel = caballosLabels.get(caballo);
    if (caballoLabel != null) {
        caballoLabel.setLocation(posicion, caballoLabel.getY()); // Mueve la imagen horizontalmente
        caballoLabel.repaint();
    }
}


    public void mostrarGanador(String mensaje) {
        info.setText(info.getText()+"\n"+mensaje);
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
    
    class FondoPanel extends JPanel {

        private Image imagen;

        @Override

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

    }
class FondoPanel2 extends JPanel {

        private Image imagen;

        @Override

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/pista.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCaballo;
    private javax.swing.JButton btnIniciarCarrera;
    private javax.swing.JButton btnInterrumpir;
    private javax.swing.JButton btnSalir;
    public javax.swing.JTextPane info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
