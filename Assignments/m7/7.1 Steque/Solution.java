import java.util.Scanner;

/**
 * Class for solution.
 */
final class Solution {
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
        int num = Integer.parseInt(sc.nextLine());
        Steque st = new Steque();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
            case "push":
                st.push(input[1]);
                System.out.println(st);
                break;
            case "pop":
                try {
                    st.pop();
                    if (st.isEmpty()) {
                        System.out.println("Steque is empty.");
                    } else {
                        System.out.println(st);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "enqueue":
                st.enqueue(input[1]);
                System.out.println(st);
                break;
            default:
                st = new Steque();
                System.out.println();
                break;
            }
        }
    }
}
