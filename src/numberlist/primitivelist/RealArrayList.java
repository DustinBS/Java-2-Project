package numberlist.primitivelist;

/**
 * This class provides a growable array for primitive double values by acting as
 * a public interface for BigFloatArrayList.
 *
 * @author Dustin Sumarli
 * @version 1.0
 */
public class RealArrayList extends BigFloatArrayList {

    /**
     * Inserts the given double value at the last index.
     *
     * @param value the value to be stored
     * @return the index the value was inserted at
     */
    public int insert(double value) {
        super.insert(getCount(), value);
        return getCount() - 1;
    }

    /**
     * Deletes all instances of the given double value. Does nothing if value
     * doesn't exist.
     *
     * @param value the value(s) to be deleted
     */
    public void deleteAll(double value) {
        for (int i = getCount() - 1; i >= 0; i--) {
            if (getValueAt(i) == value) {
                deleteAt(i);
            }
        }
    }

    /**
     * Returns the last index of the given double value in the array. If the
     * value doesn't exist, -1 is returned
     *
     * @param value the value to find
     * @return the last index where the value was found
     */
    public int locateLast(double value) {
        for (int i = getCount() - 1; i >= 0; i--) {
            if (getValueAt(i) == value) {
                return i;
            }
        }
        return -1;
    }

}
