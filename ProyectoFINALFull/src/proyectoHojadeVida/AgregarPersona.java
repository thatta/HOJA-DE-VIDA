/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoHojadeVida;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
* @Juan David Ojeda Bernal
 * @Tatiana Almansa
 */
public class AgregarPersona extends JPanel implements ActionListener{
    
    private static final String AGREGAR = "AgregarImagen";
    private static final String GUARDAR = "GUARDAR";
    private static final String CALCULAR = "CALCULAR";
    
    JLabel LNombre,LProfesion,LIdentificacion,etiquetaImagen,LGenero,LApellido,LEdad, LTelefono,LEstado,LDireccion,LMensaje1,LMensaje2;
    JTextField JTNombre, JTIdentificacion,JTApellido,JTEdad,JTTelefono,JTDireccion;
    JComboBox CMProfesion, CMGenero, CMEstado;
    JButton BGuardar, BCargarFoto;
    private JLabel LCorreo;
    private JTextField JTCorreo;
    
    private List<Persona> listaAspirantes;
    Persona persona;
    private VentanaPrincipal ventana;
            
    public AgregarPersona(VentanaPrincipal ventana) {
        
         this.ventana = ventana;
         setBorder(BorderFactory.createTitledBorder("REGISTRESE"));
         setLayout(null);
         listaAspirantes = new ArrayList<Persona>();
         
         LNombre = new JLabel ("NOMBRE:");
         LProfesion = new JLabel ("PROFESION:");
         LIdentificacion = new JLabel ("CÉDULA:");
         LGenero = new JLabel ("GENERO:");
         LApellido = new JLabel ("APELLIDO:");
         LEdad = new JLabel ("EDAD:");
         LTelefono = new JLabel("TELEFONO:");
         LEstado = new JLabel("EST. CIVIL:");
         LDireccion = new JLabel("DIRECCION:");
         LMensaje1 = new JLabel("[INGRESE CORRECTAMENTE LOS DATOS, DE LO CONTRARIO DEBE CORREGIR EL ERROR");
         LMensaje2 = new JLabel("QUE COMETIO EN SU REGISTRO Y CONTINUAR EL PROCEDIMIENTO A PARTIR DEL BOTON]");
         LMensaje1.setBounds(28, 152, 1069, 20);
         LMensaje1.setForeground(Color.red);
         add(LMensaje1);
         
         LMensaje2.setBounds(24, 167, 1069, 20);
         LMensaje2.setForeground(Color.red);
         add(LMensaje2);
         
         LDireccion.setBounds(560, 130, 100, 20);
         LDireccion.setForeground(Color.WHITE);
         add(LDireccion);
         
         LGenero.setBounds(560, 10, 100, 20);
         LGenero.setForeground(Color.WHITE);
         add(LGenero);
         
         LNombre.setBounds(240, 10, 100, 20);
         LNombre.setForeground(Color.WHITE);
         add(LNombre);
         
         LApellido.setBounds(240, 40, 100, 20);
         LApellido.setForeground(Color.WHITE);
         add(LApellido);
         
         LIdentificacion.setBounds(240, 70, 100, 20);
         LIdentificacion.setForeground(Color.WHITE);
         add(LIdentificacion);
        
         LEstado.setBounds(560, 70, 100, 20);
         LEstado.setForeground(Color.WHITE);
         add(LEstado);
         
         LProfesion.setBounds(560, 40, 100, 20);
         LProfesion.setForeground(Color.WHITE);
         add(LProfesion);
         
         LTelefono.setBounds(560, 100, 100, 20);
         LTelefono.setForeground(Color.WHITE);
         add(LTelefono);
         
         JTTelefono = new JTextField();
         JTTelefono.setBounds(640, 100, 150, 20);
         add(JTTelefono);
        
         JTDireccion = new JTextField();
         JTDireccion.setBounds(640,130, 150,20);
         add(JTDireccion);
         
         LCorreo = new JLabel("CORREO: ");
         LCorreo.setBounds(240, 100, 100, 20);
         LCorreo.setForeground(Color.WHITE);
         add(LCorreo);
         
         LEdad.setBounds(240, 130, 100, 20);
         LEdad.setForeground(Color.WHITE);
         add(LEdad);
         
         JTEdad = new JTextField();
         JTEdad.setBounds(315,130, 150, 20);
         JTEdad.setVisible(false);
         add(JTEdad);
         
         JTCorreo = new JTextField();
         JTCorreo.setBounds(315,100, 150, 20);
         add(JTCorreo);
         
         JTNombre = new JTextField();
         JTNombre.setBounds(315, 10, 150, 20);
         add(JTNombre);
         
         JTIdentificacion = new JTextField();
         JTIdentificacion.setBounds(315, 70, 150, 20);
         add(JTIdentificacion);
         
         JTApellido = new JTextField();
         JTApellido.setBounds(315, 40, 150, 20);
         add(JTApellido);
         
         CMProfesion = new JComboBox(Profesion.values());
         CMProfesion.setBounds(640, 40, 150, 20);
         add(CMProfesion);

         CMEstado = new JComboBox(EstadoCivil.values());
         CMEstado.setBounds(640, 70, 150, 20);
         add(CMEstado);
         
         CMGenero = new JComboBox(Genero.values());
         CMGenero.setBounds(640, 10, 150, 20);
         add(CMGenero);
         
         ImageIcon icono = new ImageIcon( "src/ImagenPrincipal/NF.jpg" );
         etiquetaImagen = new JLabel(icono );
         etiquetaImagen.setBounds(880, 5, 154, 154);
         etiquetaImagen.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );
         add( etiquetaImagen);
        
         
         BCargarFoto = new JButton ("CARGAR IMAGEN                                          /                                                 GUARDAR");
         BCargarFoto.setActionCommand(AGREGAR);
         BCargarFoto.setBounds(3, 189, 1069, 20);
         BCargarFoto.addActionListener(this);
         BCargarFoto.setBackground( Color.LIGHT_GRAY );
         BCargarFoto.setForeground(Color.black);
         add(BCargarFoto);
        
         
         setBackground( Color.black );
         setBorder( new LineBorder( Color.ORANGE ) );
        
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand( );
        
        
       if(AGREGAR.equals(comando)){
            
            ventana.MetodoCalcularEdad(this);
            ventana.MetodoAgregarImagen(this);
           
            
        }
       if(validarDatosPersona() && validarDatosCorreo(JTCorreo.getText())){
            persona = new Persona(JTNombre.getText(), ((Profesion) CMProfesion.getSelectedItem()), etiquetaImagen.getIcon(),JTIdentificacion.getText().toString(), ((Genero)CMGenero.getSelectedItem()), JTCorreo.getText().toString(), JTApellido.getText().toString(), JTEdad.getText(), JTTelefono.getText(), ((EstadoCivil)CMEstado.getSelectedItem()), JTDireccion.getText().toString());
            listaAspirantes.add(persona);
            JOptionPane.showMessageDialog(null, "Datos Enlistados Exitosamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            LNombre.setForeground(Color.ORANGE);
            LProfesion.setForeground(Color.ORANGE);
            LCorreo.setForeground(Color.ORANGE);
            LGenero.setForeground(Color.ORANGE);
            LIdentificacion.setForeground(Color.ORANGE);
            LApellido.setForeground(Color.ORANGE);
            LEdad.setForeground(Color.ORANGE);
            LTelefono.setForeground(Color.ORANGE);
            LEstado.setForeground(Color.ORANGE);
            LDireccion.setForeground(Color.ORANGE);
            vaciarDatos();         
       } 
    }

