/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class SetOfNaturalsTest {
    private SetOfNaturals setA;
    private SetOfNaturals setB;
    private SetOfNaturals setC;
    private SetOfNaturals setD;

    @BeforeEach
    public void setUp() {
        setA = new SetOfNaturals();
        setB = SetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});

        setC = new SetOfNaturals();
        for (int i = 5; i < 50; i++) {
            setC.add(i * 10);
        }
        setD = SetOfNaturals.fromArray(new int[]{30, 40, 50, 60, 10, 20});
    }

    @AfterEach
    public void tearDown() {
        setA = setB = setC = setD = null;
    }

    @Test
    public void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        setB.add(11);
        assertTrue(setB.contains(11), "add: added element not found in set.");
        assertEquals(7, setB.size(), "add: elements count not as expected.");


        assertThrows(IllegalArgumentException.class, () -> setD.add(30), "adding existing element didn't throw an error");

        assertThrows(IllegalArgumentException.class, () -> setB.add(10), "adding an already existing element didn't throw an error");


        
    }

    @Test
    public void testAddBadArray() {
        int[] elems = new int[]{10, 20, -30};

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems), "adding invalid elements in the array form didn't throw an error");

        assertThrows(IllegalArgumentException.class, () -> setB.add(new int[]{10, 15}), "adding repeated elements in the array form didn't throw an error");

        assertThrows(IllegalArgumentException.class, () -> SetOfNaturals.fromArray(elems), "adding invalid elements fromArray didn't throw an error");
    }

    @Test
    public void testSize(){
        SetOfNaturals new_set = new SetOfNaturals();
        assertEquals(0, new_set.size(), "Set size isn't 0 at initialization");
        new_set.add(1);
        int size = new_set.size();
        assertEquals(1, size, "after 1 insertion, set size should be 1, but is " + size + " instead");
        new_set.add(2);
        size = new_set.size();
        assertEquals(2, size, "after second insertion, the set's size should be 2 instead of " + size);
    }

    @Test
    public void testIntersectForNoIntersection() {
        assertFalse(setA.intersects(setB), "no intersection but was reported as existing");
        assertTrue(setD.intersects(setB), "existing intersection wasn't reported");
    }

    @Test
    public void testContains(){
        assertFalse(setA.contains(1), "empty set should not contain natural element 1" );
        assertFalse(setB.contains(1), "setB should not contain natural element 1" );
        assertTrue(setD.contains(40), "setD should contain natural element 40");
    }

}
