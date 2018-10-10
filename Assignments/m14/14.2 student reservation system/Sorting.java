/**
 * Arrays import.
 */
import java.util.Arrays;
/**
 * Class for sorting.
 */
class Sorting {
    /**
     * Student array declaration.
     */
    Student[] stdarray;
    /**
     * Size for incrementing in every iteration.
     */
    int size;
    /**
     * Constructs the object.
     */
    Sorting() {
        stdarray = new Student[40];
        size = 0;
    }
    /**
     * Adds a student.
     * Complexity is N.
     *
     * @param      item  The item
     */
    void addStudent(Student item) {
        stdarray[size++] = item;
        //System.out.println(Arrays.toString(stdarray));
    }
    /**
     * Resizes the array based on the requirement.
     * The complexity is N.
     */
    public void resize() {
        stdarray = Arrays.copyOf(stdarray, 2 * size);
    }
    /**
     * Returns the size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        for (int i = 0; i < size; i++) {
            System.out.println(stdarray[i]);
        }
        return "";
    }

    /**
     * Sort the given array.
     * The element is sinked into the heap and based
     * on the order it is swaped and order is maintained
     * by conducting the sink operations.
     * Complexity is logN.
     */
    public void sort() {
        int n = size;
        for (int i = n / 2; i >= 1; i--) {
            sink(stdarray, i, n);
        }

        while (n > 1) {
            swap(stdarray, 1, n--);
            sink(stdarray, 1, n);
        }
    }

    /**
     * Sink function performes the sink operations.
     * Complexity is log n.
     *
     * @param      array  The array
     * @param      k      { parameter_description }
     * @param      n      { parameter_description }
     */
    public void sink(Student[] array, int k, int n) {
        while(2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(stdarray, j, j + 1)) {
                j++;
            }

            if (!less(stdarray, k, j)) {
                break;
            }

            swap(stdarray, k, j);
            k = j;
        }
    }

    /**
     * Less function compares the two objects.
     *
     * @param      array  The array
     * @param      i      { parameter_description }
     * @param      j      { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(Student[] array, int i, int j) {
        return array[i - 1].compareTo(array[j - 1]) >= 0;
    }

    /**
     * Swap method swaps the two objects.
     *
     * @param      array  The array
     * @param      i      { parameter_description }
     * @param      j      { parameter_description }
     */
    public void swap(Student[] array, int i, int j) {
        Student temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }

    /**
     * Checks if the element is present or not.
     *
     * @param      array  The array
     * @param      s      { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(int[] array, int s) {
        for (int i : array) {
            if (s == i) {
                return true;
            }
        }
        return false;
    }
    /**
     * Printing method for the vacancies.
     *
     * @param      n     { parameter_description }
     */
    public void vacancyprint(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(stdarray[i].getname() + "," + stdarray[i].gettotal() + "," + stdarray[i].getcat());
        }
    }
    /**
     * Allocates the seats based on the vacancy.
     *
     * @param      open  The open
     * @param      bc    { parameter_description }
     * @param      sc    The screen
     * @param      st    { parameter_description }
     */
    public void vacancy(int open, int bc, int sc, int st) {
        int[] array = new int[bc + sc + st];
        int i = 0;
        int n = open;
        for (int k = n; k < size; k++) {
            if (stdarray[k].getcat().equals("BC") && bc > 0) {
                array[i++] = k;
                bc--;
            }

            else if (stdarray[k].getcat().equals("SC") && sc > 0) {
                array[i++] = k;
                sc--;
            }

            else if (stdarray[k].getcat().equals("ST") && st > 0) {
                array[i++] = k;
                st--;
            }
        }

        if (bc > 0) {
            for (int k = n; k < size; k++) {
                if (stdarray[k].getcat().equals("Open") && bc > 0) {
                    if (!contains(array, k)) {
                        array[i++] = k;
                        bc--;
                    }
                }
            }
        }

        if (sc > 0) {
            for (int k = n; k < size; k++) {
                if (stdarray[k].getcat().equals("Open") && sc > 0) {
                    if (!contains(array, k)) {
                        array[i++] = k;
                        sc--;
                    }
                }
            }
        }

        if (st > 0) {
            for (int k = n; k < size; k++) {
                if (stdarray[k].getcat().equals("Open") && st > 0) {
                    if (!contains(array, k)) {
                        array[i++] = k;
                        st--;
                    }
                }
            }
        }
        Arrays.sort(array);
        for (int k = 0; k < array.length; k++) {
            System.out.println(stdarray[array[k]].toString());
        }
    }

}