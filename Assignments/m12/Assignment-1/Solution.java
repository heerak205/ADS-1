import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class Student implements Comparable<Student> {
	String name;
	String dob;
	int s1;
	int s2;
	int s3;
	int tm;
	String rc;
	int day;
	int month;
	int year;
	Student(String name, String dob, int s1, int s2, int s3, int tm, String rc ){
		this.name = name;
		String[] d = dob.split("-");
		this.day = Integer.parseInt(d[0]);
		this.month = Integer.parseInt(d[1]);
		this.year = Integer.parseInt(d[2]);
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.tm = tm;
		this.rc = rc;
	} 
	public String getName() {
		return name;
	}
	public String getDob() {
		return dob;
	}
	public int getSub1() {
		return s1;
	}
	public int getSub2() {
		return s2;
	}
	 int getSub3() {
		return s3;
	}
	public int getTotalmarks() {
		return tm;
	}
	public String getRc() {
		return rc;
	}
	public int compareTo(Student other) {
		if (this.tm > other.tm) return 1;
		if (this.tm < other.tm) return -1;
		if (this.s3 > other.s3) return 1;
		if (this.s3 < other.s3) return -1;
		if (this.s2 > other.s2) return 1;
		if (this.s2 < other.s2) return -1;
		if (this.year > other.year) return 1;
		if (this.year < other.year) return -1;
		if (this.month > other.month) return 1;
		if (this.month > other.month) return -1;
		if (this.day > other.day) return 1;
		if (this.day < other.day) return -1;
		return 0;
	}
	public int compareSome(Student other) {
		if((this.rc.equals("SC") || this.rc.equals("ST") || this.rc.equals("BC") && other.rc.equals("Open"))) {
			return 1;
		}
		if((other.rc.equals("SC") || other.rc.equals("ST") || other.rc.equals("BC") && this.rc.equals("Open"))) {
			return -1;
		}

		return 0;
	}
}
class Solution {
	Solution(){

	}
	static ArrayList<Student> studs = new ArrayList<>();
	static ArrayList<Student> vacancyArr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int vac = s.nextInt();
		int oc = s.nextInt();
		int bc = s.nextInt();
		int sc = s.nextInt();
		int st = s.nextInt();
		//int p = 0;
		//System.out.println(n+"\n"+vac+"\n"+oc+"\n"+bc+"\n"+sc+"\n"+st);
		while(s.hasNext()){
			String[] arr = s.next().split(",");
			//System.out.println(Arrays.toString(arr));
			//p++;
			Student su = new Student(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), arr[6]);
			studs.add(su);
		}
		selectionSort1();
		for (int i = 0; i < studs.size(); i++) {
			System.out.println(studs.get(i).name + "," + studs.get(i).tm + "," + studs.get(i).rc);
		}
		System.out.println();
		vacancy(vac, oc, bc, sc, st);
		
	}
	public static void vacancy(int vac, int oc, int bc, int sc, int st) {
		int p = 0;
		int q = 0;
		int r = 0;
		int s = 0;
		int t = 0;
		for (int i = 0; i < studs.size(); i++) {
			if(p == oc) break;
				vacancyArr.add(studs.get(i));
				p++;
				t++;
		}
		for (int i = 0; i < studs.size(); i++) {
			if(q == bc) break;
			if(studs.get(i).rc.equals("BC")) {
				if(!vacancyArr.contains(studs.get(i))) {
					vacancyArr.add(studs.get(i));
					q++;
					t++;
				}	
			}	
		}
		for (int i = 0; i < studs.size(); i++) {
			if(r == sc) break;
			if(studs.get(i).rc.equals("SC")) {
				if(!vacancyArr.contains(studs.get(i))) {
					vacancyArr.add(studs.get(i));
					r++;
					t++;
				}
			}	
		}
		for (int i = 0; i < studs.size(); i++) {
			if(s == st) break;
			if(studs.get(i).rc.equals("ST")) {
				if(!vacancyArr.contains(studs.get(i))) {
					vacancyArr.add(studs.get(i));
					s++;
					t++;
				}
			}	
		}
		for (int i = 0; i < studs.size(); i++) {
			if(t == vac) break;
			if(!vacancyArr.contains(studs.get(i))) {
				vacancyArr.add(studs.get(i));
				t++;
			}	
		}
		selectionSort2();
		for (int i = 0; i < vacancyArr.size(); i++) {
			if( i == vac) break;
			System.out.println(vacancyArr.get(i).name + "," + vacancyArr.get(i).tm + "," + vacancyArr.get(i).rc);
		}
	}
	public static void selectionSort2() {
		for (int i = vacancyArr.size() - 1; i >= 0; i--) {
			Student max = vacancyArr.get(i);
			int index = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (max.compareTo(vacancyArr.get(j)) == 1) {
					max = vacancyArr.get(j);
					index = j;
				}
			}
			Student temp = vacancyArr.get(i);
			vacancyArr.set(i, max);
			if (index != -1) {
				vacancyArr.set(index, temp);
			}
		}
	}
	public static void selectionSort1() {
		for (int i = studs.size() - 1; i >= 0; i--) {
			Student max = studs.get(i);
			int index = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (max.compareTo(studs.get(j)) == 1) {
					max = studs.get(j);
					index = j;
				}
			}
			Student temp = studs.get(i);
			studs.set(i, max);
			if (index != -1) {
				studs.set(index, temp);
			}
		}
	}
}