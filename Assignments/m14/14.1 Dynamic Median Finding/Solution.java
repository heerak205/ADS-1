/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        MinPQ<Float> minheap = new MinPQ<Float>();
        MaxPQ<Float> maxheap = new MaxPQ<Float>();
        Float median = 0.0f;
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            Float val = sc.nextFloat();
            if (val > median) {
                minheap.insert(val);
            } else {
                maxheap.insert(val);
            }

            if (minheap.size() - maxheap.size() > 1) {
                maxheap.insert(minheap.delMin());
            }

            if (maxheap.size() - minheap.size() > 1) {
                minheap.insert(maxheap.delMax());
            }

            if (minheap.size() == maxheap.size()) {
                median = (minheap.min() + maxheap.max()) / 2;
                System.out.println(median);
            }

            if (maxheap.size() > minheap.size()) {
                median = maxheap.max();
                System.out.println(median);
            }

            if (minheap.size() > maxheap.size()) {
                median = minheap.min();
                System.out.println(median);
            }
        }
    }
}



