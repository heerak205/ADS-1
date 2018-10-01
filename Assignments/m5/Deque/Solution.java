import java.util.Scanner;
/**
 * class solution.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Deque d = new Deque();
        while (n != 0) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "pushLeft":
                d.pushleft(Integer.parseInt(tokens[1]));
                d.print();
                break;
            case "pushRight":
                d.pushright(Integer.parseInt(tokens[1]));
                d.print();
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "popLeft":
                if (d.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    d.popleft();
                    d.print();
                }
                break;
            case "popRight":
                if (d.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    d.popright();
                    d.print();
                }
                break;
            default :
                break;
            }
            n--;
        }
    }
}

