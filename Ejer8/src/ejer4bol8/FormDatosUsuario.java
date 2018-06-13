/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Alex
 */
public class FormDatosUsuario extends JDialog {

    JLabel lblInfo;
    JTextField campoNombre;
    JButton aceptar, cancelar;
    
    public FormDatosUsuario(FormEjer4 f) {
        super(f);
        setLayout(null);
        this.setTitle("Introduce tu nombre");
        
        lblInfo = new JLabel("Introduce tu nombre:");
        lblInfo.setSize(150, 20);
        lblInfo.setLocation(10, 10);
        add(lblInfo);
        
        campoNombre = new JTextField();
        campoNombre.setSize(120, 20);
        campoNombre.setLocation(170, 10);
        add(campoNombre);
        
        aceptar = new JButton("Aceptar");
        aceptar.setSize(100, 20);
        aceptar.setLocation(10, 40);
        aceptar.addActionListener(f);
        add(aceptar);
        
        cancelar = new JButton("Cancelar");
        cancelar.setSize(100, 20);
        cancelar.setLocation(240, 40);
        cancelar.addActionListener(f);
        add(cancelar);
    }
}
