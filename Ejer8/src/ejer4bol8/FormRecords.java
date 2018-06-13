/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import java.io.File;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class FormRecords extends JDialog {

    JTextArea txtArea;

    public FormRecords(FormEjer4 f) {
        super(f);
        setLayout(null);
        this.setTitle("Records");

        txtArea = new JTextArea();
        txtArea.setSize(300, 100);
        txtArea.setLocation(0, 0);
        txtArea.setEditable(false);
        add(txtArea);

        try (Scanner scRecords = new Scanner(new File(System.getProperty("user.home") + "/records.txt"))) {
            String texto = "";
            while (scRecords.hasNext()) {
                texto += scRecords.next();
                texto += "\n";
            }
            txtArea.setText(texto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al archivo records", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e);
        }
    }

}
