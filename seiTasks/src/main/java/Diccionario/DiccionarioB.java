/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Diccionario;

import Diccionario.Entrada;
import ListaDeTareas.Tarea;
import ListaDeTareas.TareaManager;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.Color;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Nicolas Marin
 */
public class DiccionarioB extends javax.swing.JPanel {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Diccionario.class.getName());
    
    //Variables---------!
    
    int p=31;
    int m=997;
    int assix;
            

    /**
     * Creates new form Diccionario
     */
    public DiccionarioB(){
        initComponents();
        cargarLista();  
    }
    
private void cargarLista() {
    List<Entrada> auxentrada = leer();  // Asumiendo que este método te da una lista de entradas

    DefaultListModel<String> modeloLista = new DefaultListModel<>();

    for (Entrada entrada : auxentrada) {
        modeloLista.addElement(entrada.getTitulo());  // Asumiendo que quieres mostrar solo el título
    }

    ListCatalogo.setModel(modeloLista);  // Establece el modelo correcto
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
       
   private void eliminarYReescribir(String tituloEliminar) {
    try {
        int hashEliminar = hashing(tituloEliminar.toLowerCase());
        List<Entrada> entradas = leer();

        try (PrintWriter writer = new PrintWriter(new FileWriter("diccionario.csv", false))) {
            writer.println("Hash,Titulo,Definicion");

            for (Entrada e : entradas) {
                if (e.getHash() != hashEliminar) {
                    writer.println(e.getHash() + "," + e.getTitulo() + "," + e.getDefinición());
                }
            }
        }

        cargarLista(); 
        JOptionPane.showMessageDialog(this, "Entrada eliminada correctamente.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}


        
    void buscar(String cadena){
            
            try {
    String auxhash = cadena;
    String textohash = auxhash.toLowerCase();
    int textoABuscar = hashing(textohash);
    List<Entrada> listaaux = leer();
    int tamaño = listaaux.size();

    boolean encontrado = false;

    for(int i = 0; i < tamaño; i++) {
        if(listaaux.get(i).getHash() == textoABuscar){
            String consultaTitulo = listaaux.get(i).getTitulo();
            String consultaDefinicion = listaaux.get(i).getDefinición();
            TextAreaTitulo.setText(consultaTitulo);
            TextAreaDefinicion.setText(consultaDefinicion);
            DialogValor.pack();
            DialogValor.setLocationRelativeTo(this);
            DialogValor.setVisible(true);
            encontrado = true;
            break;
        }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "La entrada no fue encontrada en el diccionario.",
                                              "No encontrado", JOptionPane.INFORMATION_MESSAGE);
            }

            } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error en la búsqueda: " + e.getMessage(),
                                          "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }
    
       void verificarExistencia(String textoTitulo,String textoDefinicion){
      try {
        String auxhash = textoTitulo;
        String textohash = auxhash.toLowerCase();
        int textoABuscar = hashing(textohash);
        List<Entrada> listaaux = leer();
        int tamaño = listaaux.size();

        boolean encontrado = false;

        for(int i = 0; i < tamaño; i++) {
            if(listaaux.get(i).getHash() == textoABuscar){
                JOptionPane.showMessageDialog(this, "Ya existe una entrada con ese titulo, borrela o ponga un nuevo titulo",
                "Error", JOptionPane.INFORMATION_MESSAGE);
                encontrado = true;
                break;
            }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(this, "La entrada fue registrada exitozamente",
                                                  "Exito", JOptionPane.INFORMATION_MESSAGE);
                    guardarEntrada(textoABuscar, textohash, textoDefinicion);
                }

                } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error en la búsqueda: " + e.getMessage(),
                                              "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }
        
       

    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogNuevo = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
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
        ButtonEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListCatalogo = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        BotonBuscar = new javax.swing.JToggleButton();
        LabelBuscar = new javax.swing.JLabel();
        ButtonNuevo = new javax.swing.JButton();
        TextBoxBuscar = new javax.swing.JTextField();

        jPanel5.setBackground(new java.awt.Color(255, 251, 222));
        jPanel5.setForeground(new java.awt.Color(255, 251, 222));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(dialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonGuardar)
                    .addComponent(LabelDefinicion)
                    .addComponent(TextDefinicion, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTitulo)
                    .addComponent(TextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        dialogNuevoLayout.setVerticalGroup(
            dialogNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogNuevoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(LabelDefinicion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextDefinicion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonGuardar)
                .addContainerGap(95, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        ButtonEliminar.setText("Eliminar");
        ButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEliminarActionPerformed(evt);
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
                        .addGap(38, 38, 38)
                        .addGroup(DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DialogValorLayout.createSequentialGroup()
                                .addComponent(ButtonVolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonEliminar)))
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
                .addGroup(DialogValorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonVolver)
                    .addComponent(ButtonEliminar))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(248, 244, 239));
        setMinimumSize(new java.awt.Dimension(1010, 720));
        setPreferredSize(new java.awt.Dimension(1010, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListCatalogo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        ListCatalogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ListCatalogo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListCatalogoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListCatalogo);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 490, 640));

        jPanel1.setBackground(new java.awt.Color(237, 224, 212));

        BotonBuscar.setText("Buscar");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        LabelBuscar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        LabelBuscar.setForeground(new java.awt.Color(62, 39, 35));
        LabelBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelBuscar.setText("Buscar concepto");

        ButtonNuevo.setText("Nuevo concepto");
        ButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNuevoActionPerformed(evt);
            }
        });

        TextBoxBuscar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TextBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBoxBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonBuscar)
                            .addComponent(ButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(LabelBuscar)
                .addGap(18, 18, 18)
                .addComponent(TextBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BotonBuscar)
                .addGap(7, 7, 7)
                .addComponent(ButtonNuevo)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 720));

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
       String texto = TextBoxBuscar.getText();
       buscar(texto);
        
        
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void ButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNuevoActionPerformed
        TextTitulo.setText("");
        TextDefinicion.setText("");
        dialogNuevo.pack();
        dialogNuevo.setLocationRelativeTo(this);
        dialogNuevo.setVisible(true);
    }//GEN-LAST:event_ButtonNuevoActionPerformed

    private void TextBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBoxBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextBoxBuscarActionPerformed

    private void ButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonGuardarActionPerformed
        
        
        String textoaux = TextTitulo.getText();
        String definicion = TextDefinicion.getText();
        verificarExistencia(textoaux,definicion);
        cargarLista();
        dialogNuevo.dispose();
    }//GEN-LAST:event_ButtonGuardarActionPerformed

    private void ButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVolverActionPerformed
        DialogValor.dispose();
    }//GEN-LAST:event_ButtonVolverActionPerformed

    private void ListCatalogoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListCatalogoValueChanged
            if (!evt.getValueIsAdjusting()) {
            String tituloSeleccionado = ListCatalogo.getSelectedValue();
            if (tituloSeleccionado != null) {
                buscar(tituloSeleccionado);
            }
        }
    
    }//GEN-LAST:event_ListCatalogoValueChanged

    private void ButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEliminarActionPerformed
        int res = JOptionPane.showOptionDialog(new JFrame(), "¿Quieres eliminar la entrada?","Elimnar",
         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
         new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);
        switch (res) {
            case JOptionPane.YES_OPTION -> {
                String tituloSeleccionado = ListCatalogo.getSelectedValue();
                eliminarYReescribir(tituloSeleccionado);
                DialogValor.dispose();
            }
            case JOptionPane.NO_OPTION -> {
            }
            case JOptionPane.CLOSED_OPTION -> {
            }
            default -> {
            }
        }
    }//GEN-LAST:event_ButtonEliminarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonBuscar;
    private javax.swing.JButton ButtonEliminar;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
