package gol;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muffa
 */
public class ConwayCell extends AbstractCell {
/**
     * Creates a new ConwayCell. Boolean values are both true.
     */
    public ConwayCell() {
        status = true;
        destiny = true;
    }
        /**
     * Calculates whether the cell will be alive or dead after the next step.
     *
     */
    public void setDestiny() {
        int i;
        int j = 0;
        for(i=0;i<8;i++) if(nbh[i] != null && nbh[i].getStatus()) j++;
        if(j == 3) destiny = true;
        else if(j == 2 && status) destiny = true;
        else destiny = false;
    }
    /**
     * Adds a given cell to the neighborhood of the current cell.
     * As this relation is clearly symmetric, we will take advantage of that.
     *
     * @param cell Cell to be added to the nbh
     * @return true if adding succeeded
     */
    public boolean addToNbh(Cell cell){
           int i;
        for(i=0;i<8;i++){
            if(nbh[i] == cell) return false;
            if(nbh[i] == null) {
                
                nbh[i] = (ConwayCell)cell;
                cell.addToNbh(this);
                return true;
            }
        }
        return false;
    }

}
