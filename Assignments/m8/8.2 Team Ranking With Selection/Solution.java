import java.util.Scanner;
/**
 * Class for tournament.
 */
class Tournament implements Comparable {
    /**
     * team is of String type.
     */
    private String team;
    /**
     * wins is of int type.
     */
    private int wins;
    /**
     * losses is of int type.
     */
    private int losses;
    /**
     * draws is of int type.
     */
    private int draws;

    /**
     * Constructs the object.
     *
     * Time complexity is 1.
     * @param      teamm    The team
     * @param      winss    The wins
     * @param      lossess  The losses
     * @param      drawss   The draws
     */

    Tournament(final String teamm, final int winss,
        final int lossess, final int drawss) {
        this.team = teamm;
        this.wins = winss;
        this.losses = lossess;
        this.draws = drawss;
    }
    /**
     * Gets the team.
     * Time complexity is 1.
     * @return     The team.
     */
    public String getTeam() {
        return team;
    }
    /**
     * Gets the wins.
     * Time complexity is 1.
     * @return     The wins.
     */
    public int getWins() {
        return wins;
    }
    /**
     * Gets the losses.
     * Time complexity is 1.
     * @return     The losses.
     */
    public int getLosses() {
        return losses;
    }
    /**
     * Gets the draws.
     * Time complexity is 1.
     * @return     The draws.
     */
    public int getDraws() {
        return draws;
    }
    /**
      * method to return boolean.
      * Time complexity is 1.
      * @param      that  The that
      *
      * @return     return boolean.
      */
    public boolean less(final Tournament that) {
        return this.compareTo(that) > 0;
    }
    /**
     * compareTo is used to compare.
     * Time complexity is 1.
     * @param      object  The object
     *
     * @return     returns an int value.
     */
    public int compareTo(final Object object) {
        Tournament that = (Tournament) object;
        if (this.getWins() > that.getWins()) {
            return +1;
        } else if (this.getWins() < that.getWins()) {
            return -1;
        }
        if (this.getLosses() > that.getLosses()) {
            return -1;
        } else if (this.getLosses() < that.getLosses()) {
            // System.out.println("lsj");
            return +1;
        }
        if (this.getDraws() > that.getDraws()) {
            return +1;
        } else if (this.getDraws() < that.getDraws()) {
            return -1;
        }
        return 0;
    }
}
/**
 * Class for selection.
 */
class Selection {
    /**
     * 100 is a magic number.
     */
    private static final int HUN = 100;
    /**
     * tournaments is of Tournament array.
     */
    private Tournament[] tournaments;
    /**
     * size is of type int.
     */
    private int size;
    /**
     * Time complexity is 1.
     * Constructs the object.
     */
    Selection() {
        tournaments = new Tournament[HUN];
        size = 0;
    }
    /**
     * Adds a tournament.
     * Time complexity is 1.
     * @param      t     t is of type Tournament.
     */
    public void addTournament(final Tournament t) {
        tournaments[size++] = t;
    }
    /**
     * Gets the tournament.
     * Time complexity is 1.
     * @param      index  The index
     *
     * @return     The tournament.
     */
    public Tournament getTournament(final int index) {
        return tournaments[index];
    }
    /**
     * Time complexity is N^2.
     * sort method is used to sort.
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (tournaments[j].less(tournaments[min])) {
                    min = j;
                }
            }
            exch(tournaments, i, min);
        }
    }
    /**
     * exch is a method to swap.
     * Time complexity is N.
     * @param      a     a is of type Tournament.
     * @param      i     i is of type int.
     * @param      j     j is of type int.
     */
    public void exch(final Tournament[] a, final int i, final int j) {
        Tournament temp = tournaments[i];
        tournaments[i] = tournaments[j];
        tournaments[j] = temp;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is 1.
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
        s += tournaments[i].getTeam() + ",";
        }
        s += tournaments[i].getTeam();
        return s;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Selection sortlist = new Selection();
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            sortlist.addTournament(new Tournament(s[0],
                Integer.parseInt(s[1]), Integer.parseInt(s[2]),
                Integer.parseInt(s[2 + 1])));

    }
    sortlist.sort();
    System.out.println(sortlist);
    }
}