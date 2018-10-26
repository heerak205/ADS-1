/**
 * {imports Scanner class}.
 */
import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method that drives the program.
     * @param      args  The arguments
     * Time complexity for this method is O(N log N)*
     * For some cases the time complexity may be O(M * N) where
     * M is for hash method and N is for while loop.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearProbingHashST<String, Integer> linrprob = new LinearProbingHashST();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- != 0) {
            String[] choices = sc.nextLine().split(" ");
            switch (choices[0]) {
            case "put":
                linrprob.put(choices[1], Integer.parseInt(choices[2]));
                break;
            case "get":
                System.out.println(linrprob.get(choices[1]));
                break;
            case "delete":
                linrprob.delete(choices[1]);
                break;
            case "display":
                String str = "{";
                for (String s : linrprob.keys()) {
                    str += (s + ":" + linrprob.get(s) + ", ");
                }
                str = str.replaceAll(", $", "");
                System.out.println(str + "}");
                break;
            default:
                break;
            }
        }
    }
}
