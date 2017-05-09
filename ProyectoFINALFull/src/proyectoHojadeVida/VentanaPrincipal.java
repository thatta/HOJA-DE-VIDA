/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoHojadeVida;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @Juan David Ojeda Bernal
 * @Tatiana Almansa
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    private DialogoVista dialogoV;
    private AgregarPersona panel1;
    private PanelRegistrese panelInicial;
    private PanelPersonas panel3;
    private JMenuBar menuBar;
    private JMenu MFile;
    private JMenu MEdit;
    private JMenuItem MirarTabla;
    private JMenuItem Registrese;
    private JMenuItem MNewFile;
    private JMenuItem Salir;
    private JMenuItem Informacion;
    private JMenuItem ayuda;
    private JPanel jpanel;
    private PanelAgregarFoto panFot;
   
    
    
    
    private static final String PERSONAS_REGISTRADAS = "PERSONAS REGISTRADAS";
     private static final String PANELINICIAL = "REGISTRESE";
    private static final String CREADORES_PROGRAMA = "CREADORES";
    private static final String AYUDA = "AYUDA";
    private static final String EXIT = "EXIT";
    
        
    public VentanaPrincipal() {
        setSize(1100, 485);
        Date fecha = new Date( );
        setTitle("REGISTRO DE PERSONAS  [Hoja de Vida]                                                                                                                                                                          "  + "FECHA:  " + fecha.toString());
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        panelInicial = new PanelRegistrese (this);
        panelInicial.setBounds(0, 0, 1100, 485);
        panelInicial.setBackground(Color.BLACK);
        add(panelInicial);
        
        panFot = new PanelAgregarFoto(this);
        panFot.setBounds(10, 4, 1075, 166);
        panFot.setBackground(Color.BLACK);
        panFot.setVisible(false);
        add(panFot, BorderLayout.SOUTH);
        
        panel1 = new AgregarPersona(this);
        panel1.setBounds(10, 175, 1075, 215);
        panel1.setVisible(false);
        add(panel1);
        
        panel3 = new PanelPersonas(this);
        panel3.setBounds(10, 392, 1075, 33);
        panel3.setVisible(false);
        add(panel3);
        
    
        menuBar = new JMenuBar();    
        setJMenuBar(menuBar);
        menuBar.setBackground( Color.BLACK );
        
        
        MFile = new JMenu("REGISTROS");
        MFile.setForeground(Color.WHITE);
        
        Registrese = new JMenuItem("REGISTRESE AQUí");
        Registrese.setActionCommand(PANELINICIAL);
        Registrese.setBorder( new LineBorder( Color.black ) );
        Registrese.setBackground( Color.LIGHT_GRAY );
        Registrese.setForeground(Color.black);
        Registrese.addActionListener(this);
        
        MirarTabla = new JMenuItem("ASPIRANTES REGISTRADOS");
        MirarTabla.setActionCommand(PERSONAS_REGISTRADAS);
        MirarTabla.setBorder( new LineBorder( Color.black ) );
        MirarTabla.setBackground( Color.LIGHT_GRAY );
        MirarTabla.setForeground(Color.black);
        MirarTabla.addActionListener(this);
        dialogoV = new DialogoVista (this);
        Salir = new JMenuItem("SALIR");
        Salir.setActionCommand(EXIT);
        Salir.setBorder( new LineBorder( Color.black ) );
        Salir.setBackground( Color.LIGHT_GRAY );
        Salir.setForeground(Color.black);
        Salir.addActionListener(this);
        MFile.add(Registrese);
        MFile.add(MirarTabla);
        MFile.add(Salir);
        menuBar.add(MFile);
        
        MEdit = new JMenu("INFORMACION");
        MEdit.setForeground(Color.WHITE);
        
        Informacion = new JMenuItem("INFORMACION");
        Informacion.setActionCommand(CREADORES_PROGRAMA);
        Informacion.setBorder( new LineBorder( Color.BLACK) );
        Informacion.setBackground( Color.LIGHT_GRAY );
        Informacion.setForeground(Color.black);
        Informacion.addActionListener(this);
        ayuda = new JMenuItem("AYUDA");
        ayuda.setActionCommand(AYUDA);
        ayuda.setBorder( new LineBorder( Color.BLACK) );
        ayuda.setBackground( Color.LIGHT_GRAY );
        ayuda.setForeground(Color.black);
        ayuda.addActionListener(this);
        
        MEdit.add(Informacion);
        MEdit.add(ayuda);
        menuBar.add(MEdit);
        
        
        
        
        setVisible(true);
        
    }

    public AgregarPersona getPanel1() {
        return panel1;
    }

   

    public PanelAgregarFoto getPanFot() {
        return panFot;
    }
    
    File fichero;
    public void MetodoAgregarImagen(AgregarPersona Panel1){
       
        int resultado;
        CargarFoto ventana = new CargarFoto ();
        
        FileNameExtensionFilter filtro = new  FileNameExtensionFilter("JPG & PNG", "jpg","png");
        ventana.jFileCargarFoto.setFileFilter(filtro);
     
        resultado = ventana.jFileCargarFoto.showOpenDialog(null);
        
        if(JFileChooser.APPROVE_OPTION == resultado){
            
            
            fichero= ventana.jFileCargarFoto.getSelectedFile();
               
            
            try{
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(panel1.getEtiquetaImagen().getWidth(),panel1.getEtiquetaImagen().getHeight(), Image.SCALE_DEFAULT));
                panel1.getEtiquetaImagen().setText(null);
                panel1.getEtiquetaImagen().setIcon(icono);
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "error"+ ex);
                
                
            }
        }
        
    }
    
    
    public void MetodoCalcularEdad(AgregarPersona Panel1){
     
        int año_actual,año_nacimiento, edad;
        
        
        año_actual = Integer.parseInt(JOptionPane.showInputDialog("ingrese el Año Actual"));
        año_nacimiento = Integer.parseInt(JOptionPane.showInputDialog("ingrese el Año de Nacimiento"));
        edad = año_actual - año_nacimiento;
        JOptionPane.showMessageDialog(null,"[Su edad para este año es :::["+edad+"]::: Su edad será agregada al campo de texto en el panel, Deslice la siguiente ventana sin cerrarla para verificar]");
        panel1.JTEdad.setText(String.valueOf(edad));
        panel1.JTEdad.setVisible(true);
        
    }
    

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(PANELINICIAL)){
              panel1.setVisible(true);
              panFot.setVisible(true);
              panel3.setVisible(true);
              panelInicial.setVisible(false);
              
    }else if(e.getActionCommand().equals(PERSONAS_REGISTRADAS)) {
            dialogoV.actualizarTabla();
            dialogoV.setVisible(true);
        }else if(e.getActionCommand().equals(CREADORES_PROGRAMA)) {
               JOptionPane.showMessageDialog(this, "AUTORES: \n Juan David Ojeda Bernal \n Karen Tatiana Almansa Jimenez");
               }else if(e.getActionCommand().equals(AYUDA)) {
               JOptionPane.showMessageDialog(this, "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::MODO DE USO::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::  \n 1.Al ingresar el Email se verificará si es un correo autentico. \n 2.Si es verdadero, la etiqueta correo cambiará a color verde. \n 3. si es falso, la etiqueta correo se podra de color rojo y pedira que ingrese de nuevo el correo. \n 4.si el correo es correcto, la información se guardará en un listado que se encuentra en la barra de menú en la opcion Registros/REGISTRO CORREOS. \n 5.Al igual que el correo, en el panel Registro Personas se debe agregar nombre y seleccionar genero. \n 6.Si la anterior condicion no se cumple, la etiqueta nombre se pondrá en rojo como prueba de que el nombre no ha sido ingresado. \n 7.Si el nombre que ingresó y el genero seleccionado son validos, la etiqueta nombre se pondrá de color verde. \n 8.al darle guardar la informacion quedará guardada en una lista en barra de menú Registros/REGISTRO PERSONAS. \n 9.Si aparece la información y desea salir, oprime EXIT en la barra de menú. \n 10.los autores del programa se pueden encontrar en la barra de menú Informacion/INFORMACION. \n ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: GRACIAS POR USAR NUESTROS SERVICIOS:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::   ");
               
            }else if(e.getActionCommand().equals(EXIT)) {
            System.exit(0);
            }
        
        }
    }
      


