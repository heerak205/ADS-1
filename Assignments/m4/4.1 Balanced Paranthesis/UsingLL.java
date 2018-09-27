import java.util.Scanner;
//import java.util.Arrays;


/**
 * Class for using ll.
 */
final class UsingLL {
    /**
     * Constructs the object.
     */
    private UsingLL() {
        //Empty constructor.
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n != 0) {
            String[] input = sc.nextLine().split("");
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


