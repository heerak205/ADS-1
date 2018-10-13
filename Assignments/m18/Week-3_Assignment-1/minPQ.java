import java.util.Comparator;
import java.util.ArrayList;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
public class minPQ<Key> {
    /**
     * stores items from 1 to n.
     */
    private Key[] pq;
    /**
     * Number of items on priority queue.
     */
    private int n;
    /**
     * Comparator variable.
     */
    private Comparator<Key> comparator;
    /**
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     */
    public minPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue.
     */
    public minPQ() {
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
     * {method to return no of keys}.
     *
     * @return     {int type}.
     */
    public int size() {
        return n;
    }
    /**
     * {method min}.
     *
     * @return     {key type}.
     */
    public Key min() {
        return pq[1];
    }
    /**
     * {method for resizing}.
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
     * {method to insert}.
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
     * {method to delete}.
     *
     * @return     {key type}.
     */
    public Key delMin() {
        final int four = 4;
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        return min;
    }
    /**
     * {swim method}.
     *
     * @param      m     {m}.
     */
    private void swim(final int m) {
        int k = m;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * {sink method}.
     *
     * @param      m     {m}.
     */
    private void sink(final int m) {
        int k = m;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * {boolean method}.
     *
     * @param      i     {i}.
     * @param      j     {j}.
     *
     * @return     {boolean type}.
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * {method to swap}.
     *
     * @param      i     {i}.
     * @param      k     {k}.
     */
    private void exch(final int i, final int k) {
        int j = k;
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * {method to print minimum}.
     *
     * @param      l     {l}.
     */
    public void printsort(final ArrayList<Key> l) {
        for (int i = 1; i <= 5; i++) {
            Key temp = delMin();
            System.out.println(temp);
            l.add(temp);
        }
        System.out.print("\n");
    }
}
