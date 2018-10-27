import java.util.Iterator;
class Queue<Item> implements Iterable<Item> {
    /**
     * {queue beginning}.
     */
    private Node<Item> first;
    /**
     * {queue end}.
     */
    private Node<Item> last;
    /**
     * {no.of elements}.
     */
    private int n;          
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    /**
     * Constructs the object.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * {size method}.
     *
     * @return     {returns the number of items in this queue}.
     */
    public int size() {
        return n;
    }
    /**
     * {recentmethod to get the least recent item}.
     *
     * @return     {Returns the item least recent added}.
     */
    public Item recent() {
        return first.item;
    }
    /**
     * {method to add}.
     *
     * @param      item  The item
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }         
        n++;
    }
    /**
     * {method to remove}.
     *
     * @return     {returns the item on this queue thats least recently added.}.
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 
    /**
     * {iterator method}.
     *
     * @return     {Returns an iterator that iterates over the items in
     *  this queue in First In First Out order}.
     */
    public Iterator<Item> iterator()  {
       return new ListIterator<Item>(first);  
    }
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        public ListIterator(Node<Item> first) {
            current = first;
        }
        /**
         * Determines if it has next and to override.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next; 
            return item;
        }
    } 
}