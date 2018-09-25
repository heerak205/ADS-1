import java.util.Scanner;
class Percolation {
	int grid[][];
	int size;
	int noofsites;
	public Percolation(int n) {				// create n-by-n grid, with all sites blocked
		grid = new int[size][size];
		size = n;
		noofsites = 0;
	}                					
	public void open(int row, int col){		// open site (row, col) if it is not open already
		grid[row][col] = 1;
		noofsites++;
		
	}    
    public boolean isOpen(int row, int col) {	// is site (row, col) open?
    	return grid[row][col] == 1;
    }  
  	public boolean isFull(int row, int col) {	// is site (row, col) full?
  		return grid[row][col] == 0;
  	} 
    // public int numberOfOpenSites() {			// number of open sites
    // 	int count = 0;			
    // 	for(int i = 0; i < size-1; i++){
    // 		for(int j = 0; j < size-1; j++){
    // 			if(grid[i][j] == 1){
    // 				count++;
    // 			}
    // 		}
    // 	}

    // } 
    public int numberOfOpenSites() {		// number of open sites
    	return noofsites;
    }     
    public boolean percolates() {			// does the system percolate?
    	return false;
    }             
 }
 public class Solution {
 	public static void main(String[] args) {
 		Scanner s = new Scanner(System.in);
 		int num = s.nextInt();
 		Percolation obj = new Percolation(num);
 		while (s.hasNext()) {
 			//s.nextLine().split(" ");
 			obj.open(s.nextInt(), s.nextInt());
 		}
 		System.out.println(obj.percolates());
 	}
 }


// You can implement the above API to solve the problem
