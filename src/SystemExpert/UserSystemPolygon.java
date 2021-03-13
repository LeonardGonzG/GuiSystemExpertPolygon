package SystemExpert;

import SystemExpert.base.fact.IFact;
import SystemExpert.base.rule.Rule;
import SystemExpert.system.HumanInterface;
import SystemExpert.system.Motor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leogonz.gut
 */
public class UserSystemPolygon extends javax.swing.JFrame implements HumanInterface {

    Motor motor;
    DefaultTableModel modelo;

    public UserSystemPolygon() {
        initComponents();
        this.setLocationRelativeTo(null);

        modelo = (DefaultTableModel) respTable.getModel();

        int filas = modelo.getRowCount();

        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
        // Creación del motor
        this.motor = new Motor(this);
    }

    protected void loadDataMotro(String lineDataFile) {

        this.motor.addRule(lineDataFile);

    }

    protected String cargarNombreArchivo() {

        String ruta = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpg", "gif", "txt");
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                this.fileName.setText("...");
            } else {
                this.fileName.setText(fileName.getAbsolutePath());
                ruta = fileName.getAbsolutePath().trim();
            }
        }

        return ruta;
    }

    protected void muestraContenido(String archivo) throws FileNotFoundException, IOException {

        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);

        //   int linesCount = (int) b.lines().count();
        int max = 100;

        this.jProgressBar1.setMinimum(0);
        this.jProgressBar1.setMaximum(max);
        this.jProgressBar1.setStringPainted(true);

        int cont = 0;

        while ((cadena = b.readLine()) != null) {
            jProgressBar1.setValue(cont);
            cont++;

            //Alimentar motor de inferencia
            // System.out.println(cadena);
            motor.addRule(cadena.trim());

        }

        jProgressBar1.setValue((max - cont) + cont);
        this.fileUpload.setText("Completado!");
        this.numreglas.setText("" + cont);

        //Poner en funcionamiento el motor
        motor.solve();

        b.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fileName = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        fileUpload = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        numreglas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        numresp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        respTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        informe = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUI Sistema Experto");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema experto - poligonos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 50));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 100, 490));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemExpert/ImgGUI/upload.png"))); // NOI18N
        jButton1.setText("Cargar archivo");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 65, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Motor de inferencia");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, -1, -1));

        fileName.setEditable(false);
        fileName.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(fileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 230, -1));

        jProgressBar1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 10));

        fileUpload.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jPanel3.add(fileUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 50, 10));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 250, 100));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        numreglas.setFont(new java.awt.Font("Calibri", 0, 70)); // NOI18N
        numreglas.setText("@");
        jPanel4.add(numreglas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 90, 60));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Nº de reglas");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numresp.setFont(new java.awt.Font("Calibri", 0, 70)); // NOI18N
        numresp.setForeground(new java.awt.Color(0, 102, 0));
        numresp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numresp.setText("¿?");
        jPanel5.add(numresp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, 60));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Nº de posibles respuestas ");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 103, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("encontradas");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 210, 170));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 208, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 250, 300));

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        respTable.setBackground(new java.awt.Color(204, 255, 255));
        respTable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        respTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Triangulo", null},
                {"", null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo de poligonos", "Imagen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        respTable.setGridColor(new java.awt.Color(0, 51, 51));
        respTable.setSelectionBackground(new java.awt.Color(0, 204, 204));
        respTable.setSelectionForeground(new java.awt.Color(0, 51, 51));
        respTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(respTable);
        if (respTable.getColumnModel().getColumnCount() > 0) {
            respTable.getColumnModel().getColumn(0).setResizable(false);
            respTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 430, 400));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Respuestas...");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 210, -1));

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemExpert/ImgGUI/refresh.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemExpert/ImgGUI/power.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, -1, -1));

        informe.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        informe.setForeground(new java.awt.Color(0, 102, 102));
        informe.setText("Informe de motor");
        jPanel1.add(informe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 154, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemExpert/ImgGUI/geometry-cube.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 70, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        String rutaArchivo = cargarNombreArchivo();

        if (rutaArchivo != null) {

            System.out.println("oee");
            try {
                muestraContenido(rutaArchivo);
            } catch (IOException ex) {
                System.out.println("Error en la carga del archivo");
                this.fileUpload.setText("Falla en la carga!");

            }
        } else {
            System.out.println("No existe la ruta");
        }


    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        int filas = modelo.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
        
        this.numresp.setText("¿?");

    //Poner en funcionamiento el motor
        motor.solve();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(UserSystemPolygon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSystemPolygon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSystemPolygon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSystemPolygon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSystemPolygon().setVisible(true);
            }
        });
    }

    @Override
    public int askIntValue(String question) {
        int edad = 0;

        try {
            edad = Integer.parseInt(JOptionPane.showInputDialog(question));
        } catch (NumberFormatException e) {
            return edad;
        }

        return edad;
    }

    @Override
    public boolean askBoolValue(String question) {
        String resp;
        try {
            resp = JOptionPane.showInputDialog(question + " (si, no)");
            return (resp.equals("si"));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void printFacts(List<IFact> facts) {

        String res = "";

        Collections.sort(facts, (IFact f1, IFact f2) -> {
            return Integer.compare(f2.getLevel(), f1.getLevel());
        });

        String data = "";
        int cantResp = 0;

        for (IFact f : facts) {
            if (f.getLevel() != 0) {
                res += f.toString() + "\n";

                data = f.toString();
                modelo.addRow(new Object[]{data, " "});
                cantResp++;
            }
        }

        numresp.setText("" + cantResp);

       // System.out.println(res);

    }

    @Override
    public void printRules(List<Rule> paramList) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileName;
    private javax.swing.JLabel fileUpload;
    private javax.swing.JLabel informe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel numreglas;
    private javax.swing.JLabel numresp;
    private javax.swing.JTable respTable;
    // End of variables declaration//GEN-END:variables
}
