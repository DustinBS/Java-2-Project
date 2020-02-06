package numberlist.primitivelist;

/**
 * This class provides a growable array for primitive long values by acting as a
 * public interface for BigIntArrayList.
 *
 * @author Dustin Sumarli
 * @version 1.0
 */
public class IntegerArrayList extends BigIntArrayList {

    /**
     * Inserts the given long value at the last index.
     *
     * @param value the value to be stored
     * @return the index the value was inserted at
     */
    public int insert(long value) {
        super.insert(getCount(), value);
        return getCount() - 1;
    }

    /**
     * Deletes all instances of the given long value. Does nothing if value
     * doesn't exist.
     *
     * @param value the value(s) to be deleted
     */
    public void deleteAll(long value) {
        for (int i = getCount() - 1; i >= 0; i--) {
            if (getValueAt(i) == value) {
                deleteAt(i);
            }
        }
    }

    /**
     * Returns the last index of the given long value in the array. If the value
     * doesn't exist, -1 is returned
     *
     * @param value the value to find
     * @return the last index where the value was found
     */
    public int locateLast(long value) {
        for (int i = getCount() - 1; i >= 0; i--) {
            if (getValueAt(i) == value) {
                return i;
            }
        }
        return -1;
    }

}
