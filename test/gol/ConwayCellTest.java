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
public class ConwayCellTest {

    public ConwayCellTest() {
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

    @Test
    public void testSomeMethod() {

        ConwayCell test = new ConwayCell();
        assertTrue(test.getStatus());
        ConwayCell test2 = new ConwayCell();
        assertTrue(test2.getStatus());
        test2.setStatus(false);
        assertFalse(test2.getStatus());
        assertTrue(test.addToNbh(test2));
        assertFalse(test.addToNbh(test2));
        assertTrue(test.isInNbh(test2));
        ConwayCell foo[] = new ConwayCell[9];
        int i;
        for(i=0;i<9;i++){
            foo[i] = new ConwayCell();
        }
        for(i=0;i<7;i++){
            assertTrue(test.addToNbh(foo[i]));
        }
        test2.setStatus(true);
        test2.addToNbh(foo[0]);
        test2.addToNbh(foo[1]);
        test2.setDestiny();
        assertTrue(test2.getDestiny());
        test2.addToNbh(test);
        test2.addToNbh(foo[2]);
        test2.setDestiny();
        assertFalse(test2.getDestiny());
        assertFalse(test.addToNbh(foo[8]));
        
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

}