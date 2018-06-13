package ejer4bol8;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Adaptador que colorea el componente al entrar y lo devuelve a null al salir
 * @author Alejandro Fernández Martínez
 */
class AdaptadorRaton extends MouseAdapter {
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

/**
 * Formulario secundario que muestra los números seleccionados y si tienen premio o no (Verde Si, Rojo No)
 * @deprecated <b>Quedó en desuso, las funciones aquí implementadas se pasaron al formulario principal {@link FormEjer4}</b>
 * @author Alejandro Fernández Martínez
 */
public class Form2Ejer4 extends JDialog {

    JLabel lblNumeros[] = new JLabel[6];
    JMenuBar barraMenu;
    JMenuItem guardarPartida, verRecords;
    int sorteo[] = new int[6];
    int acu = 0;
    int ancho = 20;

    /**
     * Inicializa el formulario secundario
     * @param f 
     */
    public Form2Ejer4(FormEjer4 f) {
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
                        if (numero == Integer.parseInt(f.chkCajas[i][j].getText())) {
                            lblNumeros[acu].setForeground(Color.green);
                        } else {
                            lblNumeros[acu].setForeground(Color.red);
                        }
                    }
                    ancho = ancho + 40;
                    acu++;
                }
            }
        }
    }
}
