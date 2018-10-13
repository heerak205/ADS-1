import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * {variable comp for company name}.
     */
    private String comp;
    /**
     * {variable change for change in stock per hour}.
     */
    private double change;

    /**
     * Constructs the object.
     *
     * @param      comp   The comp
     * @param      chg   The change
     */
    Stock(final String comp, final double chg) {
        this.comp = comp;
        this.change = chg;
    }
    /**
     * Gets the component.
     *
     * @return     The component.
     */
    public String getComp() {
        return comp;
    }
    /**
     * Gets the change.
     *
     * @return     The change.
     */
    public double getChange() {
        return change;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return comp + " " + change;
    }
    /**
     * {to compare data}.
     *
     * @param      that  The that
     *
     * @return     {Stock type}.
     */
    public int compareTo(final Stock that) {
        if (this.change > that.getChange()) {
            return 1;
        }
        if (this.change < that.getChange()) {
            return -1;
        }
        if (this.comp.compareTo(that.getComp()) > 0) {
            return 1;
        }
        if (this.comp.compareTo(that.getComp()) < 0) {
            return -1;
        } else {
            return 0;
        }
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
        // unused
    }
    /**
     * {main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int stockSize = Integer.parseInt(scan.nextLine());
        ArrayList<Stock> bestPerformers = new ArrayList<Stock>();
        ArrayList<Stock> lPerformers = new ArrayList<Stock>();
        minPQ<Stock> hour1min = new minPQ<Stock>();
        maxPQ<Stock> hour1max = new maxPQ<Stock>();
        for (int i = 0; i < stockSize; i++) {
            String[] inputs = scan.nextLine().split(",");
            Stock temp = new Stock(inputs[0],
                                   Double.parseDouble(inputs[1]));
            hour1max.insert(temp);
            hour1min.insert(temp);
        }
        hour1max.printsort(bestPerformers);
        hour1min.printsort(lPerformers);
        minPQ<Stock> hour2min = new minPQ<Stock>();
        maxPQ<Stock> hour2max = new maxPQ<Stock>();
        for (int i = 0; i < stockSize; i++) {
            String[] inputs = scan.nextLine().split(",");
            Stock temp = new Stock(inputs[0],
                                   Double.parseDouble(inputs[1]));
            hour2max.insert(temp);
            hour2min.insert(temp);
        }
        hour2max.printsort(bestPerformers);
        hour2min.printsort(lPerformers);
        minPQ<Stock> hour3min = new minPQ<Stock>();
        maxPQ<Stock> hour3max = new maxPQ<Stock>();
        for (int i = 0; i < stockSize; i++) {
            String[] inputs = scan.nextLine().split(",");
            Stock temp = new Stock(inputs[0],
                                   Double.parseDouble(inputs[1]));
            hour3max.insert(temp);
            hour3min.insert(temp);
        }
        hour3max.printsort(bestPerformers);
        hour3min.printsort(lPerformers);
        minPQ<Stock> hour4min = new minPQ<Stock>();
        maxPQ<Stock> hour4max = new maxPQ<Stock>();
        for (int i = 0; i < stockSize; i++) {
            String[] inputs = scan.nextLine().split(",");
            Stock temp = new Stock(inputs[0],
                                   Double.parseDouble(inputs[1]));
            hour4max.insert(temp);
            hour4min.insert(temp);
        }
        hour4max.printsort(bestPerformers);
        hour4min.printsort(lPerformers);
        minPQ<Stock> hour5min = new minPQ<Stock>();
        maxPQ<Stock> hour5max = new maxPQ<Stock>();
        for (int i = 0; i < stockSize; i++) {
            String[] inputs = scan.nextLine().split(",");
            Stock temp = new Stock(inputs[0],
                                   Double.parseDouble(inputs[1]));
            hour5max.insert(temp);
            hour5min.insert(temp);
        }
        hour5max.printsort(bestPerformers);
        hour5min.printsort(lPerformers);
        minPQ<Stock> hour6min = new minPQ<Stock>();
        maxPQ<Stock> hour6max = new maxPQ<Stock>();
        for (int i = 0; i < stockSize; i++) {
            String[] inputs = scan.nextLine().split(",");
            Stock temp = new Stock(inputs[0],
                                   Double.parseDouble(inputs[1]));
            hour6max.insert(temp);
            hour6min.insert(temp);
        }
        hour6max.printsort(bestPerformers);
        hour6min.printsort(lPerformers);
    }
}
