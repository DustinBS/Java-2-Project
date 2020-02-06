package numberlist.objectlist;

/**
 * This class provides a growable array for numeric objects.
 *
 * @author Dustin Sumarli
 * @version 1.0
 */
public class NumericObjectArrayList {

    //fields
    private int count;
    private Object[] list;

    /**
     * Constructor. Initializes the underlying array to 10 elements.
     */
    public NumericObjectArrayList() {
        list = new Object[10];
        count = 0;
    }

    /**
     * Inserts the given object at the given index. The index is checked to be a
     * value between 0 and count. Existing elements are moved up as needed to
     * make room for the new value.
     *
     * @param index the index where the new object should be stored
     * @param obj the object to be stored
     */
    public void insert(int index, Object obj) {
        if (index < 0 || index > count) {
            return;
        }
        if (count + 1 > list.length) {
            Object[] temp = list;
            list = new Object[list.length * 2];
            for (int i = 0; i < temp.length; i++) {
                list[i] = temp[i];
            }
        }
        for (int i = count - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = obj;
        count++;
    }

    /**
     * Deletes the object at the given index. The index is checked to be a value
     * between 0 and count. Existing elements are moved down as needed to keep
     * all objects contiguous, without any empty spaces in the array.
     *
     * @param index the index of the element that should be removed
     * @return the object that was removed, or null if index is out of range
     */
    public Object deleteAt(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        Object obj = list[index];
        for (int i = index; i < count; i++) {
            list[i] = list[i + 1];
        }
        count--;
        return obj; //replace this return statement
    }

    /**
     * Deletes the first instance of the given object. Existing elements are
     * moved down as needed to keep all objects contiguous, without any empty
     * spaces in the array. If the value does not exist, this method returns
     * without doing anything.
     *
     * @param obj the object to remove
     */
    public void delete(Object obj) {
        if (locate(obj) != -1) {
            deleteAt(locate(obj));
        }
    }

    /**
     * Returns the object at the given index without removing it. The index is
     * checked to be a value between 0 and count - 1.
     *
     * @param index the index of the element
     * @return the object at that index, or null if index is out of range
     */
    public Object getValueAt(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        return list[index];
    }

    /**
     * Returns the index of the first instance of the given object in the array.
     * If the object doesn't exist, -1 is returned.
     *
     * @param obj the object to find in the array
     * @return the index where the object was found, or -1 if not found
     */
    public int locate(Object obj) {
        for (int i = 0; i < count; i++) {
            if (list[i] == obj) {
                return i;
            }
        }
        return -1; //replace this return statement
    }

    /**
     * Provides access to the number of objects currently in the array.
     *
     * @return the number of objects in the array
     */
    public int getCount() {
        return count;
    }

    /**
     * Provides a string representation of the growable array, displaying all
     * objects currently in the array using the format [ object1, object2, ...
     * ].
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
