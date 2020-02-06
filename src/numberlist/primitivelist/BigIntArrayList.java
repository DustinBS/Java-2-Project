package numberlist.primitivelist;

/**
 * This class provides a growable array for primitive long values.
 *
 * @author Dustin Sumarli
 * @version 1.0
 */
class BigIntArrayList {

    //fields
    private long[] list;
    private int count;

    /**
     * Constructor. Initializes the underlying array to 10 elements.
     */
    BigIntArrayList() {
        list = new long[10];
        count = 0;
    }

    /**
     * Inserts the given long value at the given index. The index is checked to
     * be a value between 0 and count. Existing elements are moved up as needed
     * to make room for the new value.
     *
     * @param index the index where the new value should be stored
     * @param value the value to be stored
     */
    public void insert(int index, long value) {
        if (index < 0 || index > count) {
            return;
        }
        if (count + 1 > list.length) {
            long[] temp = list;
            list = new long[list.length * 2];
            for (int i = 0; i < temp.length; i++) {
                list[i] = temp[i];
            }
        }
        for (int i = count - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = value;
        count++;
    }

    /**
     * Deletes the value at the given index. The index is checked to be a value
     * between 0 and count - 1. Existing elements are moved down as needed to
     * keep all values contiguous, without any empty spaces in the array.
     *
     * @param index the index of the element that should be removed
     * @return the value that was removed, or Long.MIN_VALUE if index is out of
     * range
     */
    public long deleteAt(int index) {
        if (index < 0 || index >= count) {
            return Long.MIN_VALUE;
        }
        long value = list[index];
        for (int i = index; i < count; i++) {
            list[i] = list[i + 1];
        }
        count--;
        return value;
    }

    /**
     * Deletes the first instance of the given value. Existing elements are
     * moved down as needed to keep all values contiguous, without any empty
     * spaces in the array. If the value does not exist, this method returns
     * without doing anything.
     *
     * @param value the value to remove
     */
    public void delete(long value) {
        if (locate(value) != -1) {
            deleteAt(locate(value));
        }
    }

    /**
     * Returns the value at the given index without removing it. The index is
     * checked to be a value between 0 and count - 1.
     *
     * @param index the index of the element
     * @return the value at that index, or Long.MIN_VALUE if index is out of
     * range
     */
    public long getValueAt(int index) {
        if (index < 0 || index >= count) {
            return Long.MIN_VALUE;
        }
        return list[index];
    }

    /**
     * Returns the index of the first instance of the given value in the array.
     * If the value doesn't exist, -1 is returned.
     *
     * @param value the value to find in the array
     * @return the index where the value was found, or -1 if not found
     */
    public int locate(long value) {
        for (int i = 0; i < count; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Provides access to the number of values currently in the array.
     *
     * @return the number of values in the array
     */
    public int getCount() {
        return count;
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
        for (int i = 0; i < count; i++) {
            output += list[i] + ", ";
        }
        if (count > 0) {
            output = output.substring(0, output.length() - 2);
        } else {
            output = output.substring(0, output.length() - 1);
        }
        output += " ]";
        return output;
    }

}
