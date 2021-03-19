/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;


    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testConstructorFromBadArrays() {
        // todo: instantiate a dip passing valid or invalid arrays
        assertThrows(IllegalArgumentException.class, () -> {Dip badDip = new Dip(new int[]{12,3}, new int[]{12,1});}, "Instantiating a dip with 2 numbers didn't throw an IllegalArgumentException error as it should have");
        assertThrows(IllegalArgumentException.class, () -> {Dip badDip = new Dip(new int[]{12,3,4,2,10}, new int[]{12,1,2});}, "Instantiating a dip with 3 stars didn't throw an IllegalArgumentException error as it should have");
        assertThrows(IllegalArgumentException.class, () -> {Dip badDip = new Dip(new int[]{12,3,4,2,0}, new int[]{12,1});}, "Instantiating a dip with a number = 0 didn't throw an IllegalArgumentException error as it should have");
        assertThrows(IllegalArgumentException.class, () -> {Dip badDip = new Dip(new int[]{12,3,4,2,3}, new int[]{12,0});}, "Instantiating a dip with a star = 0 didn't throw an IllegalArgumentException error as it should have");
        assertThrows(IllegalArgumentException.class, () -> {Dip badDip = new Dip(new int[]{12,3,4,2,-3}, new int[]{12,2});}, "Instantiating a dip with a negative number didn't throw an IllegalArgumentException error as it should have");
        assertThrows(IllegalArgumentException.class, () -> {Dip badDip = new Dip(new int[]{12,3,4,2,3}, new int[]{-12,2});}, "Instantiating a dip with a negative star didn't throw an IllegalArgumentException error as it should have");
    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

}
