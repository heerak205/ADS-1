import java.util.Scanner;
/**
 * Class for is minimum heap.
 *
 * @param      <E> generic.
 */
class isMinHeap<E extends Comparable<E>> {
    /**
     * arr of generic type.
     */
    private E[] arr;
    /**
     * Constructs the object.
     *
     * @param  a generic type
     */
    isMinHeap(final E[] a) {
        this.arr = a;
    }
    /**
     * Determines if minimum heap.
     * time complexity is N.
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (less(i + 1, i)) {
                return false;
            }
        }
        return true;
    }
    /**
     * checks whether the element is less.
     *
     * @param      i  integer.
     * @param      j  integer.
     *
     * @return   True if less, False otherwise.
     */
    public boolean less(final int i, final int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

}

/**
 * client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor
    }
    /**
     * client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        switch (line) {
        case "String":
            int n = Integer.parseInt(s.nextLine());
            for (int i = 0; i < n; i++) {
                String[] choices = s.nextLine().split(",");
                isMinHeap<String> isobj
                    = new isMinHeap<String>(choices);
                System.out.println(isobj.isMinHeap());
            }
            break;
        case "Integer":
            int n1 = Integer.parseInt(s.nextLine());
            for (int i = 0; i < n1; i++) {
                String[] choices = s.nextLine().split(",");
                Integer[] elementInt = new Integer[choices.length];
                for (int j = 0; j < choices.length; j++) {
                    elementInt[j] = Integer.parseInt(choices[j]);
                }
                isMinHeap<Integer> isobj
                    = new isMinHeap<Integer>(elementInt);
                System.out.println(isobj.isMinHeap());
            }
            break;
        case "Double":
            int n2 = Integer.parseInt(s.nextLine());
            for (int i = 0; i < n2; i++) {
                String[] choices = s.nextLine().split(",");
                Double[] elementDouble = new Double[choices.length];
                for (int j = 0; j < choices.length; j++) {
                    elementDouble[j] = Double.parseDouble(choices[j]);
                }
                isMinHeap<Double> isobj
                    = new isMinHeap<Double>(elementDouble);
                System.out.println(isobj.isMinHeap());
            }
            break;
        case "Float":
            int n3 = Integer.parseInt(s.nextLine());
            for (int i = 0; i < n3; i++) {
                String str = s.nextLine();
                if (str.equals("")) {
                    System.out.println("false");
                    break;
                } else {
                    String[] choices = str.split(",");
                    Float[] elementFloat = new Float[choices.length];
                    for (int j = 0; j < choices.length; j++) {
                        elementFloat[j] = Float.parseFloat(choices[j]);
                    }
                    isMinHeap<Float> isobj
                        = new isMinHeap<Float>(elementFloat);
                    System.out.println(isobj.isMinHeap());
                }
            }
            break;
        default:
            break;
        }
    }
}
