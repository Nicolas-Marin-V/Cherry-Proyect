/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Diccionario;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.seitasks.encuesta.RespuestaEncuesta;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Nicolas Marin
 */
public class Diccionario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Diccionario.class.getName());
    
    //Variables---------!
    
    int p=31;
    int m=997;
    int assix;
            

    /**
     * Creates new form Diccionario
     */
    public Diccionario() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private int hashing(String texto){
            int longitud = texto.length();
            Integer hash_value = 0;
            for(int i = 0; i < longitud;i++){
                assix = texto.charAt(i);
                int power = (int)(Math.pow(p, i));
                hash_value = (hash_value + (assix * power));
    }
            return hash_value % m;
    }
    
        public static void guardarEntrada(int hash, String titulo, String definicion) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("Diccionario.csv", true));
            String[] fila = new String[3];
            fila[0] = String.valueOf(hash);
            fila[1] = String.valueOf(titulo);
            fila[2] = String.valueOf(definicion);
            csvWriter.writeNext(fila);
            csvWriter.close();

            System.out.println("Datos escritos correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
        
        public static List<Entrada> leer() {
        List<Entrada> resultados = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("Diccionario.csv"))) {
            String[] fila;
            reader.readNext();
            while ((fila = reader.readNext()) != null && fila.length == 3) {
                int hash = Integer.parseInt(fila[0]);
                String titulo = fila[1];
                String definicion = fila[2];


                resultados.add(new Entrada(hash, titulo, definicion));
            }
        } catch (Exception e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return resultados;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogNuevo = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        LabelDefinicion = new javax.swing.JLabel();
        TextTitulo = new javax.swing.JTextField();
        TextDefinicion = new javax.swing.JTextField();
        ButtonGuardar = new javax.swing.JButton();
        DialogValor = new javax.swing.JDialog();
        LabelTituloDic = new javax.swing.JLabel();
        LabelDefinicionDic = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaTitulo = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaDefinicion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        ButtonVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListCatalogo = new javax.swing.JList<>();
        BotonBuscar = new javax.swing.JToggleButton();
        LabelBuscar = new javax.swing.JLabel();
        ButtonNuevo = new javax.swing.JButton();
        TextBoxBuscar = new javax.swing.JTextField();

        jPanel3.setBackground(new java.awt.Color(255, 251, 222));
        jPanel3.setForeground(new java.awt.Color(255, 251, 222));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        LabelTitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        LabelTitulo.setText("Titulo");

        LabelDefinicion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        LabelDefinicion.setText("Definición");

        ButtonGuardar.setText("Guardar");
        ButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogNuevoLayout = new javax.swing.GroupLayout(dialogNuevo.getContentPane());
        dialogNuevo.getContentPane().setLayout(dialogNuevoLayout);
        dialogNuevoLayout.setHorizontalGroup(
            dialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogNuevoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonGuardar)
                    .addComponent(LabelDefinicion)
                    .addComponent(TextDefinicion, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTitulo)
                    .addComponent(TextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogNuevoLayout.setVerticalGroup(
            dialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogNuevoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(LabelDefinicion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextDefinicion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dialogNuevoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        LabelTituloDic.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        LabelTituloDic.setText("Titulo");

        LabelDefinicionDic.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        LabelDefinicionDic.setText("Definición");

        TextAreaTitulo.setEditable(false);
        TextAreaTitulo.setColumns(20);
        TextAreaTitulo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        TextAreaTitulo.setRows(5);
        jScrollPane2.setViewportView(TextAreaTitulo);

        TextAreaDefinicion.setEditable(false);
        TextAreaDefinicion.setColumns(20);
        TextAreaDefinicion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        TextAreaDefinicion.setRows(5);
        jScrollPane3.setViewportView(TextAreaDefinicion);

        jPanel2.setBackground(new java.awt.Color(70, 165, 183));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ButtonVolver.setText("Volver");
        ButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DialogValorLayout = new javax.swing.GroupLayout(DialogValor.getContentPane());
        DialogValor.getContentPane().setLayout(DialogValorLayout);
        DialogValorLayout.setHorizontalGroup(
            DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogValorLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogValorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogValorLayout.createSequentialGroup()
                                .addComponent(LabelTituloDic, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogValorLayout.createSequentialGroup()
                                .addComponent(LabelDefinicionDic, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))))
                    .addGroup(DialogValorLayout.createSequentialGroup()
                        .addGroup(DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DialogValorLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(DialogValorLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(ButtonVolver)))
                        .addContainerGap(49, Short.MAX_VALUE))))
        );
        DialogValorLayout.setVerticalGroup(
            DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogValorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LabelTituloDic)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(LabelDefinicionDic)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonVolver)
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(70, 130, 169));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 580));

        ListCatalogo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(ListCatalogo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 260, 330));

        BotonBuscar.setText("Buscar");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        LabelBuscar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        LabelBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelBuscar.setText("Buscar concepto");
        getContentPane().add(LabelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 240, -1));

        ButtonNuevo.setText("Nuevo concepto");
        ButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 140, -1));

        TextBoxBuscar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBoxBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(TextBoxBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 210, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBoxBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextBoxBuscarActionPerformed

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        String textohash = TextBoxBuscar.getText();
        int textoABuscar = hashing(textohash);
        List<Entrada> listaaux = leer();
        int tamaño = listaaux.size();
        
        for(int i = 0; i<tamaño; i++){
            if(listaaux.get(i).getHash() == textoABuscar){
                String consultaTitulo = listaaux.get(i).getTitulo();
                String consultaDefinicion = listaaux.get(i).getDefinición();
                TextAreaTitulo.setText(consultaTitulo);
                TextAreaDefinicion.setText(consultaDefinicion);
                DialogValor.pack();
                DialogValor.setLocationRelativeTo(this);
                DialogValor.setVisible(true);            
        }
        }
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void ButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNuevoActionPerformed
        dialogNuevo.pack();
        dialogNuevo.setLocationRelativeTo(this);
        dialogNuevo.setVisible(true);
    }//GEN-LAST:event_ButtonNuevoActionPerformed

    private void ButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarActionPerformed
        String textoaux = TextTitulo.getText();
        String definicion = TextDefinicion.getText();
        int aux = hashing(textoaux);
        guardarEntrada(aux, textoaux, definicion);
        dialogNuevo.dispose();
    }//GEN-LAST:event_ButtonGuardarActionPerformed

    private void ButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVolverActionPerformed
        DialogValor.dispose();
    }//GEN-LAST:event_ButtonVolverActionPerformed


    public static void main() {
        java.awt.EventQueue.invokeLater(() -> new Diccionario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonBuscar;
    private javax.swing.JButton ButtonGuardar;
    private javax.swing.JButton ButtonNuevo;
    private javax.swing.JButton ButtonVolver;
    private javax.swing.JDialog DialogValor;
    private javax.swing.JLabel LabelBuscar;
    private javax.swing.JLabel LabelDefinicion;
    private javax.swing.JLabel LabelDefinicionDic;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTituloDic;
    private javax.swing.JList<String> ListCatalogo;
    private javax.swing.JTextArea TextAreaDefinicion;
    private javax.swing.JTextArea TextAreaTitulo;
    private javax.swing.JTextField TextBoxBuscar;
    private javax.swing.JTextField TextDefinicion;
    private javax.swing.JTextField TextTitulo;
    private javax.swing.JDialog dialogNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}

