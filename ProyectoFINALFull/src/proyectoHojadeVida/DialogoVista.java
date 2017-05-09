/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoHojadeVida;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @Juan David Ojeda Bernal
 * @Tatiana Almansa
 */
public class DialogoVista extends JDialog implements ActionListener{
    private static final String GUARDAR = "GUARDAR";
    JPanel panel;
    JTable tablaArtista;
    JButton Guardar;
    private DefaultTableModel dtm;
    private VentanaPrincipal ventana;
    public DialogoVista(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setSize(1368, 300);
        setTitle("PERSONAS REGISTRADAS");
      
       
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        Date fecha = new Date( );
        panel.setBorder(BorderFactory.createTitledBorder("[FECHA] " + fecha.toString( )));
        add(panel);
        
        
        Guardar = new JButton("GUARDAR");
        Guardar.setActionCommand(GUARDAR);
        Guardar.addActionListener(this);
        add(Guardar, BorderLayout.PAGE_END);
        
        dtm = new DefaultTableModel();
        tablaArtista = new JTable(dtm);
        
        Object[] columna = {"Imagen","Nombre", "Apellido","Edad","Profesion","Documento","Est. Civil","Genero","Correo","Telefono","Direccion"};
        for (Object columna1 : columna) {
            dtm.addColumn(columna1);
        }        
        
        
        JScrollPane scrollPane = new JScrollPane(tablaArtista);
        scrollPane.setBounds(5, 30, 1340, 50);
        panel.add(scrollPane);
    }
    
    public void actualizarTabla() {
         DefaultTableModel tipo = (DefaultTableModel) tablaArtista.getModel();
         int filas = tablaArtista.getRowCount();
         for (int i =0; filas>i; i++){
             tipo.removeRow(0);
         }
        
         List<Persona> lista = this.ventana.getPanel1().getListaArtista();
         for (Persona aspirante : lista) {
             Object[] fila = {aspirante.getImagen().toString(),aspirante.getNombre().toString(), aspirante.getApellido().toString(), aspirante.getEdad() ,aspirante.getProfesion().toString(), aspirante.getDocumento().toString(),aspirante.getEstado().toString() ,aspirante.getGenero().toString(), aspirante.getCorreo().toString(), aspirante.getTelefono().toString(), aspirante.getDireccion().toString()};
             dtm.addRow(fila);
        }
    }
    private void guardaTabla(){
        try {

            String sucursalesCSVFile = "src/Listas/DatosTabla.txt";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(sucursalesCSVFile ));
           ;
            
            for (int i = 0 ; i < tablaArtista.getRowCount(); i++) //realiza un barrido por filas.
            {
                for(int j = 0 ; j < tablaArtista.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    bfw.write((String)(tablaArtista.getValueAt(i,j)));
                    if (j < tablaArtista.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        bfw.write(",");
                    }
                }
                bfw.newLine(); //inserta nueva linea.
            }

            bfw.close(); //cierra archivo!
            JOptionPane.showMessageDialog(null,"EL ARCHIVO SE HA GUARDADO SATISFACTORIAMENTE EN LA DIRECCION [src/Listas/DatosTabla] DE ESTE PROYECTO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"ERROR: OCURRIO UN PROBLEMA AL SALVAR EL ARCHIVO, VUELVA A CREAR SU ARCHIVO!" + e.getMessage());
        }
    }
    
     @Override
            public void actionPerformed (final ActionEvent d) {
                     if(d.getActionCommand().equals(GUARDAR)){
                     guardaTabla();

                     }
            }
}
