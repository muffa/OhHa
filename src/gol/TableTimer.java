/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;

/**
 *
 * @author aomarkka
 */
public class TableTimer extends Timer implements ActionListener {
    private GoLUI ui;
    private int i,j;
    public TableTimer(GoLUI ui, int time) {
        super(time, null);
        this.ui = ui;
        this.addActionListener(this);
        this.setRepeats(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(!ui.foo.iterate());
        else {
            //System.out.println("Sykli");
            JOptionPane cycle = new JOptionPane();
            JFrame cycleInfo = new JFrame();
            cycle.showMessageDialog(cycleInfo, "A cycle has been found.");
            this.stop();
        }
        for(i=0;i<ui.w;i++) for(j=0;j<ui.h;j++) {
                        ui.table.setValueAt(" ", i, j);
                        if(ui.foo.giveCell(i,j).getStatus()) ui.table.setValueAt("ALIVE", i, j);
                    }
                
    
}}

