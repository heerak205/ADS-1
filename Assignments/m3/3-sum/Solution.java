import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
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
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }
        //System.out.println(arrs.toString(array));
        threeSum(array);
    }
    /**
     * {threesum method}.
     *
     * @param      arr   The arr
     */
    public static void threeSum(final int[] arr) {
        //arrs.sort(arr);
        //System.out.println(arrs.toString(arr));
        int count = 0;
        Arrays.sort(arr);
        int j = 0;
        int k = 0;
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            j = i + 1;
            k = l - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] < 0) {
                    j += 1;
                } else if (arr[i] + arr[j] + arr[k] > 0) {
                    k -= 1;
                } else {
                    j += 1;
                    k -= 1;
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
