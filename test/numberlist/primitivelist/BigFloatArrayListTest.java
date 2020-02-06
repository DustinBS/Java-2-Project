package numberlist.primitivelist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BigFloatArrayListTest {

    BigFloatArrayList list;

    @Before
    public void setUp() {
        list = new BigFloatArrayList();
    }

    /**
     * Test of insert method, of class BigFloatArrayList.
     */
    @Test
    public void testInsertFirst() {
        list.insert(0, 123);
        assertTrue(list.getCount() == 1);
        assertTrue(list.getValueAt(0) == 123);
    }

    @Test
    public void testInsertLots() {
        for (int i = 0; i < 1000; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.getCount() == 1000);
        for (int i = 0; i < 1000; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
    }

    @Test
    public void testInsertMiddle() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        list.insert(2, 123);
        assertTrue(list.getCount() == 6);
        assertTrue(list.getValueAt(0) == 0);
        assertTrue(list.getValueAt(1) == 10);
        assertTrue(list.getValueAt(2) == 123);
        assertTrue(list.getValueAt(3) == 20);
        assertTrue(list.getValueAt(4) == 30);
        assertTrue(list.getValueAt(5) == 40);
    }

    @Test
    public void testInsertLotsMiddle() {
        for (int i = 0; i < 100; i++) {
            list.insert(i, i * 10);
        }
        list.insert(15, 123);
        assertTrue(list.getCount() == 101);
        for (int i = 0; i < 15; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
        assertTrue(list.getValueAt(15) == 123);
        for (int i = 16; i < 100; i++) {
            assertTrue(list.getValueAt(i) == (i - 1) * 10);
        }
    }

    @Test
    public void testInsertOutOfRange() {
        list.insert(1, 123);
        assertTrue(list.getCount() == 0);
        assertTrue(list.getValueAt(0)
                == Double.longBitsToDouble(Long.MIN_VALUE));
    }

    /**
     * Test of deleteAt method, of class BigFloatArrayList.
     */
    @Test
    public void testDeleteAtFirst() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        double value = list.deleteAt(0);
        assertTrue(value == 0);
        assertTrue(list.getCount() == 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(list.getValueAt(i) == (i + 1) * 10);
        }
    }

    @Test
    public void testDeleteAtLast() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        double value = list.deleteAt(4);
        assertTrue(list.getCount() == 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
    }

    @Test
    public void testDeleteAtOutOfRange() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        Object value = list.deleteAt(5);
        assertTrue(list.getCount() == 5);
        assertTrue(value.equals(Double.longBitsToDouble(Long.MIN_VALUE)));
        for (int i = 0; i < 5; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
    }

    /**
     * Test of delete method, of class BigFloatArrayList.
     */
    @Test
    public void testDeleteMiddle() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        for (int i = 5; i < 10; i++) {
            list.insert(i, (i - 5) * 10);
        }
        for (int i = 10; i < 15; i++) {
            list.insert(i, (i - 10) * 10);
        }
        list.delete(20);
        assertTrue(list.getCount() == 14);
        for (int i = 0; i < 2; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
        for (int i = 2; i < 4; i++) {
            assertTrue(list.getValueAt(i) == (i + 1) * 10);
        }
        for (int i = 4; i < 9; i++) {
            assertTrue(list.getValueAt(i) == (i - 4) * 10);
        }
        for (int i = 9; i < 14; i++) {
            assertTrue(list.getValueAt(i) == (i - 9) * 10);
        }
    }

    @Test
    public void testDeleteNonexistent() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        list.delete(123);
        assertTrue(list.getCount() == 5);
        for (int i = 0; i < 5; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
    }

    @Test
    public void testDeleteFirst() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        list.delete(0);
        assertTrue(list.getCount() == 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(list.getValueAt(i) == (i + 1) * 10);
        }
    }

    @Test
    public void testDeleteLast() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        list.delete(40);
        assertTrue(list.getCount() == 4);
        for (int i = 0; i < 4; i++) {
            assertTrue(list.getValueAt(i) == i * 10);
        }
    }

    /**
     * Test of getValueAt method, of class BigFloatArrayList.
     */
    @Test
    public void testGetOne() {
        list.insert(0, 123);
        assertTrue(list.getValueAt(0) == 123);
    }

    @Test
    public void testGetFirst() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.getValueAt(0) == 0);
    }

    @Test
    public void testGetLast() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.getValueAt(4) == 40);
    }

    @Test
    public void testGetMiddle() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.getValueAt(2) == 20);
    }

    @Test
    public void testGetOutOfRange() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.getValueAt(5)
                == Double.longBitsToDouble(Long.MIN_VALUE));
    }

    /**
     * Test of locate method, of class BigFloatArrayList.
     */
    @Test
    public void testLocateOne() {
        list.insert(0, 123);
        assertTrue(list.locate(123) == 0);

    }

    public void testLocateFirst() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.locate(0) == 0);
    }

    @Test
    public void testLocateLast() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.locate(40) == 4);
    }

    @Test
    public void testLocateMiddle() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.locate(20) == 2);
    }

    @Test
    public void testLocateNonexistent() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.locate(123) == -1);
    }

    /**
     * Test of getCount method, of class BigFloatArrayList.
     */
    @Test
    public void testGetCountEmpty() {
        assertTrue(list.getCount() == 0);
    }

    @Test
    public void testGetCountPartFilled() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.getCount() == 5);
    }

    @Test
    public void testGetCountFilled() {
        for (int i = 0; i < 10; i++) {
            list.insert(i, i * 10);
        }
        assertTrue(list.getCount() == 10);
    }

    /**
     * Test of toString method, of class BigFloatArrayList.
     */
    @Test
    public void testToStringEmpty() {
        assertEquals(list.toString(), "[ ]");
    }

    @Test
    public void testToString() {
        for (int i = 0; i < 5; i++) {
            list.insert(i, i * 10);
        }
        assertEquals(list.toString(), "[ 0.0, 10.0, 20.0, 30.0, 40.0 ]");
    }

}
