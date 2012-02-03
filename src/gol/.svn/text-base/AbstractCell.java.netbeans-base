/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

/**
 *
 * @author aomarkka
 */
public abstract class AbstractCell implements Cell{
    /**
     * The neighborhood of the cell. Every cell has a maximum of 8 neighbors.
     */
    protected Cell[] nbh = new Cell[8];
    /**
     * Status of the cell tells if the cell is alive or not.
     * True - alive
     * False - dead
     */
    protected boolean status;
    /**
     * Status of the cell in the next iteration.
     */
    protected boolean destiny; 
    /**
     * Auxiliary integers for loops and such.
     */
    private int i,j;
/**
     * Gives the status of the cell
     *
     * @return true if alive, false if dead
     */
    public boolean getStatus() {
        return status;
    }
    /**
     * Method for updating the status of the cell
     *
     * @param newStatus true for alive, false for dead
     */
    public void setStatus(boolean newStatus) {
        status = newStatus;
    }

    /**
     * Gives the status for the next iteration.
     *
     * @return True if the cell will be alive after the next step, false if not
     */

    public boolean getDestiny() {
        return destiny;
    }

    public abstract void setDestiny();
    
    /**
     * Adds a given cell to the neighborhood of the current cell.
     * As this relation is clearly symmetric, we will take advantage of that.
     *
     * @param cell Cell to be added to the nbh
     * @return true if adding succeeded
     */
    public abstract boolean addToNbh(Cell cell);

    /**
     * Checks the nbh for given cell.
     * @param cell Cell to be checked for
     * @return true if cell is in the nbh, false otherwise.
     */
    public boolean isInNbh(Cell cell) {
        for(i=0;i<8;i++) if(nbh[i] != null && nbh[i] == cell) return true;
        return false;
    }

    

}
