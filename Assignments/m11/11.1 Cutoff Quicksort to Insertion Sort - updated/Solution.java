import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Sort st = new Sort();
        int testcases = Integer.parseInt(s.nextLine());
        while (s.hasNext()) {
            int cutoff = Integer.parseInt(s.nextLine());
            String[] input  = s.nextLine().split(" ");
            if (input[0].equals("")) {
                System.out.println("[]");
            } else {
                st.quickSort(input, cutoff);
                System.out.println(st.toString(input));
            }
        }
    }
}



