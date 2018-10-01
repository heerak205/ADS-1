import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
	String data;
	Node next;
	/**
	 * Constructs the object.
	 *
	 * @param      item  The item
	 */
	Node(String item) {
		this.data = item;
	}
}
/**
 * Class for steque.
 */
class Steque {
	private Node start, end;
	int size = 0;
	/**
	 * Constructs the object.
	 */
	Steque() {
		start = null;
		end = null;
	}
	/**
	 * {to add item}.
	 *
	 * @param      item  The item
	 */
	void push(final String item) {
		Node obj = new Node(item);
		if (size == 0) {
			start = obj;
			end = start;
			size++;
			return;
		}
		obj.next = start;
		start = obj;
		size++;
	}
	/**
	 * {method to add item}.
	 *
	 * @param      item  The item
	 */
	void enqueue(final String item) {
		Node obj = new Node(item);
		if (size == 0) {
			start = obj;
			end = start;
			size++;
			return;
		}
		end.next = obj;
		end = obj;
		size++;
	}
	/**
	 * {method to remove}.
	 *
	 * @return     { description_of_the_return_value }
	 *
	 * @throws     Exception  { exception_description }
	 */
	String pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Steque is empty.");
		}
		String data = start.data;
		start = start.next;
		size--;
		return data;
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	boolean isEmpty() {
		return size == 0;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		// if(isEmpty()){

		// }
		Node temp = start;
		String res = "";
		while (temp != null) {
			res += temp.data + ", ";
			temp = temp.next;
		}
		return res.substring(0, res.length() - 2);
	}
}
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
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		Steque st = new Steque();
		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split(" ");
			switch (input[0]) {
			case "push":
				st.push(input[1]);
				System.out.println(st);
				break;
			case "pop":
				try {
					st.pop();
					if (st.isEmpty()) {
						System.out.println("Steque is empty.");
					} else {
						System.out.println(st);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "enqueue":
				st.enqueue(input[1]);
				System.out.println(st);
				break;
			default:
				st = new Steque();
				System.out.println();
				break;
			}
		}
	}
}