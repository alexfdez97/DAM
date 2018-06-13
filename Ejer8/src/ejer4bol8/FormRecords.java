package ejer4bol8;

import java.io.File;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Inicializa el formulario que muestra los records
 * @author Alejandro Fernández Martínez
 */
public class FormRecords extends JDialog {

    /**
     * Es dónde se muestran los datos
     */
    JTextArea txtArea;

    /**
     * Inicializa el formulario de records
     * @param f Es el formulario principal
     */
    public FormRecords(FormEjer4 f) {
        super(f);
        setLayout(null);
        this.setTitle("Records");

        txtArea = new JTextArea();
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
            txtArea.setSize(txtArea.getPreferredSize());
            this.setSize(txtArea.getSize());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al archivo records", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e);
        }
    }

}
