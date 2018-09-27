import java.util.Scanner;
//import java.util.arrs;


/**
 * Class for using l.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        while (n != 0) {
            String[] input = s.nextLine().split("");
            //System.out.println(arrs.toString(input));
            Balanced b = new Balanced();
            if (b.balancing(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            n--;
        }
    }
}


