

package gol;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;



public class GoLUI extends JPanel {
    private boolean DEBUG = true;
    public JTable table;
    public Grid foo;
    public int w = 10;
    public int h = 10;
    public int i,j;
    public GoLUI() {
        super(new GridLayout(1,0));

        String[] columnNames = new String[w]; //{"1st", "2nd","3rd","4th","5th"};
        for(i=0;i<w;i++) columnNames[i] = " ";
        
        foo = new Grid(w,h);
        String[][] data = new String[w][h];
        for(i=0;i<w;i++) for(j=0;j<h;j++) {
            data[i][j] = " ";
            if(foo.giveCell(i,j).getStatus()) data[i][j] = "ALIVE";
        }

        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 1000));
        table.setFillsViewportHeight(true);
        table.setDefaultRenderer(Object.class, new NewTableCellRenderer());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.repaint();

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    
                    Object asdf = e.getSource();
                    int row = ((JTable)asdf).getSelectedRow();
                    int col = ((JTable)asdf).getSelectedColumn();
                    foo.giveCell(row,col).setStatus(!(foo.giveCell(row,col).getStatus()));
                    System.out.println("r: " + row + " c: " +  col);
                    if(foo.giveCell(row,col).getStatus()) table.setValueAt(" ", row, col);
                    else table.setValueAt("ALIVE", row, col);
                    
                    table.repaint();
                    //printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }


    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static GoLUI createAndShowGUI()  {
        
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        GoLUI cntPn = new GoLUI();
        cntPn.setOpaque(true); //content panes must be opaque
        frame.setContentPane(cntPn);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        int i,j;
        //cntPn.foo.iterate();
        return cntPn;

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        
        //javax.swing.SwingUtilities.invokeLater(new Runnable() {
            //public void run() {
            GoLUI cntPn = createAndShowGUI();
            try{
            int i,j;
            while(!cntPn.foo.iterate()) {
                
                Thread.sleep(1000);
                for(i=0;i<cntPn.w;i++){
                    for(j=0;j<cntPn.h;j++) {
                        cntPn.table.setValueAt(" ", i, j);
                        if(cntPn.foo.giveCell(i,j).getStatus()) cntPn.table.setValueAt("ALIVE", i, j);
                    }
                }
                
            }
            }
            catch(Exception e){}
            return;
    }
            }
        //});
    