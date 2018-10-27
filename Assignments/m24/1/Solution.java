import java.util.Scanner;
//import java.util.Arrays;
public class Solution {
    /**
     * {main method thats mandatory to run and execute the program}.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        //int N = s.nextInt();
        SepChainHashST<Integer, Student> student = new SepChainHashST<>();
        while (N > 0) {
            String[] str = s.nextLine().split(",");
            //System.out.println(Arrays.toString(str));
            Student st = new Student(str[1], str[2]);
            student.put(Integer.parseInt(str[0]), st);
            N--;
        }
        int M = Integer.parseInt(s.nextLine());
        while (M > 0) {
            String[] queries = s.nextLine().split(" ");
            //System.out.println(Arrays.toString(queries));
            if (queries[2].equals("1")) {
                int key = Integer.parseInt(queries[1]);
                if(student.contains(key)) {
                    System.out.println(student.get(key).name);
                } else {
                    System.out.println("Student doesn't exists...");
                }
                
            } else if (queries[2].equals("2")) {
                int key = Integer.parseInt(queries[1]);
                if(student.contains(key)) {
                    System.out.println(student.get(key).marks);
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
            M--;
        }
    }
}
class Student {
    String name;
    double marks;
    Student(String name, String marks) {
        this.name  = name;
        this.marks = Double.parseDouble(marks);
    }
}
class SepChainHashST<Key, Value> {
    private static final int capacity = 4;
    /**
     * {number of key value pairs}.
     */
    private int n;
    /**
     * {hash table size}.
     */
    private int m;
    /**
     * {array of linked list}.
     */
    private SequentialSearchST<Key, Value>[] st;
    /**
     * Constructs the object.
     */
    public SepChainHashST() {
        this(capacity);
    }
    /**
     * Constructs the object.
     *
     * @param      m     {initializes an empty symbol table with m chains}.
     */
    public SepChainHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }
    /**
     * {resize method}.
     *
     * @param      chains  The chains
     */
    private void resize(int chains) {
        SepChainHashST<Key, Value> temp = new SepChainHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
    }
    /**
     * {hash method}.
     *
     * @param      key   The key
     *
     * @return     {returns a postive value}.
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * {size method}.
     *
     * @return     {returns the number of key-value pairs}.
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * {contain method to check}.
     *
     * @param      key   The key
     *
     * @return     {returns true if this symbol table contains the specified key}.
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * {get method}.
     *
     * @param      key   The key
     *
     * @return     {returns the value associated with the specified key}.
     */
    public Value get(Key key) {
        int i = hash(key);
        return st[i].get(key);
    }
    /**
     * {method to insert the specified key-value pair}.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= 10 * m) {
            resize(2 * m);
        }
        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }
    /**
     * {method to remove the specified key and its associated value}.
     *
     * @param      key   The key
     */
    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
        if (m > capacity && n <= 2 * m) {
            resize(m / 2);
        }
    }
    /**
     * {keys}.
     *
     * @return     {return keys in symbol table as an Iterable}.
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
}
