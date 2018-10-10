/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * Name of the student.
     */
    private String name;
    /**
     * Date of birth of student.
     */
    private String dob;
    /**
     * Marks1 of student.
     */
    private int marks1;
    /**
     * Marks2 of student.
     */
    private int marks2;
    /**
     * Marks3 of student.
     */
    private int marks3;
    /**
     * Total of student.
     */
    private int total;
    /**
     * Category of student.
     */
    private String cat;

    /**
     * Constructs the object.
     *
     * @param      name1    The name 1
     * @param      dob1     The dob 1
     * @param      marks11  The marks 11
     * @param      marks22  The marks 22
     * @param      marks33  The marks 33
     * @param      total1   The total 1
     * @param      cat1     The cat 1
     */

    Student(final String name1, final String dob1, final int marks11,
        final int marks22, final int marks33, final int total1,
        final String cat1)  {
        this.name = name1;
        this.dob = dob1;
        this.marks1 = marks11;
        this.marks2 = marks22;
        this.marks3 = marks33;
        this.total = total1;
        this.cat = cat1;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return name + "," + total + "," + cat;
    }

    /**
     * Getter function to get name.
     * Complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return name;
    }

    /**
     * Getting date of birth.
     * Complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public String getdob() {
        return dob;
    }

    /**
     * Getter function to get marks1.
     * Complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getmarks1() {
        return marks1;
    }
    /**
     * Getter function to get marks2.
     * Complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getmarks2() {
        return marks2;
    }

    /**
     * Getter function to get marks 3.
     * Complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getmarks3() {
        return marks3;
    }

    /**
     * Getter function to get the total.
     * Complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int gettotal() {
        return total;
    }

    /**
     * Getter function to get the category.
     * Complexity is.
     *
     * @return     { description_of_the_return_value }
     */

    public String getcat() {
        return cat;
    }

    /**
     * Compare to function compares the total
     * first then if they are equal the marks3 are
     * compared and later marks 2 are compared. If
     * they are also equal then the person who is younger
     * is gievn the first priority.
     *
     * Date is a string in the constructor that I have taken
     * I have converted it it into String and then it is compared.
     * Accordingly.b
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        if (this.total > that.total) {
            return 1;
        }

        if (this.total < that.total) {
            return -1;
        }

        if (this.marks3 > that.marks3) {
            return 1;
        }

        if (this.marks3 < that.marks3) {
            return -1;
        }

        if (this.marks2 > that.marks2) {
            return 1;
        }

        if (this.marks2 < that.marks2) {
            return -1;
        }

        String[] date1 = this.dob.split("-");
        String[] date2 = that.dob.split("-");

        if (Integer.parseInt(date1[2]) > Integer.parseInt(date2[2])) {
            return 1;
        }

        if (Integer.parseInt(date1[2]) < Integer.parseInt(date2[2])) {
            return -1;
        }

        if (Integer.parseInt(date1[1]) > Integer.parseInt(date2[1])) {
            return 1;
        }

        if (Integer.parseInt(date1[1]) < Integer.parseInt(date2[1])) {
            return -1;
        }

        if (Integer.parseInt(date1[0]) > Integer.parseInt(date2[0])) {
            return 1;
        }

        if (Integer.parseInt(date1[0]) < Integer.parseInt(date2[0])) {
            return -1;
        }

        return 0;
    }
}

