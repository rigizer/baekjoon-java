import java.util.Scanner;

// https://www.acmicpc.net/problem/2460

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int total = 0;
		
		for (int i = 0; i < 10; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			total -= a;
			total += b;
			
			if (max < total) {
				max = total;
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}
}
