package ejer4bol8;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Clase del formulario que pide datos
 * @author Alejandro Fernández Martínez
 */
public class FormDatosUsuario extends JDialog {

    /**
     * Label de información
     */
    JLabel lblInfo;
    /**
     * Campo donde se introduce el nombre
     */
    JTextField txfCampoNombre;
    /**
     * Botones de aceptar, y cancelar
     */
    JButton btnAceptar, btnCancelar;
    
    /**
     * Inicializa el formulario que pide datos
     * @param f Es el formulario principal
     */
    public FormDatosUsuario(FormEjer4 f) {
        super(f);
        setLayout(null);
        this.setTitle("Introduce tu nombre");
        
        lblInfo = new JLabel("Introduce tu nombre:");
        lblInfo.setSize(150, 20);
        lblInfo.setLocation(10, 10);
        add(lblInfo);
        
        txfCampoNombre = new JTextField();
        txfCampoNombre.setSize(120, 20);
        txfCampoNombre.setLocation(170, 10);
        add(txfCampoNombre);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setSize(100, 20);
        btnAceptar.setLocation(10, 40);
        btnAceptar.addActionListener(f);
        add(btnAceptar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setSize(100, 20);
        btnCancelar.setLocation(240, 40);
        btnCancelar.addActionListener(f);
        add(btnCancelar);
    }
}
