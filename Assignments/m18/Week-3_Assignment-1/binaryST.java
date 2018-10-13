/**
 * {to import Arrays}.
 */
import java.util.Arrays;
/**
 * {class for binary search tree}.
 */
public final class binaryST<Key extends Comparable<Key>, Value> {
    /**
     * {to store keys}.
     */
    private Key[] keys;
    /**
     * {to store values}.
     */
    private Value[] values;
    /**
     * {size}.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public binaryST() {
        keys = (Key[]) new Comparable[2];
        values = (Value[]) new Object[2];
        size = 0;
    }
    /**
     * {method to resize}.
     *
     * @param      cap   The capability
     */
    private void resize(final int cap) {
        keys = Arrays.copyOf(keys, cap);
        values = Arrays.copyOf(values, cap);
    }
    /**
     * {method to put}.
     *
     * @param      k     { parameter_description }
     * @param      v     { parameter_description }
     */
    public void put(final Key k, final Value v) {
        if (v == null) {
            delete(k);
            return;
        }
        int i = getRank(k);
        if (i < size && keys[i].compareTo(k) == 0) {
            values[i] = v;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = k;
        values[i] = v;
        size++;
        if (size == keys.length) {
            resize(2 * size);
        }
    }
    /**
     * Gets the rank.
     *
     * @param      key   The key
     *
     * @return     The rank.
     */
    public int getRank(final Key key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp > 0) {
                lo = mid + 1;
            } else if (comp < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /**
     * {method to get the value}.
     *
     * @param      a     {a}.
     *
     * @return     {key type}.
     */
    public Value get(final Key a) {
        if (isEmpty()) {
            return null;
        }
        int i = getRank(a);
        if (i < size && keys[i].compareTo(a) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * {checks wether present or not}.
     *
     * @param      k     {k}.
     *
     * @return     { key type}.
     */
    public boolean contains(final Key k) {
        return get(k) != null;
    }
    /**
     * Gets the floor.
     *
     * @param      k     {k}.
     *
     * @return     The floor.
     */
    public Key getFloor(final Key k) {
        if (isEmpty()) {
            return null;
        }
        int i = getRank(k);
        if (i == 0) {
            return null;
        }
        if (i < size && keys[i].compareTo(k) == 0) {
            return keys[i];
        }
        return keys[i - 1];
    }
    /**
     * {method to delete}.
     *
     * @param      delkey  The delkey
     */
    public void delete(final Key delkey) {
        final int four = 4;
        if (isEmpty()) {
            return;
        }
        int i = getRank(delkey);
        if (i < size && keys[i].compareTo(delkey) != 0) {
            return;
        }
        for (int j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[size] = null;
        values[size] = null;
        if (size > 0 && size == keys.length / four) {
            resize(keys.length / 2);
        }
    }
    /**
     * {method to delete the minimum value}.
     */
    public void deleteMin() {
        if (!(isEmpty())) {
            delete(keys[0]);
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                s += keys[i] + " " + values[i] + "\n";
            }
            return s.substring(0, s.length() - 1);
        }
        return s;
    }
    /**
     * Gets the maximum.
     *
     * @return     The maximum.
     */
    public Key getMax() {
        return keys[size - 1];
    }
}
