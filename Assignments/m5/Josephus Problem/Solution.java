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
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n != 0) {
            String[] tokens = sc.nextLine().split(" ");
            int size = Integer.parseInt(tokens[0]);
            int[] ele = new int[size];
            int temp = Integer.parseInt(tokens[1]);
            for (int i = 0; i < size; i++) {
                ele[i] = i;
            }
            //System.out.println(Arrays.toString(ele));
            int count = size, i = 1, index = 0;
            String str = "";
            while (count != 0) {
                if (ele[index % size] != -1) {
                    if (i == temp) {
                        str += ele[index % size] + " ";
                        ele[index % size] = -1;
                        count--;
                        i = 1;
                        index++;
                    } else {
                        index++;
                        i++;
                    }
                } else {
                    index++;
                }

            }
            str = str.substring(0, str.length() - 1);
            System.out.println(str);
            n--;
        }
    }
}

