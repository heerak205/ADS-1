import java.util.Scanner;
import java.util.Arrays;

class Sort {
	private int cutoff = 7;
	int[] auxill;
	int[] arr;
	Sort() {

	}

	void sort(int[] arr) {
		this.arr = arr;
		auxill = new int[arr.length];
		sort(arr, 0, arr.length - 1);
	}

	void sort(int[] arr, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		sort(arr, lo, mid);
		sort(arr, mid + 1, hi);
		mergeSort(arr, lo, mid, hi);
	}

	void mergeSort(int[] arr, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = 0; k <= hi; k++) {
			auxill[k] = arr[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = auxill[j++];
			}

			else if (j > hi) {
				arr[k] = auxill[i++];
			}

			else if (less(auxill[j], auxill[i])) {
				arr[k] = auxill[j++];
			}

			else {
				arr[k] = auxill[i++];
			}
		}
	}

	public  boolean less(int i, int j) {
		return j > i;
	}

	public String toString() {
		System.out.println(Arrays.toString(arr));
		return "";
	}

}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] inputarray = sc.nextLine().split(",");
			
			int[] arr1 = new int[inputarray.length];
			for (int i = 0; i < inputarray.length; i++) {
				arr1[i] = Integer.parseInt(inputarray[i]);
			}
			//System.out.println(arrs.toString(intarr));
			Sort s = new Sort();
			s.sort(arr1);
			System.out.println(s);
		}
	}
}