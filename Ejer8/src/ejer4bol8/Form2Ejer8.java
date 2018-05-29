/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author alex
 */
public class Form2Ejer8 extends JDialog {

    JLabel lblNumeros[] = new JLabel[6];
    int sorteo[] = new int[6];
    int acu = 0;
    int ancho = 20;

    public Form2Ejer8(FormEjer8 f) {
        super(f, true);
        setLayout(null);

        sorteo = f.aleatorios();

        for (int i = 0; i < f.chkCajas.length; i++) {
            for (int j = 0; j < f.chkCajas[0].length; j++) {
                if (f.chkCajas[i][j].isSelected()) {
                    lblNumeros[acu] = new JLabel(f.chkCajas[i][j].getText());
                    lblNumeros[acu].setSize(20, 20);
                    lblNumeros[acu].setLocation(ancho, 20);
                    add(lblNumeros[acu]);
                    for (int numero: sorteo) {
                        System.out.println(numero);
                        if (numero == Integer.parseInt(f.chkCajas[i][j].getText())) {
                            lblNumeros[acu].setForeground(Color.green);
                        } else {
                            lblNumeros[acu].setForeground(Color.red);
                        }
                    }
                    System.out.println("--");
                    ancho = ancho + 40;
                    acu++;
                }
            }
        }
    }
}
