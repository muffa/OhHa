/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author muffa
 */
public class GridTest {
    
    public GridTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of iterate method, of class Grid.
     */
    @Test
    public void testAsdf() {
        
        Grid grid = new Grid(11,11);
        assertFalse(null == grid.giveCell(10, 10));
        assertTrue(null == grid.giveCell(10,11));
        assertTrue(grid.giveCell(5,5).isInNbh(grid.giveCell(4, 4)));
        assertFalse(grid.giveCell(5, 5).isInNbh(grid.giveCell(3, 4)));
        int i;
        //for (i=1;i<5;i++) {
            grid = new Grid(1024,1024);
            grid.iterate();
            assertFalse(grid.checkForCycles());
            System.out.println("While begins:");
            while(!grid.iterate());
            System.out.println("While ends.");
            assertTrue(grid.checkForCycles());
            grid = grid.reset();
            assertFalse(grid.checkForCycles());
        //}
        
        

    }
}
