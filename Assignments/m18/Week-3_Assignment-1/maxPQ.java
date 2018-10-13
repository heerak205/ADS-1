import java.util.Comparator;
import java.util.ArrayList;
/**
 * Class for maximum pq.
 *
 * @param      <Key>  The key
 */
public class maxPQ<Key> {
    /**
     * {to store items from 1 to n}.
     */
    private Key[] pq;
    /**
     * {no of items}.
     */
    private int n;
    /**
     * {comparator variable}.
     */
    private Comparator<Key> comparator;
    /**
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     */
    public maxPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Constructs the object.
     */
    public maxPQ() {
        this(1);
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * {the number of elments inside}.
     *
     * @return     {int type}.
     */
    public int size() {
        return n;
    }
    /**
     * {returns max key}.
     *
     * @return     {key type}.
     */
    public Key max() {
        return pq[1];
    }
    /**
     * {to resize}.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * {adds a new key}.
     *
     * @param      x     {x}.
     */
    public void insert(final Key x) {
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }
    /**
     * {method to return the max value}.
     *
     * @return     {key type}.
     */
    public Key delMax() {
        final int four = 4;
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        return max;
    }
    /**
     * {swim function}.
     *
     * @param      m    The k 1
     */
    private void swim(final int m) {
        int k = m;
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * {sink function}.
     *
     * @param      m    The k 1
     */
    private void sink(final int m) {
        int k = m;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * {boolean function}.
     *
     * @param      i     {i}.
     * @param      j     {j}.
     *
     * @return     {boolean type}.
     */
    private boolean less(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }
    /**
     * {swaps the values}.
     *
     * @param      i     {i}.
     * @param      j     {j}.
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * {prints the minimum}.
     *
     * @param      best  The best
     */
    public void printsort(final ArrayList<Key> best) {
        for (int i = 1; i <= 5; i++) {
            Key temp = delMax();
            System.out.println(temp);
            best.add(temp);
        }
        System.out.print("\n");
    }
}
