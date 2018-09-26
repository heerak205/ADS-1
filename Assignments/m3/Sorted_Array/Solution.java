import java.util.Scanner;
import java.util.Arrays;
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
     * {method to conver string to int}.
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    public static int[] intArray(final String str) {
        String[] strArr = str.split(",");
        int[] tempArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            tempArr[i] = Integer.parseInt(strArr[i]);
        }
        return tempArr;
    }
    /**
     * {main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        s.nextLine();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        if (m == 0) {
            s.nextLine();
        } else {
            arr1 = intArray(s.next());
        }
            arr2 = intArray(s.next());
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        //System.out.println(Arrays.copyOf(arr1, m+n));
        //Arrays.copyOf(arr1, m+n);
        //for(int i = 0; i < )
        int[] resultArray = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                resultArray[k++] = arr1[i];
                i = i + 1;
            } else if (arr1[i] > arr2[j]) {
                resultArray[k++] = arr2[j];
                j = j + 1;
            }
        }
        if (m > n) {
            while (k < m + n) {
                resultArray[k++] = arr1[i++];
            }

        }
        if (n > m) {
            while (k < m + n) {
                resultArray[k++] = arr2[j++];
            }
        }
        System.out.println(Arrays.toString(resultArray).replace("[", "")
                           .replace("]", "").replace(" ", ""));

    }
}
