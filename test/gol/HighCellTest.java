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
public class HighCellTest {
    
    public HighCellTest() {
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
     * Test of setDestiny method, of class HighCell.
     */
    @Test
    public void testHighCell() {
        HighCell test = new HighCell();
        assertTrue(test.getStatus());
        HighCell test2 = new HighCell();
        assertTrue(test.getDestiny());
        
        test2.setStatus(false);
        assertFalse(test2.getStatus());
        test2.setStatus(true);
        assertTrue(test2.getStatus());
        
        
        
        assertTrue(test.addToNbh(test2));
        assertFalse(test.addToNbh(test2));
        assertTrue(test.isInNbh(test2));
        HighCell foo[] = new HighCell[9];
        int i;
        for(i=0;i<9;i++){
            foo[i] = new HighCell();
        }
        for(i=0;i<7;i++){
            assertTrue(test.addToNbh(foo[i]));
        }
        assertFalse(test.addToNbh(foo[8]));
        
        test2.setStatus(true);
        test2.setDestiny();
        assertFalse(test2.getDestiny());
        test2.addToNbh(foo[0]);
        test2.setDestiny();
        assertTrue(test2.getDestiny());
        test2.addToNbh(foo[1]);
        test2.setDestiny();
        assertTrue(test2.getDestiny());
        
        test2.addToNbh(foo[2]);
        test2.setDestiny();
        assertFalse(test2.getDestiny());
        test2.addToNbh(foo[3]);
        test2.addToNbh(foo[4]);
        test2.setStatus(false);
        test2.setDestiny();
        assertTrue(test2.getDestiny());
        test2.addToNbh(foo[5]);
        test2.setDestiny();
        assertFalse(test2.getDestiny());
    }
}
