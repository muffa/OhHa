/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author aomarkka
 */
public class NewTableCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(((String)value) == "ALIVE") c.setBackground(new java.awt.Color(0, 0, 0));
        else c.setBackground(new java.awt.Color(255, 255, 255));
        
        return c;
    }

  }

