import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/3047

public class BOJ3047 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[3];
		for (int i = 0; i < 3; i++) {
			num[i] = sc.nextInt();
		}
		String s = sc.next().trim();
		Arrays.sort(num);
		
		for (int i = 0; i < 3; i++) {
			char c = s.charAt(i);
			
			if ('A' == c) {
				System.out.print(num[0] + " ");
			} else if ('B' == c) {
				System.out.print(num[1] + " ");
			} else if ('C' == c) {
				System.out.print(num[2] + " ");
			}
		}
		
		sc.close();
	}
}