        public void vaciarDatos() {
        ImageIcon icono = new ImageIcon( "src/ImagenPrincipal/NF.jpg" );
        JTNombre.setText("");
        etiquetaImagen.setIcon(icono);
        CMProfesion.setSelectedIndex(0);
        CMGenero.setSelectedIndex(0);
        CMEstado.setSelectedIndex(0);
        JTIdentificacion.setText("");
        JTCorreo.setText("");
        JTEdad.setVisible(false);
        JTApellido.setText("");
        JTTelefono.setText("");
        JTDireccion.setText("");
        
}
    
    public boolean validarDatosPersona() {
        ImageIcon foto = new ImageIcon( "src/ImagenPrincipal/leriiiito.gif" );
        if(JTNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el Nombre.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombre.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;
        } else if(JTApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el Nombre.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LApellido.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;  
        } else if (JTIdentificacion.getText().length()>=11){
            JOptionPane.showMessageDialog(this, "El documento debe ser de 10 caracteres", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LIdentificacion.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;  
        } else if (JTIdentificacion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar el Documento", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LIdentificacion.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false; 
        } else if(JTCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el Nombre.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LCorreo.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;
        } else if(validarDatosCorreo(JTCorreo.getText()) == false) {
            JOptionPane.showMessageDialog(this, "El correo es invalido.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LCorreo.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;      
        } else if(CMGenero.getSelectedItem() == Genero.SELECCIONE) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un genero.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LGenero.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;
            
        } else if(CMProfesion.getSelectedItem() == Profesion.SELECCIONE) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Profesion.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LProfesion.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;        
        } else if(CMEstado.getSelectedItem() == EstadoCivil.SELECCIONE) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un genero.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LEstado.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;  
        } else if (JTTelefono.getText().length()>=11){
            JOptionPane.showMessageDialog(this, "Su numero telefonico es INVALIDO, vuelva a intentarlo", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LTelefono.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;  
        } else if (JTTelefono.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar su numero telefonico", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LTelefono.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;
            
        } else if (JTDireccion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe ingresar el Documento", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LDireccion.setForeground(Color.red);
            etiquetaImagen.setIcon(foto);
            return false;     
        }
        
        return true;
    }
    
    
      public boolean validarDatosCorreo(String Correo) {
          
          
        Pattern p = null;
        Matcher m = null;
        
        p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        m = p.matcher(Correo);
        
        if(m.find()){
            return true;
        }else {
            return false;
        }
        
    }

     
    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }
    

    public JComboBox getCMGenero() {
        return CMProfesion;
    } 

    public JLabel getLNombre() {
        return LNombre;
    }

    public JTextField getJTNombre() {
        return JTNombre;
    } 
 
    public List<Persona> getListaArtista() {
        return listaAspirantes;
    }
    
}
