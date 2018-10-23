import java.util.Scanner;
/**
 * Solution for class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();
        while(scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch(tokens[0]) {
                case "put":
                bst.put(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1])), tokens[2 + 2]);
                break;
                case "get":
                System.out.println(bst.get(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
                case "max":
                System.out.println(bst.max());
                break;
                case "min":
                System.out.println(bst.min());
                break;
                case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
                case "floor":
                System.out.println(bst.floor(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
                case "ceiling":
                System.out.println(bst.ceiling(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
                case "delete":
                bst.delete(new Key(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1])));
                break;
                case "deleteMax":
                bst.deleteMax();
                break;
                case "deleteMin":
                bst.deleteMin();
                break;
                default:
                break;
            }
        }
    }
}
class Key implements Comparable{
    /**
     * name is of type string.
     */
    private String name;
    /**
     * author is of type string.
     */
    private String author;
    /**
     * price is of type float.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      namee    The namee
     * @param      authorr  The authorr
     * @param      pricee   The pricee
     */
    Key (final String namee, final String authorr, final float pricee) {
        this.name = namee;
        this.author = authorr;
        this.price = pricee;
    }
    /**
     * { function_description }.
     *
     * @param      object  The object
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Object object) {
        Key that = (Key) object;
        return this.name.compareTo(that.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return name + ", " + author + ", " + price;
    }
}
