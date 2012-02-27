package gol;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;

import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;



public class GoLUI extends JPanel implements ActionListener {
    public JTable table;
    public Grid grid;
    public int w = 50;
    public int h = 50;
    public int i,j;
    TableTimer timer;
    public GoLUI() {
        super();
        
        String[] columnNames = new String[w]; /* empty names for columns */
        for(i=0;i<w;i++) columnNames[i] = " "; 
        
        grid = new Grid(w,h);
        String[][] data = new String[w][h]; 
        for(i=0;i<w;i++) for(j=0;j<h;j++) {
            data[i][j] = " ";
            if(grid.giveCell(i,j).getStatus()) data[i][j] = "ALIVE"; /* For every live cell we write "ALIVE" in the JTable.  That way we can render them black. */
        }

        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 800)); // These dimensions seem to work.
        table.setFillsViewportHeight(true);
        table.setDefaultRenderer(Object.class, new NewTableCellRenderer());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.repaint();

        /* We can click on the cells to kill/resurrect them: */
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                    Object asdf = e.getSource();
                    int row = ((JTable)asdf).getSelectedRow();
                    int col = ((JTable)asdf).getSelectedColumn();
                    grid.giveCell(row,col).setStatus((grid.giveCell(row,col).getStatus()) == false);
                    if(grid.giveCell(row,col).getStatus()) table.setValueAt(" ", row, col);
                    else table.setValueAt("ALIVE", row, col);
                    
                    for(i=0;i<w;i++) for(j=0;j<h;j++) {
                        table.setValueAt(" ", i, j);
                        if(grid.giveCell(i,j).getStatus()) table.setValueAt("ALIVE", i, j);
                    }
                    table.repaint();
                }
            });
        

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
        /* We will have 3 buttons. */
        JButton b1 = new JButton("Play/Pause");
        b1.setActionCommand("play");
        b1.addActionListener(this);
        add(b1);
        JButton b2 = new JButton("Clear");
        b2.setActionCommand("clear");
        b2.addActionListener(this);
        add(b2);
        JButton b3 = new JButton("Reset");
        b3.setActionCommand("reset");
        b3.addActionListener(this);
        add(b3);
              
        timer = new TableTimer(this,1000);
        timer.start();
        
    }
 public void actionPerformed(ActionEvent e) {
      if ("play".equals(e.getActionCommand())) {
          if(timer.isRunning()) timer.stop();
          else timer.start();
      }
      if ("clear".equals(e.getActionCommand())) {
          for(i=0;i<w;i++) for(j=0;j<h;j++) {
              table.setValueAt(" ", i, j);
              grid.giveCell(i,j).setStatus(false);
          }
          timer.stop();
          
      }
      if ("reset".equals(e.getActionCommand())) {
          grid = grid.reset();
          for(i=0;i<w;i++) for(j=0;j<h;j++) {
            table.setValueAt(" ", i, j);
            if(grid.giveCell(i,j).getStatus()) table.setValueAt("ALIVE", i, j);
          }
          table.repaint();
          
      }
 }
 

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static GoLUI createAndShowGUI()  {
        
        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GoLUI cntPn = new GoLUI();
        cntPn.setOpaque(true);
        frame.setContentPane(cntPn);
        
        frame.pack();
        frame.setVisible(true);
               
        return cntPn;

    }
}

