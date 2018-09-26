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
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[] arr1 = intArray(s.next());
		int[] arr2 = intArray(s.next());
		//System.out.println(Arrays.toString(arr1));
		//System.out.println(Arrays.toString(arr2));
		//System.out.println(Arrays.copyOf(arr1, m+n));
		//Arrays.copyOf(arr1, m+n);
		//for(int i = 0; i < )
		int[] resultArray = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				resultArray[k++] = arr1[i];
				i = i + 1;
			} else if (arr1[i] > arr2[j]) {
				resultArray[k++] = arr2[j];
				j = j + 1;
			}
		}
		if (arr1.length > arr2.length) {
			while (k < arr1.length + arr2.length) {
				resultArray[k++] = arr1[i++];
			}

		}
		if (arr2.length > arr1.length) {
			while (k < arr1.length + arr2.length) {
				resultArray[k++] = arr2[j++];
			}
		}
		System.out.println(Arrays.toString(resultArray).replace("[", "")
		                   .replace("]", "").replace(" ", ""));

	}
}