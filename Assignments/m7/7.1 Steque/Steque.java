/**
 * Class for node.
 */
class Node {
    /**
     * {data declaration}.
     */
    String data;
    /**
     * {Next variable of type Node}.
     */
    Node next;
    /**
     * Constructs the object.
     *
     * @param      item  The item
     */
    Node(final String item) {
        this.data = item;
    }
    // public void setData() {
    //  this.data = data;
    // }
    // public String getData() {
    //  return data;
    // }
    // public void setNext() {
    //  this.next = next;
    // }
    // public Node getNext() {
    //  return next;
    // }
}
/**
 * Class for steque.
 */
class Steque {
    /**
     * {start and end declaration}.
     */
    private Node start, end;
    /**
     * {size declaration}.
     */
    private int size = 0;
    /**
     * Constructs the object.
     */
    Steque() {
        start = null;
        end = null;
    }
    /**
     * {to add item}.
     *
     * @param      item  The item
     */
    void push(final String item) {
        Node obj = new Node(item);
        if (size == 0) {
            start = obj;
            end = start;
            size++;
            return;
        }
        obj.next = start;
        start = obj;
        size++;
    }
    /**
     * {method to add item}.
     *
     * @param      item  The item
     */
    void enqueue(final String item) {
        Node obj = new Node(item);
        if (size == 0) {
            start = obj;
            end = start;
            size++;
            return;
        }
        end.next = obj;
        end = obj;
        size++;
    }
    /**
     * {method to remove}.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    String pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Steque is empty.");
        }
        String data = start.data;
        start = start.next;
        size--;
        return data;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return size == 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // if(isEmpty()){

        // }
        Node temp = start;
        String res = "";
        while (temp != null) {
            res += temp.data + ", ";
            temp = temp.next;
        }
        return res.substring(0, res.length() - 2);
    }
}