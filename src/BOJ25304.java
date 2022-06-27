import java.util.Scanner;

// https://www.acmicpc.net/problem/25304

public class BOJ25304 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		
		int r = 0;
		
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int c = sc.nextInt();
			
			r += m * c;
		}
		
		System.out.println(t == r ? "Yes" : "No");
		
		sc.close();
	}
}
