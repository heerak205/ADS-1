import java.util.Scanner;
//import java.util.Arrays;
/**
 * List of .
 */
class Stack {
    Node first = null;
    /**
     * Class for node.
     */
    class Node {
        /**
         * {data}.
         */
        private int data;
        /**
         * {next}.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data2  The data 2
         */
        Node(final int data2) {
            this.data = data2;
        }
    }
    /**
     * {method to insert}.
     *
     * @param      value  The value
     */
    public void push(final int value) {
        Node obj = new Node(value);
        obj.next = first;
        first = obj;
    }
    /**
     * {method to delete}.
     *
     * @return     { description_of_the_return_value }
     */
    public int pop() {
        int item = first.data;
        first = first.next;
        return item;
    }
    /**
     * {method to print}.
     */
    public void printLt() {
        Node node = first;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * {first}.
     */
    private Node first = null;
    /**
     * {last}.
     */
    private Node last = null;
    /**
     * {size}.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { var_description }.
         */
        private String data;
        /**
         * { var_description }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data  The data
         */
        Node(final String data1) {
            this.data = data1;
        }
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
     * {method to insert}.
     *
     * @param      element  The element
     */
    public void push(final String element) {
        Node obj = new Node(element);
        if (isEmpty()) {
            first = obj;
            last = first;
            last.next = null;
            size++;
            return;
        }
        Node oldlast = last;
        last = obj;
        oldlast.next = last;
        last.next = null;
        size++;
    }
    /**
     * {method to delete}.
     *
     * @return     { description_of_the_return_value }
     */
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String item = first.data;
        first = first.next;
        size--;
        return item;
    }
    /**
     * {method to print list}.
     */
    public void printLt() {
        Node node = first;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {
    }
    /**
     * {method numbertodigits}.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList link = new LinkedList();
        String[] data = number.split("");
        for (int i = 0; i < data.length; i++) {
            link.push(data[i]);
        }
        //System.out.println(Arrays.toString(numbers));
        return link;
    }
    /**
     * {method digitstonumbers}.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList list) {
        String num = "";
        while (!list.isEmpty()) {
            num += list.pop();
        }
        return num;
    }
    // public static LinkedList 
    // addLargeNumbers(LinkedList list1, LinkedList list2) {
    // return LinkedList l;
    // }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * {main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            //LinkedList result = 
            //AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
        }
    }

}
