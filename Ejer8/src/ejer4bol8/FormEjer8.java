/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class FormEjer8 extends JFrame implements ItemListener {

    JCheckBox chkCajas[][] = new JCheckBox[7][7];
    JButton btnJugar;

    public FormEjer8() {
        super("Primitiva");
        setLayout(null);

        int ancho = 10;
        int alto = 10;
        int acu = 0;

        for (int i = 0; i < chkCajas.length; i++) {
            for (int j = 0; j < chkCajas[0].length; j++) {
                System.out.println(i + " " + j);
                chkCajas[i][j] = new JCheckBox(String.format("%d", acu+1));
                chkCajas[i][j].setLocation(ancho, alto);
                chkCajas[i][j].setSize(45, 45);
                chkCajas[i][j].addItemListener(this);
                acu++;
                add(chkCajas[i][j]);
                ancho = ancho + chkCajas[i][j].getWidth() + 10;
            }
            alto = alto + chkCajas[i][0].getHeight() + 10;
            ancho = 10;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
