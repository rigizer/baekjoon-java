import java.util.Scanner;

// https://www.acmicpc.net/problem/2525

public class BOJ2525 {
	public static void main(String[]args){
	   Scanner in = new Scanner(System.in);
	    
	   int h = in.nextInt();
	   int m = in.nextInt();
	   int c = in.nextInt();
	   int s = m + c;
	   if (s >= 60) {
		   	h += s / 60;
		   	s = s % 60;
	   }
	   
	   if (h >= 24) {
		   h = h - 24;
	   }
	   
	   System.out.print(h+" "+s);
	}
}
