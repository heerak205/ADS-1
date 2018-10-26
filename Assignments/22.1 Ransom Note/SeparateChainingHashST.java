/**
 * Class for separate chaining hash st.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public final class SeparateChainingHashST<Key, Value> {
    /**
     * initial capacity of hash table.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs.
     */
    private int n;
    /**
     * hash table size.
     */
    private int m;
    /**
     * array of linked-list symbol tables.
     */
    private SequentialSearchST<Key, Value>[] st;
    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    public SeparateChainingHashST(final int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }
    /**
     * hash method that returns the hash code of a particular key.
     * @param      key   The key
     * @return     hash code of type int.
     */
    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     * Checks whether the key is present in the hash table or not.
     * @param      key   The key
     * @return     true or false.
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * gets the value of a particular key from hash table.
     * @param      key   The key
     * @return     Value of type Integer.
     */
    public Value get(final Key key) {
        int i = hash(key);
        return st[i].get(key);
    }
    /**
     * Inserts the key value pair into the hash table.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }
}
