package ejer4bol8;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Clase del formulario
 * @author Alejandro Fernández Martínez
 */
public class FormEjer4 extends JFrame implements ItemListener, ActionListener {

    /**
     * Cantidad de chkCajas seleccionados
     */
    int selecciones;
    /**
     * Son los CheckBox que se van a crear
     */
    JCheckBox chkCajas[][] = new JCheckBox[7][7];
    /**
     * Botón de juego
     */
    JButton btnJugar;
    /**
     * Formulario de datos que se piden
     */
    FormDatosUsuario formDatos;
    /**
     * Items para guardar y ver los records
     */
    JMenuItem mnuGuardar, mnuVerRecords;
    /**
     * Es el menú de opciones
     */
    JMenu mnuOpciones;
    /**
     * Es la barra de menú
     */
    JMenuBar mnuBarra;
    /**
     * Cantidad de veces que se ha acertado
     */
    int coincidencias = 0;
    /**
     * Valor que indica si se debe de volver a jugar antes de guardar la partida
     */
    boolean volverJugar = false;

    /**
     * Inicializa el formulario
     */
    public FormEjer4() {
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
        btnJugar.setEnabled(false);
        btnJugar.addActionListener(this);
        add(btnJugar);

        mnuGuardar = new JMenuItem("Guardar Partida");
        mnuGuardar.setMnemonic('g');
        mnuGuardar.addActionListener(this);

        mnuVerRecords = new JMenuItem("Ver records");
        mnuVerRecords.setMnemonic('v');
        mnuVerRecords.addActionListener(this);

        mnuOpciones = new JMenu("Opciones");
        mnuOpciones.setMnemonic('o');
        mnuOpciones.add(mnuGuardar);
        mnuOpciones.addSeparator();
        mnuOpciones.add(mnuVerRecords);

        mnuBarra = new JMenuBar();
        mnuBarra.add(mnuOpciones);
        setJMenuBar(mnuBarra);

        formDatos = new FormDatosUsuario(this);
        formDatos.setSize(350, 100);
        formDatos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        formDatos.setLocationRelativeTo(null);
    }

    /**
     * Genera números aleatorios y <b>únicos</b>
     * @return El vector de números generados
     */
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

    /**
     * Sobreescribe la interfaz ItemListener
     * Controla el número de checkbox seleccionados, y deshabilita los checkbox si es hay 6 seleccionados y habilita el botón para jugar
     * @param e El evento del ItemListener
     */
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
                btnJugar.setEnabled(true);
            } else {
                for (int i = 0; i < chkCajas.length; i++) {
                    for (int j = 0; j < chkCajas[0].length; j++) {
                        if (!chkCajas[i][j].isSelected()) {
                            chkCajas[i][j].setEnabled(true);
                        }
                    }
                }
                btnJugar.setEnabled(false);
            }
        }
    }

    /**
     * Sobreescribe la interfaz ActionListener
     * Controla el resto de eventos
     * @param e El evento del ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJugar) {
            coincidencias = 0;
            volverJugar = false;
            for (int i = 0; i < chkCajas.length; i++) {
                for (int j = 0; j < chkCajas[0].length; j++) {
                    chkCajas[i][j].setBackground(null);
                }
            }
            int numeros[] = aleatorios();
            for (int i = 0; i < chkCajas.length; i++) {
                for (int j = 0; j < chkCajas[0].length; j++) {
                    for (int numero : numeros) {
                        if (numero == Integer.parseInt(chkCajas[i][j].getText())) {
                            chkCajas[i][j].setBackground(Color.red);
                            if (chkCajas[i][j].isSelected()) {
                                chkCajas[i][j].setBackground(Color.green);
                                coincidencias++;
                            }
                        }
                    }
                }
            }
        }

        if (e.getSource() == mnuGuardar) {
            if (volverJugar) {
                JOptionPane.showMessageDialog(null, "Debes de jugar otra partida antes de volver a guardar", "No hagas trampas", JOptionPane.INFORMATION_MESSAGE);
            } else {
                volverJugar = true;
                formDatos.setVisible(true);
            }
        }

        if (e.getSource() == mnuVerRecords) {
            FormRecords fRecords = new FormRecords(this);
            fRecords.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fRecords.setLocationRelativeTo(null);
            fRecords.setVisible(true);
        }
        
        if (e.getSource() == formDatos.btnAceptar) {
            String nombre;
            String ruta = System.getProperty("user.home") + "/records.txt";
            try (
                    FileWriter archivoGuardado = new FileWriter(ruta, true);
                    BufferedWriter bufferGuardado = new BufferedWriter(archivoGuardado);
                    PrintWriter escritura = new PrintWriter(bufferGuardado);) {
                if (formDatos.txfCampoNombre.getText().trim().length() == 0) {
                    nombre = "Anónimo";
                    JOptionPane.showMessageDialog(null, "Se añadirá el resultado con nombre \"Anónimo\"", "", JOptionPane.PLAIN_MESSAGE);
                } else {
                    nombre = formDatos.txfCampoNombre.getText().trim();
                }
                escritura.println(nombre + "." + coincidencias);
                formDatos.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar guardar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == formDatos.btnCancelar) {
            formDatos.dispose();
        }
    }

}
