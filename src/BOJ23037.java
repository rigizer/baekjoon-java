import java.util.Scanner;

// https://www.acmicpc.net/problem/23037

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = 0;
		int d = 10000;
		
		for (int i = 0; i < 5; i++) {
			int tmp = (n / d) % 10;
			int o = (int) Math.pow(tmp, 5);
			r += o;
			d /= 10;
		}
		
		System.out.println(r);
		
		sc.close();
	}
}
