import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * {main method}.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i < a; i++) {
			arr[i] = s.nextInt();
		}
		//System.out.println(arr1s.toString(arr));
		noOfPairs(arr);
	}
	/**
	 * {method to find no.of pairs}.
	 *
	 * @param      arr1  The arr 1
	 */
	public static void noOfPairs(int[] arr1) {
		int count = 1;
		int sum = 0;
		Arrays.sort(arr1);
		for (int i = 0; i < arr1.length - 1; i++) {
			if (i == arr1.length - 2 && arr1[i] == arr1[i + 1]) {
				count++;
				sum += count * (count - 1) / 2;
				break;
			}
			if (arr1[i] == arr1[i + 1]) {
				count++;
			}
			if (count > 1 && arr1[i] != arr1[i + 1]) {
				sum += count * (count - 1) / 2;
				count = 1;
			}

		}
		System.out.println(sum);
	}
}