package numberlist.primitivelist;

/**
 * This class provides a growable array for primitive float values
 *
 * @author Dustin Sumarli
 * @version 1.0
 */
class BigFloatArrayList {

    //fields
    private BigIntArrayList list;

    /**
     * Constructor. Initializes the internal BigIntArrayList by calling its
     * default constructor.
     */
    public BigFloatArrayList() {
        list = new BigIntArrayList();
    }

    /**
     * Inserts the given double value at the given index. The index is assumed
     * to be a value between 0 and count. Existing elements are moved up as
     * needed to make room for the new value.
     *
     * @param index the index where the new value should be stored
     * @param value the value to be stored
     */
    public void insert(int index, double value) {
        list.insert(index, Double.doubleToRawLongBits(value));
    }

    /**
     * Deletes the value at the given index. The index is checked to be a value
     * between 0 and count - 1. Existing elements are moved down as needed to
     * keep all values contiguous, without any empty spaces in the array.
     *
     * @param index the index of the element that should be removed
     * @return the value that was removed, or Long.MIN_VALUE (as a double) if
     * index is out of range
     */
    public double deleteAt(int index) {
        return Double.longBitsToDouble(list.deleteAt(index));
    }

    /**
     * Deletes the first instance of the given value. Existing elements are
     * moved down as needed to keep all values contiguous, without any empty
     * spaces in the array. If the value does not exist, this method returns
     * without doing anything.
     *
     * @param value the value to remove
     */
    public void delete(double value) {
        list.delete(Double.doubleToRawLongBits(value));
    }

    /**
     * Returns the value at the given index without removing it. The index is
     * checked to be a value between 0 and count - 1.
     *
     * @param index the index of the element
     * @return the value at that index, or Long.MIN_VALUE (as a double) if index
     * is out of range
     */
    public double getValueAt(int index) {
        return Double.longBitsToDouble(list.getValueAt(index));
    }

    /**
     * Returns the index of the first instance of the given value in the array.
     * If the value doesn't exist, -1 is returned.
     *
     * @param value the value to find in the array
     * @return the index where the value was found, or -1 if not found
     */
    public int locate(double value) {
        return list.locate(Double.doubleToRawLongBits(value));
    }

    /**
     * Provides access to the number of values currently in the array.
     *
     * @return the number of values in the array
     */
    public int getCount() {
        return list.getCount();
    }

    /**
     * Provides a string representation of the growable array, displaying all
     * values currently in the array using the format [ value1, value2, ... ].
     *
     * @return the string representation of the array
     */
    @Override
    public String toString() {
        String output = "[ ";
        for (int i = 0; i < list.getCount(); i++) {
            output += Double.longBitsToDouble(list.getValueAt(i)) + ", ";
        }
        if (list.getCount() > 0) {
            output = output.substring(0, output.length() - 2);
        } else {
            output = output.substring(0, output.length() - 1);
        }
        output += " ]";
        return output;
    }
}
