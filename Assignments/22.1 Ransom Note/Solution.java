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
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        SeparateChainingHashST<String, Integer> maG =
        new SeparateChainingHashST<String, Integer>();
        String[] magazine = sc.nextLine().split(" ");
        for (int  i = 0; i < m; i++) {
            maG.put(magazine[i], 0);
        }
        SeparateChainingHashST<String, Integer> raN =
        new SeparateChainingHashST<String, Integer>();
        String[] ransom = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            raN.put(ransom[i], 0);
        }

        for (int i = 0; i < m; i++) {
            int count = maG.get(magazine[i]);
            if (maG.contains(magazine[i])) {
                maG.put(magazine[i], count + 1);
            } else {
                maG.put(magazine[i], 1);
            }
        }
        for (int k = 0; k < n; k++) {
            if (!maG.contains(ransom[k])) {
                System.out.println("No");
                return;
            } else if (maG.contains(ransom[k])) {
                int num = raN.get(ransom[k]);
                if (raN.contains(ransom[k])) {
                    raN.put(ransom[k], num + 1);
                } else {
                    raN.put(ransom[k], 1);
                }
                if (raN.get(ransom[k]) > maG.get(ransom[k])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}


