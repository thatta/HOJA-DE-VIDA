/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoHojadeVida;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
*@Juan David Ojeda Bernal
*@Tatiana Almansa
 */
public class PanelPersonas extends JPanel implements ActionListener{
  
    JButton BVista;
    private DialogoVista dialog;
    private VentanaPrincipal ventana;
    
    
    public PanelPersonas(VentanaPrincipal ventana) {
         this.ventana = ventana;
         setBorder(BorderFactory.createTitledBorder("REGISTRO"));
         setLayout(null);
         
         BVista = new JButton("Ver Personas");
         BVista.setFont(new Font("Serif", Font.BOLD, 18));
         BVista.addActionListener(this);
         BVista.setBounds(440, 7, 150, 20);
         BVista.setBackground( Color.LIGHT_GRAY );
         BVista.setForeground(Color.black);
         add(BVista);
         
       
        setBackground( Color.black );
         setBorder( new LineBorder( Color.ORANGE ) );
         
         dialog = new DialogoVista(this.ventana);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.actualizarTabla();
        dialog.setVisible(true);
        
    }
    
    
    
}
