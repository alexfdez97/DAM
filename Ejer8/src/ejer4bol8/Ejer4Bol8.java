package ejer4bol8;

import java.awt.*;
import javax.swing.*;

/**
 * La clase Main
 * @author Alejandro Fernández Martínez
 */
public class Ejer4Bol8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormEjer4 form = new FormEjer4();

        Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension resolucionMinima = resolucion;
        int ancho = 385;
        int alto = 440;
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(ancho, alto);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        resolucionMinima.setSize(ancho, alto);
        form.setMinimumSize(resolucionMinima);
    }
    
}
