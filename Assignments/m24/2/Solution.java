import java.util.Scanner;
import java.util.Arrays;
class Solution {
	private Solution() {
		//empty constructor
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		while (N > 0) {
			String str[] = s.next().split(",");
			System.out.println(Arrays.toString(str));
			N--;
		}
		int M = s.nextInt();

	}
}