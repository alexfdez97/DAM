/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author alex
 */
class AdaptadorRaton extends MouseAdapter{
        @Override
	public void mouseEntered(MouseEvent ev){
		ev.getComponent().setBackground(new Color(186, 195, 196));
                ev.getComponent().setForeground(Color.white);
	}
        @Override
	public void mouseExited(MouseEvent ev){
		ev.getComponent().setBackground(null);
                ev.getComponent().setForeground(null);
	}
}

public class Form2Ejer8 extends JDialog {

    JLabel lblNumeros[] = new JLabel[6];
    JMenu opciones;
    JMenuBar barraMenu;
    JMenuItem guardarPartida, verRecords;
    int sorteo[] = new int[6];
    int acu = 0;
    int ancho = 20;

    public Form2Ejer8(FormEjer8 f) {
        super(f, true);
        setLayout(null);
        setTitle("Números Premiados");
        
        guardarPartida = new JMenuItem("Guardar Partida");
        guardarPartida.setMnemonic('g');
        guardarPartida.addActionListener(f);
        guardarPartida.addMouseListener(new AdaptadorRaton());
        
        verRecords = new JMenuItem("Ver records");
        verRecords.setMnemonic('v');
        verRecords.addActionListener(f);
        verRecords.addMouseListener(new AdaptadorRaton());
        
        opciones = new JMenu("Opciones");
        opciones.setMnemonic('o');
        
        barraMenu = new JMenuBar();
        barraMenu.add(guardarPartida);
        barraMenu.add(verRecords);
        this.setJMenuBar(barraMenu);
        
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
