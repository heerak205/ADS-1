import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
        //Empty constructor.
    }
    /**
     * Creates a stu.
     *
     * @param      studentdet  The studentdet
     *
     * @return     { New student object }
     */
    public static Student createStu(final String[] studentdet) {
        String name = studentdet[0];
        String dob = studentdet[1];
        int marks1 = Integer.parseInt(studentdet[2]);
        int marks2 = Integer.parseInt(studentdet[3]);
        int marks3 = Integer.parseInt(studentdet[4]);
        int total = Integer.parseInt(studentdet[5]);
        String cate = studentdet[6];
        return new Student(name, dob, marks1, marks2, marks3, total, cate);
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Sorting s = new Sorting();
        int qualified = Integer.parseInt(scan.nextLine());
        int vacant = Integer.parseInt(scan.nextLine());
        int open = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        while(scan.hasNextLine()) {
            String[] input = scan.nextLine().split(",");
            s.addStudent(createStu(input));
        }
        s.sort();
        System.out.println(s);
        s.vacancyprint(open);
        s.vacancy(open, bc, sc, st);
    }
}