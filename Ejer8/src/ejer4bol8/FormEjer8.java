/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class FormEjer8 extends JFrame implements ItemListener, ActionListener {

    int selecciones;
    JCheckBox chkCajas[][] = new JCheckBox[7][7];
    JButton btnJugar;
    Form2Ejer8 f;
    FormDatosUsuario formDatos;

    public FormEjer8() {
        super("Primitiva");
        setLayout(null);

        int ancho = 10;
        int alto = 10;
        int acu = 0;

        for (int i = 0; i < chkCajas.length; i++) {
            for (int j = 0; j < chkCajas[0].length; j++) {
                chkCajas[i][j] = new JCheckBox(String.format("%d", acu + 1));
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

        btnJugar = new JButton("Jugar");
        btnJugar.setSize(120, 30);
        btnJugar.setLocation((385 / 2) - 60, 390);
        btnJugar.setVisible(false);
        btnJugar.addActionListener(this);
        add(btnJugar);

        formDatos = new FormDatosUsuario(this);
        formDatos.setSize(350, 100);
        formDatos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        formDatos.setLocationRelativeTo(null);
    }

    public int[] aleatorios() {

        int numeros[] = new int[6];
        ArrayList<Integer> lista = new ArrayList<>(6);
        for (int i = 1; i <= 49; i++) {
            lista.add(i);
        }
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = lista.remove((int) (Math.random() * lista.size()));
        }
        return numeros;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().getClass() == JCheckBox.class) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selecciones++;
            } else {
                selecciones--;
            }

            if (selecciones == 6) {
                for (int i = 0; i < chkCajas.length; i++) {
                    for (int j = 0; j < chkCajas[0].length; j++) {
                        if (!chkCajas[i][j].isSelected()) {
                            chkCajas[i][j].setEnabled(false);
                        }
                    }
                }
                btnJugar.setVisible(true);
            } else {
                for (int i = 0; i < chkCajas.length; i++) {
                    for (int j = 0; j < chkCajas[0].length; j++) {
                        if (!chkCajas[i][j].isSelected()) {
                            chkCajas[i][j].setEnabled(true);
                        }
                    }
                }
                btnJugar.setVisible(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnJugar) {
            f = new Form2Ejer8(this);
            f.setSize(260, 80);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }

        if (e.getSource() == f.guardarPartida) {
            formDatos.setVisible(true);
            f.setVisible(false);
        }

        if (e.getSource() == formDatos.aceptar) {
            int coincidencias = 0;
            try (
                    FileWriter archivoGuardado = new FileWriter("savegame.dat", true);
                    BufferedWriter bufferGuardado = new BufferedWriter(archivoGuardado);
                    PrintWriter escritura = new PrintWriter(bufferGuardado);) {
                for (int i = 0; i < f.lblNumeros.length; i++) {
                    if (f.lblNumeros[i].getForeground() == Color.green) {
                        coincidencias++;
                    }
                }
                escritura.println(formDatos.campoNombre.getText().trim() + "." + coincidencias);
                System.err.println(formDatos.campoNombre.getText().trim());
                System.err.println(coincidencias);
                formDatos.dispose();
                f.dispose();
            } catch (Exception ex) {
            }
        }

        if (e.getSource() == formDatos.cancelar) {
            formDatos.dispose();
            f.setVisible(true);
        }

        if (e.getSource() == f.verRecords) {
            System.err.println("Ver records seleccionado");
        }
    }

}
