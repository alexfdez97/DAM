/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class Ejer4Bol8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormEjer8 form = new FormEjer8();

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
