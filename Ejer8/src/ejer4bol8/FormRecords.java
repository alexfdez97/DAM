/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer4bol8;

import javax.swing.JDialog;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class FormRecords extends JDialog {

    JTextArea txtArea;
    
    public FormRecords(FormEjer8 f) {
        super(f);
        setLayout(null);
        this.setTitle("Records");
        
        txtArea = new JTextArea();
        txtArea.setSize(300, 100);
        txtArea.setLocation(0, 0);
        add(txtArea);
    }
    
}
