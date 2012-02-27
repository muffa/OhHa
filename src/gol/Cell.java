/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

/**
 *
 * @author aomarkka
 */
public interface Cell {
    /**
     * Gives the status of the cell
     *
     * @return true if alive, false if dead
     */
    public boolean getStatus();
    
    /**
     * Method for updating the status of the cell
     *
     * @param newStatus true for alive, false for dead
     */
    public void setStatus(boolean newStatus);
    
    /**
     * Gives the status for the next iteration.
     *
     * @return True if the cell will be alive after the next step, false if not
     */
    public boolean getDestiny();
    /**
     * Calculates whether the cell will be alive or dead after the next step.
     */
    
    public void setDestiny();
    
    /**
     * Adds a given cell to the neighborhood of the current cell.
     * As this relation is clearly symmetric, we will take advantage of that.
     *
     * @param cell Cell to be added to the nbh
     * @return true if adding succeeded
     */
    public boolean addToNbh(Cell cell);
    
    /**
     * Checks the nbh for given cell.
     * @param cell Cell to be checked for
     * @return true if cell is in the nbh, false otherwise.
     */
    public boolean isInNbh(Cell cell);
                        
}
