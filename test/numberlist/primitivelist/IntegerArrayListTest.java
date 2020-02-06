package numberlist.primitivelist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dustin Sumarli
 */
public class IntegerArrayListTest {

    IntegerArrayList list;

    @Before
    public void setUp() {
        list = new IntegerArrayList();
    }

    /**
     * Test of insert method, of class IntegerArrayList.
     */
    @Test
    public void testInsertOne() {
        int index = list.insert(123);
        assertTrue(index == 0);
        assertTrue(list.getValueAt(0) == 123);
        assertTrue(list.getCount() == 1);
    }

    @Test
    public void testInsertLots() {
        int index = 0;
        for (int i = 0; i < 5; i++) {
            index = list.insert(i * 10);
        }
        assertTrue(index == 4);
        for (int i = 0; i < 5; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
        assertTrue(list.getCount() == 5);
    }

    /**
     * Test of deleteAll method, of class IntegerArrayList.
     */
    @Test
    public void testDeleteAllOneInstance() {
        for (int i = 0; i < 5; i++) {
            list.insert(i * 10);
        }
        list.deleteAll(40);
        assertTrue(list.getCount() == 4);
        assertTrue(list.locate(40) == -1);
    }

    @Test
    public void testDeleteAllMultipleInstance() {
        for (int i = 0; i < 5; i++) {
            list.insert(i * 10);
            list.insert(i * 10);
            list.insert(i * 10);
        }
        list.deleteAll(10);
        assertTrue(list.getCount() == 12);
        assertTrue(list.locate(10) == -1);
    }

    @Test
    public void testDeleteAllNonexistent() {
        for (int i = 0; i < 5; i++) {
            list.insert(i * 10);
        }
        list.deleteAll(123);
        assertTrue(list.getCount() == 5);
        for (int i = 0; i < 5; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
    }

    /**
     * Test of locateLast method, of class IntegerArrayList.
     */
    @Test
    public void testLocateLastOne() {
        list.insert(123);
        int index = list.locate(123);
        assertTrue(index == 0);
    }

    @Test
    public void testLocateLastMultiple() {
        for (int i = 0; i < 5; i++) {
            list.insert(123);
        }
        int index = list.locateLast(123);
        assertTrue(index == 4);
    }

    @Test
    public void testLocateLastMiddle() {
        for (int i = 0; i < 5; i++) {
            list.insert(i * 10);
        }
        int index = list.locate(20);
        assertTrue(index == 2);
    }

    @Test
    public void testLocateLastNonexistent() {
        for (int i = 0; i < 5; i++) {
            list.insert(i * 10);
        }

        int index = list.locate(123);
        assertTrue(index == -1);
    }

}
