package gol;
import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muffa
 */


public class Grid {

    /**
     * Auxiliary integers
     */
    private int i,j;
    /**
     * Height and weight of the grid
     */
    private int h,w;
    /**
     * Grids know their predecessor
     */
    private Grid prev;
    /**
     * Random generator used in the initialization of the grid
     */
    private Random gen = new Random();
    /**
     * 2D array of the cells in the grid
     */
    private Cell cells[][]; // = new Cell[][];
    
    /**
     * Creates a wh*ht grid of cells ands randomizes their state.
     * 
     * 
     * @param wh Width of the grid
     * @param ht Height of the grid
     *
     */

    public Grid(int wh, int ht) {
        w = wh;
        h = ht;
        prev = null;
        cells = new Cell[wh][ht];
        for(i=0;i<wh;i++) for(j=0;j<ht;j++) cells[i][j] = new HighCell();
        for(i=0;i<wh;i++) for(j=0;j<ht;j++) cells[i][j].setStatus((gen.nextInt(3) < 1));
        for(i=0;i<wh;i++) { for(j=0;j<ht;j++) {
            if(i-1 != -1) cells[i][j].addToNbh(cells[i-1][j]);
            if(j-1 != -1) cells[i][j].addToNbh(cells[i][j-1]);
            if(i-1 != -1 && j-1 != -1) cells[i][j].addToNbh(cells[i-1][j-1]);
            if(i+1 != wh && j-1 != -1) cells[i][j].addToNbh(cells[i+1][j-1]);
        }}
    }
    /**
     * Returns a cell with coordinates (wh,ht).
     * @param wh x coordinate
     * @param ht y coordinate
     * @return Pointer to the corresponding cell, null on error
     */
    public Cell giveCell(int wh, int ht) {
        if(wh < w && ht < h) return cells[wh][ht];
        return null;
    }
    /**
     * Prints the current grid in text form.
     * 
     */
    public void printGrid(){
        for(i=0;i<w;i++) {
            for(j=0;j<h;j++) {
                if(cells[i][j].getStatus()) System.out.print("*");
                else System.out.print("o");
            }
            System.out.println();
        }
    }
    /**
     * Advances the cells to another generation.
     * Returns true if the conditions for ending are met.
     * 
     * asdf
     * 
     * @return Ending criterion met
     */
    public boolean iterate() {
        
        for(i=0;i<w;i++) for(j=0;j<h;j++) cells[i][j].setDestiny();
        boolean temp = true;
        for(i=0;i<w;i++) for(j=0;j<h;j++) if(cells[i][j].getDestiny() != cells[i][j].getStatus()) temp = false;
        if(temp || this.checkForCycles()) return true;
        for(i=0;i<w;i++) for(j=0;j<h;j++) cells[i][j].setStatus(cells[i][j].getDestiny());
        
        return false;
    }
    /**
     * Function checks for repeating cycles.
     * 
     * @return True if a cycle is found.
     */
    public boolean checkForCycles() {
        Grid previous = this.copy();
        this.prev = previous;
        Grid temp;
        boolean foo = true;
        for(temp = previous;temp.prev!=null;temp=temp.prev) {
            foo = true;
            for(i=0;i<w;i++) for(j=0;j<h;j++) if(temp.prev.giveCell(i, j).getStatus() != this.giveCell(i,j).getStatus()) foo = false;
            if(foo) return true;
        }
        return false;
    }
    /**
     * Creates a copy of a given grid.
     * @return Pointer to the copy.
     */
    public Grid copy() {
        Grid copy = new Grid(w,h);
        for(i=0;i<w;i++) for(j=0;j<h;j++) copy.giveCell(i, j).setStatus(this.giveCell(i, j).getStatus());
        copy.prev = this.prev;
        return copy;
    }
    




}
