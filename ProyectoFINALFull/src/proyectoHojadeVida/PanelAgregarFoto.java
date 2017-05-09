/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoHojadeVida;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
* @Juan David Ojeda Bernal
 * @Tatiana Almansa
 */
public class PanelAgregarFoto extends JPanel {
    
    private JLabel Imagen;
    private JLabel imagenPrincipal;
    private VentanaPrincipal ventana;
    
    public PanelAgregarFoto(VentanaPrincipal ventana){
        this.ventana= ventana;
        
        FlowLayout layout = new FlowLayout( );
        layout.setHgap( 5 );
        layout.setVgap( -20 );
        setLayout( layout );
        
        ImageIcon icono = new ImageIcon( "src/ImagenPrincipal/yes.jpeg" );
        
        
        imagenPrincipal = new JLabel("REGISTRO  "  );
        imagenPrincipal.setForeground(Color.LIGHT_GRAY);
        imagenPrincipal.setIcon( icono );
        imagenPrincipal.setBounds(12, 12, 1060, 140);
        add( imagenPrincipal );
        
        setBackground( Color.black );
        setBorder( new LineBorder( Color.ORANGE ) );
    }
    
    
}

