// https://www.acmicpc.net/problem/17450

import java.util.Scanner;

public class BOJ17450 {
	private double get_ratio(int price, int weigh) {
		int total_price = price * 10;
		
		if (total_price >= 5000) {
			total_price -= 500;
		}
		
		double ratio = ((double) (weigh * 10)) / total_price;
		
		return ratio;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BOJ17450 b = new BOJ17450();
		
		int s_price = sc.nextInt();
		int s_weigh = sc.nextInt();
		int n_price = sc.nextInt();
		int n_weigh = sc.nextInt();
		int u_price = sc.nextInt();
		int u_weigh = sc.nextInt();
		
		double s_ratio = b.get_ratio(s_price, s_weigh);
		double n_ratio = b.get_ratio(n_price, n_weigh);
		double u_ratio = b.get_ratio(u_price, u_weigh);
		
		double good_ratio = Math.max(s_ratio, Math.max(n_ratio, u_ratio));
		
		if (good_ratio == s_ratio) {
			System.out.println("S");
		} else if (good_ratio == n_ratio) {
			System.out.println("N");
		} else {
			System.out.println("U");
		}
		
		sc.close();
	}
}
