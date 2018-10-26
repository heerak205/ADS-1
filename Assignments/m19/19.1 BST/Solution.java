import java.util.Scanner;
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
     * @param      args  The arguments
     * The time complexity is O(N).
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Book, Integer> bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String[] choices = sc.nextLine().split(",");
            switch (choices[0]) {
            case "put":
                Book key = new Book(choices[1],
                    choices[2], Double.parseDouble(choices[2 + 1]));
                int value = Integer.parseInt(choices[2 + 2]);
                bst.put(key, value);
                break;
            case "get":
                key = new Book(choices[1],
                               choices[2], Double.parseDouble(choices[2 + 1]));
                System.out.println(bst.get(key));
                break;
            case "max":
                Book b = bst.max();
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "min":
                b = bst.min();
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "select":
                b = bst.select(Integer.parseInt(choices[1]));
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "floor":
                b = bst.floor(new Book(choices[1],
                          choices[2], Double.parseDouble(choices[2 + 1])));
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "ceiling":
                b = bst.ceiling(new Book(choices[1],
                          choices[2], Double.parseDouble(choices[2 + 1])));
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            default:
                break;
            }
        }
    }
}
